package com.blainechai;

import com.blainechai.model.NodeTemplete;
import com.blainechai.model.TopologyTemplete;
import com.blainechai.model.ToscaInputs;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@SuppressWarnings("unchecked")
public class YamlParser {

    public ToscaInputs inputs = new ToscaInputs();
    public TopologyTemplete topologyTemplete = new TopologyTemplete();
    public NodeTemplete nodeTemplete = new NodeTemplete();

    public void traverse(String filePath) {
        Yaml yaml = new Yaml();

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Map map = (Map) yaml.load(fileInputStream);
            getInfo(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getInfo(Map node) {
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getInfo((Map) node.get(subValueKey));
            } else {
                System.out.println(subValueKey + ": " + node.get(subValueKey));
            }
        }
    }

    public TopologyTemplete makeTopologyTemplete(Map node) {

        TopologyTemplete topologyTemplete = new TopologyTemplete();
        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
                getInfo((Map) node.get(subValueKey));
            } else {
                System.out.println(node.get(subValueKey));
            }
        }
        return topologyTemplete;
    }


    public ArrayList<NodeTemplete> makeNodeTemplete(Map node, ArrayList<NodeTemplete> nodeTempletes) {

        for (Object subValueKey : node.keySet()) {
            if (node.get(subValueKey) != null
                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())
                    ) {
                getInfo((Map) node.get(subValueKey));
            } else {
                System.out.println(node.get(subValueKey));
                if (node.get(subValueKey).equals("node_templates")) {
                    NodeTemplete nodeTemplete = new NodeTemplete();
                    nodeTemplete.setData(new LinkedHashMap(node));
                    nodeTempletes.add(nodeTemplete);
                }
            }
        }
        return nodeTempletes;
    }
}
