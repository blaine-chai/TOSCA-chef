package com.blainechai;

import com.blainechai.model.Node;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by blainechai on 2016. 4. 12..
 */

@SuppressWarnings("unchecked")
public class Program {

    public static void main(String[] args) {
        YamlParser parser = new YamlParser();

        parser.getToscaFile(Constants.TOSCA_FILE_PATH + "wordpress_server.yaml");
        parser.getNodeTemplete(YamlParser.map);

        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Node> nodes2 = new ArrayList<Node>();
        parser.getParentNodeByKey(YamlParser.map, "type", null, nodes);
//        System.out.println(parser.getNodeByKey(YamlParser.map, "type"));

//        parser.getNodeTemplete(YamlParser.map);
        System.out.println(nodes);
        System.out.println();

        for (Node node : nodes) {
            System.out.println(node.getAttribute());
        }

        System.out.println();
        parser.getNodeByKey(YamlParser.map, "mysql_dbms", nodes2);
        for (Node node : nodes2) {
            System.out.println(node.getAttribute());
            System.out.println(node.keySet());
        }


        for (Object key : parser.nodeTemplate.keySet()){
            System.out.println(parser.nodeTemplate.get(key));
        }

//        parser.getNodeTemplete()
    }

}
