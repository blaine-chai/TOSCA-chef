package kr.ac.hanyang.model.definition;

/*
 * 3.5.5 Repository definition
 */

/*
 * Keyname
 Required
 type
 Constraints
 Description

 description
 no
 description
 None
 The optional description for the repository.

 url
 yes
 string
 None
 The required URL or network address used to access the repository.

 credential
 no
 Credential
 None
 The optional Credential used to authorize access to the repository.
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.util.Map;

/**
 * grammar
 * <p>
 * single line
 * <repository_name>: <repository_address>
 * <p>
 * <p>
 * multi line
 * <repository_name>:
 * description: <repository_description>
 * url: <repository_address>
 * credential: <authorization_credential>
 */
public class RepositoryDefinition extends DefinitionValidator {

    public RepositoryDefinition(){}

    public RepositoryDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("description", false, "description", "The optional description for the repository.", "None"));
        keyNames.add(new KeyName("url", true, "string", "The required URL or network address used to access the repository.", "None"));
        keyNames.add(new KeyName("credential", false, "Credential", "The optional Credential used to authorize access to the repository.", "None"));
    }
}