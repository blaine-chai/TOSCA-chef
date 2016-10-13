package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.assignment.AttributeAssignment;
import kr.ac.hanyang.model.assignment.CapabilityAssignment;
import kr.ac.hanyang.model.assignment.PropertyAssignment;
import kr.ac.hanyang.model.assignment.RequirementAssignment;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.collection.Interfaces;
import kr.ac.hanyang.model.definition.ArtifactDefinition;
import kr.ac.hanyang.model.definition.InterfaceDefinition;
import kr.ac.hanyang.model.definition.NodeFilterDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.7.3 Node Template
 */

/**
 * Keyname
 * Required
 * type
 * Description
 * <p>
 * type
 * yes
 * string
 * The required name of the Node type the Node Template is based upon.
 * <p>
 * description
 * no
 * description
 * An optional description for the Node Template.
 * <p>
 * directives
 * no
 * string[]
 * An optional list of directive values to provide processing instructions to orchestrators and tooling.
 * properties
 * no
 * list of property assignments
 * An optional list of property value assignments for the Node Template.
 * <p>
 * attributes
 * no
 * list of attribute assignments
 * An optional list of attribute value assignments for the Node Template.
 * <p>
 * requirements
 * no
 * list of requirement assignments
 * An optional sequenced list of requirement assignments for the Node Template.
 * <p>
 * capabilities
 * no
 * list of capability assignments
 * An optional list of capability assignments for the Node Template.
 * <p>
 * interfaces
 * no
 * list of interface definitions
 * An optional list of named interface definitions for the Node Template.
 * <p>
 * artifacts
 * no
 * list of artifact definitions
 * An optional list of named artifact definitions for the Node Template.
 * <p>
 * node_filter
 * no
 * node filter
 * The optional filter definition that TOSCA orchestrators would use to select the correct target node. This keyname is only valid if the directive has the value of “selectable” set.
 * <p>
 * copy
 * no
 * string
 * The optional (symbolic) name of another node template to copy into (all keynames and values) and use as a basis for this node template.
 * <p>
 * Grammar
 * <node_template_name>:
 * type: <node_type_name>
 * description: <node_template_description>
 * directives: [<directives>]
 * properties:
 * <property_assignments>
 * attributes:
 * <attribute_assignments>
 * requirements:
 * - <requirement_assignments>
 * capabilities:
 * <capability_assignments>
 * interfaces:
 * <interface_definitions>
 * artifacts:
 * <artifact_definitions>
 * node_filter:
 * <node_filter_definition>
 * copy: <source_node_template_name>
 * <p>
 * <p>
 * node_template_name: represents the required symbolic name of the Node Template being declared.
 * node_type_name: represents the name of the Node type the Node Template is based upon.
 * node_template_description: represents t'he optional description string for Node Template.
 * directives: represents the optional list of processing instruction keywords (as strings) for use by tooling and orchestrators.
 * property_assignments: represents the optional list of property assignments for the Node Template that provide values for properties defined in its declared Node type
 * attribute_assignments: represents the optional list of attribute assignments for the Node Template that provide values for attributes defined in its declared Node type.
 * requirement_assignments: represents the optional sequenced list of requirement assignments for the Node Template that allow assignment of type-compatible capabilities, target nodes, relationships and target (node filters) for use when fulfilling the requirement at runtime.
 * capability_assignments: represents the optional list of capability assignments for the Node Template that augment those provided by its declared Node type.
 * interface_definitions: represents the optional list of interface definitions for the Node Template that augment those provided by its declared Node type.
 * artifact_definitions: represents the optional list of artifact definitions for the Node Template that augment those provided by its declared Node type.
 * node_filter_definition: represents the optional node filter TOSCA orchestrators would use for selecting a matching node template.
 * source_node_template_name: represents the optional (symbolic) name of another node template to copy into (all keynames and values) and use as a basis for this node template.
 */

public class NodeTemplate extends TemplateValidator {

    public String nodeName;

    public String type;
    public String description;
    public ArrayList<String> directives = new ArrayList<>();
    public ArrayList<PropertyAssignment> properties = new ArrayList<>();
    public ArrayList<AttributeAssignment> attributes = new ArrayList<>();
    public ArrayList<RequirementAssignment> requirements = new ArrayList<>();
    public Interfaces interfaces;
    public ArrayList<ArtifactDefinition> artifacts = new ArrayList<>();
    public ArrayList<CapabilityAssignment> capabilities = new ArrayList<>();
    public NodeFilterDefinition node_filter;
    public String copy;


