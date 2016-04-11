package code;

import javax.swing.SwingUtilities;

import code.gui.GUI;
import code.model.LabyrinthModel;

public class Driver {
    public static void main(String[] args){
    	LabyrinthModel _board = new LabyrinthModel();
    	if(args.length>=2 && args.length<=4){
        	_board.setPlayerNumber(args.length);
        	for(int i = 0; i<args.length;i++){
        		_board.getPlayer().get(i).setName(args[i]);       		
        	}
        	SwingUtilities.invokeLater(new GUI(_board));
    	}
    	else{
    		System.out.println("error, there is not enough players or too much players");
    	}
    }
}