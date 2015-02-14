package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedVariableDeceleration implements Parseable{

    String type;
    String name;
    String initialVariable;

    public ParsedVariableDeceleration(String type, String name, String initialVariable) {
        this.type = type;
        this.name = name;
        this.initialVariable = initialVariable;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ParsedVariableDeceleration{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", initialVariable='" + initialVariable + '\'' +
                '}';
    }

    @Override
    public void parse() throws ParseException {

    }
}
