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
public class YamlParser {

    public ToscaInputs inputs = new ToscaInputs();
    public TopologyTemplete topologyTemplete = new TopologyTemplete();
    public NodeTemplate nodeTemplate = new NodeTemplate();
    public static Map map;

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
//            getInfo(map);

            getNodeTemplete(map);
//            new Thread(new Runnable() {
//                public void run() {
//                    getNodeTemplete(map);
////                    System.out.println(nodeTemplate.keySet());
//                }
//            }).start();
//
////            getNodeTemplete(map);
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


    public void getNodeTemplete(Map node) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                if (((String) subValueKey).equals("node_templates")) {
//                    Object nodeTempateNode = node.get(subValueKey);
                    for (Object values : ((Map) node.get(subValueKey)).keySet()) {
                        nodeTemplate.put(values, ((Map) node.get(subValueKey)).get(subValueKey));
//                        System.out.println(values);
                    }
                    break;
                }
                getNodeTemplete((Map) node.get(subValueKey));
            }
        }
    }

    public ArrayList<Node> getParentNodeByKey(Map node, String key, String parentKey, ArrayList maps) {
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {

                maps.add(new Node(node, (String) parentKey));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
//                System.out.println(subValueKey);
                getParentNodeByKey((Map) node.get(subValueKey), key, (String) subValueKey, maps);
            }

        }
        return maps;
    }

    public boolean isLeafNode(Map curNode) {
        return LinkedHashMap.class.getName().equals(curNode.getClass().getName());
    }

    public ArrayList<Node> getNodeByKey(Map node, String key, ArrayList maps) {
        for (Object subValueKey : node.keySet()) {
            if (((String) subValueKey).equals(key)) {
                maps.add(new Node((Map) node.get(key), (String) key));
            }
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
//                System.out.println(subValueKey)
                getNodeByKey((Map) node.get(subValueKey), key, maps);
            }

        }
        return maps;
    }

    public 

    public void sortByDependency() {

    }
}
