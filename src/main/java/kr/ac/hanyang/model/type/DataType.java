package kr.ac.hanyang.model.type;


import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.Map;

/**
 * 3.6.5 Data Type

 Keyname
 Required
 Type
 Description

 derived_from
 no
 string
 The optional key used when a datatype is derived from an existing TOSCA Data Type.

 version
 no
 version
 An optional version for the Data Type definition.

 description
 no
 description
 The optional description for the Data Type.
 constraints
 no
 list of
 constraint clauses
 The optional list of sequenced constraint clauses for the Data Type.

 properties
 no
 list of
 property definitions
 The optional list property definitions that comprise the schema for a complex Data Type in TOSCA.

 */

public class DataType extends TypeValidator {

    public DataType(){
        super();
        keyNames.add(new KeyName("derived_from", false, "string",  "The optional key used when a datatype is derived from an existing TOSCA Data Type."));
        keyNames.add(new KeyName("version", false, "version",  "An optional version for the Data Type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Data Type."));
        keyNames.add(new KeyName("constraints" , false, "list of constraint clauses", "The optional list of sequenced constraint clauses for the Data Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "The optional list property definitions that comprise the schema for a complex Data Type in TOSCA."));
    }

    public DataType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string",  "The optional key used when a datatype is derived from an existing TOSCA Data Type."));
        keyNames.add(new KeyName("version", false, "version",  "An optional version for the Data Type definition."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the Data Type."));
        keyNames.add(new KeyName("constraints" , false, "list of constraint clauses", "The optional list of sequenced constraint clauses for the Data Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "The optional list property definitions that comprise the schema for a complex Data Type in TOSCA."));
    }

}
