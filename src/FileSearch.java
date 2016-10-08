/**
 * Created by Jordan on 10/8/2016.
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

    public static void main(String [] args){
        findFiles();
    }
}