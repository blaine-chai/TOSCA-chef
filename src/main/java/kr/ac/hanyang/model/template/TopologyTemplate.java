package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.collection.Inputs;
import kr.ac.hanyang.model.collection.NodeTemplates;
import kr.ac.hanyang.model.collection.Outputs;
import kr.ac.hanyang.model.definition.GroupDefinition;
import kr.ac.hanyang.model.definition.PolicyDefinition;
import kr.ac.hanyang.model.type.GroupType;
import kr.ac.hanyang.model.type.PolicyType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.8.1 TopologyTemplate
 */

/**
 * Keyname
 * Required
 * type
 * Description
 * <p>
 * description
 * no
 * description
 * The optional description for the Topology Template.
 * <p>
 * inputs
 * no
 * list of parameter definitions
 * An optional list of input parameters (i.e., as parameter definitions) for the Topology Template.
 * <p>
 * node_templates
 * no
 * list of node templates
 * An optional list of node template definitions for the Topology Template.
 * <p>
 * relationship_templates
 * no
 * list of relationship templates
 * An optional list of relationship templates for the Topology Template.
 * <p>
 * groups
 * no
 * list of group definitions
 * An optional list of Group definitions whose members are node templates defined within this same Topology Template.
 * <p>
 * policies
 * no
 * list of policy definitions
 * An optional list of Policy definitions for the Topology Template.
 * <p>
 * outputs
 * no
 * list of parameter definitions
 * An optional list of output parameters (i.e., as parameter definitions) for the Topology Template.
 * <p>
 * substitution_mappings
 * no
 * N/A
 * An optional declaration that exports the topology template as an implementation of a Node type. This also includes the mappings between the external Node Types named capabilities and requirements to existing implementations of those capabilities and requirements on Node templates declared within the topology template.
 * <p>
 * <p>
 * /**
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
 * # as an implementation of a Node type.
 * substitution_mappings:
 * node_type: <node_type_name>
 * capabilities:
 * <map_of_capability_mappings_to_expose>
 * requirements:
 * <map_of_requirement_mapping_to_expose>
 * <p>
 * <p>
 * template_description: represents the optional description string for Topology Template.
 * input_parameter_list: represents the optional list of input parameters (i.e., as property definitions) for the Topology Template.
 * output_parameter_list: represents the optional list of output parameters (i.e., as property definitions) for the Topology Template.
 * group_definition_list: represents the optional list of group definitions whose members are node templates that also are defined within this Topology Template.
 * policy_definition_list: represents the optional sequenced list of policy definitions for the Topology Template.
 * node_template_list: represents the optional list of node template definitions for the Topology Template.
 * relationship_template_list: represents the optional list of relationship templates for the Topology Template.
 * node_type_name: represents the optional name of a Node type that the Topology Template implements as part of the substitution_mappings.
 * map_of_capability_mappings_to_expose: represents the mappings that expose internal capabilities from node templates (within the topology template) as capabilities of the Node type definition that is declared as part of the substitution_mappings.
 * map_of_requirement_mappings_to_expose: represents the mappings of link requirements of the Node type definition that is declared as part of the substitution_mappings to internal requirements implementations within node templates (declared within the topology template).
 * <p>
 * <p>
 * <p>
 * Required
 * type
 * Description
 */

public class TopologyTemplate extends TemplateValidator {

    public String description;
    public Inputs inputs;
    public NodeTemplates node_templates;
    public ArrayList<RelationshipTemplate> relationship_templates = new ArrayList<>();
    public ArrayList<GroupDefinition> groups = new ArrayList<>();
    public ArrayList<PolicyDefinition> policies = new ArrayList<>();
    public Outputs outputs;
    public String substitution_mappings;

    public TopologyTemplate() {
        super();
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Topology Template."));
        keyNames.add(new KeyName("inputs", false, "list of parameter definitions", "An optional list of input parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("node_templates", false, "list of node templates", "An optional list of node template definitions for the Topology Template."));
        keyNames.add(new KeyName("relationship_templates", false, "list of relationship templates", "An optional list of relationship templates for the Topology Template."));
        keyNames.add(new KeyName("groups", false, "list of group definitions", "An optional list of Group definitions whose members are node templates defined within this same Topology Template."));
        keyNames.add(new KeyName("policies", false, "list of policy definitions", "An optional list of Policy definitions for the Topology Template."));
        keyNames.add(new KeyName("outputs", false, "list of parameter definitions", "An optional list of output parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("substitution_mappings", false, "N/A", "An optional declaration that exports the topology template as an implementation of a Node type. This also includes the mappings between the external Node Types named capabilities and requirements to existing implementations of those capabilities and requirements on Node templates declared within the topology template."));
    }

    public TopologyTemplate(LinkedHashMap data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Topology Template."));
        keyNames.add(new KeyName("inputs", false, "list of parameter definitions", "An optional list of input parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("node_templates", false, "list of node templates", "An optional list of node template definitions for the Topology Template."));
        keyNames.add(new KeyName("relationship_templates", false, "list of relationship templates", "An optional list of relationship templates for the Topology Template."));
        keyNames.add(new KeyName("groups", false, "list of group definitions", "An optional list of Group definitions whose members are node templates defined within this same Topology Template."));
        keyNames.add(new KeyName("policies", false, "list of policy definitions", "An optional list of Policy definitions for the Topology Template."));
        keyNames.add(new KeyName("outputs", false, "list of parameter definitions", "An optional list of output parameters (i.e., as parameter definitions) for the Topology Template."));
        keyNames.add(new KeyName("substitution_mappings", false, "N/A", "An optional declaration that exports the topology template as an implementation of a Node type. This also includes the mappings between the external Node Types named capabilities and requirements to existing implementations of those capabilities and requirements on Node templates declared within the topology template."));


        for (Object key : data.keySet()) {
            try {
                Field field = this.getClass().getField(key.toString());
                String simpleClassName = field.getType().getSimpleName();
                Object o = data.get(key.toString());
                if (simpleClassName.equals(String.class.getSimpleName())) {
                    field.set(this, data.get(key).toString());
                } else if (simpleClassName.equals(ArrayList.class.getSimpleName())) {
                    Class<?> cl = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                    Constructor constructor = cl.getConstructor(o.getClass());
                    System.out.println(key.toString() + "?????????");
//                    data.get(key.toString().getClass().getSimpleName().equals(Map.class.getSimpleName()))
                    o = constructor.newInstance(o.getClass().cast(data.get(key.toString())));
                    field.getType().getMethod("add", Object.class).invoke(field.get(this), o);
                } else {
                    Class<?> cl = Class.forName(field.getType().getName());
                    Constructor constructor = cl.getConstructor(o.getClass());
                    o = constructor.newInstance((Map) data.get(key.toString()));
                    field.set(this, o);
                }
            } catch (Exception e) {
                System.err.println(key.toString());
                System.err.println(data.get(key.toString()));
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isValid() {
        if (!super.isValid()) {
            System.err.println("Topology Template is not valid");
            return false;
        } else if (!node_templates.isValid()) {
            System.err.println("Node Template is not valid");
            return false;
        }
        return true;
    }
}