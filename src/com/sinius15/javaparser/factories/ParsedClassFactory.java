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

    public ArrayList<ParsedClass> findTopLevelClasses(String data){
        ArrayList<ParsedClass> out = new ArrayList<ParsedClass>();

        Matcher matcher;
        while((matcher = RegexLib.secondClassDefPatterh.matcher(data)).find()){
            int classEnd = Util.getCloseBracket(data, matcher.end(), '{', '}');

            String decleration = matcher.group(1);
            Visibility visibility = Visibility.getFromString(matcher.group(2));
            String body =  data.substring(matcher.end(), classEnd);
            boolean isStatic = matcher.group(3) != null;
            boolean isAbstract = matcher.group(4) != null;
            boolean isFinal = matcher.group(5) != null;
            String name = matcher.group(6);
            String generics = matcher.group(8);
            String extending = matcher.group(10);
            String implenting = matcher.group(12);

            ParsedClass found = new ParsedClass(visibility,isStatic, isAbstract, isFinal, trimIfPossible(name), trimIfPossible(generics), trimIfPossible(extending), trimIfPossible(implenting), trimIfPossible(decleration), trimIfPossible(body));
            out.add(found);

            data = data.substring(classEnd+1);
        }
        return out;
    }

    private String trimIfPossible(String name) {
        return name == null ? name : name.trim();
    }

}
