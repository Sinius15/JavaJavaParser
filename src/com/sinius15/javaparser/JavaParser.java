package com.sinius15.javaparser;

import com.sinius15.javaparser.ast.JavaFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sinius15 on 6-2-2015.
 */
public class JavaParser {

    private final ArrayList<JavaFile> files = new ArrayList<JavaFile>();

    public void addFile(File file) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
        String data = new String(encoded, StandardCharsets.UTF_8);
        JavaFile jf = new JavaFile(file.getName(), data);
        files.add(jf);
    }

    public void parse() throws ParseException {
        for(JavaFile file : files){
            file.parse();
        }
    }

    public List<JavaFile> getFiles() {
        return files;
    }

    public static void main(String[] args){
        JavaParser parser = new JavaParser();
        try {
            parser.addFile(new File("res/testfile.java"));
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
