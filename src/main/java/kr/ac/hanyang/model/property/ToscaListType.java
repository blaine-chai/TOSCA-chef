package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * [ <list_entry_1>, <list_entry_2>, ... ]
 * <p>
 * - <list_entry_1>
 * - ...
 * - <list_entry_n>
 * <p>
 * <list_entry_*>: represents one entry of the list.
 * <p>
 * 3.2.4.2 Declaration Examples
 * 3.2.4.2.1 List declaration using a simple type
 * The following example shows a list declaration with an entry schema based upon a simple integer type (which has additional constraints):
 * entry_schema:
 * description: listen port entry (simple integer type) type: integer
 * constraints:
 * - max_length: 128
 * <some_entity>:
 * ...
 * properties:
 * listen_ports:
 * type: list
 * <p>
 * <p>
 * 3.2.4.2.2 List declaration using a complex type
 * The following example shows a list declaration with an entry schema based upon a complex type:
 * <some_entity>:
 * ...
 * properties:
 * products:
 * type: list entry_schema:
 * description: Product information entry (complex type) defined elsewhere type: ProductInfo
 * 3.2.4.3 Definition Examples
 * These examples show two notation options for defining lists:
 * A single-line option which is useful for only short lists with simple entries.
 * A multi-line option where each list entry is on a separate line; this option is typically useful or more
 * readable if there is a large number of entries, or if the entries are complex.
 * 3.2.4.3.1 Square bracket notation
 * 3.2.4.3.2 Bulleted list notation
 * <p>
 * listen_ports: [ 80, 8080 ]
 * listen_ports:
 * - 80
 * - 8080
 */
public interface ToscaListType {
    public static final String SHORTAND_NAME = "list";
    public static final String TYPE_QUALIFIED_NAME = "tosca:list";

    //It's same as yaml list notation
}
