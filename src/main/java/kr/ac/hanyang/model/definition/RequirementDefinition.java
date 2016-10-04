package kr.ac.hanyang.model.definition; /**
 *3.6.2 Requirement definition
 */

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.DefinitionKeyName;
import kr.ac.hanyang.model.DefinitionKeyNames;

/**
 * Keyname
 * Requred
 * Type
 * Constraints
 * Description

capability
yes
string
N/A
The required reserved keyname used that can be used to provide the name of a valid Capability Type that can fulfill the requirement.

node
no
string
N/A
The optional reserved keyname used to provide the name of a valid Node Type that contains the capability definition that can be used to fulfill the requirement.

relationship
no
string
N/A
The optional reserved keyname used to provide the name of a valid Relationship Type to construct when fulfilling the requirement.

occurrences
no
range of integer
implied default of [1,1]
The optional minimum and maximum occurrences for the requirement. Note: the keyword UNBOUNDED is also supported to represent any positive integer.

 *3.6.2.1.1 Additional Keynames for multi-line relationship grammar

/**
 * Keyname
 * Requred
 * Type
 * Constraints
 * Description

type
yes
string
N/A
The optional reserved keyname used to provide the name of the Relationship Type for the requirement definition’s relationship keyname.

interfaces
no
list of interface definitions
N/A
The optional reserved keyname used to reference declared (named) interface definitions of the corresponding Relationship Type in order to declare additional Property definitions for these interfaces or operations of these interfaces.

 * Grammar
 * Simple grammar
 * <requirement_name>: <capability_type_name>
 * 
 * Extended grammar
 * <requirement_name>:
 * capability: <capability_type_name>
 * node: <node_type_name>
 * relationship: <relationship_type_name>
 * occurrences: [ <min_occurrences>, <max_occurrences> ]
 * 
 * Extended grammar for declaring Property Definitions on the relationship’s Interfaces
 * <requirement_name>:
 * # Other keynames omitted for brevity
 * relationship:
 * type: <relationship_type_name>
 * interfaces:
 * <interface_definitions>
 * <p>
 * requirement_name: represents the required symbolic name of the requirement definition as a string.
 * capability_type_name: represents the required name of a Capability type that can be used to fulfill the requirement.
 * node_type_name: represents the optional name of a TOSCA Node Type that contains the Capability Type definition the requirement can be fulfilled by.
 * relationship_type_name: represents the optional name of a Relationship Type to be used to construct a relationship between this requirement definition (i.e., in the source node) to a matching capability definition (in a target node).
 * min_occurrences, max_occurrences: represents the optional minimum and maximum occurrences of the requirement (i.e., its cardinality).
 * interface_definitions: represents one or more already declared interface definitions in the Relationship Type (as declared on the type keyname) allowing for the declaration of new Property definition for these interfaces or for specific Operation definitions of these interfaces.
 * 
 * 
 * 
 * 
 * 
 * 
 */

//TODO: if relationship is defined in requirement key, there should be type definition is needed for relationships
public class RequirementDefinition implements ToscaValidator {

    private DefinitionKeyNames keyNames;

    public RequirementDefinition() {
        super();
        keyNames = new DefinitionKeyNames();
        keyNames.add(new DefinitionKeyName("capability", true, "string", "The required reserved keyname used that can be used to provide the name of a valid Capability Type that can fulfill the requirement.", "N/A"));
        keyNames.add(new DefinitionKeyName("node", false, "string", "The optional reserved keyname used to provide the name of a valid Node Type that contains the capability definition that can be used to fulfill the requirement.", "N/A"));
        keyNames.add(new DefinitionKeyName("relationship", false, "string", "The optional reserved keyname used to provide the name of a valid Node Type that contains the capability definition that can be used to fulfill the requirement.", "N/A"));
        keyNames.add(new DefinitionKeyName("occurrences", false, "range of integer", "The optional minimum and maximum occurrences for the requirement. Note: the keyword UNBOUNDED is also supported to represent any positive integer.", "implied default of [1,1]"));
    }

    public boolean isValid() {
        return false;
    }
}


