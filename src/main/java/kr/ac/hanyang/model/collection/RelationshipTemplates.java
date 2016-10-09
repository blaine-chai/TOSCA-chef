package kr.ac.hanyang.model.collection;
/**
 * 3.8.2.3 relationship_templates
 */

import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;

import java.util.Map;

/**
 * Grammar
 * relationship_templates:
 * <relationship_template_defn_1>
 * ...
 * <relationship_template_defn_n>
 */

public class RelationshipTemplates extends ValidatorModel{
    public RelationshipTemplates() {
    }

    public RelationshipTemplates(Map data) {
        super();
        this.data = data;
    }
}
