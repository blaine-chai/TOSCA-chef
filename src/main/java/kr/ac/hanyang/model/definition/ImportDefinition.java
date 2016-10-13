package kr.ac.hanyang.model.definition;

/**
 * Created by blainechai on 2016. 9. 21..
 */

import kr.ac.hanyang.model.KeyName;
import kr.ac.hanyang.model.KeyNames;
import kr.ac.hanyang.model.basemodel.validator.DefinitionValidator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 3.5.7 Import definition
 * <p>
 * Keyname
 * Required
 * type
 * Constraints
 * Description
 * <p>
 * file
 * yes
 * string
 * None
 * The required symbolic name for the imported file.
 * <p>
 * repository
 * no
 * string
 * None
 * The optional symbolic name of the repository definition where the imported file can be found as a string.
 * <p>
 * namespace_uri
 * no
 * string
 * None
 * The optional namespace URI to that will be applied to type definitions found within the imported file as a string.
 * <p>
 * namespace_prefix
 * no
 * string
 * None
 * The optional namespace prefix (alias) that will be used to indicate the namespace_uri when forming a qualified name (i.e., qname) when referencing type definitions from the imported file.
 * <p>
 * <p>
 * Grammar
 * single line
 * <import_name>: <file_URI>
 * <p>
 * multi line
 * <import_name>:
 * file: <file_URI>
 * repository: <repository_name>
 * namespace_uri: <definition_namespace_uri>
 * namespace_prefix: <definition_namespace_prefix>
 * <p>
 * import_name: represents the required symbolic name for the imported file as a string.
 * file_uri: contains the required name (i.e., URI) of the file to be imported as a string.
 * repository_name: represents the optional symbolic name of the repository definition where the
 * imported file can be found as a string.
 * namespace_uri: represents the optional namespace URI to that will be applied to type definitions found
 * within the imported file as a string.
 * namespace_prefix: represents the optional namespace prefix (alias) that will be used to indicate the
 * namespace_uri when forming a qualified name (i.e., qname) when referencing type definitions from the imported file as a string.
 */
public class ImportDefinition extends DefinitionValidator {

    public String file;
    public String repository;
    public String namespace_uri;
    public String namespace_prefix;

    public ImportDefinition() {
    }

    public ImportDefinition(Object data) {
        super();
        keyNames.add(new KeyName("file", true, "string", "The required artifact type for the artifact definition.", "None"));
        keyNames.add(new KeyName("repository", false, "string", "The optional symbolic name of the repository definition where the imported file can be found as a string.", "None"));
        keyNames.add(new KeyName("namespace_uri", false, "string", "The optional namespace URI to that will be applied to type definitions found within the imported file as a string.", "None"));
        keyNames.add(new KeyName("namespace_prefix", false, "string", "The optional namespace prefix (alias) that will be used to indicate the namespace_uri when forming a qualified name (i.e., qname) when referencing type definitions from the imported file.", "None"));

        if (data.getClass().getSimpleName().equals(String.class.getSimpleName())) {
            this.file = data.toString();
        } else {
            for (Object key : ((Map)data).keySet()) {
                try {
                    Field field = this.getClass().getField(key.toString());
                    String simpleClassName = field.getType().getSimpleName();
                    Object o = ((Map)data).get(key.toString());
                    if (simpleClassName.equals(String.class.getSimpleName())) {
                        field.set(this, o);
                    } else if (simpleClassName.equals(ArrayList.class.getSimpleName())) {
                        Class<?> cl = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                        Constructor constructor = cl.getConstructor(o.getClass());
                        o = constructor.newInstance(o.getClass().cast(o));
                        field.getType().getMethod("add", Object.class).invoke(field.get(this), o);
                    } else {
                        Class<?> cl = Class.forName(field.getType().getName());
                        Constructor constructor = cl.getConstructor(o.getClass());
                        o = constructor.newInstance((Map) o);
                        field.set(this, o);
                    }
                } catch (Exception e) {
                    return;
                }
            }
        }
    }
}
