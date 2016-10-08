import java.io.File;
import java.util.ArrayList;
/**
 * Created by Jordan on 10/8/2016.
 */

public class FileManager {
    static ArrayList<File> fileList = new ArrayList<File>(); //List of ALL retrieved files

    static ArrayList<File> onlineList = new ArrayList<File>(); //List of ONLINE shortcut files
    static ArrayList<File> programList = new ArrayList<File>(); //List of installed PROGRAMS
    static ArrayList<File> documentList = new ArrayList<File>(); //List of DOCUMENTS in user dir
    static ArrayList<File> unassignedList = new ArrayList<File>(); //List of unknown filetype files


    static int fileCount = 0;

    public static void addFile(String pathName){
        String fileType = Identify.identifyFileType(pathName);
        fileList.add(new File(pathName));

        if(fileType.equals("doc") || fileType.equals("docx") || fileType.equals("xls") || fileType.equals("xlsx") || fileType.equals("mp3") || fileType.equals("mp4") || fileType.equals("jpg") || fileType.equals("png") || fileType.equals("mov") || fileType.equals("ppt") || fileType.equals("pptx")){
            documentList.add(fileList.get(fileCount)); //Adds the file to documentList if its type is document
        }

        else if(fileType.equals("lnk")){
            programList.add(fileList.get(fileCount)); //Adds the file to programList if its type is program
        }

        else if(fileType.equals("html")){
            onlineList.add(fileList.get(fileCount)); //Adds the file to onlineList if its type is onlines
        }

        else{
            unassignedList.add(fileList.get(fileCount)); //Unable to assign object to a type
        }

        fileCount++;

        System.out.println(fileList.get(fileCount - 1));

    }

}
