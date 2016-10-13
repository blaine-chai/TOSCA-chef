package kr.ac.hanyang.model.collection;

import kr.ac.hanyang.model.basemodel.validator.CollectionValidator;
import kr.ac.hanyang.model.definition.InterfaceDefinition;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by blainechai on 2016. 10. 13..
 */
public class Interfaces extends CollectionValidator{
    public ArrayList<InterfaceDefinition> interfaceDefinitions = new ArrayList<>();

    public Interfaces() {
    }

    public Interfaces(LinkedHashMap data) {
        super();
        this.data = data;
        for (Object o : data.keySet()) {
            interfaceDefinitions.add(new InterfaceDefinition((LinkedHashMap) data.get(o.toString()), o.toString()));
        }
    }

    @Override
    public String toString() {
        String rtn = "";
        for (InterfaceDefinition iDefinition : interfaceDefinitions) {
            rtn += iDefinition.interfaceDName + " ";
        }
        return rtn;
    }
}
