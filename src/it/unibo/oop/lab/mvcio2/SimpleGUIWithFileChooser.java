package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    private final JFrame frame = new JFrame("my second java graphic interface");
    
    /**
     * builds a {@link SimplGUIWithFileChooser}}
     */
    public SimpleGUIWithFileChooser(final Controller controller){
        final JPanel mainPanel = new JPanel(new BorderLayout());
        final JPanel panel1 = new JPanel(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("save");
        final JButton browse = new JButton("Broswe...");
        final JTextArea pathText = new JTextArea(controller.getPath());
        
        frame.setContentPane(mainPanel);
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(save, BorderLayout.SOUTH );
        mainPanel.add(text, BorderLayout.CENTER);
        mainPanel.add(panel1, BorderLayout.NORTH);
        panel1.add(browse, BorderLayout.EAST);
        panel1.add(pathText);
      
      //events
        save.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                controller.save(text.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            }       
        });
        
        browse.addActionListener(new ActionListener() {
          //preso da soluzioni 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                final JFileChooser fc = new JFileChooser("Choose where to save");
                fc.setSelectedFile(controller.getCurrentFile());
                final int result = fc.showSaveDialog(frame);
                switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    final File newDest = fc.getSelectedFile();
                    controller.setCurrentFile(newDest);
                    pathText.setText(newDest.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, result, "Meh!", JOptionPane.ERROR_MESSAGE);
                }
 
            }
            
        });
        
        
      //frame size 
       final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       final int sw = (int) screen.getWidth();
       final int sh = (int) screen.getHeight();
       frame.setSize(sw / 2, sh / 2);
       frame.setLocationByPlatform(true);
        
       frame.setVisible(true);
    }
    
   
    public static void main(final String[] args) {
       new SimpleGUIWithFileChooser(new Controller());
    }

}
