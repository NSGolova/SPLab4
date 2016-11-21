package com.radulov.study;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<Node> result = new ArrayList<>();

    public static void main(String[] args) {
        sortLexems();

        String code = "b:=0; for n=n downto 0 do b:= b+a[n];";
        spplit(code, 0);
        System.out.println(Arrays.toString(result.toArray()));
        Node[] tokens = new Node[result.size()];
        for (int i = 0; i < result.size(); i++) {
            tokens[i] = result.get(i);
        }
        Reconstruction.construct(tokens);
        result.clear();
    }

    public static void spplit(String code, int index) {
        String[] array = code.split(lexems[index]);
        if (array.length == 0)
        {
            result.add(new Node(null, null, lexems[index].replace("\\", ""), true));
        }
        for (int i = 0; i < array.length; i++) {
            if (index == lexems.length - 1) {
                if (array[i].length() > 0) {
                    result.add(new Node(null, null, array[i], false));
                }
            } else {
                spplit(array[i], index + 1);
            }
            if ((i != array.length - 1 || array.length == 1) && !array[0].equalsIgnoreCase(code)) {
                result.add(new Node(null, null, lexems[index].replace("\\", ""), true));
            }
        }
    }

    static void sortLexems(){
        Arrays.sort(lexems, (o1, o2) -> {
            o1 = o1.replace("\\", ""); o2 = o2.replace("\\", "");
            if (o1.length() > o2.length()) {
                return -1;
            } else {
                if (o1.length() == o2.length()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    static String[] lexems = {" if ", " then ", " else ", " elseif "," downto ",
            "case", "switch", " defualt ", " break ", " return ", " while ", " continue ",
            "while", " do ", "for", ";", "while", "with", "endif",
            "goto", "extern", "var", "const", "enum", "struct", "union", "register",
            "unsigned", "signed", "char", "short", "int","long","int64","int64",
            "float", "double", "void", "auto", "static", "volatile", "typedef", "sizeof",
            "real", "array", "set", "file", "object", "string", "label",
            "int main\\(\\)","function", "procedure", "inline", "forward", "interrupt", "export",
            "extern", "_asm", "object", "constructor", "destructor",
            "property", "resP", "abstract", "class", "public", "private", "protected",
            "virtual", "friend", "new","delete","try","catch","throw",
            "fork", "join", "\\{", "\\}", "\\[", "\\]", "\\(", "\\)",
            ",;","\\.;", ",", ":", "\\?", "&=","=", "^=", ":=", "\\+=", "-=", "\\*=", "/=", "%=",
            "<<=", ">>=", "--", "\\+\\+",
            "<", "<=", "==", "!=", ">=", ">",
            "\\+", "-", "/",
            "\\.", "->", "\\*\\*", "<<<", ">>>", "===", "!==",
            "\\+", "-", "\\*", "&",
            "%", "^", "<<", ">>", "&&",
            "!"};
}

