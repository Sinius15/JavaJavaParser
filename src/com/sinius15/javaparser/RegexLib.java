package com.sinius15.javaparser;

import java.util.regex.Pattern;

/**
 * Created by Sinius15 on 10-2-2015.
 */
public class RegexLib {

    public static final String publicKeyword = "public";
    public static final String privateKeyword = "private";
    public static final String protectedKeyword = "protected";
    public static final String staticKeyword = "static";
    public static final String abstractKeyword = "abstract";
    public static final String finalKeyword = "final";
    public static final String classKeyword = "class";
    public static final String extendsKeyword =  "extends";
    public static final String implementsKeyword = "implements";

    public static final String classNameDefinitionCharset = "[\\w_$]";
    public static final String classNameCharset = "[\\w\\._\\$]";
    public static final String genericType = "(\\s*<([\\w,\\s])*>)?";

    // http://regexr.com/3acto
    public static final Pattern classDefinitionPattern = Pattern.compile("(("+publicKeyword+"\\s+|"+privateKeyword+"\\s+|"+protectedKeyword+"\\s+)?("+staticKeyword+
            "\\s+)?("+abstractKeyword+"\\s+)?("+finalKeyword+"\\s+)?"+classKeyword+"\\s+("+ classNameDefinitionCharset+ "+)"+
            genericType+"(\\s+"+extendsKeyword+"\\s("+classNameCharset+"+))?"+genericType+"(\\s+"+implementsKeyword+"\\s([\\w\\._\\$,\\s]+))?\\s*)\\{");
    public static final Pattern secondClassDefPatterh = Pattern.compile("((public\\s+|private\\s+)?(static\\s+)?(abstract\\s+)?(final\\s+)?class\\s+([\\w_$]+)(\\s*<([\\w,\\s].*)>)?(\\s+extends\\s+([\\w\\.\\_\\$]+))?(\\s+implements\\s([\\w\\.\\_\\$\\,\\s]+))?\\s*)\\{");

    static{
        System.out.println(classDefinitionPattern.toString());
    }
}
