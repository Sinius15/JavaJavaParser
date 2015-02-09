package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sijmen on 6-2-2015.
 */
public class PClass implements Parseable {

    public static final KeyWord[] possibleKeywords = {KeyWord.PUBLIC, KeyWord.PRIVATE, KeyWord.ABSTRACT, KeyWord.FINAL, KeyWord.STATIC};

    private final String decleration, body;

    private final ArrayList<KeyWord> prefixes = new ArrayList<KeyWord>();

    public PClass(String decleration, String body) {
        this.decleration = decleration;
        this.body = body;
    }

    @Override
    public void parse() throws ParseException {
        for(KeyWord word : possibleKeywords){
            if(decleration.contains(word.toString())){
                prefixes.add(word);
            }
        }
        Pattern brakcetPattern = Pattern.compile("<([\\w,\\s]*)>", Pattern.DOTALL);
        Matcher m = brakcetPattern.matcher(decleration);
        if(m.find()){
            System.out.println(m.group(1));
        }
    }

    @Override
    public String toString() {
        return decleration + "{" + body + "}";
    }


}
