package kr.ac.hanyang;

import kr.ac.hanyang.model.Node;
import kr.ac.hanyang.model.template.NodeTemplate;
import kr.ac.hanyang.model.template.ServiceTemplate;
import kr.ac.hanyang.model.template.TopologyTemplate;
import kr.ac.hanyang.model.ToscaInputs;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


@SuppressWarnings("unchecked")
public class ToscaParser {

    public static ToscaInputs inputs = new ToscaInputs();
    public static NodeTemplate nodeTemplate = new NodeTemplate();
    public static Map map;
    public static ServiceTemplate serviceTemplate;

    public ToscaParser(String filePath) {
        Yaml yaml = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            map = (Map) yaml.load(fileInputStream);

            serviceTemplate = new ServiceTemplate(map);

            if(!serviceTemplate.isValid()){
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        this.setNodeTemplate(map);
        this.sortByDependency();
        this.setInputs(map);
    }

    //get topology_templates's input
    public void setInputs(Map node) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                if (((String) subValueKey).equals("inputs")) {
//                    Object nodeTempateNode = node.get(subValueKey);
                    for (Object key : ((Map) node.get(subValueKey)).keySet()) {
                        inputs.put(key, ((Map) node.get(subValueKey)).get(key));
//                        System.out.println(values);
                    }
                    break;
                }
                setInputs((Map) node.get(subValueKey));
            }
        }
//        System.out.println(inputs);
    }

    @Deprecated
    public void getToscaFile(String filePath) {
        Yaml yaml = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            map = (Map) yaml.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void traverse(String filePath) {
        Yaml yaml = new Yaml();

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            map = (Map) yaml.load(fileInputStream);
            setNodeTemplate(map);
//            new Thread(new Runnable() {
//                public void run() {
//                    setNodeTemplate(map);
////                    System.out.println(nodeTemplate.keySet());
//                }
//            }).start();
//
////            setNodeTemplate(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getInfo(Map node) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getInfo((Map) node.get(subValueKey));
            } else {
//                System.out.println(subValueKey + ": " + node.get(subValueKey));
            }
        }
    }

    @Deprecated
    public void makeTopologyTemplate(LinkedHashMap node) {
        TopologyTemplate topologyTemplate = new TopologyTemplate(node);
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getInfo((Map) node.get(subValueKey));
            } else {
                System.out.println(node.get(subValueKey));
            }
        }
//        return topologyTemplete;
    }

    public void getInputs() {

    }

    private void setNodeTemplate(Map node) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                if (((String) subValueKey).equals("node_templates")) {
                    for (Object key : ((Map) node.get(subValueKey)).keySet()) {
                        nodeTemplate.put(key, ((Map) node.get(subValueKey)).get(key));
                    }
                    break;
                }
                setNodeTemplate((Map) node.get(subValueKey));
            }
        }
    }

    public static ArrayList<Node> getParentNodesByKey(Map node, String key, String parentKey, ArrayList maps) {
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {
                maps.add(new Node(node, (String) parentKey));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getParentNodesByKey((Map) node.get(subValueKey), key, (String) subValueKey, maps);
            }

        }
        return maps;
    }

    public static boolean isLeafNode(Object curNode) {
        return !(LinkedHashMap.class.getName().equals(curNode.getClass().getName())
                || Node.class.getName().equals(curNode.getClass().getName()));
    }


    public static ArrayList getNodeByKey(Map node, String key) {
        ArrayList nodeList = new ArrayList();
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {
                if (!isLeafNode(node.get(key)))
                    nodeList.add(new Node((Map) node.get(key), (String) key));
                else
                    nodeList.add(node.get(key));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getNodeByKey((Map) node.get(subValueKey), key, nodeList);
            }

        }
        return nodeList;
    }

    private static ArrayList getNodeByKey(Map node, String key, ArrayList nodeList) {
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {
                if (!isLeafNode(node.get(key)))
                    nodeList.add(new Node((Map) node.get(key), (String) key));
                else
                    nodeList.add(node.get(key));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getNodeByKey((Map) node.get(subValueKey), key, nodeList);
            }

        }
        return nodeList;
    }

    public static void sortByDependency() {

        class NodeWithDependency {
            String name;
            ArrayList<String> dependencyList = new ArrayList<>();

            public NodeWithDependency(String name) {
                this.name = name;
            }

            public NodeWithDependency(String name, ArrayList<String> dependencyList) {
                this.name = name;
                this.dependencyList = dependencyList;
            }

            @Override
            public String toString() {
                return name + dependencyList;
            }
        }

        ArrayList<NodeWithDependency> dependencyList = new ArrayList<NodeWithDependency>();
        NodeWithDependency nodeWithDependency;
        final ArrayList<String> nodeNames = new ArrayList(nodeTemplate.keySet());
        for (int i = 0; i < nodeTemplate.size(); i++) {
            nodeWithDependency = new NodeWithDependency(nodeNames.get(i));
            if (((Map) nodeTemplate.get(nodeNames.get(i))).containsKey("requirements")) {
                ArrayList<Map> curNode = new ArrayList<>((ArrayList) ((Map) nodeTemplate.get(nodeNames.get(i))).get("requirements"));
                Iterator<Map> it = curNode.iterator();
                do {
                    nodeWithDependency.dependencyList.add((String) it.next().values().iterator().next());
                } while (it.hasNext());
            }
            dependencyList.add(nodeWithDependency);
        }
        nodeNames.clear();
        do {
            for (int i = 0; i < dependencyList.size(); i++) {
                if (dependencyList.get(i).dependencyList.isEmpty()) {
                    for (int j = 0; j < dependencyList.size(); j++) {
//                        System.out.println(dependencyList.get(i).name);
                        dependencyList.get(j).dependencyList.remove(dependencyList.get(i).name);
//                        System.out.println(dependencyList.get(j).dependencyList);
                    }
                    nodeNames.add(dependencyList.get(i).name);
                    dependencyList.remove(i);
                    i--;
                }
            }
        } while (!dependencyList.isEmpty());

        List<Map.Entry> entries =
                new ArrayList(nodeTemplate.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry>() {
            public int compare(Map.Entry a, Map.Entry b) {
                return Integer.compare(nodeNames.indexOf(a.getValue()), nodeNames.indexOf(b.getValue()));
            }
        });
        Map sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        ((Map) map.get("topology_template")).put("node_templates", sortedMap);
    }
}
