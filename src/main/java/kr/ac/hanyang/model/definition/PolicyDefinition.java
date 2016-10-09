package kr.ac.hanyang.model.definition;

import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

import java.util.LinkedHashMap;
import java.util.Map;

/** 3.7.6 Policy definition
 */

/**
 * Keyname
 * Requred
 * type
 * Description

 type
 yes
 string
 The required name of the policy type the policy definition is based upon.

 description
 no
 description
 The optional description for the policy definition.

 properties
 no list of property assignments
 An optional list of property value assignments for the policy definition.

 targets
 no
 string[]
 An optional list of valid Node Templates or Groups the Policy can be applied to.

 /**
 * Grammar
 * <policy_name>:
 * type: <policy_type_name>
 * description: <policy_description>
 * properties:
 * <property_assignments>
 * targets: [<list_of_policy_targets>]
 *
 * policy_name: represents the required symbolic name of the policy as a string.
 * policy_type_name: represents the name of the policy the definition is based upon.
 * policy_description: contains an optional description of the policy.
 * property_assignments: represents the optional list of property assignments for the policy definition that provide values for properties defined in its declared Policy type.
 * list_of_policy_targets: represents the optional list of names of node templates or groups that the policy is to applied to.
 */

//TODO: PolicyType의 list로 구현하여 어떤 모양을 지정하는 방식으로 구현

public class PolicyDefinition extends DefinitionValidator {

    public PolicyDefinition(){}

    public PolicyDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required name of the policy type the policy definition is based upon."));
        keyNames.add(new KeyName("description" , false, "description", "The optional description for the policy definition."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the policy definition."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Templates or Groups the Policy can be applied to."));


    }


}