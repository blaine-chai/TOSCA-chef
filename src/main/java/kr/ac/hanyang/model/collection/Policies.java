package kr.ac.hanyang.model.collection; /**
 * 3.8.2.6 policies
 */

import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;

import java.util.Map;

/**
 * Grammar
 * policies:
 * - <policy_defn_1>
 * - ...
 * - <policy_defn_n>
 * type
 * Value type
 * Description
 */

public class Policies extends ValidatorModel{
    public Policies() {
    }

    public Policies(Map data) {
        super();
        this.data = data;
    }
}