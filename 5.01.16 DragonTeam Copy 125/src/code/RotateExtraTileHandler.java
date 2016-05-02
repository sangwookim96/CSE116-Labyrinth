package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import code.Tile;
import gui.MultiLayers;

public class RotateExtraTileHandler implements ActionListener {
	
	private Tile _tile;
	private MultiLayers ml;
	
	public RotateExtraTileHandler(Tile tile, MultiLayers m){
		_tile=tile;
		ml=m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		_tile.rotate();
		ml.initualize();
		
	}

}
