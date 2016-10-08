import java.io.*;
import java.nio.file.*;

public class Identify{
    public static String identifyFileType(final String fileName)
    {
        String fileType = "Undetermined";
        final File file = new File(fileName);
        try
        {
            fileType = Files.probeContentType(file.toPath());
        }
        catch (IOException ioException)
        {
           //TODO: Implement exception handling
        }
        return getType(fileType);
    }
    public static String getType(String str){
        String type = "";

        for(int len = 0; len < str.length(); len++){

            if(str.charAt(len) == '/'){

                type = str.substring((len + 1),str.length());

            }
        }
        return type;
    }
}