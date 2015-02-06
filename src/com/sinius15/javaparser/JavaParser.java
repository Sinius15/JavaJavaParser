package com.sinius15.javaparser;

import com.sinius15.javaparser.ast.JavaFile;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Sinius15 on 6-2-2015.
 */
public class JavaParser {

    ArrayList<JavaFile> files = new ArrayList<JavaFile>();

    public JavaParser(File file){
        processFile(file);
    }

    String curWord;

    private void processFile(File file){
        curWord = "";
        try {
            FileReader inputStream = new FileReader(file.getAbsoluteFile());

            int c;
            while ((c = inputStream.read()) != -1) {
                processChar((char)c);
            }

            inputStream.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void processChar(char c){

    }

    public static void main(String[] args){
        JavaParser parser = new JavaParser(new File("res/testfile.java"));
    }
}