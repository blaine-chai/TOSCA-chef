package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

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

    private String nodeName;
    private String type;
    private String properties;
    private String requirements;
    private String interfaces;
    private String artifacts;
    private String capabilities;
    private String node_filter;
    private String copy;

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

    public NodeTemplate(Map data) {
        super();
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
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

//    public boolean isDataContainsKeyName(KeyName keyName){
//
//    }
}
