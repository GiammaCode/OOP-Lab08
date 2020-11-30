package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * 
 */
public class Controller {
    private static final String USER = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String NAME = "output.txt";
    private static final String PATH = USER + 
                                        SEPARATOR + NAME;
    private File file = new File(PATH);
   
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file 
     * 
     * 2) A method for getting the current File -------------
     * 
     * 3) A method for getting the path (in form of String) of the current File ----------
     * 
     * 4) A method that gets a String as input and saves its content on the current ---------
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
    
    /**
     * a method that set File as current file
     * @param 
     *      file is the new destination file 
     */
    public void setCurrentFile(File nwFile) {
       if(nwFile.getPath() != null) {
           file = nwFile;
       }
       else {
               throw new IllegalArgumentException("error: file not existing");
       }
    }
    
    /**
     * 
     *@return 
     *       a current file
     */
    public File getCurrentFile () {
        return file;
    }
    
    /**
     * 
     *@return
     *     a String of current file path 
     */
    public String getPath() {
        return file.getPath();
    }
    /**
     * @param 
     *      input is the content to save 
     *@return 
     *      saves its content on the current file
     */
    public void save (String input) throws IOException {
        Path path = Paths.get("output.txt");
        Files.writeString(path, input, StandardCharsets.UTF_8);
       
    }
    
    
    
}
