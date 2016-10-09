package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.LinkedHashMap;

/**
 * 3.6.8 Node Type
 */

/**
 * Keyname
 * Requred
 * Definition/type
 * Description

 derived_from
 no
 string
 An optional parent Node type name this new Node type derives from.

 version
 no
 version
 An optional version for the Node type definition.

 description
 no
 description
 An optional description for the Node type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Node type.

 attributes
 no
 list of attribute definitions
 An optional list of attribute definitions for the Node type.

 requirements
 no
 list of requirement definitions
 An optional sequenced list of requirement definitions for the Node type.

 capabilities
 no
 list of capability definitions
 An optional list of capability definitions for the Node type.

 interfaces
 no
 list of interface definitions
 An optional list of interface definitions supported by the Node type

 artifacts
 no
 list of artifact definitions
 An optional list of named artifact definitions for the Node type.

 * Grammer
 * <node_type_name>:
 * derived_from: <parent_node_type_name>
 * version: <version_number>
 * description: <node_type_description>
 * properties:
 * <property_definitions>
 * attributes:
 * <attribute_definitions>
 * requirements:
 * - <requirement_definitions>
 * capabilities:
 * <capability_definitions>
 * interfaces:
 * <interface_definitions>
 * artifacts:
 * <artifact_definitions>
 *
 * <p>
 * node_type_name: represents the required symbolic name of the Node type being declared.
 *  parent_node_type_name: represents the name (string) of the Node type this Node type definition derives from (i.e., its “parent” type).
 *  version_number: represents the optional TOSCA version number for the Node type.
 *  node_type_description: represents the optional description string for the corresponding node_type_name.
 *  property_definitions: represents the optional list of property definitions for the Node type.
 *  attribute_definitions: represents the optional list of attribute definitions for the Node type.
 *  requirement_definitions: represents the optional sequenced list of requirement definitions for the Node type.
 *  capability_definitions: represents the optional list of capability definitions for the Node type.
 *  interface_definitions: represents the optional list of one or more interface definitions supported by the Node type.
 *  artifact_definitions: represents the optional list of artifact definitions for the Node type.
 */
public class NodeType extends TypeValidator{

    private KeyNames keyNames;

    public NodeType() {
        super();
        this.data = new LinkedHashMap();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Node type name this new Node type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Node type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Node type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Node type."));
        keyNames.add(new KeyName("attributes", false, "list of attribute definitions", "An optional list of attribute definitions for the Node type."));
        keyNames.add(new KeyName("requirements", false, "list of requirement definitions", "An optional sequenced list of requirement definitions for the Node type."));
        keyNames.add(new KeyName("capabilities", false, "list of capability definitions", "An optional list of capability definitions for the Node type."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of interface definitions supported by the Node type"));
        keyNames.add(new KeyName("artifacts", false, "list of artifact definitions", "An optional list of named artifact definitions for the Node type."));


    }


}





















