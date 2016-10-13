package kr.ac.hanyang.model.collection; /**
 * 3.8.2.4 outputs
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.ParameterDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Grammar
 * outputs:
 * <parameter_def_list>
 */
//list
public class Outputs extends CollectionValidator {
    public ArrayList<ParameterDefinition> parameterDefinitions = new ArrayList<>();

    public Outputs() {
    }

    public Outputs(LinkedHashMap data) {
        super();
        this.data = data;

        for (Object o : data.keySet()) {
            parameterDefinitions.add(new ParameterDefinition((Map) data.get(o),o.toString()));
        }
    }
}