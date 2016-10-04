package kr.ac.hanyang.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by blainechai on 2016. 6. 7..
 */
public class Node extends LinkedHashMap {
    private String attribute;

    public Node() {
    }


    public Node(Map node, String attribute) {
        super(node);
        this.attribute = attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }
}
