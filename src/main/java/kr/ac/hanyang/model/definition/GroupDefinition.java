package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 10. 10..
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;

import java.util.Map;

/**
 * 3.7.5 Group definition
 * <p>
 * <p>
 * Keyname
 * Required
 * Type
 * Description
 * <p>
 * type
 * yes
 * string
 * The required name of the group type the group definition is based upon.
 * <p>
 * description
 * no
 * description
 * The optional description for the group definition.
 * <p>
 * properties
 * no
 * list of property assignments
 * An optional list of property value assignments for the group definition.
 * <p>
 * members
 * no
 * list of string
 * The optional list of one or more node template names that are members of this group definition.
 * <p>
 * interfaces
 * no
 * list of interface definitions
 * An optional list of named interface definitions for the group definition.
 */
public class GroupDefinition extends DefinitionValidator {

    public GroupDefinition() {
    }

    public GroupDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required name of the group type the group definition is based upon."));
        keyNames.add(new KeyName("description", false, "description", " An optional description for the Relationship Template."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the group definition."));
        keyNames.add(new KeyName("members", false, "list of string", "The optional list of one or more node template names that are members of this group definition."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of named interface definitions for the group definition."));
    }
}
