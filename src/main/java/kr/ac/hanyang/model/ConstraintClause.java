package kr.ac.hanyang.model;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.2 Constraint clause
 */

/**
 * Keyname 
 * Required
 * type
 * Description

 type
 yes
 string
 The required name of the group type the group definition is based upon.

 description
 no
 description
 The optional description for the group definition.

 properties
 no
 list of property assignments
 An optional list of property value assignments for the group definition.

 members
 no
 list of string
 The optional list of one or more node template names that are members of this group definition.

 interfaces
 no
 list of interface definitions
 An optional list of named interface definitions for the group definition.

 * Grammar 
 * <group_name>:
 * type: <group_type_name>
 * description: <group_description>
 * properties:
 * <property_assignments>
 * members: [ <list_of_node_templates> ]
 * interfaces:
 * <interface_definitions>
 *
 * <p>
 * group_name: represents the required symbolic name of the group as a string.
 * group_type_name: represents the name of the Group type the definition is based upon.
 * group_description: contains an optional description of the group.
 * property_assignments: represents the optional list of property assignments for the group definition that provide values for properties defined in its declared Group type.
 * list_of_node_templates: contains the required list of one or more node template names (within the same topology template) that are members of this logical group.
 * interface_definitions: represents the optional list of interface definitions for the group definition that augment those provided by its declared Group type.
 */

public class ConstraintClause extends ValidatorModel{

    public ConstraintClause(){}

    public ConstraintClause(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string ", "The required name of the group type the group definition is based upon."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the group definition."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the group definition."));
        keyNames.add(new KeyName("members", false, "list of string", "The optional list of one or more node template names that are members of this group definition."));
        keyNames.add(new KeyName("interfaces", false , "list of interface definitions", "An optional list of named interface definitions for the group definition."));
    }

}