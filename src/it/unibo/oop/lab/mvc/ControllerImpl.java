package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    
    private String string;
    private List<String> stringHistory = new LinkedList<>();
    
   
    @Override
    public void setNextString(String nextString) {
        if(nextString.isEmpty()) {
            throw new IllegalStateException("exception: string null");
        }
        string = nextString;
    }

    @Override
    public String getNextString() {
        return this.string;
    }

    @Override
    public List<String> getHistory() {
        return stringHistory;
    }

    @Override
    public void printCurrentString() {
        if(string.equals(null)) {
            throw new IllegalStateException("exception: string unset");
        }
        stringHistory.add(string);
        System.out.println(string);
        
    }
    
    
}
