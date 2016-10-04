package kr.ac.hanyang.model.Type;

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * 3.6.11 Policy Type
 */

/**
 * Keyname
 * Requred
 * Type
 * Description

 derived_from
 no
 string
 An optional parent Policy Type name the Policy Type derives from.

 version
 no
 version
 An optional version for the Policy Type definition.

 description
 no
 description
 The optional description for the Policy Type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Policy Type.

 targets
 no
 string[]
 An optional list of valid Node Types or Group Types the Policy Type can be applied to.

 * Grammar
 * derived_from: <parent_policy_type_name>
 * version: <version_number>
 * description: <policy_description>
 * properties:
 * <property_definitions>
 * targets: [ <list_of_valid_target_types> ]
 *
 * <p>
 * policy_type_name: represents the required symbolic name of the Policy Type being declared as a string.
 * parent_policy_type_name: represents the name (string) of the Policy Type this Policy Type definition derives from (i.e., its “parent” type). 
 * version_number: represents the optional TOSCA version number for the Policy Type.
 * policy_description: represents the optional description string for the corresponding policy_type_name.
 * property_definitions: represents the optional list of property definitions for the Policy Type.
 * list_of_valid_target_types: represents the optional list of TOSCA types (i.e., Group or Node Types) that are valid targets for this Policy Type.
 *
 *
 *
 */

public class PolicyType implements ToscaValidator {

    private KeyNames keyNames;

    public PolicyType() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy Type name the Policy Type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy Type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy Type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy Type can be applied to."));
    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

    public KeyNames getKeyNames() {
        return keyNames;
    }


}