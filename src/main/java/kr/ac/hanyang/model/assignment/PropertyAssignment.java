package kr.ac.hanyang.model.assignment;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.basemodel.validator.AssignmentValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.9 Property assignment
 * <p>
 * <property_name>: <property_value> | { <property_value_expression> }
 * <p>
 * property_name: represents the name of a property that would be used to select a property definition with the same name within on a TOSCA entity (e.g., Node Template, Relationship Template, etc.,) which is declared in its declared type (e.g., a Node type, Node Template, Capability type, etc.).
 * <p>
 * property_value, property_value_expression: represent the type-compatible value to assign to the named property. Property values may be provided as the result from the evaluation of an expression or a function.
 */

//TODO: No keyname
public class PropertyAssignment extends AssignmentValidator {
    public String property_name;
    public String property_value;


    public PropertyAssignment(LinkedHashMap data) {
        super();
        this.data = data;
        for (Object key : data.keySet()) {
            this.property_value = this.data.get(key.toString()).toString();
            this.property_name = key.toString();
        }
    }

    @Override
    public String toString() {
        return this.property_name + " !!!!!!!!!!!!" + this.property_value;
    }
}
