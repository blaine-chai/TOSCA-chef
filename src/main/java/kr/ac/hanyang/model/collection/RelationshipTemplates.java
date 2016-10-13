package kr.ac.hanyang.model.collection;
/**
 * 3.8.2.3 relationship_templates
 */

import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;
import kr.ac.hanyang.model.template.RelationshipTemplate;

import java.util.ArrayList;
import java.util.Map;

/**
 * Grammar
 * relationship_templates:
 * <relationship_template_defn_1>
 * ...
 * <relationship_template_defn_n>
 */
//list
public class RelationshipTemplates extends ValidatorModel{

    public ArrayList<RelationshipTemplate> relationshipTemplates = new ArrayList<>();

    public RelationshipTemplates() {
    }

    public RelationshipTemplates(Map data) {
        super();
        this.data = data;
        for (Object o : data.values()) {
            relationshipTemplates.add(new RelationshipTemplate((Map) o));
        }
    }
}
