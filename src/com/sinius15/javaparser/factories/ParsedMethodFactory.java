package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.RegexLib;
import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedClass;
import com.sinius15.javaparser.ast.ParsedMethod;
import com.sinius15.javaparser.ast.Visibility;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Sinius15 on 13-2-2015.
 */
public class ParsedMethodFactory {

    private static final ParsedMethodFactory instance = new ParsedMethodFactory();

    /**
     * finds the methods in the first argument, adds the found methods to the 'toAdd' list,
     * the left over string (without the methods) is returned.
     */
    public String addTopLevelMethods(String toSearch, ArrayList<ParsedMethod> toAdd){
        Matcher matcher;
        while((matcher = RegexLib.methodDefPattern.matcher(toSearch)).find()){
            int methodEnd = Util.getCloseBracket(toSearch, matcher.end(), '{', '}');

            String name  = matcher.group(4);
            Visibility visibility = Visibility.getFromString(matcher.group(1));
            String[] prefixes = matcher.group(2).split("\\s");
            String type = matcher.group(3);
            String arguments = matcher.group(5);
            String body = toSearch.substring(matcher.end(), methodEnd);

            ParsedMethod found = new ParsedMethod(name, visibility, Util.trimIfPossible(prefixes), Util.trimIfPossible(type), Util.trimIfPossible(arguments), Util.trimIfPossible(body));
            toAdd.add(found);

            toSearch = toSearch.substring(0, matcher.start()) + toSearch.substring(methodEnd+1);
        }
        return toSearch;
    }

    public static ParsedMethodFactory getInstance() {
        return instance;
    }
}
