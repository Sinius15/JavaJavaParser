package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.RegexLib;
import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedVariableDeceleration;
import com.sinius15.javaparser.ast.Visibility;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedVariableDecelerationFactory {

    private static final  ParsedVariableDecelerationFactory instance = new ParsedVariableDecelerationFactory();

    public String addTopLevelDeclarations(String toSearch, ArrayList<ParsedVariableDeceleration> toAdd){
        Matcher matcher;
        while((matcher = RegexLib.varDeclPattern.matcher(toSearch)).find()){

            String type = Util.trimIfPossible(matcher.group(3));
            String name = Util.trimIfPossible(matcher.group(4));
            String initVal = Util.trimIfPossible(matcher.group(6));
            Visibility visibility = Visibility.getFromString(matcher.group(1));
            String[] modifiers = matcher.group(2) != null ?  matcher.group(2).split("\\s") : new String[0];

            toAdd.add(new ParsedVariableDeceleration(type, name, initVal, visibility, modifiers));
            toSearch = toSearch.substring(0, matcher.start()) + toSearch.substring(matcher.end());
        }
        return toSearch;
    }

    public static ParsedVariableDecelerationFactory getInstance(){
        return instance;
    }


}
