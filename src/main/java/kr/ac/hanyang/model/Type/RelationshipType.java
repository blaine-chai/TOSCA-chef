package kr.ac.hanyang.model.Type; /**
 * 3.6.9 Relationship Type
 */

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * Keyname   
 * Required
 * Definition/Type
 * Description
 * 
derived_from
no
string
An optional parent Relationship Type name the Relationship Type derives from.
 
version
no
version
An optional version for the Relationship Type definition.

description
no
description
An optional description for the Relationship Type.

properties
no
list of property definitions
An optional list of property definitions for the Relationship Type.

attributes
no
list of attribute definitions
An optional list of attribute definitions for the Relationship Type.

interfaces
no
list of interface definitions
An optional list of interface definitions interfaces supported by the Relationship Type.

valid_target_types
no
string[]
An optional list of one or more names of Capability Types that are valid targets for this relationship.

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
* relationship_type_name: represents the required symbolic name of the Relationship Type being declared as a string.  
* parent_relationship_type_name: represents the name (string) of the Relationship Type this Relationship Type definition derives from (i.e., its “parent” type).
* relationship_description: represents the optional description string for the corresponding relationship_type_name.
* version_number: represents the optional TOSCA version number for the Relationship Type.
* property_definitions: represents the optional list of property definitions for the Relationship Type.
* attribute_definitions: represents the optional list of attribute definitions for the Relationship Type.
* interface_definitions: represents the optional list of one or more names of valid interface definitions supported by the Relationship Type.
* capability_type_names: represents one or more names of valid target types for the relationship (i.e.,Capability Types).
* 
* 
* 
* 
* 
*/


public class RelationshipType implements ToscaValidator {

    private KeyNames keyNames;

    public RelationshipType() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Policy Type name the Policy Type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Policy Type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Policy Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Policy Type."));
        keyNames.add(new KeyName("targets", false, "string[]", "An optional list of valid Node Types or Group Types the Policy Type can be applied to."));




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