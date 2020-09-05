package com.epam.automation.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader {
    public static void readFiles(File baseDirectory) {
        if (baseDirectory.isDirectory()) {
            try (FileWriter writer = new FileWriter("D:/info.txt")) {
                for (File file : baseDirectory.listFiles()) {
                    if (file.isFile()) {
                        writer.append(" |------ " + file.getName());
                        writer.append("\n");
                    } else {
                        writer.append(" |+++++ " + file.getName());
                        writer.append("\n");
                        File subfolder = new File(file.getAbsolutePath());
                        for (File folder : subfolder.listFiles()) {
                            if (folder.isFile()) {
                                writer.append(" |------ " + folder.getName());
                                writer.append("\n");
                            }
                        }
                    }
                }
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (baseDirectory.isFile()){
            String[] words;
            String s;
            String fileInput = "|------";
            String folderInput = "|+++++";
            int fileCount=0;
            int folderCount=0;
            double averageFilesInFolders;
            try(BufferedReader reader = new BufferedReader(new java.io.FileReader(baseDirectory))){
                while((s=reader.readLine())!=null){
                    words=s.split(" ");
                    for (String word : words) {
                        if (word.equals(fileInput)) {
                            fileCount++;
                        }
                        if (word.equals(folderInput)) {
                            folderCount++;
                        }
                    }
                }
                averageFilesInFolders = fileCount/folderCount;
                System.out.println("There are " + fileCount + " files in " + baseDirectory.getName() + " file");
                System.out.println("There are " + folderCount + " folders in " + baseDirectory.getName() + " file");
                System.out.println("Average quantity of files in folders: " + averageFilesInFolders);
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
