package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.12 Parameter definition
 *
 * Keyname
 Required
 type
 Constraints
 Description

 type
 no
 string
 None
 The required data type for the parameter.Note: This keyname is required for a TOSCA Property definition, but is not for a TOSCA Parameter definition.

 value
 no
 <any>
 N/A
 The type-compatible value to assign to the named parameter. Parameter values may be provided as the result from the evaluation of an expression or a function.



 * Grammar
 * <parameter_name>:
     type: <parameter_type>
     description: <parameter_description>
     value: <parameter_value> | { <parameter_value_expression> }
     required: <parameter_required>
     default: <parameter_default_value>
     status: <status_value>
     constraints:
       - <parameter_constraints>
     entry_schema:
       description: <entry_description>
       type: <entry_type>
       constraints:
         - <entry_constraints>

 parameter_name: represents the required symbolic name of the parameter as a string.
 parameter_description: represents the optional description of the parameter.
 parameter_type: represents the optional data type of the parameter. Note, this keyname is required for
 a TOSCA Property definition, but is not for a TOSCA Parameter definition.
 parameter_value, parameter_value_expresssion: represent the type-compatible value to assign to the named parameter. Parameter values may be provided as the result from the evaluation of an expression or a function.
 parameter_required: represents an optional boolean value (true or false) indicating whether or not the parameter is required. If this keyname is not present on a parameter definition, then the property SHALL be considered required (i.e., true) by default.
 default_value: contains a type-compatible value that may be used as a default if not provided by another means.
 status_value: a string that contains a keyword that indicates the status of the parameter relative to the specification or implementation.
 parameter_constraints: represents the optional sequenced list of one or more constraint clauses on the parameter definition.
 entry_description: represents the optional description of the entry schema.
 entry_type: represents the required type name for entries in a list or map parameter type.
 entry_constraints: represents the optional sequenced list of one or more constraint clauses on
 entries in a list or map parameter type.
 */
public class ParameterDefinition extends DefinitionValidator {

    public String parameterName;

    public String type;
    public String value;

    public ParameterDefinition(){}

    public ParameterDefinition(Map data, String parameterName) {
        super();
        this.data = data;
        this.parameterName =parameterName;
        keyNames.add(new KeyName("type", false, "string", "The required data type for the parameter.Note: This keyname is required for a TOSCA Property definition, but is not for a TOSCA Parameter definition.", "None"));
        keyNames.add(new KeyName("value", false, "<any>", "The type-compatible value to assign to the named parameter. Parameter values may be provided as the result from the evaluation of an expression or a function.", "N/A"));
        for(Object key:data.keySet()){
            this.type=key.toString();
            this.value = data.get(key).toString();
        }
    }

}
