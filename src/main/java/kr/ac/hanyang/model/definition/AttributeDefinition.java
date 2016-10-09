package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;

import java.util.Map;

/**
 * 3.5.10 Attribute definition
 * <p>
 * Keyname
 * Required
 * type
 * Constraints
 * Description
 * <p>
 * type
 * yes
 * string
 * None
 * The required data type for the attribute.
 * <p>
 * description
 * no
 * description
 * None
 * The optional description for the attribute.
 * <p>
 * default
 * no
 * <any>
 * None
 * An optional key that may provide a value to be used as a default if not provided by another means.
 * This value SHALL be type compatible with the type declared by the property definition’s type keyname.
 * <p>
 * status
 * no
 * string
 * default: supported
 * The optional status of the attribute relative to the specification or implementation. See supported status values defined under the Property definition section.
 * <p>
 * entry_schema
 * no
 * string
 * None
 * The optional key that is used to declare the name of the Datatype definition for entries of set types such as the TOSCA list or map.
 * <p>
 * Grammar
 * <p>
 * attributes:
 * <attribute_name>:
 * type: <attribute_type>
 * description: <attribute_description> default: <default_value>
 * status: <status_value>
 * <p>
 * <p>
 * attribute_name: represents the required symbolic name of the attribute as a string.
 * attribute_type: represents the required data type of the attribute.
 * attribute_description: represents the optional description of the attribute.
 * default_value: contains a type-compatible value that may be used as a default if not provided byanother means.
 * status_value: contains a value indicating the attribute’s status relative to the specification version (e.g., supported, deprecated, etc.). Supported status values for this keyname are defined under Property definition.
 */

//TODO: AttributeType list로 구현하여 어떤 모양을 지정하는 방식으로 구현

public class AttributeDefinition extends DefinitionValidator {

    public AttributeDefinition(){}

    public AttributeDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required data type for the attribute."));
        keyNames.add(new KeyName("description", false, "description", "The required URI string (relative or absolute) which can be used to locate the artifact’s file."));
        keyNames.add(new KeyName("repository", false, "string", "The optional name of the repository definition which contains the location of the external repository that contains the artifact. The artifact is expected to be referenceable by its file URI within the repository."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the artifact definition."));
        keyNames.add(new KeyName("deploy_path", false, "string", "The file path the associated file would be deployed into within the target node’s container."));
    }

}
