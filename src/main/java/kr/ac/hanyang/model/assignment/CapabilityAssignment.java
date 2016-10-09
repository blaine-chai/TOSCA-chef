package kr.ac.hanyang.model.assignment;

import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.7.1 Capability assignment
 * <p>
 * Keyname
 * Required
 * type
 * Description

 properties
 no
 list of property assignments
 An optional list of property definitions for the Capability definition.

 attributes
 no
 list of attribute assignments
 An optional list of attribute definitions for the Capability definition.

 * Grammar
 * <capability_definition_name>:
 * properties:
 * <property_assignments>
 * attributes:
 * <attribute_assignments>
 *
 * <p>
 * capability_definition_name: represents the symbolic name of the capability as a string.
 * property_assignments: represents the optional list of property assignments for the capability definition.
 attribute_assignments: represents the optional list of attribute assignments for the capability definition.
 */

public class CapabilityAssignment extends TemplateValidator {

    public CapabilityAssignment(){}

    public CapabilityAssignment(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property definitions for the Capability definition."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute definitions for the Capability definition."));
    }
}