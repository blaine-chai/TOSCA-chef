package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

/**
 * 3.5.10 Attribute definition
 * <p>
 * Keyname
 * Required
 * Type
 * Constraints
 * Description
 * <p>
 * type
 * yes
 * string
 * None
 * The required data type for the attribute.
 * <p>
 * description
 * no
 * description
 * None
 * The optional description for the attribute.
 * <p>
 * default
 * no
 * <any>
 * None
 * An optional key that may provide a value to be used as a default if not provided by another means.
 * This value SHALL be type compatible with the type declared by the property definition’s type keyname.
 * <p>
 * status
 * no
 * string
 * default: supported
 * The optional status of the attribute relative to the specification or implementation. See supported status values defined under the Property definition section.
 * <p>
 * entry_schema
 * no
 * string
 * None
 * The optional key that is used to declare the name of the Datatype definition for entries of set types such as the TOSCA list or map.
 * <p>
 * Grammar
 * <p>
 * attributes:
 * <attribute_name>:
 * type: <attribute_type>
 * description: <attribute_description> default: <default_value>
 * status: <status_value>
 * <p>
 * <p>
 * attribute_name: represents the required symbolic name of the attribute as a string.
 * attribute_type: represents the required data type of the attribute.
 * attribute_description: represents the optional description of the attribute.
 * default_value: contains a type-compatible value that may be used as a default if not provided byanother means.
 * status_value: contains a value indicating the attribute’s status relative to the specification version (e.g., supported, deprecated, etc.). Supported status values for this keyname are defined under Property definition.
 */

public class AttributeDefinition {
}
