package kr.ac.hanyang.model.collection; /**
 * 3.8.2.6 policies
 */

import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;
import kr.ac.hanyang.model.definition.ParameterDefinition;
import kr.ac.hanyang.model.definition.PolicyDefinition;

import java.util.ArrayList;
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
//list
public class Policies extends ValidatorModel{

    ArrayList<PolicyDefinition> policyDefinitions = new ArrayList<>();

    public Policies() {
    }

    public Policies(Map data) {
        super();
        this.data = data;
        for (Object o : data.values()) {
            policyDefinitions.add(new PolicyDefinition((Map) o));
        }
    }
}