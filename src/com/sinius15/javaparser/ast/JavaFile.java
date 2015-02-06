package com.sinius15.javaparser.ast;

import java.util.ArrayList;

/**
 * Created by Sijmen on 6-2-2015.
 */
public class JavaFile {

    String name;

    ArrayList<ImportDecleration> imports = new ArrayList<ImportDecleration>();
    ArrayList<PackageDecleration>  packages = new ArrayList<PackageDecleration>();
    ArrayList<ClassDecleration> classes = new ArrayList<ClassDecleration>();
    ArrayList<InterfaceDecleration> interfaces = new ArrayList<InterfaceDecleration>();
    ArrayList<EnumDecleration> enums = new ArrayList<EnumDecleration>();


    public JavaFile(String name){
        this.name = name;
    }

}
