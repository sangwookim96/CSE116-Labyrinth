package code;

import gui.MultiLayers;

public class Driver {
	public static void main(String[]args){	
		if(args.length>=1&&args.length<=4){
		MultiLayers ml = new MultiLayers(args);
		ml.setVisible(true);
		}
		else{
		System.out.println("That's not the right amount of players!");
		}
	}
}
