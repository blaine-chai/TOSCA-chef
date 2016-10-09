package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.Map;

/**
 * 3.6.4 Interface Type
 Keyname
 Required
 Type
 Description
 derived_from
 no
 string
 An optional parent Interface Type name this new Interface Type derives from.
 version
 no
 version
 An optional version for the Interface Type definition.
 description
 no
 description
 An optional description for the Interface Type.
 inputs
 no
 list of
 property definitions
 The optional list of input parameter definitions.
 */

public class InterfaceType extends TypeValidator {

    public InterfaceType(){}

    public InterfaceType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent Interface Type name this new Interface Type derives from."));
        keyNames.add(new KeyName("version", false, "version", "An optional version for the Interface Type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Interface Type."));
        keyNames.add(new KeyName("inputs", false, "list ofproperty definitions", "The optional list of input parameter definitions."));


    }

}