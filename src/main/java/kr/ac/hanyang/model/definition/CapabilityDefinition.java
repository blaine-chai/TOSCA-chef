package kr.ac.hanyang.model.definition;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.6.1 Capability definition
 */

/**
 * Keyname
 * Requred
 * type
 * Constraints
 * Description

 type
 yes
 string
 N/A
 The required name of the Capability type the capability

 description
 no
 description
 N/A
 The optional description of the Capability definition.

 properties
 no
 list of property definitions
 N/A
 An optional list of property definitions for the Capability definition.

 attributes
 no
 list of attribute definitions
 N/A
 An optional list of attribute definitions for the Capability definition.

 valid_source_types
 no
 string[]
 N/A
 An optional list of one or more valid names of Node Types that are supported as valid sources of any relationship established to the declared Capability type.abstract

 occurrences
 no
 range of integer
 implied default of [1,UNBOUNDED]
 The optional minimum and maximum occurrences for the capability. By default, an exported Capability should allow at least one relationship to be formed with it with a maximum of UNBOUNDED relationships. Note: the keyword UNBOUNDED is also supported to represent any positive integer.

 * Grammar
 * Short notation
 * <capability_definition_name>: <capability_type>
 *
 * Extended notation
 * <capability_definition_name>:
 * type: <capability_type>
 * description: <capability_description>
 * properties:
 * <property_definitions>
 * attributes:
 * <attribute_definitions>
 * valid_source_types: [ <node type_names> ]
 * <p>
 * capability_definition_name: represents the symbolic name of the capability as a string.
 * capability_type: represents the required name of a capability type the capability definition is based upon.
 * capability_description: represents the optional description of the capability definition.
 * property_definitions: represents the optional list of property definitions for the capability definition.
 * attribute_definitions: represents the optional list of attribute definitions for the capability definition.
 * node_type_names: represents the optional list of one or more names of Node Types that the Capability definition supports as valid sources for a successful relationship to be established to itself.
 *
 * Additional requirements
 * Any Node type (names) provides as values for the valid_source_types keyname SHALL be typecompatible (i.e., derived from the same parent Node type) with any Node Types defined using the same keyname in the parent Capability type.
 * Capability symbolic names SHALL be unique; it is an error if a capability name is found to occur more than once.

 */
//TODO: constraints

public class CapabilityDefinition extends DefinitionValidator {

    public CapabilityDefinition(){}

    public CapabilityDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required name of the Capability type the capability","N/A"));
        keyNames.add(new KeyName("description", false, "description", "The optional description of the Capability definition.","N/A"));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Capability definition.","N/A"));
        keyNames.add(new KeyName("attributes", false, "list of attribute definitions", "An optional list of attribute definitions for the Capability definition.","N/A"));
        keyNames.add(new KeyName("valid_source_types", false, "string[]", "An optional list of one or more valid names of Node Types that are supported as valid sources of any relationship established to the declared Capability type.abstract","N/A"));
        keyNames.add(new KeyName("occurrences", false, "range of integer", "The optional minimum and maximum occurrences for the capability. By default, an exported Capability should allow at least one relationship to be formed with it with a maximum of UNBOUNDED relationships. Note: the keyword UNBOUNDED is also supported to represent any positive integer.","implied default of [1,UNBOUNDED]"));


    }
}