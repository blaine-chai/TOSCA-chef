package kr.ac.hanyang.model.template;

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.TemplateValidator;
import kr.ac.hanyang.model.basemodel.validator.ValidatorModel;
import kr.ac.hanyang.model.definition.ArtifactDefinition;
import kr.ac.hanyang.model.definition.ImportDefinition;
import kr.ac.hanyang.model.definition.RepositoryDefinition;
import kr.ac.hanyang.model.type.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by blainechai on 2016. 10. 5..
 */
/* 3.9 Service Template definition
In the TOSCA Simple Profile, TOSCA Service Templates MUST always have, as the first line of YAML, the keyword “tosca_definitions_version” with an associated TOSCA Namespace Alias value. This single line accomplishes the following:
1. Establishes the TOSCA Simple Profile Specification version whose grammar MUST be used to parse and interpret the contents for the remainder of the TOSCA Service Template.
2. Establishes the default TOSCA Namespace URI and Namespace Prefix for all types found in the document that are not explicitly namespaced.
3. Automatically imports (without the use of an explicit import statement) the normative type definitions (e.g., Node, Relationship, Capability, Artifact, etc.) that are associated with the TOSCA Simple Profile Specification the TOSCA Namespace Alias value identifies.
4. Associates the TOSCA Namespace URI and Namespace Prefix to the automatically imported TOSCA type definitions.

o Since TOSCA Service Templates can import (or substitute in) other Service Templates, TOSCA Orchestrators and tooling will encounter the “tosca_definitions_version” statement for each imported template. In these cases, the following additional requirements apply:
o Imported type definitions with the same Namespace URI, local name and version SHALL be equivalent.
o If different values of the “tosca_definitions_version” are encountered, their corresponding type definitions MUST be uniquely identifiable using their corresponding Namespace URI using a different Namespace prefix.
  Duplicate local names (i.e., within the same Service Template SHALL be considered an error. These include, but are not limited to duplicate names found for the following definitions:
    o Repositories(repositories)
    o Data Types (data_types)
    o NodeTypes(node_types)
    o RelationshipTypes(relationship_types) o CapabilityTypes(capability_types)
    o ArtifactTypes(artifact_types)
    o InterfaceTypes(interface_types)
  Duplicate Template names within a Service Template’s Topology Template SHALL be considered an
error. These include, but are not limited to duplicate names found for the following template types: o NodeTemplates(node_templates)
    o RelationshipTemplates(relationship_templates)
    o Inputs(inputs)
    o Outputs(outputs)
    o Groups (groups)
  Duplicate names for the following keynames within Types or Templates SHALL be considered an error.
These include, but are not limited to duplicate names found for the following keynames: o Properties(properties)
    o Attributes(attributes)
    o Artifacts(artifacts)
    o Requirements(requirements) o Capabilities(capabilities)
    o Interfaces(interfaces)


Keyname
Required
Type
Description

tosca_definitions_version
yes
string
Defines the version of the TOSCA Simple Profile specification the template (grammar) complies with.

metadata
no
map of string
Defines a section used to declare additional metadata information. Domain-specific TOSCA profile specifications may define keynames that are required for their implementations.

description
no
description
Declares a description for this Service Template and its contents.

dsl_definitions
no
N/A
Declares optional DSL-specific definitions and conventions. For example, in YAML, this allows defining reusable YAML macros (i.e., YAML alias anchors) for use throughout the TOSCA Service Template.

repositories
no
list of
Repository definitions
Declares the list of external repositories which contain artifacts that are referenced in the service template along with their addresses and necessary credential information used to connect to them in order to retrieve the artifacts.

imports
no
list of
Import Definitions
Declares import statements external TOSCA Definitions documents. For example, these may be file location or URIs relative to the service template file within the same TOSCA CSAR file.

artifact_types
no
list of Artifact Types
This section contains an optional list of artifact type definitions for use in the service template

data_types
no
list of Data Types
Declares a list of optional TOSCA Data Type definitions.

capability_types
no
list of Capability Types
This section contains an optional list of capability type definitions for use in the service template.

interface_types
no
list of Interface Types
This section contains an optional list of interface type definitions for use in the service template.

relationship_types
no
list of Relationship Types
This section contains a set of relationship type definitions for use in the service template.

node_types
no
list of Node Types
This section contains a set of node type definitions for use in the service template.

group_types
no
list of Group Types
This section contains a list of group type definitions for use in the service template.

policy_types
no
list of Policy Types
This section contains a list of policy type definitions for use in the service template.

topology_template
no
Topology Template definition
Defines the topology template of an application or service, consisting of node templates that represent the application’s or service’s components, as well as relationship templates representing relations between the components.
 */




/*
Metadata keynames

Keyname
Required
Type
Description

template_name
no
string
Declares a descriptive name for the template.

template_author
no
string
Declares the author(s) or owner of the template.

template_version
no
string
Declares the version string for the template.
 */

