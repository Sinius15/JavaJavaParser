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

}
