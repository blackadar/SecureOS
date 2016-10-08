/**
 * Created by Jordan on 10/8/2016.
 */
import javax.swing.filechooser.FileSystemView;
import java.io.*;
public class FileSearch {

    private static File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
    private static File[] files = desktop.listFiles();

    //public static String getPath(int position) {
      //  return files[position].getAbsolutePath().toString();
    //}
/*
    public static void findFiles() {
        for (int i = 0; i < files.length; i++) {
            if (!(files[i].getPath().substring(0, 2).equals("::")))
                FileManager.addFile(getPath(i));
        }
    }

*/
   /* public static void main(String [] args){
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
               // if(!(file.getPath().substring(0,2).equals("::")))
                    FileManager.addFile(file.getAbsolutePath());
                }
            }
        }
        */
   public static void main(String [] args){
       FileManager.addFile("C:\\Users\\Jordan\\Desktop\\Adobe Lightroom.lnk");
   }
    }

