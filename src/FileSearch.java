/**
 * Searches the user desktop for files and creates and array of values.
 * @author Jordan Blackadar
 * @author Michael Alano
 * @version 0.1.0
 * @since 10/8/16
 */
import javax.swing.filechooser.FileSystemView;
import java.io.*;
public class FileSearch {

    private static File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
    private static File[] files = desktop.listFiles();

    public static void findFiles() {
        for (File file : files) {
            if (file.isFile()) {
                if (!(file.getPath().substring(0, 2).equals("::")))
                    FileManager.addFile(file.getAbsolutePath());
            }
        }
    }
}