package kr.ac.hanyang.model.property;

/**
 * Created by blainechai on 2016. 8. 24..
 */

/**
 * major_version: is a required integer value greater than or equal to 0 (zero)
 * minor_version: is a required integer value greater than or equal to 0 (zero).
 * fix_version: is an optional integer value greater than or equal to 0 (zero).
 * qualifier: is an optional string that indicates a named, pre-release version of the associated code that
 * has been derived from the version of the code identified by the combination major_version,
 * minor_version and fix_version numbers.
 * build_version: is an optional integer value greater than or equal to 0 (zero) that can be used to further
 * qualify different build versions of the code that has the same qualifer_string.
 * <p>
 * [Maven-Version] The TOSCA version type is compatible with the Apache Maven versioning policy.
 */

public class ToscaVersionType {

    public static final String TOSCA_NAMESPACE_PREFIX = "tosca";
    public static final String TOSCA_DEFINITIONS_VERSION = "tosca_definitions_version";
    public static final String TOSCA_VERSION_GRAMMAR = "<major_version>.<minor_version>[.<fix_version>[.<qualifier>[-<build_version] ] ]";
    public static final String SHORTHAND_NAME = "version";
    public static final String TYPE_QUALIFIED_NAME = "tosca:version";

//    public boolean compareVersion(String version);
}
