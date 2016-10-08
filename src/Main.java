/**
 * Created by Jordan on 10/8/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        FileSearch.findFiles();
        //TEST VARIABLES
        /*
        File program = new File("C:\\Windows\\system32\\mspaint.exe");
        File program1 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program1.exe");
        File program2 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program2.exe");
        File program3 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program3.exe");
        File program4 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program4.exe");
        File program5 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program5.exe");
        File program6 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program6.exe");
        File program7 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program7.exe");
        File program8 = new File("C:/Users/Liam Brown/Desktop/TestFiles/program8.exe");
        File online = new File("C:/Users/Liam Brown/Desktop/TestFiles/online.html");
        File document = new File("C:/Users/Liam Brown/Desktop/TestFiles/document.lnk");
        ArrayList<File> programs = new ArrayList<File>();
        programs.add(program);
        programs.add(program1);
        programs.add(program2);
        programs.add(program3);
        programs.add(program4);
        programs.add(program5);
        programs.add(program6);
        programs.add(program7);
        programs.add(program8);
        ArrayList<File> onlines = new ArrayList<File>();
        onlines.add(online);
        ArrayList<File> documents = new ArrayList<File>();
        documents.add(document);
        ArrayList<File> all = new ArrayList<File>();
        all.add(program);
        all.add(program1);
        all.add(program2);
        all.add(program3);
        all.add(program4);
        all.add(program5);
        all.add(program6);
        all.add(program7);
        all.add(program8);
        all.add(online);
        all.add(document);
*/
        //END TEST VARIABLES
        SecurOSGui myGui = new SecurOSGui(FileManager.programList, FileManager.onlineList, FileManager.documentList, FileManager.fileList);
    }
}

