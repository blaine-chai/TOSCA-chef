package kr.ac.hanyang.model.Type;

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * 3.6.10 Group Type
 */

/**
 * Keyname
 * Requred
 * Type
 * Description
 derived_from
 no
 string
 An optional parent Group Type name the Group Type derives from.

 version
 no
 version
 An optional version for the Group Type definition.

 description
 no
 description
 The optional description for the Group Type.

 properties
 no
 list of property definitions
 An optional list of property definitions for the Group Type.

 members
 no
 string[]
 An optional list of one or more names of Node Types that are valid (allowed) as members of the Group Type.

 interfaces
 no
 list of interface definitions
 An optional list of interface definitions supported by the Group Type.

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
 * group_type_name: represents the required symbolic name of the Group Type being declared as a string.
 * parent_group_type_name: represents the name (string) of the Group Type this Group Type definition derives from (i.e., its “parent” type).
 * version_number: represents the optional TOSCA version number for the Group Type.
 * group_description: represents the optional description string for the corresponding group_type_name.
 * property_definitions: represents the optional list of property definitions for the Group Type.
 * list_of_valid_member_types: represents the optional list of TOSCA types (i.e., Node or Capability Types) that are valid member types for being added to (i.e., members of) the Group Type.
 * interface_definitions: represents the optional list of one or more interface definitions supported by the Group Type.
 */

public class GroupType implements ToscaValidator {

    private KeyNames keyNames;

    public GroupType() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Group Type name the Group Type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Group Type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Group Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Group Type."));
        keyNames.add(new KeyName("members", false, "string[]", "An optional list of one or more names of Node Types that are valid (allowed) as members of the Group Type."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of interface definitions supported by the Group Type."));



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