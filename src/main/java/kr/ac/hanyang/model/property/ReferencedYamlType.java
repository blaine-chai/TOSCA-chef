package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */
public interface ReferencedYamlType {
    public final static String STRING = "string";
    public final static String INTEGER = "integer";
    public final static String FLOAT = "float";
    public final static String BOOLEAN = "boolean";
    public final static String TIMESTAMP = "timestamp";
    public final static String NULL = "null";
    public final static String STRING_URI = "tag:yaml.org,2002:str";
    public final static String INTEGER_URI = "tag:yaml.org,2002:int";
    public final static String FLOAT_URI = "tag:yaml.org,2002:float";
    public final static String BOOLEAN_URI = "tag:yaml.org,2002:bool";
    public final static String TIMESTAMP_URI = "tag:yaml.org,2002:timestamp";
    public final static String NULL_URI = "tag:yaml.org,2002:null";
}