public class ServiceTemplate extends TemplateValidator {

    public String tosca_definitions_version;
    public Metadata metadata = new Metadata();
    public String description;
    public String dsl_definitions;
    public ArrayList<RepositoryDefinition> repositories = new ArrayList<>();
    public ArrayList<ImportDefinition> imports = new ArrayList<>();
    public ArrayList<ArtifactType> artifact_types = new ArrayList<>();
    public ArrayList<DataType> data_types = new ArrayList<>();
    public ArrayList<CapabilityType> capability_types = new ArrayList<>();
    public ArrayList<InterfaceType> interface_types = new ArrayList<>();
    public ArrayList<RelationshipType> relationship_types = new ArrayList<>();
    public ArrayList<NodeType> node_types = new ArrayList<>();
    public ArrayList<GroupType> group_types = new ArrayList<>();
    public ArrayList<PolicyType> policy_types = new ArrayList<>();
    public TopologyTemplate topology_template;

    public ServiceTemplate() {
        super();
        keyNames.add(new KeyName("tosca_definitions_version", true, "string", "Defines the version of the TOSCA Simple Profile specification the template (grammar) complies with."));
        keyNames.add(new KeyName("metadata", false, "map of string", "Defines a section used to declare additional metadata information. Domain-specific TOSCA profile specifications may define keynames that are required for their implementations."));
        keyNames.add(new KeyName("description", false, "description", "Declares a description for this Service Template and its contents."));
        keyNames.add(new KeyName("dsl_definitions", false, "N/A", "Declares optional DSL-specific definitions and conventions. For example, in YAML, this allows defining reusable YAML macros (i.e., YAML alias anchors) for use throughout the TOSCA Service Template."));
        keyNames.add(new KeyName("repositories", false, "list of Repository definitions", "Declares the list of external repositories which contain artifacts that are referenced in the service template along with their addresses and necessary credential information used to connect to them in order to retrieve the artifacts."));
        keyNames.add(new KeyName("imports", false, "list of Import Definitions", "Declares import statements external TOSCA Definitions documents. For example, these may be file location or URIs relative to the service template file within the same TOSCA CSAR file."));
        keyNames.add(new KeyName("artifact_types", false, "list of Artifact Types", "This section contains an optional list of artifact type definitions for use in the service template."));
        keyNames.add(new KeyName("data_types", false, "list of Data Types", "Declares a list of optional TOSCA Data Type definitions."));
        keyNames.add(new KeyName("capability_types", false, "list of Capability Types", "This section contains an optional list of capability type definitions for use in the service template."));
        keyNames.add(new KeyName("interface_types", false, "list of Interface Types", "This section contains an optional list of interface type definitions for use in the service template."));
        keyNames.add(new KeyName("relationship_types", false, "list of Relationship Types", "This section contains a set of relationship type definitions for use in the service template."));
        keyNames.add(new KeyName("node_types", false, "list of Node Types", "This section contains a set of node type definitions for use in the service template."));
        keyNames.add(new KeyName("group_types", false, "list of Group Types", "This section contains a list of group type definitions for use in the service template."));
        keyNames.add(new KeyName("policy_types", false, "list of Policy Types", "This section contains a list of policy type definitions for use in the service template."));
        keyNames.add(new KeyName("topology_template", false, "Topology Template definition", "Defines the topology template of an application or service, consisting of node templates that represent the application’s or service’s components, as well as relationship templates representing relations between the components."));

    }

