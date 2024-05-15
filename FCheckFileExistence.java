/**
 * Write a description of class CheckFileExistence here.
 *  S
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FCheckFileExistence  
{
    // instance variables - replace the example below with your own

    public FCheckFileExistence()
    {
       
    }


    public boolean checkFileExistence(String fileName, String filePath)
    {
        java.io.File file = new java.io.File(System.getProperty("user.dir") + "/" + filePath + fileName);
       //   System.out.println(file + " exists: " + file.exists());
        return file.exists();
    }


}
