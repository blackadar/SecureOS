import java.io.File;
import java.util.ArrayList;

/**
 * Created by Jordan on 10/8/2016.
 */
public class FileManager {
    ArrayList<File> fileList = new ArrayList<File>(); //List of ALL retrieved files

    ArrayList<File> onlineList = new ArrayList<File>(); //List of ONLINE shortcut files
    ArrayList<File> programList = new ArrayList<File>(); //List of installed PROGRAMS
    ArrayList<File> documentList = new ArrayList<File>(); //List of DOCUMENTS in user dir
    ArrayList<File> unassignedList = new ArrayList<File>(); //List of unknown filetype files


    static int fileCount = 0;

    public void addFile(String pathName){
        String fileType;
        fileList.add(new File(pathName));
        fileType = Identify.identifyFileType(pathName);
        System.out.println(fileType);

        if(fileType.equals("doc") || fileType.equals("docx") || fileType.equals("xls") || fileType.equals("xlsx") || fileType.equals("mp3") || fileType.equals("mp4") || fileType.equals("jpg") || fileType.equals("png") || fileType.equals("mov") || fileType.equals("ppt") || fileType.equals("pptx")){
            documentList.add(fileList.get(fileCount)); //Adds the file to documentList if its type is document
        }

        else if(fileType.equals("exe")){
            programList.add(fileList.get(fileCount)); //Adds the file to programList if its type is program
        }

        else if(fileType.equals("html")){
            onlineList.add(fileList.get(fileCount)); //Adds the file to onlineList if its type is online
        }

        else{
            unassignedList.add(fileList.get(fileCount)); //Unable to assign object to a type
        }

        fileCount++;

    }

}
