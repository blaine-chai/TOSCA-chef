package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * 3.2.6 TOCSA scalar-unit type
 *
 * if we have a property called storage_size. which is of type scalar-unit, a valid range constraint would appear as follows:
 * storage_size: in_range [ 4 GB, 20 GB ]
 */
public class ToscaScalarUnitType {

    //byte
    class ToscaScalarUnitSize{
        public static final String SHORTHAND_NAME = "scalar-unit.size";
        public static final String TYPE_QUALIFIED_NAME = "tosca:scalar-unit.size";
    }
    //second
    class ToscaScalarUnitTime{
        public static final String SHORTHAND_NAME = "scalar-unit.time";
        public static final String TYPE_QUALIFIED_NAME = "tosca:scalar-unit.time";
    }
    //hz
    class ToscaScalarUnitFrequency{
        public static final String SHORTHAND_NAME = "scalar-unit.frequency";
        public static final String TYPE_QUALIFIED_NAME = "tosca:scalar-unit.frequency";
    }
}
