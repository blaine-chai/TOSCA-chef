package kr.ac.hanyang.model.type; /**
 * 3.6.9 Relationship type
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Keyname
 * Required
 * Definition/type
 * Description
 * <p>
 * derived_from
 * no
 * string
 * An optional parent Relationship type name the Relationship type derives from.
 * <p>
 * version
 * no
 * version
 * An optional version for the Relationship type definition.
 * <p>
 * description
 * no
 * description
 * An optional description for the Relationship type.
 * <p>
 * properties
 * no
 * list of property definitions
 * An optional list of property definitions for the Relationship type.
 * <p>
 * attributes
 * no
 * list of attribute definitions
 * An optional list of attribute definitions for the Relationship type.
 * <p>
 * interfaces
 * no
 * list of interface definitions
 * An optional list of interface definitions interfaces supported by the Relationship type.
 * <p>
 * valid_target_types
 * no
 * string[]
 * An optional list of one or more names of Capability Types that are valid targets for this relationship.
 * <p>
 * Grammer
 * <relationship_type_name>:
 * derived_from: <parent_relationship_type_name>
 * version: <version_number>
 * description: <relationship_description>
 * properties:
 * <property_definitions>
 * attributes:
 * <attribute_definitions>
 * interfaces:
 * <interface_definitions>
 * valid_target_types: [ <capability_type_names> ]
 * <p>
 * relationship_type_name: represents the required symbolic name of the Relationship type being declared as a string.
 * parent_relationship_type_name: represents the name (string) of the Relationship type this Relationship type definition derives from (i.e., its “parent” type).
 * relationship_description: represents the optional description string for the corresponding relationship_type_name.
 * version_number: represents the optional TOSCA version number for the Relationship type.
 * property_definitions: represents the optional list of property definitions for the Relationship type.
 * attribute_definitions: represents the optional list of attribute definitions for the Relationship type.
 * interface_definitions: represents the optional list of one or more names of valid interface definitions supported by the Relationship type.
 * capability_type_names: represents one or more names of valid target types for the relationship (i.e.,Capability Types).
 */


public class RelationshipType extends TypeValidator {


    public RelationshipType() {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy type name the Policy type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy type can be applied to."));
    }

    public RelationshipType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy type name the Policy type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy type can be applied to."));
    }
}