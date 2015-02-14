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
        System.out.println(this);
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
        return "ParsedClass{" +
                "implementing='" + implementing + '\'' +
                ", visibility=" + visibility +
                ", isStatic=" + isStatic +
                ", isAbstract=" + isAbstract +
                ", isFinal=" + isFinal +
                ", name='" + name + '\'' +
                ", genericTypes='" + genericTypes + '\'' +
                ", extending='" + extending + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

   public ArrayList<ParsedClass> getChildClasses() {
        return childClasses;
   }

}