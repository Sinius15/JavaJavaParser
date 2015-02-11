package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.RegexLib;

/**
 * Created by Sinius15 on 11-2-2015.
 */
public enum Visibility {

    PUBLIC, PROTECTED, DEFAULT, PRIVATE;

    public static Visibility getFromString(String name){
        if(name == null)
            return null;
        name = name.trim();
        switch (name){
            case RegexLib.publicKeyword: return PUBLIC;
            case RegexLib.protectedKeyword: return PROTECTED;
            case RegexLib.privateKeyword: return PRIVATE;
            case "": return DEFAULT;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
