package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;

import java.util.Arrays;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedVariableDeceleration implements Parseable{

    public final Visibility visibility;
    public final String[] modifiers;
    public final String type;
    public final String name;
    public final String initialVariable;

    public ParsedVariableDeceleration(String type, String name, String initialVariable, Visibility visibility, String[] modifiers) {
        this.type = type;
        this.name = name;
        this.initialVariable = initialVariable;
        this.modifiers = modifiers;
        this.visibility = visibility;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ParsedVariableDeceleration{" +
                "visibility=" + visibility +
                ", modifiers=" + Arrays.toString(modifiers) +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", initialVariable='" + initialVariable + '\'' +
                '}';
    }

    @Override
    public void parse() throws ParseException {

    }
}
