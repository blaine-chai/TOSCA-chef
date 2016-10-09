package kr.ac.hanyang.model.type;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.basemodel.validator.TypeValidator;

import java.util.Map;

/**
 * 3.6.6 Capability Type
 */

public class CapabilityType extends TypeValidator {

    public CapabilityType(){
        super();
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent capability type name this new Capability Type derives from."));
        keyNames.add(new KeyName("version", false, "version",  "An optional version for the Capability Type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Capability Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Capability Type."));
        keyNames.add(new KeyName("attributes", false, "list of attribute definitions", "An optional list of attribute definitions for the Capability Type."));
        keyNames.add(new KeyName("valid_source_types", false, "string[]",  "An optional list of one or more valid names of Node Types that are supported as valid sources of any relationship established to the declared Capability Type."));
    }

    public CapabilityType(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("derived_from", false, "string", "An optional parent capability type name this new Capability Type derives from."));
        keyNames.add(new KeyName("version", false, "version",  "An optional version for the Capability Type definition."));
        keyNames.add(new KeyName("description", false, "description", "An optional description for the Capability Type."));
        keyNames.add(new KeyName("properties", false, "list of property definitions", "An optional list of property definitions for the Capability Type."));
        keyNames.add(new KeyName("attributes", false, "list of attribute definitions", "An optional list of attribute definitions for the Capability Type."));
        keyNames.add(new KeyName("valid_source_types", false, "string[]",  "An optional list of one or more valid names of Node Types that are supported as valid sources of any relationship established to the declared Capability Type."));

    }

}
