package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.6.11 Policy type
 */

/**
 * Keyname
 * Requred
 * type
 * Description

 derived_from
 no
 string
 An optional parent Policy type name the Policy type derives from.

 version
 no
 version
 An optional version for the Policy type definition.

 description
 no
 description
 The optional description for the Policy type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Policy type.

 targets
 no
 string[]
 An optional list of valid Node Types or Group Types the Policy type can be applied to.

 * Grammar
 * derived_from: <parent_policy_type_name>
 * version: <version_number>
 * description: <policy_description>
 * properties:
 * <property_definitions>
 * targets: [ <list_of_valid_target_types> ]
 *
 * <p>
 * policy_type_name: represents the required symbolic name of the Policy type being declared as a string.
 * parent_policy_type_name: represents the name (string) of the Policy type this Policy type definition derives from (i.e., its “parent” type).
 * version_number: represents the optional TOSCA version number for the Policy type.
 * policy_description: represents the optional description string for the corresponding policy_type_name.
 * property_definitions: represents the optional list of property definitions for the Policy type.
 * list_of_valid_target_types: represents the optional list of TOSCA types (i.e., Group or Node Types) that are valid targets for this Policy type.
 *
 *
 *
 */

public class PolicyType extends TypeValidator{

    public PolicyType(){
        super();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy type name the Policy type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy type can be applied to."));
    }

    public PolicyType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy type name the Policy type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy type can be applied to."));
    }
    public KeyNames getKeyNames() {
        return keyNames;
    }


}