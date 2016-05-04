package gui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import code.Board;

public class FormulaTable {
	protected JLabel name = new JLabel();
	protected ArrayList<Integer> formula = new ArrayList<Integer>();
	public FormulaTable(String p,Board _board, int playerNO, int ButtonSize, int FontSize){


		name = new JLabel();
		formula = _board.getFormula(playerNO);
		String message = "";
		for(Integer i:formula){
			message += i+", ";
		}
//		message = message.substring(2);

		// text of formula.
		name.setText(message);
		name.setFont(new Font(name.getName(), Font.BOLD, FontSize));
		name.setBounds(13*ButtonSize, (playerNO+2)*ButtonSize, 3*ButtonSize, ButtonSize);


	}

	public JLabel getLabel(){
		return name;
	}
}
