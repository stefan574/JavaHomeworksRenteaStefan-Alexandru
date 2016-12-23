/*
 * Contents class
 */
package FileManagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stefan-Alexandru Rentea
 */
public class Contents {
    
    private List<String> listOfContents;

    void addContent() {
        try {
            if (listOfContents.size() >= 0) {
                String string = new LegalValue().getLegalValue("Content: ");
                listOfContents.add(string);
                System.out.println("Content Added!");
            }
        }
        catch (NullPointerException e) {
            System.out.println("The List of Contents was not initialised!\n");
            listOfContents = new ArrayList<>();
            try {
                String string = new LegalValue().getLegalValue("Content: ");
                listOfContents.add(string);
                System.out.println("Content added!");
            }
            catch(Exception e1) {
                System.out.println("Could not add Content to List Of Contents!");
            }
        }
        catch (Exception e2) {
            System.out.println("Could not add Content to List Of Contents!");
        }
        finally {
            System.out.println();
        }
    }
    
    boolean printListOfContents() {
        try {
            if (!listOfContents.isEmpty()) {
                for (int i = 0; i < listOfContents.size(); i++)
                    System.out.println((i + 1) + ": " + listOfContents.get(i));
                return true;
            }
            else {
                System.out.println("List of Contents is Empty!");
                return false; 
            }
        }
        catch (NullPointerException e) {
            System.out.println("The List of Contents was not initialised!");
            listOfContents = new ArrayList<>();
            return false;
        }
        finally {
            System.out.println();
        }
    }
    
    private String getPathForFile() {
        File file;
        String path = "D:\\JavaFolder\\";
        
        System.out.print("The current directory path is \"" + path + "\".\n"
                + "Do you wish to change it? (yes/no)\n\n");
        
        String choice = new LegalValue().getLegalValue("Choice: ");
        
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("New Path: ");
            Scanner scanner = new Scanner(System.in);
            path = scanner.nextLine();
            file = new File(path);
            System.out.println();
        }
        else
            file = new File(path);
        
        try {
            if (!file.isDirectory())
                throw new IOException("Directory does not exist! Try again!\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            boolean bool = true;
            Scanner scanner;
            while (bool) {
                System.out.print("New Path: ");
                scanner = new Scanner(System.in);
                path = scanner.nextLine();
                file = new File(path);
                if (file.isDirectory())
                    bool = false;
                else
                    System.out.println("\nTry again!\n");
            }
        }
        
        if (path.endsWith("\\"))
            return path;
        else
            return path + "\\";
    }
    
