package com.blainechai;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by blainechai on 2016. 4. 12..
 */

@SuppressWarnings("unchecked")
public class Program {

    public static void main(String[] args) {
        YamlParser parser = new YamlParser();
        parser.traverse("sample_yaml.yaml");

        ArrayList<Map> maps  = new ArrayList<Map>();

//        parser.makeNodeTemplete()
    }

}
