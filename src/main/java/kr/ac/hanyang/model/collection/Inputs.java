package kr.ac.hanyang.model.collection; /**
 * 3.8.2.1 inputs
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;

import java.util.Map;

/**
 * Grammar
 * inputs:
 * <parameter_definition_list>

 */

public class Inputs extends CollectionValidator {

    public Inputs() {
    }

    public Inputs(Map data) {
        super();
        this.data = data;
    }

}