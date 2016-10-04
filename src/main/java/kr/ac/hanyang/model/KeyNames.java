package kr.ac.hanyang.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by blainechai on 2016. 10. 4..
 */
public class KeyNames extends ArrayList<KeyName> {

    public KeyNames() {
        super();
    }

    public KeyName get(String keyName) {
        for (KeyName target : this) {
            if (keyName.equals(target.getKeyName())) {
                return target;
            }
        }
        return null;
    }
}
