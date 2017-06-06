package edu.iis.powp.window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class WindowXY {

	JButton okButton;
	JDialog frame;
	private JTextField x;
	private JTextField y;
	private JCheckBox checkBoxX;
	private JCheckBox checkBoxY;
	private WindowXYState state;
	
	public WindowXY(WindowXYState chosenState){
		this.okButton = new JButton("OK");
		this.frame = new JDialog();
		this.x = new JTextField();
		this.y = new JTextField();
		this.checkBoxX = new JCheckBox();
		this.checkBoxY = new JCheckBox();
		this.state = chosenState;
		this.state.createBox(this);
	}	
	
	public JButton getOkButton() {
		return okButton;
	}
	
	public JDialog getFrame() {
		return frame;
	}
	
	public JTextField getX() {
		return x;
	}
	
	public JTextField getY() {
		return y;
	}
	
	public JCheckBox getcheckBoxX() {
		return checkBoxX;
	}

	public JCheckBox getcheckBoxY() {
		return checkBoxY;
	}
	
}
