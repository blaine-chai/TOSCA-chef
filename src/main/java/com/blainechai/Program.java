package com.blainechai;

/**
 * Created by blainechai on 2016. 4. 12..
 */

@SuppressWarnings("unchecked")
public class Program {

    public static void main(String[] args) {
        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);

        System.out.println(parser.inputs);
//        ChefUtil chef = new ChefUtil();

//        parser.getToscaFile(Constants.TOSCA_FILE_PATH + "wordpress_server.yaml");
//        parser.setNodeTemplate(ToscaParser.map);

//        ArrayList<Node> nodes = new ArrayList<Node>();
//        ArrayList<Node> nodes2 = new ArrayList<Node>();
//        parser.getParentNodeByKey(YamlParser.map, "type", null, nodes);
//        System.out.println(parser.getNodeByKey(YamlParser.map, "type"));

//        parser.setNodeTemplate(YamlParser.map);
//        System.out.println(nodes);
//        System.out.println();

//        for (Node node : nodes) {
//            System.out.println(node.getAttribute());
//        }

//        System.out.println();
//        parser.getNodeByKey(YamlParser.map, "mysql_dbms", nodes2);
        /*for (Node node : nodes2) {
            System.out.println(node.getAttribute());
            System.out.println(node.keySet());
        }*/

//        System.out.println("!!!!!!!!!!!!!!!" + parser.nodeTemplate.keySet());
//        System.out.println(parser.nodeTemplate);

        ChefUtil.createCookbooks(parser);
    }

}