    void createFile() {
        String path = getPathForFile();
        String fileName = new LegalValue().getLegalValue("New File Name: ");
        File file = new File(path + fileName);
        try {
            if (file.exists() && file.isFile())
                throw new IOException("File already Exists! Try again!\n");
            else 
                if (file.exists() && file.isDirectory())
                    throw new IOException("File is Directory! Try again!\n");
                else 
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                            System.out.println("File Created!\n");
                        }
                        catch (IOException e) {
                            System.out.println("Error at File creation!\n");
                        }
                    }
            }
        catch (IOException e){
            boolean bool = true;
            System.out.println(e.getMessage());
            while(bool) {
                fileName = new LegalValue().getLegalValue("New File Name: ");
                file = new File(path + fileName);
                if (!file.exists())
                    try {
                            file.createNewFile();
                            System.out.println("File Created!\n");
                            bool = false;
                        }
                        catch (IOException e1) {
                            System.out.println("Error at File creation!\n");
                        }
                else 
                    if (file.exists() && file.isDirectory())
                        System.out.println("File is Directory! Try again!\n");
                    else
                        if (file.exists() && file.isFile())
                            System.out.println("File already Exists! Try again!\n");
                        else
                            System.out.println("Try Again!\n");
            }
        }
    }
    
    void readFile() {
        int i = 0;
        String fileContent;
        
        String path = getPathForFile();
        File directory = new File(path);
        File[] files = directory.listFiles();
        
        for (File file : files)
                System.out.println(++i + ": " + file.getName());
        
        int choice = new LegalValue().getLegalValue(i) - 1;
        
        try {
            if (files[choice].isDirectory())
                throw new IOException();
        }
        catch (IOException e) {
            boolean bool = true;
            while(bool) {
                bool = false;
                System.out.println("File chosen is directory! Please choose another file!");
                choice = new LegalValue().getLegalValue(i) - 1;
                if (files[choice].isDirectory())
                    bool = true;
            }
        }
        
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(files[choice].getAbsolutePath())));
            
            if (fileContent.length() > 0) { 
                System.out.println(fileContent);
                System.out.println("\nDo you wish to add it to the List Of Contents? (yes/no))\n");
                String ok = new LegalValue().getLegalValue("Choice: ");
                if (ok.equalsIgnoreCase("yes"))
                    try {
                        listOfContents.add(fileContent);
                        System.out.println("Content Added!\n");
                    }
                    catch (NullPointerException e) {
                        System.out.println("The list was not initialised!\n");
                        listOfContents = new ArrayList<>();
                        listOfContents.add(fileContent);
                    }
            }
            else
                System.out.println("File is empty!\n");       
        }
        catch (IOException e) {
            System.out.println("Error: Could not Read File!\n");
        }
    }
    
    void writeContentToFile() {
        try {
            if (listOfContents.isEmpty())
                System.out.println("List of Contents is Empty!\n");
        }
        catch (NullPointerException e) {
            System.out.println("The List of Contents was not initialised!\n");
            listOfContents = new ArrayList<>();
        }
        
        if (!listOfContents.isEmpty()) {
            int i = 0;
            int choice = 0;
            boolean bool = false;
            String path = getPathForFile();
            File directory = new File(path);
            File[] files = directory.listFiles();

            for (File file : files)
                System.out.println(++i + ": " + file.getName());

            System.out.println("\nChoose file from list of files!");
            int fileChoice = new LegalValue().getLegalValue(i) - 1;
            
            try {
                if (files[fileChoice].isDirectory())
                    throw new IOException();
            }
            catch (IOException e) {
                boolean ok = true;
                while(ok) {
                    ok = false;
                    System.out.println("File chosen is directory! Please choose another file!");
                    fileChoice = new LegalValue().getLegalValue(i) - 1;
                    if (files[fileChoice].isDirectory())
                        ok = true;
                }
            }
            
            printListOfContents();
            System.out.println("Choose content from List of Contents!");
            int contentChoice = new LegalValue().getLegalValue(i) - 1;
            
            if (files[fileChoice].length() > 0) {
                System.out.println("1. Overwrite File.\n"
                        + "2. Write at the beggining of the File.\n"
                        + "3. Write at the beggining of the File with New Line after.\n"
                        + "4. Write at the end of the File.\n"
                        + "5. Write at the end of the File but with New Line first.");
                choice = new LegalValue().getLegalValue(5);
            }
            
            if (choice == 4 || choice == 5)
                bool = true;
            
            if (choice == 0 || choice == 1 || choice == 4 || choice == 5)
                try (BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(files[fileChoice].getAbsolutePath(), bool))) {
                    if (choice == 5)
                        bufferwriter.write("\n" + listOfContents.get(contentChoice));
                    else
                        bufferwriter.write(listOfContents.get(contentChoice));
                    System.out.println("File Written!\n");
                }
                catch (IOException e) {
                    System.out.println("Error: Could not write Content to File!\n");
                }
            else
                if (choice == 2 || choice == 3)
                    try {
                        String fileContent = new String(Files.readAllBytes(Paths.get(files[fileChoice].getAbsolutePath())));
                        
                        try (BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(files[fileChoice].getAbsolutePath()))) {
                            if (choice == 3)
                                bufferwriter.write(listOfContents.get(contentChoice) + "\n" + fileContent);
                            else
                                bufferwriter.write(listOfContents.get(contentChoice) + fileContent);
                            System.out.println("File Written!\n");
                        }
                        catch (IOException e) {
                            System.out.println("Error: Could not write Content to File!\n");
                        }
                    }
                    catch (IOException e) {
                        System.out.println("Error: Could not Read File!\n");
                    }
        }
    }
    
    void deleteContentFromListOfContents() {
        if (printListOfContents()) {
            System.out.println("Choose with Content to remove!");
            int choice = new LegalValue().getLegalValue(listOfContents.size()) - 1;
            try {
                listOfContents.remove(choice);
                System.out.println("Content removed!\n");
            }
            catch (Exception e) {
                System.out.println("Could not remove Content!\n");
            }
        }
    }
    
    void deleteFile() {
        int i = 0;
        
        String path = getPathForFile();
        File directory = new File(path);
        File[] files = directory.listFiles();
        
        for (File file : files)
                System.out.println(++i + ": " + file.getName());
        
        int choice = new LegalValue().getLegalValue(i) - 1;
        
        try {
            if (files[choice].isDirectory())
                throw new IOException();
        }
        catch (IOException e) {
            boolean bool = true;
            while(bool) {
                bool = false;
                System.out.println("File chosen is directory! Please choose another file!");
                choice = new LegalValue().getLegalValue(i) - 1;
                if (files[choice].isDirectory())
                    bool = true;
            }
        }
        
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(files[choice].getAbsolutePath())));
            
            if (fileContent.length() > 0) {
                System.out.println("File is not Empty, do you wish to add the contents to the List Of Contents? (yes/no))\n");
                String ok = new LegalValue().getLegalValue("Choice: ");
                if (ok.equalsIgnoreCase("yes"))
                    try {
                        listOfContents.add(fileContent);
                        System.out.println("Content Added!\n");
                    }
                    catch (NullPointerException e) {
                        System.out.println("The list was not initialised!\n");
                        listOfContents = new ArrayList<>();
                        listOfContents.add(fileContent);
                        System.out.println("Content of file was added to the List Of Contents!\n");
                    }
            }
        }
        catch (IOException e) {
            System.out.println("Error: Could not Read File!\n");
        }
        
        try {
            files[choice].delete();
            System.out.println("File was deleted!\n");
        }
        catch (Exception e) {
            System.out.println("Error: Could not detele file!\n");
        }
    }
    
    void deleteContentOfFile() {
        int i = 0;
        
        String path = getPathForFile();
        File directory = new File(path);
        File[] files = directory.listFiles();
        
        for (File file : files)
                System.out.println(++i + ": " + file.getName());
        
        int choice = new LegalValue().getLegalValue(i) - 1;
        
        try {
            if (files[choice].isDirectory())
                throw new IOException();
        }
        catch (IOException e) {
            boolean bool = true;
            while(bool) {
                bool = false;
                System.out.println("File chosen is directory! Please choose another file!");
                choice = new LegalValue().getLegalValue(i) - 1;
                if (files[choice].isDirectory())
                    bool = true;
            }
        }
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(files[choice], false);
            try {
                fileOutputStream.close();
                System.out.println("Content of File was deleted!\n");
            }
            catch (IOException e1) {
                System.out.println("Could not close File!\n");
            }
        } catch (IOException ex) {
            System.out.println("Could not read file!\n");
        }
    }
    
}