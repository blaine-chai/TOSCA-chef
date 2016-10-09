package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.7.4 Relationship Template
 */

/**
 * Keyname
 * Required
 * type
 * Description

 type
 yes
 string
 The required name of the Relationship type the Relationship Template is based upon.

 description
 no
 description
 An optional description for the Relationship Template.

 properties
 no
 list of property assignments
 An optional list of property assignments for the Relationship Template.

 attributes
 no
 list of attribute assignments
 An optional list of attribute assignments for the Relationship Template.

 interfaces
 no
 list of interface definitions
 An optional list of named interface definitions for the Node Template.

 copy
 no
 string
 The optional (symbolic) name of another relationship template to copy into (all keynames and values) and use as a basis for this relationship template.

 * Grammar
 * <relationship_template_name>:
 * type: <relationship_type_name>
 * description: <relationship_type_description>
 * properties:
 * <property_assignments>
 * attributes:
 * <attribute_assignments>
 * interfaces:
 * <interface_definitions>
 * copy:
 * <source_relationship_template_name>
 *
 * <p>
 * relationship_template_name: represents the required symbolic name of the Relationship Template being declared.
 * relationship_type_name: represents the name of the Relationship type the Relationship Template is based upon.
 * relationship_template_description: represents the optional description string for the Relationship Template.
 * property_assignments: represents the optional list of property assignments for the Relationship Template that provide values for properties defined in its declared Relationship type.
 * attribute_assignments: represents the optional list of attribute assignments for the Relationship Template that provide values for attributes defined in its declared Relationship type.
 * interface_definitions: represents the optional list of interface definitions for the Relationship Template that augment those provided by its declared Relationship type.
 * source_relationship_template_name: represents the optional (symbolic) name of another relationship template to copy into (all keynames and values) and use as a basis for this relationship template.
 *
 *
 *
 *
 *
 */
public class RelationshipTemplate extends TemplateValidator {

    public RelationshipTemplate(){}

    public RelationshipTemplate(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required name of the Relationship type the Relationship Template is based upon."));
        keyNames.add(new KeyName("description" ,false, "description", " An optional description for the Relationship Template."));
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property assignments for the Relationship Template."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute assignments for the Relationship Template."));
        keyNames.add(new KeyName("interfaces", false, "list of interface definitions", "An optional list of named interface definitions for the Node Template."));
        keyNames.add(new KeyName("copy", false, "string", "The optional (symbolic) name of another relationship template to copy into (all keynames and values) and use as  basis for this relationship template."));




    }

    public KeyNames getKeyNames() {
        return keyNames;
    }


}