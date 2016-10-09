import kr.ac.hanyang.Constants;
import kr.ac.hanyang.model.template.NodeTemplate;
import kr.ac.hanyang.model.template.ServiceTemplate;
import kr.ac.hanyang.model.template.TopologyTemplate;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by blainechai on 2016. 10. 5..
 */
public class ToscaParserTest extends LinkedHashMap{
    @Test
    public void topologyTemplateTest() {
        Map<String, Map> map;
        Yaml yaml = new Yaml();
        try {
            FileInputStream fileInputStream = new FileInputStream(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
            map = (Map) yaml.load(fileInputStream);

//            System.out.println(map.keySet());
            map = (Map)map.get("topology_template");
//            System.out.println(map);

////            System.out.println(map.get("outputs"));
//            map = map.get("outputs");
//
//            System.out.println(map);
//            map = map.get("website_url");
//            System.out.println(map);
//            map = map.get("value");
//            System.out.println(map);
//            Object obj = map.get("get_attribute");
//            System.out.println(obj.getClass());
//            System.out.println(map);
            map = map.get("node_templates");
            map= map.get("wordpress");
//            map = map.get("requirements");
            System.out.println(map);
            System.out.println(map.get("host"));
            System.out.println(map);


            NodeTemplate nodeTemplate = new NodeTemplate();
//
//            nodeTemplate.setData(map);
//            System.out.println(nodeTemplate.getData());
//            System.out.println(nodeTemplate.isValid());


            ///////////////////////////////////////////


            fileInputStream = new FileInputStream(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_2);
            map = (Map) yaml.load(fileInputStream);

//            System.out.println(map.keySet());
            map = (Map)map.get("topology_template");
//            System.out.println(map);

////            System.out.println(map.get("outputs"));
//            map = map.get("outputs");
//
//            System.out.println(map);
//            map = map.get("website_url");
//            System.out.println(map);
//            map = map.get("value");
//            System.out.println(map);
//            Object obj = map.get("get_attribute");
//            System.out.println(obj.getClass());
//            System.out.println(map);
            map = map.get("node_templates");
            map= map.get("wordpress");


            nodeTemplate = new NodeTemplate();

            nodeTemplate.setData(map);
            System.out.println(nodeTemplate.getData());
            System.out.println(nodeTemplate.isValid());

            ///////////////////////////////////////////


            fileInputStream = new FileInputStream(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
            map = (Map) yaml.load(fileInputStream);

//            System.out.println(map.keySet());
            map = (Map)map.get("topology_template");
//            System.out.println(map);

////            System.out.println(map.get("outputs"));
//            map = map.get("outputs");
//
//            System.out.println(map);
//            map = map.get("website_url");
//            System.out.println(map);
//            map = map.get("value");
//            System.out.println(map);
//            Object obj = map.get("get_attribute");
//            System.out.println(obj.getClass());
//            System.out.println(map);
            map = map.get("node_templates");
            map= map.get("wordpress");


            nodeTemplate = new NodeTemplate();

            nodeTemplate.setData(map);
            System.out.println(nodeTemplate.getData());
            System.out.println(nodeTemplate.isValid());
//            Set set = map.entrySet();

//            TopologyTemplate topologyTemplate = new TopologyTemplate();

//            topologyTemplate.getKeyNames();
//            for(Object object:set){
////                System.out.println(object);
////                System.out.println();
//
//                System.out.println(((Map)((Map)((Map.Entry) object).getValue()).get("website_url")));
//            }

            fileInputStream = new FileInputStream(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
            map = (Map) yaml.load(fileInputStream);

//            System.out.println(map.keySet());
            ServiceTemplate serviceTemplate = new ServiceTemplate(map);
            serviceTemplate.setData(map);
            System.out.println(serviceTemplate.isValid());

            fileInputStream = new FileInputStream(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_4);
            map = (Map) yaml.load(fileInputStream);

//            System.out.println(map.keySet());
             serviceTemplate = new ServiceTemplate(map);
            serviceTemplate.setData(map);
            System.out.println(serviceTemplate.isValid());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (Object subValueKey : .keySet()) {
//            if (node.get(subValueKey) != null
//                    && LinkedHashMap.class.getName().equals(node.get(subValueKey).getClass().getName())) {
//                if (((String) subValueKey).equals("node_templates")) {
//                    for (Object key : ((Map) node.get(subValueKey)).keySet()) {
//                        nodeTemplate.put(key, ((Map) node.get(subValueKey)).get(key));
//                    }
//                    break;
//                }
//                setNodeTemplate((Map) node.get(subValueKey));
//            }
//        }

    }
}
