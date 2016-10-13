package kr.ac.hanyang.model.assignment;
/**
 * 3.7.2 Requirement assignment
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.basemodel.validator.AssignmentValidator;

import java.util.ArrayList;
import java.util.Map;

/**
 * Keyname
 * Requred
 * type
 * Description

capability
no
string
The optional reserved keyname used to provide the name of either a:
 Capability definition within a target node template that can fulfill the requirement.
 Capability type that the provider will use to select a type-compatible target node template to fulfill the requirement at runtime.

node
no
string
   The optional reserved keyname used to identify the target node of a relationship. specifically, it is used to provide either a:
 Node Template name that can fulfill the target node requirement.
 Node type name that the provider will use to select a type-compatible node template to fulfill the requirement at runtime.

relationship
no
string
   The optional reserved keyname used to provide the name of either a:
 Relationship Template to use to relate the source node to the (capability in the) target node when fulfilling the requirement.
 Relationship type that the provider will use to select a type-compatible relationship template to relate the source node to the target node at runtime.

node_filter
no
node filter
 The optional filter definition that TOSCA orchestrators or providers would use to select a type-compatible target node that can fulfill the associated abstract requirement at runtime.



 relationship
type
no
string
The optional reserved keyname used to provide the name of the Relationship type for the requirement assignment’s relationship keyname.

properties
no
list of interface definitions
The optional reserved keyname used to reference declared (named) interface definitions of the corresponding Relationship type in order to provide Property assignments for these interfaces or operations of these interfaces.

 * Grammar
 * Short notation
 * <requirement_name>: <node_template_name>
 * 
 * Extended notation:
 * <requirement_name>:
 * node: <node_template_name> | <node_type_name>
 * relationship: <relationship_template_name> | <relationship_type_name>
 * capability: <capability_symbolic_name> | <capability_type_name>
 * node_filter:
 * <node_filter_definition>
 * occurrences: [ min_occurrences, max_occurrences ]
 * 
 * Extended grammar with Property Assignments for the relationship’s Interfaces
 * <requirement_name>:
 * # Other keynames omitted for brevity
 * relationship:
 * type: <relationship_template_name> | <relationship_type_name>
 * properties:
 * <property_assignments>
 * interfaces:
 * <interface_assignments>
 * 
 * <p>
 * requirement_name: represents the symbolic name of a requirement assignment as a string.
 * node_template_name: represents the optional name of a Node Template that contains the capability this requirement will be fulfilled by.
 * relationship_template_name: represents the optional name of a Relationship type to be used when relating the requirement appears to the capability in the target node.
 * capability_symbolic_name: represents the optional ordered list of specific, required capability type or named capability definition within the target Node type or Template.
 * node_type_name: represents the optional name of a TOSCA Node type the associated named requirement can be fulfilled by. This must be a type that is compatible with the Node type declared on the matching requirement (same symbolic name) the requirement’s Node Template is based upon.
 * relationship_type_name: represents the optional name of a Relationship type that is compatible with the Capability type in the target node.
 * property_assignments: represents the optional list of property value assignments for the declared relationship.
 * interface_assignments: represents the optional list of interface definitions for the declared relationship used to provide property assignments on inputs of interfaces and operations.
 * capability_type_name: represents the optional name of a Capability type definition within the target Node type this requirement needs to form a relationship with.
 * node_filter_definition: represents the optional node filter TOSCA orchestrators would use to fulfill the requirement for selecting a target node. Note that this SHALL only be valid if the node keyname’s value is a Node type and is invalid if it is a Node Template.
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class RequirementAssignment extends AssignmentValidator{
    public ArrayList<PropertyAssignment> properties = new ArrayList<>();
    public ArrayList<AttributeAssignment> attributes = new ArrayList<>();
    public ArrayList requirements;

    public RequirementAssignment(){

    }

    public RequirementAssignment(ArrayList data) {
        super();
        this.requirements = data;
        keyNames.add(new KeyName("capability", false, "string", "The optional reserved keyname used to provide the name of either a:\n" +
                "\uF0B7 Capability definition within a target node template that can fulfill the requirement.\n" +
                "\uF0B7 Capability type that the provider will use to select a type-compatible target node template to fulfill the requirement at runtime."));
        keyNames.add(new KeyName("node", false, "string", "node\n" +
                "no\n" +
                "string\n" +
                "   The optional reserved keyname used to identify the target node of a relationship. specifically, it is used to provide either a:\n" +
                "\uF0B7 Node Template name that can fulfill the target node requirement.\n" +
                "\uF0B7 Node type name that the provider will use to select a type-compatible node template to fulfill the requirement at runtime."));
        keyNames.add(new KeyName("relationship", false, "string", "The optional reserved keyname used to provide the name of either a:\n" +
                "\uF0B7 Relationship Template to use to relate the source node to the (capability in the) target node when fulfilling the requirement.\n" +
                "\uF0B7 Relationship type that the provider will use to select a type-compatible relationship template to relate the source node to the target node at runtime."));
        keyNames.add(new KeyName("node_filter", false, "string", "The optional filter definition that TOSCA orchestrators or providers would use to select a type-compatible target node that can fulfill the associated abstract requirement at runtime."));
    }

}