    public ServiceTemplate(Map data) {
        super();
        this.data = data;
        keyNames.add(new KeyName("tosca_definitions_version", true, "string", "Defines the version of the TOSCA Simple Profile specification the template (grammar) complies with."));
        keyNames.add(new KeyName("metadata", false, "map of string", "Defines a section used to declare additional metadata information. Domain-specific TOSCA profile specifications may define keynames that are required for their implementations."));
        keyNames.add(new KeyName("description", false, "description", "Declares a description for this Service Template and its contents."));
        keyNames.add(new KeyName("dsl_definitions", false, "N/A", "Declares optional DSL-specific definitions and conventions. For example, in YAML, this allows defining reusable YAML macros (i.e., YAML alias anchors) for use throughout the TOSCA Service Template."));
        keyNames.add(new KeyName("repositories", false, "list of Repository definitions", "Declares the list of external repositories which contain artifacts that are referenced in the service template along with their addresses and necessary credential information used to connect to them in order to retrieve the artifacts."));
        keyNames.add(new KeyName("imports", false, "list of Import Definitions", "Declares import statements external TOSCA Definitions documents. For example, these may be file location or URIs relative to the service template file within the same TOSCA CSAR file."));
        keyNames.add(new KeyName("artifact_types", false, "list of Artifact Types", "This section contains an optional list of artifact type definitions for use in the service template."));
        keyNames.add(new KeyName("data_types", false, "list of Data Types", "Declares a list of optional TOSCA Data Type definitions."));
        keyNames.add(new KeyName("capability_types", false, "list of Capability Types", "This section contains an optional list of capability type definitions for use in the service template."));
        keyNames.add(new KeyName("interface_types", false, "list of Interface Types", "This section contains an optional list of interface type definitions for use in the service template."));
        keyNames.add(new KeyName("relationship_types", false, "list of Relationship Types", "This section contains a set of relationship type definitions for use in the service template."));
        keyNames.add(new KeyName("node_types", false, "list of Node Types", "This section contains a set of node type definitions for use in the service template."));
        keyNames.add(new KeyName("group_types", false, "list of Group Types", "This section contains a list of group type definitions for use in the service template."));
        keyNames.add(new KeyName("policy_types", false, "list of Policy Types", "This section contains a list of policy type definitions for use in the service template."));
        keyNames.add(new KeyName("topology_template", false, "Topology Template definition", "Defines the topology template of an application or service, consisting of node templates that represent the application’s or service’s components, as well as relationship templates representing relations between the components."));


        for (Object key : data.keySet()) {
            System.out.println(key.toString() + "1");

            try {
                Field field = this.getClass().getField(key.toString());
                String simpleClassName = field.getType().getSimpleName();
                System.out.println(simpleClassName);
                if (simpleClassName.equals(String.class.getSimpleName())) {
                    field.set(this, data.get(key).toString());
                    System.out.println(this.getClass().getField(key.toString()).get(this));
                } else if (simpleClassName.equals(ArrayList.class.getSimpleName())) {
                    System.out.println(((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]);
                    field.set(this, Class.forName(field.getType().getName()).newInstance());
                    System.out.println(this.getClass().getField(key.toString()).get(this).getClass() + "!!!!!!!!!!!!!!");
//                    data.get(key)
                } else {
                    Class cl = Class.forName(field.getType().getName());
                    Constructor constructor = cl.getConstructor(Map.class);
                    Object o = constructor.newInstance((Map) data.get(key.toString()));
                    field.set(this, o);
                    System.out.println(this.getClass().getField(key.toString()).get(this));
                }
//                System.out.println(field.getName());

//                Class cl = Class.forName((String) key);
//                    System.out.println(cl.newInstance());
//            System.out.println((((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0]));
//                Method method = this.getClass().getMethod("getKeyNames");
//                System.out.println(this.getClass().getField("description").get(this));
//                System.out.println(method.invoke(this));
//
//                Field field1 = this.getClass().getField("topology_template");
//                System.out.println(field1.get(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isValid() {

        if (!(super.isValid() && metadata.isValid())) {
            System.out.println("1");
            return false;
        }


        for (RepositoryDefinition repositoryDefinition : repositories) {
            if (!repositoryDefinition.isValid()) {
                System.out.println("2");
                return false;
            }
        }

        for (ImportDefinition importDefinition : imports) {
            if (!importDefinition.isValid()) {
                System.out.println("3");
                return false;
            }
        }

        for (ArtifactType artifactType : artifact_types) {
            if (!artifactType.isValid()) {
                System.out.println("4");
                return false;
            }
        }

        for (DataType dataType : data_types) {
            if (!dataType.isValid()) {
                System.out.println("5");
                return false;
            }
        }

        for (CapabilityType capabilityType : capability_types) {
            if (!capabilityType.isValid()) {
                System.out.println("6");
                return false;
            }
        }

        for (InterfaceType interfaceType : interface_types) {
            if (!interfaceType.isValid()) {
                System.out.println("7");
                return false;
            }
        }

        for (RelationshipType relationshipType : relationship_types) {
            if (!relationshipType.isValid()) {
                System.out.println("8");
                return false;
            }
        }

        for (NodeType nodeType : node_types) {
            if (!nodeType.isValid()) {
                System.out.println("9");
                return false;
            }
        }

        for (GroupType groupType : group_types) {
            if (!groupType.isValid()) {
                System.out.println("10");
                return false;
            }
        }

        for (PolicyType policyType : policy_types) {
            if (!policyType.isValid()) {
                System.out.println("11");
                return false;
            }
        }

        if (topology_template != null) {
            if (!topology_template.isValid()) {
                System.out.println("11");
                return false;
            }
        }
        return true;
    }

    public void setData() {

    }

    public KeyNames getKeyNames() {
        return keyNames;
    }


    private class Metadata extends ValidatorModel {

        Metadata(){}

        Metadata(Map data) {
            super();
            this.data = data;
            keyNames.add(new KeyName("template_name", false, "string", "Declares a descriptive name for the template."));
            keyNames.add(new KeyName("template_author", false, "string", "Declares the author(s) or owner of the template."));
            keyNames.add(new KeyName("template_version", false, "string", "Declares the version string for the template."));
        }
    }

}