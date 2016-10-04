package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

/**
 * 3.5.3 Property Filter definition
 */

/**
 * <property_name>: <property_constraint_clause>
 *
 *
 *
 *     <property_name>:
 - <property_constraint_clause_1>
 - ...
 - <property_constraint_clause_n>

 property_name: represents the name of property that would be used to select a property definition with the same name (property_name) on a TOSCA entity (e.g., a Node Type, Node Template, Capability Type, etc.).
 property_constraint_clause_*: represents constraint clause(s) that would be used to filter entities based upon the named property’s value(s).
 */
public class PropertyFilterDefinition {

}
