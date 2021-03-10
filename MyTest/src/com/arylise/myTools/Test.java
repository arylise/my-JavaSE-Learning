package com.arylise.myTools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Test {
    public static void main(String[] args) throws IOException {
        File file1=new File("D:\\Desktop\\123\\新建文件夹");
        File file2=new File("D:\\Desktop\\新建文件夹");
        Files.copy(file1.toPath(),file2.toPath());
    }
}
