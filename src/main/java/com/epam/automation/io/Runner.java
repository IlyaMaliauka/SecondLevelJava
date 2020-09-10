package com.epam.automation.io;

import java.io.*;


public class Runner {
    public static void main(String[] args) {
        Tree tree = new Tree();
        File file = new File("D:/info.txt");

        if (file.isDirectory()) {
            try (Writer out = new FileWriter("D:/info.txt")) {
                tree.tree(new File("D:/test"), "", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            tree.scanFile(new File("D:/info.txt"));
    }
}
