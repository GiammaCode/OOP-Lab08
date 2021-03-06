package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * class that control method about file 
 */
public class Controller {
    private static final String USER = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String NAME = "output.txt";
    private static final String PATH = USER + 
                                        SEPARATOR + NAME;
    private File file = new File(PATH);
   
    /**
     * a method that set File as current file
     * @param 
     *      file is the new destination file 
     */
    public void setCurrentFile(File nwFile) {
        final File parent = nwFile.getParentFile();
        if (parent.exists()) {
             file = nwFile;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
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
          FileWriter writer = new FileWriter(file);
          writer.write(input);
          writer.close();
    }
    
    
    
}
