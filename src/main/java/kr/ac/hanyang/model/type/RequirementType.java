package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

/**
 * 3.6.7 Requirement Type
 * A Requirement Type is a reusable entity that describes a kind of requirement that a Node Type can declare to expose. The TOSCA Simple Profile seeks to simplify the need for declaring specific Requirement Types from nodes and instead rely upon nodes declaring their features sets using TOSCA Capability Types along with a named Feature notation.
 * Currently, there are no use cases in this TOSCA Simple Profile in YAML specification that utilize an independently defined Requirement Type. This is a desired effect as part of the simplification of the TOSCA v1.0 specification.
 */
public class RequirementType extends TypeValidator{
}
