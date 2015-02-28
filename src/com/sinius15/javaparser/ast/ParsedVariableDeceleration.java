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
    }

    @Override
    public String toString() {
        String out = "";
        out += "Variable Decleration " + name + System.lineSeparator();
        out += "\t- visibility: \t" + visibility + System.lineSeparator();
        out += "\t- modifiers: \t" + Arrays.toString(modifiers) + System.lineSeparator();
        out += "\t- type: \t" + type + System.lineSeparator();
        out += "\t- initialVariable: \t" + initialVariable;
        return out;
    }

    @Override
    public void parse() throws ParseException {

    }
}
