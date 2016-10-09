package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.util.Map;

/**
 * 3.5.13 Operation definition
 */

//TODO: 복잡하당 ㅠ

public class OperationDefinition extends DefinitionValidator {

    public OperationDefinition() {
    }

    public OperationDefinition(Map data) {
        super();
        this.data = data;
    }
}