    public NodeTemplate() {
        super();
        keyNames.add(new KeyName("type", true, "string", "The required name of the Node type the Node Template is based upon."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Node Template."));
        keyNames.add(new KeyName("directives", false, "string[]", "An optional list of directive values to provide processing instructions to orchestrators and tooling."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the Node Template."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute value assignments for the Node Template."));
        keyNames.add(new KeyName("requirements", false, "list of requirement assignments", "An optional sequenced list of requirement assignments for the Node Template."));
        keyNames.add(new KeyName("capabilities", false, "list of capability assignments", "An optional list of capability assignments for the Node Template."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of named interface definitions for the Node Template."));
        keyNames.add(new KeyName("artifacts", false, "list of artifact definitions", "An optional list of named artifact definitions for the Node Template."));
        keyNames.add(new KeyName("node_filter", false, "node filter", "The optional filter definition that TOSCA orchestrators would use to select the correct target node. his keyname is only valid if the directive has the value of “selectable” set."));
        keyNames.add(new KeyName("copy", false, "string", "The optional (symbolic) name of another node template to copy into (all keynames and values) and use as a basis or this node template."));
    }

    public NodeTemplate(String nodeName) {
        super();
        this.nodeName = nodeName;
        keyNames.add(new KeyName("type", true, "string", "The required name of the Node type the Node Template is based upon."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Node Template."));
        keyNames.add(new KeyName("directives", false, "string[]", "An optional list of directive values to provide processing instructions to orchestrators and tooling."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the Node Template."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute value assignments for the Node Template."));
        keyNames.add(new KeyName("requirements", false, "list of requirement assignments", "An optional sequenced list of requirement assignments for the Node Template."));
        keyNames.add(new KeyName("capabilities", false, "list of capability assignments", "An optional list of capability assignments for the Node Template."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of named interface definitions for the Node Template."));
        keyNames.add(new KeyName("artifacts", false, "list of artifact definitions", "An optional list of named artifact definitions for the Node Template."));
        keyNames.add(new KeyName("node_filter", false, "node filter", "The optional filter definition that TOSCA orchestrators would use to select the correct target node. his keyname is only valid if the directive has the value of “selectable” set."));
        keyNames.add(new KeyName("copy", false, "string", "The optional (symbolic) name of another node template to copy into (all keynames and values) and use as a basis or this node template."));
    }

    public NodeTemplate(String nodeName, Map data) {
        super();
        this.nodeName = nodeName;
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required name of the Node type the Node Template is based upon."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Node Template."));
        keyNames.add(new KeyName("directives", false, "string[]", "An optional list of directive values to provide processing instructions to orchestrators and tooling."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property value assignments for the Node Template."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute value assignments for the Node Template."));
        keyNames.add(new KeyName("requirements", false, "list of requirement assignments", "An optional sequenced list of requirement assignments for the Node Template."));
        keyNames.add(new KeyName("capabilities", false, "list of capability assignments", "An optional list of capability assignments for the Node Template."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of named interface definitions for the Node Template."));
        keyNames.add(new KeyName("artifacts", false, "list of artifact definitions", "An optional list of named artifact definitions for the Node Template."));
        keyNames.add(new KeyName("node_filter", false, "node filter", "The optional filter definition that TOSCA orchestrators would use to select the correct target node. his keyname is only valid if the directive has the value of “selectable” set."));
        keyNames.add(new KeyName("copy", false, "string", "The optional (symbolic) name of another node template to copy into (all keynames and values) and use as a basis or this node template."));

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
                    o = constructor.newInstance(o.getClass().cast(data.get(key.toString())));
                    field.getType().getMethod("add", Object.class).invoke(field.get(this), o);
                } else {
                    Class<?> cl = Class.forName(field.getType().getName());
                    Constructor constructor = cl.getConstructor(o.getClass());
                    o = constructor.newInstance((Map) data.get(key.toString()));
                    field.set(this, o);
                }
            } catch (Exception e) {
                return;
            }
        }

    }

    @Override
    public String toString() {
        return nodeName;
    }
}
