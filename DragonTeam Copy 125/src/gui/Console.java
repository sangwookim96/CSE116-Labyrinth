package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Console {

	JLabel console;
	public Console(String message, int ButtonSize, int FontSize){

		console = new JLabel();
		console.setText(message);
		console.setFont(new Font(console.getName(), Font.BOLD, 2*FontSize));
		console.setBounds(2*ButtonSize, 10*ButtonSize, 10*ButtonSize, ButtonSize);
	}
	
	public JLabel getLabel(){
		return console;
	}
	
	public class DeleteConsole implements ActionListener{

		private MultiLayers ml;
		public DeleteConsole(MultiLayers m){
			ml = m;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ml.initualize();
		}
		
	}
}
