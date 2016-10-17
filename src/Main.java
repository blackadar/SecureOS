/**
 * Secure OS overlay for user familiarity and usability.
 * @author Jordan Blackadar
 * @author Liam Brown
 * @author Michael Alano
 * @version 0.1.2
 * @since 10/16/16
 */
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import de.javasoft.*;

import javax.swing.*;
import java.awt.Font;

public class Main {
    public static void main(String args[]) {
        // Search desktop for files and icons
        FileSearch.findFiles();
        // Set Look and Feel for UIManager
        try {
            // Only necessary if using Synthetica (which is free only for non-commercial use)
            SyntheticaLookAndFeel.setWindowsDecorated(false);
            System.setProperty("swing.aatext", "true");
            SyntheticaLookAndFeel.setFont(new Font("Calibri", Font.PLAIN, 45));
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel");
             // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Alt to Synthetica
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            // Handle exception if look & feel set fails
            e.printStackTrace();
        }
        // Create GUI
        SecurOSGui myGui = new SecurOSGui(FileManager.programList, FileManager.onlineList, FileManager.documentList, FileManager.fileList);

    }
}
