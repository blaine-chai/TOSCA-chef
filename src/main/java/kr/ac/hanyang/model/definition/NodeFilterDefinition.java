package kr.ac.hanyang.model.definition;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;

/**
 * Created by blainechai on 2016. 9. 21..
 * <p>
 * 3.5.4 Node Filter definition
 * <p>
 * Keyname
 * Required
 * type
 * Description
 * <p>
 * properties
 * no
 * list of property filter definition
 * An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their property definitions’ values.
 * <p>
 * capabilities
 * no
 * list of capability names or capability type names
 * An optional sequenced list of capability names or types that would be used to select (filter) matching TOSCA entities based upon their existence.
 * <p>
 * 3.5.4.2 Additional filtering on named Capability properties
 * <p>
 * <capability name_or_type> : properties
 * no
 * list of property filter definitions
 * An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their capabilities’ property definitions’ values.
 * <p>
 * 3.5.4 Node Filter definition
 * <p>
 * Keyname
 * Required
 * type
 * Description
 * <p>
 * properties
 * no
 * list of property filter definition
 * An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their property definitions’ values.
 * <p>
 * capabilities
 * no
 * list of capability names or capability type names
 * An optional sequenced list of capability names or types that would be used to select (filter) matching TOSCA entities based upon their existence.
 * <p>
 * 3.5.4.2 Additional filtering on named Capability properties
 * <p>
 * <capability name_or_type> : properties
 * no
 * list of property filter definitions
 * An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their capabilities’ property definitions’ values.
 */

/**
 * 3.5.4 Node Filter definition
 */

/**
 * Keyname
 Required
 type
 Description

 properties
 no
 list of property filter definition
 An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their property definitions’ values.

 capabilities
 no
 list of capability names or capability type names
 An optional sequenced list of capability names or types that would be used to select (filter) matching TOSCA entities based upon their existence.
 *
 * 3.5.4.2 Additional filtering on named Capability properties
 *
 * <capability name_or_type> : properties
 * no
 * list of property filter definitions
 * An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their capabilities’ property definitions’ values.
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

import java.util.Map;

/** Grammar
 * <filter_name>:
 properties:
 - <property_filter_def_1>
 - ...
 - <property_filter_def_n>
 capabilities:
 - <capability_name_or_type_1>:
 properties:
 - <cap_1_property_filter_def_1>
 - ...
 - <cap_m_property_filter_def_n>
 -  ...
 - <capability_name_or_type_n>:
 properties:
 - <cap_1_property_filter_def_1>
 - ...
 - <cap_m_property_filter_def_n>
 */

public class NodeFilterDefinition extends DefinitionValidator {

    public NodeFilterDefinition(){}

    public NodeFilterDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("properties", false, "list of property filter definition", " An optional sequenced list of property filters that would be used to select (filter) matching TOSCA entities (e.g., Node Template, Node type, Capability Types, etc.) based upon their property definitions’ values."));
        keyNames.add(new KeyName("capabilities", false, "list of capability names or capability type names", "An optional sequenced list of capability names or types that would be used to select (filter) matching TOSCA entities based upon their existence."));
    }

}
