package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;
import com.sinius15.javaparser.factories.ParsedClassFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sijmen on 6-2-2015.
 */
public class ParsedClass implements Parseable {

    public static final KeyWord[] possibleKeywords = {KeyWord.PUBLIC, KeyWord.PRIVATE, KeyWord.ABSTRACT, KeyWord.FINAL, KeyWord.STATIC};

    private final String decleration, body;

    private String name;

    private final ArrayList<String> genericTypes = new ArrayList<String>();
    private final ArrayList<KeyWord> prefixes = new ArrayList<KeyWord>();
    private final ArrayList<ParsedClass> childClasses = new ArrayList<ParsedClass>();

    public ParsedClass(String decleration, String body) {
        this.decleration = decleration;
        this.body = body;
    }

    @Override
    public void parse() throws ParseException {
        name = decleration.trim();

        for(KeyWord word : possibleKeywords){
            if(decleration.contains(word.toString())){
                prefixes.add(word);
            }
        }
        Pattern brakcetPattern = Pattern.compile("<([\\w,\\s]*)>", Pattern.DOTALL);
        Matcher m = brakcetPattern.matcher(decleration);
        if(m.find())
            for(String s : m.group(1).split(",")){
                genericTypes.add(s.trim());
            }

        ParsedClassFactory clzFactory = new ParsedClassFactory();
        childClasses.addAll(clzFactory.findTopLevelClasses(body));

        for(ParsedClass clz : childClasses){
            clz.parse();
        }
    }

    @Override
    public String toString() {
        return decleration + "{" + body + "}";
    }


    public String getName() {
        return name;
    }

   public ArrayList<ParsedClass> getChildClasses() {
        return childClasses;
   }
}