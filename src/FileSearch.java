/**
 * Created by Jordan on 10/8/2016.
 */
import java.io.*;
public class FileSearch {

    File desktop = new File(System.getProperty("User.home"), "Desktop");
    File[] files = desktop.listFiles();

    public String getPath(int position){
        return files[position].toString();
    }

    public int getNumberFiles(){
        return files.length;
    }

    public void findFiles(){
        for(File file : files){

            }
        }
}
