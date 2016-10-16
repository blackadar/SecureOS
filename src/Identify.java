/**
 * Identifies file type and returns the ending file type.
 * @author Michael Alano
 * @version 0.1.0
 * @since 10/8/16
 */

public class Identify {

    public static String identifyFileType(String fileName){
        String truncatedName = "";
        for(int len =( fileName.length()-1); len > 0; len--){
            if(fileName.charAt(len) == '.'){
               truncatedName = fileName.substring((len + 1),fileName.length());
            }
        }
        return truncatedName;
    }
}
