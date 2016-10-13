package kr.ac.hanyang.model.collection; /**
 * 3.8.2.1 inputs
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.GroupDefinition;
import kr.ac.hanyang.model.definition.ParameterDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Grammar
 * inputs:
 * <parameter_definition_list>
 */

//TODO: List
public class Inputs extends CollectionValidator {

    public ArrayList<ParameterDefinition> parameterDefinitions = new ArrayList<>();

    public Inputs() {
    }

    public Inputs(LinkedHashMap data) {
        super();
        this.data = data;
        for (Object o : data.keySet()) {
            parameterDefinitions.add(new ParameterDefinition((Map) data.get(o.toString()), o.toString()));
        }
    }

    @Override
    public String toString() {
        String rtn = "";
        for (ParameterDefinition pDefinition : parameterDefinitions) {
            rtn += pDefinition.parameterName + " " + pDefinition.type + " " + pDefinition.value + "\n";
        }
        return rtn;
    }
}