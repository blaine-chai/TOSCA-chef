package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.collection.Inputs;
import sun.awt.image.ImageWatched;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.13 Operation definition
 */


/*
Keyname
Required
Type
Description

description
no
description
The optional description string for the associated named operation.

implementation
no
string
The optional implementation artifact name (e.g., a script file name within a TOSCA CSAR file).

inputs
no
list of property definitions
The optional list of input properties definitions (i.e., parameter definitions) for operation definitions that are within TOSCA Node or Relationship Type definitions. This includes when operation definitions are included as part of a Requirement definition in a Node Type.
no
list of property assignments
The optional list of input property assignments (i.e., parameters assignments) for operation definitions that are within TOSCA Node or Relationship Template definitions. This includes when operation definitions are included as part of a Requirement assignment in a Node Template.
 */

public class OperationDefinition extends DefinitionValidator {

    public String description;
    public String operationName;
    public String implementation;
    public Inputs inputs;

    public OperationDefinition() {
    }

    public OperationDefinition(Object data, String operationName) {
        super();
        this.operationName = operationName;
        if (data.getClass().getSimpleName().equals(String.class.getSimpleName())) {
            this.implementation = data.toString();
        } else {
            for (Object key : ((Map) data).keySet()) {
                if (key.toString().equals("description")) {
                    description = ((Map) data).get(key.toString()).toString();
                } else if (key.toString().equals("inputs")) {
                    inputs = new Inputs((LinkedHashMap) ((Map) data).get(key.toString()));
                } else if (key.toString().equals("implementation")) {
                    implementation = ((Map) data).get(key.toString()).toString();
                }
            }
        }
    }
}
