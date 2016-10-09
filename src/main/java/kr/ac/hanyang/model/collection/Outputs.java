package kr.ac.hanyang.model.collection; /**
 * 3.8.2.4 outputs
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.ParameterDefinition;

import java.util.ArrayList;
import java.util.Map;

/**
 * Grammar
 * outputs:
 * <parameter_def_list>
 */

public class Outputs extends CollectionValidator {
    public ArrayList<ParameterDefinition> parameterDefinitions = new ArrayList<>();

    public Outputs() {
    }

    public Outputs(Map data) {
        super();
        this.data = data;

        for (Object o : data.values()) {
            parameterDefinitions.add(new ParameterDefinition((Map) o));
        }
    }
}