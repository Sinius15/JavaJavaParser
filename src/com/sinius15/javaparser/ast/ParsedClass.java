package com.sinius15.javaparser.ast;

import com.sinius15.javaparser.ParseException;
import com.sinius15.javaparser.Parseable;
import com.sinius15.javaparser.factories.ParsedClassFactory;
import com.sinius15.javaparser.factories.ParsedMethodFactory;
import com.sinius15.javaparser.factories.ParsedVariableDecelerationFactory;

import java.util.ArrayList;

/**
 * Created by Sijmen on 6-2-2015.
 */
public class ParsedClass implements Parseable {

    public final Visibility visibility;
    public final boolean isStatic, isAbstract, isFinal;
    public final String decleration, body, name, genericTypes, extending, implementing;

    private final ArrayList<ParsedClass> childClasses = new ArrayList<>();
    private final ArrayList<ParsedMethod> methods = new ArrayList<>();
    private final ArrayList<ParsedVariableDeceleration> variables = new ArrayList<>();

    public ParsedClass(Visibility visibility,boolean isStatic, boolean isAbstract, boolean isFinal, String name, String genericTypes, String extending, String implementing, String decleration, String body) {
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isAbstract = isAbstract;
        this.isFinal = isFinal;
        this.name = name;
        this.genericTypes = genericTypes;
        this.extending = extending;
        this.implementing = implementing;
        this.decleration = decleration;
        this.body = body;
    }

    @Override
    public void parse() throws ParseException {
        String parsed = ParsedClassFactory.getInstance().findTopLevelClasses(body, childClasses);
        parsed = ParsedMethodFactory.getInstance().addTopLevelMethods(parsed, methods);
        parsed = ParsedVariableDecelerationFactory.getInstance().addTopLevelDeclarations(parsed, variables);

        for(ParsedClass clz : childClasses){
            clz.parse();
        }
    }

    @Override
    public String toString() {
        String out = "";
        out += "Class " + name +  System.lineSeparator();
        out += "\t- visibility: \t" + visibility + System.lineSeparator();
        out += "\t- isStatic: \t" + isStatic + System.lineSeparator();
        out += "\t- isAbstract: \t" + isAbstract + System.lineSeparator();
        out += "\t- isFinal: \t\t" + isFinal + System.lineSeparator();
        out += "\t- implementing: " + implementing +  System.lineSeparator();
        out += "\t- genericTypes: " + genericTypes +  System.lineSeparator();
        out += "\t- extending: \t" + extending + System.lineSeparator();
        for(ParsedVariableDeceleration var : variables){
            out += "\t"+var.toString().replaceAll("(\n+)", "\n\t") + System.lineSeparator();
        }
        for(ParsedMethod method : methods){
            out += "\t"+method.toString().replaceAll("(\n+)", "\n\t") + System.lineSeparator();
        }
        for(ParsedClass clz : childClasses){
            out += "\t"+clz.toString().replaceAll("(\n+)", "\n\t") + System.lineSeparator();
        }

        return out;
    }

    public String getName() {
        return name;
    }

   public ArrayList<ParsedClass> getChildClasses() {
        return childClasses;
   }

}