/**
 * Created by Jordan on 10/8/2016.
 */
import javax.swing.filechooser.FileSystemView;
import java.io.*;
public class FileSearch {

    static File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
    static File[] files = desktop.listFiles();

    public static String getPath(int position){
        return files[position].toString();
    }

    public static void findFiles(){
        for(int i = 0; i < files.length ; i++){
            FileManager.addFile(getPath(i));
            }
        }

    public static void main(String [] args){
        System.out.println(desktop);
        findFiles();
    }
}
