package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 * <p>
 * 3.5.1 Description definition
 */

/**
 * 3.5.1 Description definition
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The YAML “folded” style may also be used for multi-line descriptions which “folds” line breaks as space characters.
 */


//TODO: String
public class DescriptionDefinition extends DefinitionValidator{
    public static final String GRAMMAR = "description: <string>";

    public DescriptionDefinition(){}

    public DescriptionDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("description", true, "string", "This optional element provides a means include single or multiline descriptions within a TOSCA Simple Profile template as a scalar string value."));


    }
}
