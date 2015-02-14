package com.sinius15.javaparser;

/**
 * Created by Sinius15 on 9-2-2015.
 */
public class Util {

    public static int getCloseBracket(String input, int startBracketLocation, char openBracket, char closeBracket){
        int level = 1;
        for(int pointer = startBracketLocation; pointer <input.length(); pointer++){
            char curChar = input.charAt(pointer);
            if(curChar == openBracket)
                level++;
            if(curChar == closeBracket)
                level--;
            if(level == 0)
                return pointer;
        }
        return -1;

    }

    public static String trimIfPossible(String name) {
        return name == null ? name : name.trim();
    }

    public static String[] trimIfPossible(String[] prefixes) {
        for(int i = 0; i< prefixes.length; i++){
            prefixes[i] = prefixes[i] == null ? prefixes[i] : prefixes[i].trim();
        }
        return prefixes;
    }
}
