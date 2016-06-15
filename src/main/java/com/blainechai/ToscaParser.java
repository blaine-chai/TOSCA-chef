package com.blainechai;

import com.blainechai.model.Node;
import com.blainechai.model.NodeTemplate;
import com.blainechai.model.TopologyTemplete;
import com.blainechai.model.ToscaInputs;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


@SuppressWarnings("unchecked")
public class ToscaParser {

    public static ToscaInputs inputs = new ToscaInputs();
    public static NodeTemplate nodeTemplate = new NodeTemplate();
    public static Map map;

    public ToscaParser(String filePath) {
        Yaml yaml = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            map = (Map) yaml.load(fileInputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setNodeTemplate(map);
        this.setInputs(map);
//        sout
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
    }

    public void getToscaFile(String filePath) {
        Yaml yaml = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            map = (Map) yaml.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void makeTopologyTemplete(Map node) {
        TopologyTemplete topologyTemplete = new TopologyTemplete();
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
//                    Object nodeTempateNode = node.get(subValueKey);
                    for (Object key : ((Map) node.get(subValueKey)).keySet()) {
                        nodeTemplate.put(key, ((Map) node.get(subValueKey)).get(key));
//                        System.out.println(values);
                    }
                    break;
                }
                setNodeTemplate((Map) node.get(subValueKey));
            }
        }

        sortByDependency();
    }

    public static ArrayList<Node> getParentNodeByKey(Map node, String key, String parentKey, ArrayList maps) {
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {
                maps.add(new Node(node, (String) parentKey));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getParentNodeByKey((Map) node.get(subValueKey), key, (String) subValueKey, maps);
            }

        }
        return maps;
    }

    public static boolean isLeafNode(Object curNode) {
        return !(LinkedHashMap.class.getName().equals(curNode.getClass().getName()) || Node.class.getName().equals(curNode.getClass().getName()));
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
//                System.out.println(subValueKey)
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

    private static void sortByDependency() {

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
        ArrayList<String> nodeNames = new ArrayList(nodeTemplate.keySet());
        for (int i = 0; i < nodeTemplate.size(); i++) {
            nodeWithDependency = new NodeWithDependency(nodeNames.get(i));
//            System.out.println(nodeTemplate.get(nodeNames.get(i)));
//            System.out.println(((Map) nodeTemplate.get(nodeNames.get(i))).containsKey("requirements"));
//            System.out.println(nodeWithDependency.name);
//            System.out.println(((Map) nodeTemplate.get(nodeNames.get(i))));
//            Map tmpNode = ((Map) nodeTemplate.get(nodeNames.get(i)));
//            for (Object key : tmpNode.keySet()) {
//                System.out.println(tmpNode.get(key));
//                System.out.println(key);
//            }
//            System.out.println(((Map) nodeTemplate.get(nodeNames.get(i))).get("requirements"));
            if (((Map) nodeTemplate.get(nodeNames.get(i))).containsKey("requirements")) {
//                System.out.println(((Map) nodeTemplate.get(nodeNames.get(i))).get("requirements"));
                ArrayList<Map> curNode = new ArrayList<>((ArrayList) ((Map) nodeTemplate.get(nodeNames.get(i))).get("requirements"));
//                System.out.println(curNode);
                Iterator<Map> it = curNode.iterator();
                do {
                    nodeWithDependency.dependencyList.add((String) it.next().values().iterator().next());
//                    System.out.println(nodeWithDependency.dependencyList);
                } while (it.hasNext());
            }
            dependencyList.add(nodeWithDependency);
//            System.out.println(dependencyList);
        }
        nodeNames.clear();

        System.out.println(dependencyList);
        do {
            for (int i = 0; i < dependencyList.size(); i++) {
                if (dependencyList.get(i).dependencyList.isEmpty()) {
                    for (int j = 0; j < dependencyList.size(); j++) {
                        System.out.println(dependencyList.get(i).name);
                        dependencyList.get(j).dependencyList.remove(dependencyList.get(i).name);
                        System.out.println(dependencyList.get(j).dependencyList);
                    }
                    nodeNames.add(dependencyList.get(i).name);
                    dependencyList.remove(i);
                    i--;
                }
                System.out.println("nodeName: " + nodeNames);
            }
        } while (!dependencyList.isEmpty());
        System.out.println(nodeNames);
//        System.out.println(nodeNames);

        List<Map.Entry> entries =
                new ArrayList(nodeTemplate.entrySet());

        List<Map.Entry> resultEntries = new ArrayList();

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

//    class
}
