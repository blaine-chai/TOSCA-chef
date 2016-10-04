package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.ToscaValidator;

/**
 * 3.8.1 TopologyTemplate
 */

/**
 * Keyname
 * Required
 * Type
 * Description

description 
no 
description 
The optional description for the Topology Template.

inputs 
no 
list of parameter definitions
An optional list of input parameters (i.e., as parameter definitions) for the Topology Template.

node_templates 
no 
list of node templates
An optional list of node template definitions for the Topology Template.

relationship_templates 
no 
list of relationship templates
An optional list of relationship templates for the Topology Template.

groups 
no 
list of group definitions
An optional list of Group definitions whose members are node templates defined within this same Topology Template.

policies 
no 
list of policy definitions
An optional list of Policy definitions for the Topology Template.

outputs 
no 
list of parameter definitions
An optional list of output parameters (i.e., as parameter definitions) for the Topology Template.

substitution_mappings 
no 
N/A 
An optional declaration that exports the topology template as an implementation of a Node type. This also includes the mappings between the external Node Types named capabilities and requirements to existing implementations of those capabilities and requirements on Node templates declared within the topology template.


/**
 * Grammar
 * topology_template:
 * description: <template_description>
 * inputs: <input_parameter_list>
 * outputs: <output_parameter_list>
 * node_templates: <node_template_list>
 * relationship_templates: <relationship_template_list>
 * groups: <group_definition_list>
 * policies:
 * - <policy_definition_list>
 * # Optional declaration that exports the Topology Template
 * # as an implementation of a Node Type.
 * substitution_mappings:
 * node_type: <node_type_name>
 * capabilities:
 * <map_of_capability_mappings_to_expose>
 * requirements:
 * <map_of_requirement_mapping_to_expose>
 * 
 * <p>
 * template_description: represents the optional description string for Topology Template.
 * input_parameter_list: represents the optional list of input parameters (i.e., as property definitions) for the Topology Template.
 * output_parameter_list: represents the optional list of output parameters (i.e., as property definitions) for the Topology Template.
 * group_definition_list: represents the optional list of group definitions whose members are node templates that also are defined within this Topology Template.
 * policy_definition_list: represents the optional sequenced list of policy definitions for the Topology Template.
 * node_template_list: represents the optional list of node template definitions for the Topology Template.
 * relationship_template_list: represents the optional list of relationship templates for the Topology Template.
 * node_type_name: represents the optional name of a Node Type that the Topology Template implements as part of the substitution_mappings.
 * map_of_capability_mappings_to_expose: represents the mappings that expose internal capabilities from node templates (within the topology template) as capabilities of the Node Type definition that is declared as part of the substitution_mappings.
 * map_of_requirement_mappings_to_expose: represents the mappings of link requirements of the Node Type definition that is declared as part of the substitution_mappings to internal requirements implementations within node templates (declared within the topology template).
 * 
 * 
 * 
 * Required
 * Type
 * Description
 */

public class TopologyTemplate implements ToscaValidator {

    private KeyNames keyNames;

    public TopologyTemplate() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Topology Template."));
        keyNames.add(new KeyName("inputs", false, "list of parameter definitions", "An optional list of input parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("node_templates", false, "list of node templates", "An optional list of node template definitions for the Topology Template."));
        keyNames.add(new KeyName("relationship_templates", false, "list of relationship templates", "An optional list of relationship templates for the Topology Template."));
        keyNames.add(new KeyName("groups", false, "list of group definitions", "An optional list of Group definitions whose members are node templates defined within this same Topology Template."));
        keyNames.add(new KeyName("policies", false, "list of policy definitions", "An optional list of Policy definitions for the Topology Template."));
        keyNames.add(new KeyName("outputs", false, "list of parameter definitions", "An optional list of output parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("substitution_mappings", false, "N/A", "An optional declaration that exports the topology template as an implementation of a Node type. This also includes the mappings between the external Node Types named capabilities and requirements to existing implementations of those capabilities and requirements on Node templates declared within the topology template."));
    }

    public boolean isValid() {
        return false;
    }
}