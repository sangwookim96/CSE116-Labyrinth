package code;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import code.gui.GUI;
import code.gui.GUI;
import code.model.LabyrinthModel;

public class Driver {
      
    public static void main(String[] args){
    	SwingUtilities.invokeLater(new GUI(new LabyrinthModel()));
    }
}
 