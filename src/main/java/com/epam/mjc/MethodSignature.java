package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodSignature {
    private String accessModifier;
    private String returnType;
    private String methodName;
    private final List<Argument> arguments;

    public MethodSignature(String methodName, List<Argument> arguments) {
        this.methodName = methodName;
        this.arguments = arguments;
    }

    public MethodSignature(String methodName) {
        this(methodName, new ArrayList<>());
    }

    public String getMethodName() {
        methodName = methodName.substring(0, methodName.length() - 2);
        String[] arr = methodName.split("\\(");
        if (arr.length == 1) {
            methodName = null;
            return arr[0];
        }

        methodName = arr[1];
        return arr[0];
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getAccessModifier() {
        String[] arr = methodName.split("\\s");

        switch (arr[0]) {
            case "public":
                methodName = "";
                for (int i = 1; i < arr.length; i++) {
                    methodName += arr[i] + " ";
                }
                return "public";
            case "private":
                methodName = "";
                for (int i = 1; i < arr.length; i++) {
                    methodName += arr[i] + " ";
                }
                return "private";
            case "protected":
                methodName = "";
                for (int i = 1; i < arr.length; i++) {
                    methodName += arr[i] + " ";
                }
                return "protected";
            default:
                return null;
        }
    }

    public void setAccessModifier(String accessModifier) {
        this.accessModifier = accessModifier;
    }

    public String getReturnType() {
        String[] arr = methodName.split("\\s");

        methodName = "";
        for (int i = 1; i < arr.length; i++) {
            methodName += arr[i] + " ";
        }

        switch (arr[0]) {
            case "void":
                return "void";
            case "int":
                return "int";
            case "double":
                return "double";
            case "float":
                return "float";
            case "byte":
                return "byte";
            case "short":
                return "short";
            case "long":
                return "long";
            case "boolean":
                return "boolean";
            case "char":
                return "char";
            case "String":
                return "String";
            default:
                return null;
        }
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<Argument> getArguments() {
        if (methodName == null) {
            return arguments;
        }

        methodName = methodName.replaceAll(",", "");
        String[] arr = methodName.split("\\s");

        for (int i = 0; i < arr.length; i += 2) {
            arguments.add(new Argument(arr[i], arr[i + 1]));
        }

        return arguments;
    }

    public static class Argument {
        private String type;
        private String name;

        public Argument(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
