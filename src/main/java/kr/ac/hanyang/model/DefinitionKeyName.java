package kr.ac.hanyang.model;

/**
 * Created by blainechai on 2016. 10. 4..
 */
public class DefinitionKeyName extends KeyName{
    private String constraint;

    public DefinitionKeyName(){
    }

    public DefinitionKeyName(String keyName, boolean required, String type, String description, String constraint) {
        super(keyName, required, type, description);
        this.constraint = constraint;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }
}
