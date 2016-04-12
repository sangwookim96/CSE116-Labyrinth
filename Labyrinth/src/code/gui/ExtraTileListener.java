package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.omg.Messaging.SyncScopeHelper;

import code.model.LabyrinthModel;

public class ExtraTileListener implements ActionListener {

	private GUI _g;
	private LabyrinthModel _lm = new LabyrinthModel();
	public ExtraTileListener(LabyrinthModel lm /*, GUI g*/) {
		_lm=lm;
//		_g=g;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		char c = _lm.extraTile().getCharacter();
		if(c == 'I'){
			_lm.extraTile().setCharacter('&');
//			_g._b.setIcon(_g.char2Image(_lm.extraTile().getCharacter()));
		}
		else if(c == '&'){
			_lm.extraTile().setCharacter('I');
		}
		else if(c == '%'){
			_lm.extraTile().setCharacter('^');
		}
		else if(c == '^'){
			_lm.extraTile().setCharacter('T');
		}
		else if(c == 'T'){
			_lm.extraTile().setCharacter('$');
		}
		else if(c == '$'){
			_lm.extraTile().setCharacter('%');
		}
		else if(c == 'L'){
			_lm.extraTile().setCharacter('#');
		}
		else if(c == '#'){
			_lm.extraTile().setCharacter('@');
		}
		else if(c == '@'){
			_lm.extraTile().setCharacter('!');
		}
		else if(c == '!'){
			_lm.extraTile().setCharacter('L');
		}
		else{
			_lm.setCharacter(_lm.getCharacter());
		}
		System.out.println(c);
	}
}
