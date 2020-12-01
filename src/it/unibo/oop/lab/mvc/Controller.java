package it.unibo.oop.lab.mvc;

import java.util.List;

/**
 * A controller that prints strings and has memory of the strings it printed.
 */
public interface Controller {
    
    /**
     *set the next string 
     * @param
     *      next string
     */
    void setNextString(final String nextString);
     
    /**
     *@return
     *      the next string to print 
     */
    String getNextString();
    
    /**
     *@return
     *      a list of strings get show a history of string 
     */
    List<String> getHistory();
    
    /**
     *print the current string on 
     *  standard output  
     */
    void printCurrentString();
    
    

}
