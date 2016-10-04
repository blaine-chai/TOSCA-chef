package kr.ac.hanyang.model.Type;

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * 3.6.3 Artifact Type
 */

/**
 * Keyname
 * Requred
 * Type
 * Description

 derived_from
 no
 string
 An optional parent Artifact Type name the Artifact Type derives from.

 version
 no
 version
 An optional version for the Artifact Type definition.

 description
 no
 description
 An optional description for the Artifact Type.

 mime_type
 no
 string
 The required mime type property for the Artifact Type.

 file_ext
 no
 string[]
 The required file extension property for the Artifact Type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Artifact Type.

 * Grammar
 * <capability_type_name>:
 * derived_from: <parent_capability_type_name>
 * version: <version_number>
 * description: <capability_description>
 * properties:
 * <property_definitions>
 * attributes:
 * <attribute_definitions>
 * valid_source_types: [ <node type_names> ]
 * <p>
 * capability_type_name: represents the required name of the Capability Type being declared as a string.
 *parent_capability_type_name: represents the name of the Capability Type this Capability Type definition derives from (i.e., its “parent” type).
 * version_number: represents the optional TOSCA version number for the Capability Type.
 * capability_description: represents the optional description string for the corresponding capability_type_name.
 * property_definitions: represents an optional list of property definitions that the Capability type exports.
 * attribute_definitions: represents the optional list of attribute definitions for the Capability Type.
 * node_type_names: represents the optional list of one or more names of Node Types that the Capability Type supports as valid sources for a successful relationship to be established to itself.
 */
public class ArtifactType implements ToscaValidator {

    private KeyNames keyNames;

    public ArtifactType() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string","An optional description for the Artifact Type."));
        keyNames.add(new KeyName("version", false, "version","An optional version for the Artifact Type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Artifact Type."));
        keyNames.add(new KeyName("mime_type", false, "string","The required mime type property for the Artifact Type.."));
        keyNames.add(new KeyName("file_ext", false, "string[]", "The required file extension property for the Artifact Type."));
        keyNames.add(new KeyName("properties", false , "list of property definitions", "An optional list of property definitions for the Artifact ype."));

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





