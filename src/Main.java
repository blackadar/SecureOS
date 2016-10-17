/**
 * Secure OS overlay for user familiarity and usability.
 * @author Jordan Blackadar
 * @author Liam Brown
 * @author Michael Alano
 * @version 0.1.2
 * @since 10/16/16
 */
import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        // Search desktop for files and icons
        FileSearch.findFiles();
        // Set Look and Feel for UIManager
        try {
            // Set cross-platform Java L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //TODO: Find a good-looking L&F that actually works
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            // handle exception
            e.printStackTrace();
        }
        // Create GUI
        SecurOSGui myGui = new SecurOSGui(FileManager.programList, FileManager.onlineList, FileManager.documentList, FileManager.fileList);

    }
}
