package edu.iis.powp.window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowXY {

	JButton okButton;
	JDialog frame;
	private JTextField x;
	private JTextField y;
	
	public WindowXY(){
		createBox();
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


	public void createBox() {
		frame = new JDialog();
	    frame.setLayout(null);
	    frame.setSize(230, 170);
	    frame.setLocation(300, 250);
	    x = new JTextField();
	    JLabel xLabel = new JLabel("Przesunięcie x");
	    y = new JTextField(); 	   
	    JLabel yLabel = new JLabel("Przesunięcie y");
	    okButton = new JButton("OK");
	    
	    x.setSize(50, 25);
	    y.setSize(50, 25);
	    xLabel.setSize(100, 25);
	    yLabel.setSize(100, 25);

	    okButton.setSize(75, 40);		 	    
	  
	    x.setLocation(25, 5);		 	   
	    xLabel.setLocation(5, 35);
	    y.setLocation(135, 5);
	    yLabel.setLocation(115, 35);
	    okButton.setLocation(65, 75);
	    
	    frame.add(okButton);		 	
	    frame.add(x);
	    frame.add(y);
	    frame.add(yLabel);
	    frame.add(xLabel);
	    frame.setResizable(false);		 	
	    frame.setVisible(true);
	    frame.setTitle("Podaj x i y");
	}
	
	
}
