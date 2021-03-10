package com.arylise.test01;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedList;

public class Test {
    private static Class<Object> a;
//    int a=1;
    public static void main(String[] args) throws IOException {
//        a.getModifiers();
//        System.out.println(Modifier.toString(3));
//        Collection
//        LinkedList
        File f= new File("MyTest/src/com/arylise/test01/test.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        FileReader fileReader = new FileReader(f);
        System.out.println((char)10);
        for(int n; (n=fileReader.read())!=-1;){
            System.out.println((char) n+" "+n);
        }

    }
}
