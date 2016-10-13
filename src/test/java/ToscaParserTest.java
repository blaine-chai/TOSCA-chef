import kr.ac.hanyang.ChefUtil;
import kr.ac.hanyang.Constants;
import kr.ac.hanyang.ToscaParser;
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
public class ToscaParserTest extends LinkedHashMap {
    @Test
    public void topologyTemplateTest() {
        Map map;
        Yaml yaml = new Yaml();
        NodeTemplate nodeTemplate;
        FileInputStream fileInputStream;
        ServiceTemplate serviceTemplate;
        try {

             fileInputStream = new FileInputStream(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_1);
            map = (Map) yaml.load(fileInputStream);
            serviceTemplate = new ServiceTemplate(map);
            System.out.println(serviceTemplate.isValid());
            /////////////////////
            fileInputStream = new FileInputStream(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_4);
            map = (Map) yaml.load(fileInputStream);
            serviceTemplate = new ServiceTemplate(map);
            System.out.println(serviceTemplate.isValid());


            ///////////////////////////////////////////


            fileInputStream = new FileInputStream(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_3);
            map = (Map) yaml.load(fileInputStream);
            serviceTemplate = new ServiceTemplate(map);
            System.out.println(serviceTemplate.isValid());
            //////////////////////

            fileInputStream = new FileInputStream(Constants.TOSCA_FILE_PATH + Constants.TOSCA_FILE_NAME);
            map = (Map) yaml.load(fileInputStream);
            serviceTemplate = new ServiceTemplate(map);
            System.out.println(serviceTemplate.isValid());
            System.out.println(serviceTemplate.description);
            System.out.println(serviceTemplate.topology_template.inputs);
            System.out.println(serviceTemplate.topology_template.node_templates.nodeTemplates.get(0).requirements);

            TopologyTemplate topologyTemplate = new TopologyTemplate();




//            ToscaParser parser = new ToscaParser(Constants.TOSCA_TEST_FILE_PATH + Constants.TOSCA_FILE_NAME_TEST_1);
////        ToscaParser parser = new ToscaParser(Constants.TOSCA_FILE_PATH + "master-service-template-application.yml");
//
//            ChefUtil chefUtil = new ChefUtil(Constants.CHEF_PROJECT_PATH, Constants.TOSCA_FILE_PATH);
//            chefUtil.createCookbooks(parser);
//            chefUtil.addInterface(parser);
//            chefUtil.uploadCookbooks();
//            chefUtil.bootstrap(Constants.NODE_NAME, Constants.NODE_URL, parser);
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
