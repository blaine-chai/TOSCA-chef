package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * 3.2.5.1.1 Single-line grammar
 * { <entry_key_1>: <entry_value_1>, ..., <entry_key_n>: <entry_value_n> } ...
 * <entry_key_n>: <entry_value_n>
 * <p>
 * 3.2.5.1.2 Multi-line grammar
 * <entry_key_1>: <entry_value_1>
 * ...
 * <entry_key_n>: <entry_value_n>
 */
public interface ToscaMapType {
    public static final String SHORTHAND_NAME = "map";
    public static final String TYPE_QUALIFIED_NAME ="tosca:map";

    //same as yaml map notation
    //properties' entry_schema can be defined
    /**
     * <some_entity>:
     ...
     properties:
     emails:
     type: map entry_schema:
     description: basic email address
     type: string
     constraints:
     - max_length: 128
     */

    //also entry_schema's type can be other Defined information
    /**
     * entry_schema:
     *  description: simple contact information type: ContactInfo
     */
}
