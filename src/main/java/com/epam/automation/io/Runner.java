package com.epam.automation.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import static com.epam.automation.io.Tree.tree;

public class Runner {
    public static void main(String[] args) {
//        TreeViewer treeViewer = new TreeViewer();
//        treeViewer.setPath("D:/test");
//        treeViewer.readFiles();
        try (Writer out = new FileWriter("D:/info.txt")) {
            tree(new File("D:/test"), "", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
