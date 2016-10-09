package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.6.3 Artifact type
 */

/**
 * Keyname
 * Requred
 * type
 * Description

 derived_from
 no
 string
 An optional parent Artifact type name the Artifact type derives from.

 version
 no
 version
 An optional version for the Artifact type definition.

 description
 no
 description
 An optional description for the Artifact type.

 mime_type
 no
 string
 The required mime type property for the Artifact type.

 file_ext
 no
 string[]
 The required file extension property for the Artifact type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Artifact type.

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
 * capability_type_name: represents the required name of the Capability type being declared as a string.
 *parent_capability_type_name: represents the name of the Capability type this Capability type definition derives from (i.e., its “parent” type).
 * version_number: represents the optional TOSCA version number for the Capability type.
 * capability_description: represents the optional description string for the corresponding capability_type_name.
 * property_definitions: represents an optional list of property definitions that the Capability type exports.
 * attribute_definitions: represents the optional list of attribute definitions for the Capability type.
 * node_type_names: represents the optional list of one or more names of Node Types that the Capability type supports as valid sources for a successful relationship to be established to itself.
 */
public class ArtifactType extends TypeValidator {

    public ArtifactType(){
        super();
        keyNames.add(new KeyName("derived_from", false, "string","An optional description for the Artifact type."));
        keyNames.add(new KeyName("version", false, "version","An optional version for the Artifact type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Artifact type."));
        keyNames.add(new KeyName("mime_type", false, "string","The required mime type property for the Artifact type.."));
        keyNames.add(new KeyName("file_ext", false, "string[]", "The required file extension property for the Artifact type."));
        keyNames.add(new KeyName("properties", false , "list of property definitions", "An optional list of property definitions for the Artifact ype."));
    }

    public ArtifactType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string","An optional description for the Artifact type."));
        keyNames.add(new KeyName("version", false, "version","An optional version for the Artifact type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Artifact type."));
        keyNames.add(new KeyName("mime_type", false, "string","The required mime type property for the Artifact type.."));
        keyNames.add(new KeyName("file_ext", false, "string[]", "The required file extension property for the Artifact type."));
        keyNames.add(new KeyName("properties", false , "list of property definitions", "An optional list of property definitions for the Artifact ype."));

    }
}





