package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.Map;

/**
 * 3.6.10 Group type
 */

/**
 * Keyname
 * Requred
 * type
 * Description
 derived_from
 no
 string
 An optional parent Group type name the Group type derives from.

 version
 no
 version
 An optional version for the Group type definition.

 description
 no
 description
 The optional description for the Group type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Group type.

 members
 no
 string[]
 An optional list of one or more names of Node Types that are valid (allowed) as members of the Group type.

 interfaces
 no
 list of interface definitions
 An optional list of interface definitions supported by the Group type.

 * Grammar
 * <group_type_name>:
 * derived_from: <parent_group_type_name>
 * version: <version_number>
 * description: <group_description>
 * properties:
 * <property_definitions>
 * members: [ <list_of_valid_member_types> ]
 * interfaces:
 * <interface_definitions>
 * <p>
 * group_type_name: represents the required symbolic name of the Group type being declared as a string.
 * parent_group_type_name: represents the name (string) of the Group type this Group type definition derives from (i.e., its “parent” type).
 * version_number: represents the optional TOSCA version number for the Group type.
 * group_description: represents the optional description string for the corresponding group_type_name.
 * property_definitions: represents the optional list of property definitions for the Group type.
 * list_of_valid_member_types: represents the optional list of TOSCA types (i.e., Node or Capability Types) that are valid member types for being added to (i.e., members of) the Group type.
 * interface_definitions: represents the optional list of one or more interface definitions supported by the Group type.
 */

public class GroupType extends TypeValidator{

    public GroupType(){
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Group type name the Group type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Group type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Group type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Group type."));
        keyNames.add(new KeyName("members", false, "string[]", "An optional list of one or more names of Node Types that are valid (allowed) as members of the Group type."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of interface definitions supported by the Group type."));
    }

    public GroupType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Group type name the Group type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Group type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Group type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Group type."));
        keyNames.add(new KeyName("members", false, "string[]", "An optional list of one or more names of Node Types that are valid (allowed) as members of the Group type."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of interface definitions supported by the Group type."));



    }
}