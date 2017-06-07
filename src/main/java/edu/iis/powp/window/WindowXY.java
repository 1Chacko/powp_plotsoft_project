package edu.iis.powp.window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 * WindowXY.
 */
public class WindowXY {

	JButton okButton;
	JDialog frame;
	private JTextField x;
	private JTextField y;
	private JCheckBox checkBoxX;
	private JCheckBox checkBoxY;
	private WindowXYState state;
	private JTextField label;

	public WindowXY(WindowXYState chosenState){
		this.okButton = new JButton("OK");
		this.frame = new JDialog();
		this.x = new JTextField();
		this.y = new JTextField();
		this.checkBoxX = new JCheckBox();
		this.checkBoxY = new JCheckBox();
		this.state = chosenState;
		this.label = new JTextField();
		this.state.createBox(this);
	}	
	
	/**
	 * Return OK-button.
	 * 
	 * @return OK-button.
	 */
	public JButton getOkButton() {
		return okButton;
	}
	
	/**
	 * Return frame of current WindowXY.
	 * 
	 * @return Frame of current WindowXY.
	 */
	public JDialog getFrame() {
		return frame;
	}
	
	/**
	 * Return x field of current WindowXY.
	 * 
	 * @return x field of current WindowXY.
	 */
	public JTextField getX() {
		return x;
	}
	
	/**
	 * Return y field of current WindowXY.
	 * 
	 * @return y field of current WindowXY.
	 */
	public JTextField getY() {
		return y;
	}
	
	/**
	 * Return x checkBox field of current WindowXY.
	 * 
	 * @return x checkBox field of current WindowXY.
	 */
	public JCheckBox getcheckBoxX() {
		return checkBoxX;
	}

	/**
	 * Return y checkBox field of current WindowXY.
	 * 
	 * @return y checkBox field of current WindowXY.
	 */
	public JCheckBox getcheckBoxY() {
		return checkBoxY;
	}
	
	/**
	 * Return label field of current WindowXY.
	 * 
	 * @return label field of current WindowXY.
	 */
	public JTextField getLabel() {
		return label;
	}
	
}
