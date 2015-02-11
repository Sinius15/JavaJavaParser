package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;
import com.sinius15.javaparser.factories.ParsedClassFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sinius on 6-2-2015.
 */
public class JavaFile implements Parseable{

    private final String name;
    private final String rawData;

    private String packageDeclaration = null;

    private final ArrayList<String> imports = new ArrayList<String>();

    private final ArrayList<ParsedClass> classes = new ArrayList<ParsedClass>();


    public JavaFile(String name, String rawData){
        this.name = name;
        this.rawData = rawData;
    }

    @Override
    public void parse() throws ParseException {
        Pattern packagePattern = Pattern.compile("package\\s+([\\w\\.]+);");
        Matcher matcher = packagePattern.matcher(rawData);
        if(matcher.find()){
            packageDeclaration = matcher.group(1);
        }

        Pattern importPattern = Pattern.compile("import\\s+([\\w\\.]+\\*?);");
        matcher = importPattern.matcher(rawData);
        while(matcher.find()){
            imports.add(matcher.group(1));
        }
        classes.addAll(ParsedClassFactory.getInstance().findTopLevelClasses(rawData));

        for(ParsedClass c : classes){
            c.parse();
        }
    }

    public String getName() {
        return name;
    }

    public String getRawData() {
        return rawData;
    }

    public ArrayList<ParsedClass> getClasses() {
        return classes;
    }

    public ArrayList<String> getImports() {
        return imports;
    }

    public String getPackageDeclaration() {
        return packageDeclaration;
    }


}
