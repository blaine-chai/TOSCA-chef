package kr.ac.hanyang.model.collection;

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.ImportDefinition;

import java.util.ArrayList;

/**
 * Created by blainechai on 2016. 10. 13..
 */
public class Imports extends CollectionValidator {

    public ArrayList<ImportDefinition> data =  new ArrayList<>();

    public Imports(ArrayList data) {
        for (Object o : data) {
            this.data.add(new ImportDefinition(o));
        }
    }
}
