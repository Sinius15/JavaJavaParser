package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.RegexLib;
import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedClass;

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
        while((matcher = RegexLib.classDefinitionPattern.matcher(data)).find()){
            int classEnd = Util.getCloseBracket(data, matcher.end(), '{', '}');

            ParsedClass found = new ParsedClass(data.substring(matcher.start(), matcher.end()-1),
                    data.substring(matcher.end(), classEnd));
            out.add(found);

            data = data.substring(classEnd+1);
        }
        return out;
    }

    public ArrayList<ParsedClass> findAllClasses(String data){
        ArrayList<ParsedClass> out = new ArrayList<ParsedClass>();

        Matcher matcher = RegexLib.classDefinitionPattern.matcher(data);
        while(matcher.find()){
            int classEnd = Util.getCloseBracket(data, matcher.end(), '{', '}');

            ParsedClass found = new ParsedClass(data.substring(matcher.start(), matcher.end()-1),
                    data.substring(matcher.end(), classEnd));
            out.add(found);
        }
        return out;
    }

}
