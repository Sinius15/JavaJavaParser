package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;
import com.sinius15.javaparser.Util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sinius on 6-2-2015.
 */
public  class JavaFile implements Parseable{

    private final String name;
    private final String rawData;

    private String packageDeclaration = null;

    private final ArrayList<String> imports = new ArrayList<String>();

    private final ArrayList<PClass> classes = new ArrayList<PClass>();


    public JavaFile(String name, String rawData){
        this.name = name;
        this.rawData = rawData;
    }

    @Override
    public void parse() throws ParseException {
        Pattern packagePattern = Pattern.compile("package\\s+([\\w\\.]+);");
        Matcher m = packagePattern.matcher(rawData);
        if(m.find()){
            packageDeclaration = m.group(1);
        }

        Pattern importPattern = Pattern.compile("import\\s+([\\w\\.]+\\*?);");
        m = importPattern.matcher(rawData);
        while(m.find()){
            imports.add(m.group(1));
        }
        //todo: annotaitons
        Pattern classPattern = Pattern.compile("\\s*(public|private|static|abstract|final)\\s+class\\s+(\\w+)\\s*(<[\\w,\\s]*>)?\\s+((extends\\s+\\w+)|(implements\\s+\\w+( ,\\w+)*))?\\s*\\{");
        m =classPattern.matcher(rawData);
        while(m.find()){
            int classEnd = Util.getCloseBracket(rawData, m.end(), '{', '}');

            PClass found = new PClass(rawData.substring(m.start(),m.end()-1), rawData.substring(m.end(), classEnd));
            classes.add(found);
            System.out.println(found);

        }

        for(PClass c : classes){
            c.parse();
        }
    }

    public String getName() {
        return name;
    }

    public String getRawData() {
        return rawData;
    }

    public ArrayList<PClass> getClasses() {
        return classes;
    }

    public ArrayList<String> getImports() {
        return imports;
    }

    public String getPackageDeclaration() {
        return packageDeclaration;
    }


}
