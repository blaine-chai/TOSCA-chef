package kr.ac.hanyang.model.collection; /**
 * 3.8.2.5 groups
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.GroupDefinition;
import kr.ac.hanyang.model.definition.ParameterDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * list of GroupType
 *
 * Grammar
 * groups:
 * <group_defn_1>
 * ...
 * <group_defn_n>
*/

//TODO:list
public class Groups extends CollectionValidator{

    public ArrayList<GroupDefinition> groupDefinitions = new ArrayList<>();

    public Groups() {
    }

    public Groups(LinkedHashMap data) {
        super();
        this.data = data;

        for (Object o : data.values()) {
            groupDefinitions.add(new GroupDefinition((Map) o));
        }
    }
}