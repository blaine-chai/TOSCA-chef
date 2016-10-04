package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.DefinitionKeyName;
import kr.ac.hanyang.model.DefinitionKeyNames;

/**
 * 3.5.8 Property definition
 * The value of a property can be retrieved using the get_property function within TOSCA Service Templates.
 *
 * reflected by attribute definition
 *
 *
 * Keynames*
 Keyname
 Required
 Type
 Constraints
 Description

 type
 yes
 string
 None
 The required data type for the property.

 description
 no
 description
 None
 The optional description for the property.

 required
 no
 boolean
 default: true
 An optional key that declares a property as required (true) or not (false).

 default
 no
 <any>
 None
 An optional key that may provide a value to be used as a default if not provided by another means.

 status
 no
 string
 default: supported
 The optional status of the property relative to the specification or implementation. See table below for valid values.

 constraints
 no
 list of constraint clauses
 None
 The optional list of sequenced constraint clauses for the property.

 entry_schema
 no
 string
 None
 The optional key that is used to declare the name of the Datatype definition for entries of set types such as the TOSCA list or map.


 * status values *
 * supported
 * unsupported
 * experimental
 * deprecated
 *
 * Grammar
 *
 * property_name>:
 type: <property_type>
 description: <property_description> required: <property_required> default: <default_value>
 status: <status_value>
 constraints:
 - <property_constraints>
 entry_schema:
 description: <entry_description>
 type: <entry_type>
 constraints:
 - <entry_constraints>

 *
 * property_name: represents the required symbolic name of the property as a string.
 property_description: represents the optional description of the property.
 property_type: represents the required data type of the property.
 property_required: represents an optional boolean value (true or false) indicating whether or not the
 property is required. If this keyname is not present on a property definition, then the property SHALL be
 considered required (i.e., true) by default.
 default_value: contains a type-compatible value that may be used as a default if not provided by
 another means.
 status_value: a string that contains a keyword that indicates the status of the property relative to the
 specification or implementation.
 property_constraints: represents the optional sequenced list of one or more constraint clauses on
 the property definition.
 entry_description: represents the optional description of the entry schema.
 entry_type: represents the required type name for entries in a list or map property type.
 entry_constraints: represents the optional sequenced list of one or more constraint clauses on
 entries in a list or map property type.
 */
//// TODO: 2016. 10. 4. constraints
public class PropertyDefinition implements ToscaValidator {

    private DefinitionKeyNames keyNames;

    public PropertyDefinition() {
        super();
        keyNames = new DefinitionKeyNames();
        keyNames.add(new DefinitionKeyName("type", true, "string", "The required data type for the property.", "None"));
        keyNames.add(new DefinitionKeyName("description", false, "description", "The optional description for the property.", "None"));
        keyNames.add(new DefinitionKeyName("required", false, "boolean", "An optional key that declares a property as required (true) or not (false).", "default: true"));
        keyNames.add(new DefinitionKeyName("default", false, "<any>", "An optional key that may provide a value to be used as a default if not provided by another means.", "None"));
        keyNames.add(new DefinitionKeyName("status", false, "string", "The optional status of the property relative to the specification or implementation. See table below for valid values.", "default: supported"));
        keyNames.add(new DefinitionKeyName("constraints", false, "list of constraint clauses", "The optional list of sequenced constraint clauses for the property.", "None"));
        keyNames.add(new DefinitionKeyName("entry_schema", false, "string", "The optional key that is used to declare the name of the Datatype definition for entries of set types such as the TOSCA list or map.", "None"));
    }

    public boolean isValid() {
        return false;
    }
}