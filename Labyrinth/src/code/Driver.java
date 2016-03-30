package code;

import javax.swing.SwingUtilities;

import code.model.LabyrinthModel;

public class Driver {
      
    	 public static void main(String[] args){
    		 SwingUtilities.invokeLater(new LabyrinthModel());
    	 }
}
      
