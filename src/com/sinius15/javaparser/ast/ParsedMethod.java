package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;

import java.util.Arrays;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedMethod implements Parseable{

    public final String name;
    public final Visibility visibility;
    public final String[] prefixes;
    public final String type;
    public final String arguments;
    public final String body;

    public ParsedMethod(String name, Visibility visibility, String[] prefixes, String type, String arguments, String body) {
        this.name = name;
        this.visibility = visibility;
        this.prefixes = prefixes;
        this.type = type;
        this.arguments = arguments;
        this.body = body;
        System.out.println(this);
    }

    @Override
    public void parse() throws ParseException {

    }

    @Override
    public String toString() {
        return "ParsedMethod{" +
                "arguments='" + arguments + '\'' +
                ", visibility=" + visibility +
                ", prefixes=" + Arrays.toString(prefixes) +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
