package kr.ac.hanyang.model.Type;

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * 3.6.7 Requirement Type
 */

/**
 * Keyname
 * Requred
 * Definition/Type
 * Description

 derived_from
 no
 string
 An optional parent Node Type name this new Node Type derives from.

 version
 no
 version
 An optional version for the Node Type definition.

 description
 no
 description
 An optional description for the Node Type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Node Type.

 attributes
 no
 list of attribute definitions
 An optional list of attribute definitions for the Node Type.

 requirements
 no
 list of requirement definitions
 An optional sequenced list of requirement definitions for the Node Type.

 capabilities
 no
 list of capability definitions
 An optional list of capability definitions for the Node Type.

 interfaces
 no
 list of interface definitions
 An optional list of interface definitions supported by the Node Type

 artifacts
 no
 list of artifact definitions
 An optional list of named artifact definitions for the Node Type.

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
 * node_type_name: represents the required symbolic name of the Node Type being declared.
 *  parent_node_type_name: represents the name (string) of the Node Type this Node Type definition derives from (i.e., its “parent” type).
 *  version_number: represents the optional TOSCA version number for the Node Type.
 *  node_type_description: represents the optional description string for the corresponding node_type_name.
 *  property_definitions: represents the optional list of property definitions for the Node Type.
 *  attribute_definitions: represents the optional list of attribute definitions for the Node Type.
 *  requirement_definitions: represents the optional sequenced list of requirement definitions for the Node Type.
 *  capability_definitions: represents the optional list of capability definitions for the Node Type.
 *  interface_definitions: represents the optional list of one or more interface definitions supported by the Node Type.
 *  artifact_definitions: represents the optional list of artifact definitions for the Node Type.
 */
public class RequirementType implements ToscaValidator {

    private KeyNames keyNames;

    public RequirementType() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Node Type name this new Node Type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Node Type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Node Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Node Type."));
        keyNames.add(new KeyName("attributes", false, "list of attribute definitions", "An optional list of attribute definitions for the Node Type."));
        keyNames.add(new KeyName("requirements", false, "list of requirement definitions", "An optional sequenced list of requirement definitions for the Node Type."));
        keyNames.add(new KeyName("capabilities", false, "list of capability definitions", "An optional list of capability definitions for the Node Type."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of interface definitions supported by the Node Type"));
        keyNames.add(new KeyName("artifacts", false, "list of artifact definitions", "An optional list of named artifact definitions for the Node Type."));


    }

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

    public KeyNames getKeyNames() {
        return keyNames;
    }


}





















