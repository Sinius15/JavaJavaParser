package com.sinius15.javaparser.factories;

import com.sinius15.javaparser.Util;
import com.sinius15.javaparser.ast.ParsedClass;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sinius15 on 9-2-2015.
 */
public class ParsedClassFactory {

    public static final Pattern classPattern = Pattern.compile("\\s*(public|private|static|abstract|final)\\s+class\\s+(\\w+)\\s*(<[\\w,\\s]*>)?\\s*((extends\\s+\\w+)|(implements\\s+\\w+( ,\\w+)*))?\\s*\\{");

    //todo: annotaitons

    public ParsedClassFactory(){

    }

    public ArrayList<ParsedClass> findTopLevelClasses(String data){
        ArrayList<ParsedClass> out = new ArrayList<ParsedClass>();

        Matcher matcher;
        while((matcher = classPattern.matcher(data)).find()){
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

        Matcher matcher = classPattern.matcher(data);
        while(matcher.find()){
            int classEnd = Util.getCloseBracket(data, matcher.end(), '{', '}');

            ParsedClass found = new ParsedClass(data.substring(matcher.start(), matcher.end()-1),
                    data.substring(matcher.end(), classEnd));
            out.add(found);
        }
        return out;
    }

}
