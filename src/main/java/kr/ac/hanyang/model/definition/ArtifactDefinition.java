package kr.ac.hanyang.model.definition;

/*
 * 3.5.6 Artifact definition
 */

/*
 *
 Keyname
 Required
 type
 Description

 type
 yes
 string
 The required artifact type for the artifact definition.

 file
 yes
 string
 The required URI string (relative or absolute) which can be used to locate the artifact’s file.

 repository
 no
 string
 The optional name of the repository definition which contains the location of the external repository that contains the artifact. The artifact is expected to be referenceable by its file URI within the repository.

 description
 no
 description
 The optional description for the artifact definition.
 deploy_path
 no
 string
 The file path the associated file would be deployed into within the target node’s container.
 */

import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * grammar
 *
 * Short notation
 *<artifact_name>: <artifact_file_URI>
 *
 *
 * <artifact_name>:
 description: <artifact_description>
 type: <artifact_type_name>
 file: <artifact_file_URI>
 repository: <artifact_repository_name>
 deploy_path: <file_deployment_path>

 artifact_name: represents the required symbolic name of the artifact as a string.
 artifact_description: represents the optional description for the artifact.
 artifact_type_name: represents the required artifact type the artifact definition is based upon.
 artifact_file_URI: represents the required URI string (relative or absolute) which can
 be used to locate the artifact’s file.
 artifact_repository_name: represents the optional name of the repository definition to use to
 retrieve the associated artifact (file) from.
 file_deployement_path: represents the optional path the artifact_file_URI would be copied into
 within the target node’s container.

 */

//TODO: list로 구현하여 어떤 모양을 지정하는 방식으로 구현
public class ArtifactDefinition extends DefinitionValidator {



    public ArtifactDefinition(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("type", true, "string", "The required artifact type for the artifact definition."));
        keyNames.add(new KeyName("file", true, "string", "The required URI string (relative or absolute) which can be used to locate the artifact’s file."));
        keyNames.add(new KeyName("repository", false, "string", "The optional name of the repository definition which contains the location of the external repository that contains the artifact. The artifact is expected to be referenceable by its file URI within the repository."));
        keyNames.add(new KeyName("description", false, "description", "The optional description for the artifact definition."));
        keyNames.add(new KeyName("deploy_path", false, "string", "The file path the associated file would be deployed into within the target node’s container."));

    }

}
