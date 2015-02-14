package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.RegexLib;
import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedVariableDeceleration;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedVariableDecelerationFactory {

    private static final  ParsedVariableDecelerationFactory instance = new ParsedVariableDecelerationFactory();

    public String addTopLevelDeclarations(String toSearch, ArrayList<ParsedVariableDeceleration> toAdd){
        ArrayList<ParsedVariableDeceleration> out = new ArrayList<>();
        Matcher matcher;
        while((matcher = RegexLib.varDeclPattern.matcher(toSearch)).find()){
            toAdd.add(new ParsedVariableDeceleration(Util.trimIfPossible(matcher.group(1)), Util.trimIfPossible(matcher.group(2)), Util.trimIfPossible(matcher.group(4))));
            toSearch = toSearch.substring(0, matcher.start()) + toSearch.substring(matcher.end());
        }
        return toSearch;
    }

    public static ParsedVariableDecelerationFactory getInstance(){
        return instance;
    }


}
