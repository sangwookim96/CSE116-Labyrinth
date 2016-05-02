package code;
//
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.GameBoard;
import gui.MultiLayers;

public class SizeListener implements ActionListener{
	MultiLayers ml;
	int size;
	GameBoard gameb;
	public SizeListener(MultiLayers m, int _size){
		ml = m;
		size = _size;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(size == 1){
			ml.setSize(2);
		}
		else if(size == 2){
			ml.setSize(3);
		}
		else if(size == 3){
			ml.setSize(1);
		}
		
		
	}
}

