package kr.ac.hanyang.model.collection; /**
 * 3.8.2.2 node_templates
 */


import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;

import java.util.Map;

/**
 * Grammar
 * node_templates:
 * <node_template_defn_1>
 * ...
 * <node_template_defn_n>
 */

public class NodeTemplates extends CollectionValidator{
    public NodeTemplates() {
    }

    public NodeTemplates(Map data) {
        super();
        this.data = data;
    }
}