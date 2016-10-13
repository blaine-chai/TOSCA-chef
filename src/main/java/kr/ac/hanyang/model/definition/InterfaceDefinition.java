package kr.ac.hanyang.model.definition;

import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.collection.Inputs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by blainechai on 2016. 10. 10..
 */

/*
Keyname
Required
Type
Description

inputs
no
list of property definitions
The optional list of input property definitions available to all defined operations for interface definitions that are within TOSCA Node or Relationship Type definitions. This includes when interface definitions are included as part of a Requirement definition in a Node Type.

no
list of property assignments
The optional list of input property assignments (i.e., parameters assignments) for interface definitions that are within TOSCA Node or Relationship Template definitions. This includes when interface definitions are referenced as part of a Requirement assignment in a Node Template.

<interface_definition_name>:
  type: <interface_type_name>
  inputs:
    <property_definitions>
  <operation_definitions>

<interface_definition_name>:
  inputs:
  <property_assignments>
<operation_definitions>
 */
public class InterfaceDefinition extends DefinitionValidator{
    public String type;
    public String interfaceDName;
    public Inputs inputs;
    public ArrayList<OperationDefinition> operationDefinitions = new ArrayList<>();

    public InterfaceDefinition() {
    }

    public InterfaceDefinition(LinkedHashMap data, String interfaceDName) {
        this.data = data;
        this.interfaceDName= interfaceDName;
        for (Object key : data.keySet()) {
            if (key.toString().equals("inputs")) {
                inputs = new Inputs((LinkedHashMap) data.get(key.toString()));
            } else if (key.toString().equals("type")) {
                type = data.get(key.toString()).toString();
            } else {
                operationDefinitions.add(new OperationDefinition(data.get(key.toString()), key.toString()));
            }
        }
    }
}
