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

    // http://regexr.com/3acto
    public static final Pattern classDefPattern = Pattern.compile("((public\\s+|private\\s+)?(static\\s+)?(abstract\\s+)?(final\\s+)?class\\s+([\\w_$]+)(\\s*<([\\w,\\s].*)>)?(\\s+extends\\s+([\\w\\.\\_\\$]+))?(\\s+implements\\s([\\w\\.\\_\\$\\,\\s]+))?\\s*)\\{");
    public static final Pattern methodDefPattern = Pattern.compile("((?:public|private|protected)\\s+)?((?:(?:static|final|native|synchronized|abstract)\\s+)*)([\\$_\\w\\<\\>\\[\\]]+)\\s+([\\$_\\w]+)\\(([^\\)]*)\\)?\\s*\\{");
    public static final Pattern varDeclPattern = Pattern.compile("(\\w+)\\s+(\\w+)(\\s*=\\s*([\\w\\s(),]+))*;");
}
