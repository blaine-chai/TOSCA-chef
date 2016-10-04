package kr.ac.hanyang.model.assignment;

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

/**
 * 3.7.1 Capability assignment
 * <p>
 * Keyname
 * Required
 * Type
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

public class CapabilityAssignment implements ToscaValidator {

    private KeyNames keyNames;

    public CapabilityAssignment() {
        super();
        keyNames = new KeyNames();
        keyNames.add(new KeyName("properties", false, "list of property assignments", "An optional list of property definitions for the Capability definition."));
        keyNames.add(new KeyName("attributes", false, "list of attribute assignments", "An optional list of attribute definitions for the Capability definition."));
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