package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.RegexLib;
import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedClass;
import com.sinius15.javaparser.ast.Visibility;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Sinius15 on 9-2-2015.
 */
public class ParsedClassFactory {

    private static final ParsedClassFactory instance = new ParsedClassFactory();

    //todo: annotaitons
    private ParsedClassFactory(){

    }

    public static ParsedClassFactory getInstance(){
        return instance;
    }

    public String findTopLevelClasses(String data, ArrayList<ParsedClass> toAdd){

        Matcher matcher;
        while((matcher = RegexLib.classDefPattern.matcher(data)).find()){
            int classEnd = Util.getCloseBracket(data, matcher.end(), '{', '}');

            String deceleration = matcher.group(1);
            Visibility visibility = Visibility.getFromString(matcher.group(2));
            String body =  data.substring(matcher.end(), classEnd);
            boolean isStatic = matcher.group(3) != null;
            boolean isAbstract = matcher.group(4) != null;
            boolean isFinal = matcher.group(5) != null;
            String name = matcher.group(6);
            String generics = matcher.group(8);
            String extending = matcher.group(10);
            String implanting = matcher.group(12);

            ParsedClass found = new ParsedClass(visibility,isStatic, isAbstract, isFinal, Util.trimIfPossible(name), Util.trimIfPossible(generics), Util.trimIfPossible(extending), Util.trimIfPossible(implanting), Util.trimIfPossible(deceleration), Util.trimIfPossible(body));
            toAdd.add(found);

            data = data.substring(classEnd+1);
        }
        return data;
    }

}
