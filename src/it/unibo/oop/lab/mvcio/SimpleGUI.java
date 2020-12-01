package it.unibo.oop.lab.mvcio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("my firts java graphical interface");
    
    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI(final Controller controller) {
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       final JPanel panel = new JPanel();
       panel.setLayout(new BorderLayout());
       frame.setContentPane(panel);
       
       final JTextArea txa = new JTextArea();
       final JButton save = new JButton("save");
       
       panel.add(save, BorderLayout.SOUTH);
       panel.add(txa, BorderLayout.CENTER);
       
       save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            try {
                controller.save(txa.getText());
            } catch(IOException e1) {}
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
    
    public void display() {
        frame.setVisible(true);
    }
    
    public static void main(String args[]) throws IOException {
        new SimpleGUI(new Controller()).display();
     }

}
