package kr.ac.hanyang.model.collection;

/**
 * Constraints
 * list of constraint
 */


import kr.ac.hanyang.model.ConstraintClause;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * # Scalar grammar
 * <operator>: <scalar_value>
 * # Dual scalar grammar
 * <operator>: [ <scalar_value_1>, <scalar_value_2> ]
 * # List grammar
 * <operator> [ <value_1>, <value_2>, ..., <value_n> ]
 * # Regular expression (regex) grammar pattern: <regular_expression_value>
 * <p>
 * operator: represents a required operator from the specified list shown above (see section 3.5.2.1 “Operator keynames”).
 * scalar_value, scalar_value_*: represents a required scalar (or atomic quantity) that can hold only one value at a time. This will be a value of a primitive type, such as an integer or string that is allowed by this specification.
 * value_*: represents a required value of the operator that is not limited to scalars.
 * reqular_expression_value: represents a regular expression (string) value.
 */

//TODO: list
public class Constraints extends TemplateValidator {

    public ArrayList<ConstraintClause> constraintClauses = new ArrayList<>();

    public Constraints() {
    }

    public Constraints(LinkedHashMap data) {
        super();
        this.data = data;
        for (Object o : data.values()) {
            constraintClauses.add(new ConstraintClause((Map) o));
        }
    }
}
