package com.sinius15.javaparser.ast;

/**
 * Created by Sijmen on 6-2-2015.
 */
public class ClassDeceleration {

    private final String rawData;

    public ClassDeceleration(String substring) {
        this.rawData = substring;


    }

    @Override
    public String toString() {
        return rawData;
    }
}
