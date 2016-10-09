package kr.ac.hanyang.model.collection; /**
 * 3.8.2.5 groups
 */

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;

import java.util.Map;

/**
 * list of GroupType
 *
 * Grammar
 * groups:
 * <group_defn_1>
 * ...
 * <group_defn_n>
*/

public class Groups extends CollectionValidator{
    public Groups() {
    }

    public Groups(Map data) {
        super();
        this.data = data;
    }
}