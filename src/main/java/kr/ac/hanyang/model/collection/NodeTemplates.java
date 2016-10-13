package kr.ac.hanyang.model.collection; /**
 * 3.8.2.2 node_templates
 */


import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.ParameterDefinition;
import kr.ac.hanyang.model.template.NodeTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Grammar
 * node_templates:
 * <node_template_defn_1>
 * ...
 * <node_template_defn_n>
 */


//TODO:list
public class NodeTemplates extends CollectionValidator {

    public ArrayList<NodeTemplate> nodeTemplates = new ArrayList<>();

    public NodeTemplates() {
    }

    public NodeTemplates(LinkedHashMap data) {
        super();

        this.data = data;
        for (Object key : data.keySet()) {
            nodeTemplates.add(new NodeTemplate(key.toString(), (Map) data.get(key)));
        }

//        for (Object o : data.values()) {
//            nodeTemplates.add(new NodeTemplate(o.toString(), (Map) o));
//        }
    }

    @Override
    public String toString() {
        String rtn = "";
        for (NodeTemplate nodeTemplate : nodeTemplates) {
            rtn += nodeTemplate.nodeName;
        }
        return super.toString();
    }

    @Override
    public boolean isValid() {
        for(NodeTemplate nodeTemplate:nodeTemplates){
            if(!nodeTemplate.isValid()){
                return false;
            }
        }
        return true;
    }
}