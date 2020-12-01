package it.unibo.oop.lab.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /*
     * Once the Controller is done, implement this class in such a way that:
     * 
     * 1) I has a main method that starts the graphical application
     * 
     * 2) In its constructor, sets up the whole view
     * 
     * 3) The graphical interface consists of a JTextField in the upper part of the frame, 
     * a JTextArea in the center and two buttons below it: "Print", and "Show history". 
     * SUGGESTION: Use a JPanel with BorderLayout
     * 
     * 4) By default, if the graphical interface is closed the program must exit
     * (call setDefaultCloseOperation)
     * 
     * 5) The behavior of the program is that, if "Print" is pressed, the
     * controller is asked to show the string contained in the text field on standard output. 
     * If "show history" is pressed instead, the GUI must show all the prints that
     * have been done to this moment in the text area.
     * 
     */

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI(final ControllerImpl controller) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //construction
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel southPanel = new JPanel(new GridLayout(1,0));
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("show History");
        final JTextArea printtxt = new JTextArea();
        final JTextField txt = new JTextField();
        
        frame.setContentPane(mainPanel);
        mainPanel.add(txt, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
                      southPanel.add(print);
                      southPanel.add(showHistory);
        mainPanel.add(printtxt, BorderLayout.CENTER);
        
        //event
        print.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
               controller.setNextString(txt.getText());
               controller.printCurrentString();
            }
            
        });
        
        showHistory.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                printtxt.setText(controller.getHistory() + "\n");
            }
            
        });
       
        
        
        //set size 
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        
        frame.setLocationByPlatform(true);
    }
    
    public void display() {
        frame.setVisible(true);
    }
    

    public static void main(final String[] args) {
        new SimpleGUI(new ControllerImpl()).display();
    }
}
