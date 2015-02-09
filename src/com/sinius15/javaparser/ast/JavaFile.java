package com.sinius15.javaparser.ast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sinius on 6-2-2015.
 */
public class JavaFile {

    private final String name;
    private final String rawData;

    private String packageDeclaration = null;

    private final ArrayList<String> imports = new ArrayList<String>();

    private final ArrayList<ClassDeceleration> classes = new ArrayList<ClassDeceleration>();
    private final ArrayList<InterfaceDecleration> interfaces = new ArrayList<InterfaceDecleration>();
    private final ArrayList<EnumDecleration> enums = new ArrayList<EnumDecleration>();

    public JavaFile(String name, String rawData){
        this.name = name;
        this.rawData = rawData;
    }

    public void process(){

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

        Pattern classPattern = Pattern.compile("\\s*(public|private)\\s+class\\s+(\\w+)\\s+((extends\\s+\\w+)|(implements\\s+\\w+( ,\\w+)*))?\\s*\\{");
        m =classPattern.matcher(rawData);
        while(m.find()){
            ClassDeceleration found = new ClassDeceleration(rawData.substring(m.start(), m.end()));
            classes.add(found);
        }

        for(ClassDeceleration d : classes){
            System.out.println(d);
        }
    }

    public String getName() {
        return name;
    }

    public String getRawData() {
        return rawData;
    }

    public ArrayList<ClassDeceleration> getClasses() {
        return classes;
    }

    public ArrayList<EnumDecleration> getEnums() {
        return enums;
    }

    public ArrayList<InterfaceDecleration> getInterfaces() {
        return interfaces;
    }

    public ArrayList<String> getImports() {
        return imports;
    }

    public String getPackageDeclaration() {
        return packageDeclaration;
    }
}
