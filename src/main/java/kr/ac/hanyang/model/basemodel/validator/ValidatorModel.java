package kr.ac.hanyang.model.basemodel.validator;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by blainechai on 2016. 10. 8..
 */
public abstract class ValidatorModel extends LinkedHashMap {

    public KeyNames keyNames;
    public Map data;

    public ValidatorModel(Map data) {
        super();
        this.data = data;
    }

    public ValidatorModel() {
        data = new LinkedHashMap();
        keyNames = new KeyNames();
    }

    public boolean isValid() {
        // 1. 키가 전부 존재하는지 확인
        // 2. required인 키가 존재하는지 확인
        // 3. type이 맞는지 확인
        return isValidKeyNames() && isRequiredValid();

    }

    public KeyNames getKeyNames() {
        return keyNames;
    }

    public boolean isKeyRequired(String key) {
        return keyNames.get(key).isRequired();
    }

    private boolean isValidKeyNames() {
        for (Object entry : this.data.entrySet()) {
            if (!keyNames.contains(((Map.Entry) entry).getKey().toString())) {
                return false;
            }
        }
        return true;
    }

    private boolean isDataContainsKeyName(String key) {
        for (Object entry : this.data.entrySet()) {
            if (((Map.Entry) entry).getKey().toString().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDataContainsKeyName(KeyName keyName) {
        return isDataContainsKeyName(keyName.getKeyName());
    }

    private boolean isRequiredValid() {
        for (KeyName keyName : keyNames) {
            if (keyName.isRequired()) {
                if (!isDataContainsKeyName(keyName.getKeyName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setKeyNames(KeyNames keyNames) {
        this.keyNames = keyNames;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String rtn = "";
        for (KeyName keyName : keyNames) {
            rtn += keyName.getKeyName() + " ";
        }
        return rtn;
    }
}
