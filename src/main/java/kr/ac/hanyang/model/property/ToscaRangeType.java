package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * 3.2.3 TOCSA range type
 *
 * [<lower_bound>, <upper_bound>]
 * <p>
 * UNBOUNDED
 */
public interface ToscaRangeType {
    public static final String SHORTHAND_NAME = "range";
    public static final String TYPE_QUALIFIED_NAME = "tosca:range";
    public static final String UNBOUNDED = "UNBOUNDED";
    public static final String UNBOUNED_TYPE = "scalar";

    public void setUnbounded(Object o);
    //TODO: If unbounded value is passed, set value as max or min of value
}
