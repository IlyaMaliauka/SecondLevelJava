package com.epam.automation.io;

import java.io.*;


public class Runner {
    public static void main(String[] args) {
        TreeViewer treeViewer = new TreeViewer();
        String treePath = "D:/test";
        String fileToWrite = "D:/info.txt";
        File file = new File(treePath);

        if (file.isDirectory()) {
            try (Writer out = new FileWriter(fileToWrite)) {
                treeViewer.displayTree(new File(treePath), "", out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            treeViewer.scanFile(new File(treePath));
    }
}
