package kr.ac.hanyang.model;

/**
 * Created by blainechai on 2016. 10. 4..
 */
public class KeyName {
    private String keyName;
    private boolean required;
    private String type;
    private String description;
    private String constraint;

    public KeyName() {
    }

    public KeyName(String keyName, boolean required, String type, String description) {
        this.keyName = keyName;
        this.required = required;
        this.type = type;
        this.description = description;
    }

    public KeyName(String keyName, boolean required, String type, String description, String constraint) {
        this.keyName = keyName;
        this.required = required;
        this.type = type;
        this.description = description;
        this.constraint = constraint;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }
}
