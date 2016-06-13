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

    public ToscaInputs inputs = new ToscaInputs();
    public NodeTemplate nodeTemplate = new NodeTemplate();
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

    public void sortByDependency() {
        List<Map.Entry> entries =
                new ArrayList(nodeTemplate.entrySet());

        List<Map.Entry> resultEntries = new ArrayList();

//        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
//                return a.getValue().compareTo(b.getValue());
//            }
//        });
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
    }

//    class
}
