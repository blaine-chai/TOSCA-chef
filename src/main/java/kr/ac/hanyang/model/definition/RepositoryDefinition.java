package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 * <p>
 * 3.5.5 Repository definition
 * <p>
 * Keyname
 * Required
 * Type
 * Constraints
 * Description
 * <p>
 * description
 * no
 * description
 * None
 * The optional description for the repository.
 * <p>
 * url
 * yes
 * string
 * None
 * The required URL or network address used to access the repository.
 * <p>
 * credential
 * no
 * Credential
 * None
 * The optional Credential used to authorize access to the repository.
 */

/**
 * 3.5.5 Repository definition
 */

/**
 * Keyname
 Required
 Type
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

import kr.ac.hanyang.model.basemodel.ToscaValidator;
import kr.ac.hanyang.model.DefinitionKeyName;
import kr.ac.hanyang.model.DefinitionKeyNames;

/**
 * grammar
 *
 * single line
 * <repository_name>: <repository_address>
 *
 *
 * multi line
 * <repository_name>:
 description: <repository_description>
 url: <repository_address>
 credential: <authorization_credential>
 */
public class RepositoryDefinition implements ToscaValidator {

    private DefinitionKeyNames keyNames;

    public RepositoryDefinition() {
        super();
        keyNames = new DefinitionKeyNames();
        keyNames.add(new DefinitionKeyName("description", false, "description", "The optional description for the repository.", "None"));
        keyNames.add(new DefinitionKeyName("url", true, "string", "The required URL or network address used to access the repository.", "None"));
        keyNames.add(new DefinitionKeyName("credential", false, "Credential", "The optional Credential used to authorize access to the repository.", "None"));
    }

    public boolean isValid() {
        return false;
    }
}