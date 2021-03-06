package kr.ac.hanyang.model.assignment;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.basemodel.validator.AssignmentValidator;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyNames;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.11 Attribute assignment
 * <p>
 * short notation
 * <p>
 * <attribute_name>: <attribute_value> | { <attribute_value_expression> }
 * <p>
 * <p>
 * extened notation
 * <p>
 * <attribute_name>:
 * description: <attribute_description>
 * value: <attribute_value> | { <attribute_value_expression> }
 *
 attribute_name: represents the name of an attribute that would be used to select an attribute definition with the same name within on a TOSCA entity (e.g., Node Template, Relationship Template, etc.) which is declared (or reflected from a Property definition) in its declared type (e.g., a Node type, Node Template, Capability type, etc.).
 attribute_value, attribute_value_expresssion: represent the type-compatible value to assign to the named attribute. Attribute values may be provided as the result from the evaluation of an expression or a function.
 attribute_description: represents the optional description of the attribute.
 */


//TODO: no kename
public class AttributeAssignment extends AssignmentValidator {

    public String attribute_name;
    public String attribute_description;
    public String attribute_value;

    public AttributeAssignment(){}

    public AttributeAssignment(LinkedHashMap data) {
        super();
        this.data = data;

    }

}

