package edu.iis.powp.window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
	
	public void createScaleBox() {
		frame = new JDialog();
	    frame.setLayout(null);
	    frame.setSize(230, 170);
	    frame.setLocation(300, 250);
	    x = new JTextField();
	    JLabel xLabel = new JLabel("Skala x");
	    okButton = new JButton("OK");
	    
	    x.setSize(50, 25);
	    xLabel.setSize(100, 25);  
	    okButton.setSize(75, 40);	 	    
	    x.setLocation(85, 5);		 	   
	    xLabel.setLocation(85, 35);	  
	    okButton.setLocation(75, 75);	     
	    frame.add(okButton);		 	
	    frame.add(x);  
	    frame.add(xLabel);
	    frame.setResizable(false);		 	
	    frame.setVisible(true);
	    frame.setTitle("Podaj skale x");
	}
	
	public void createRotateBox() {
		frame = new JDialog();
	    frame.setLayout(null);
	    frame.setSize(230, 170);
	    frame.setLocation(300, 250);
	    x = new JTextField();
	    JLabel xLabel = new JLabel("Rotacja (stopnie) x");
	    okButton = new JButton("OK");
	    
	    x.setSize(50, 25);
	    xLabel.setSize(200, 25);  
	    okButton.setSize(75, 40);	 	    
	    x.setLocation(75, 5);		 	   
	    xLabel.setLocation(50, 35);	  
	    okButton.setLocation(65, 75);	    
	    frame.add(okButton);		 	
	    frame.add(x);  
	    frame.add(xLabel);
	    frame.setResizable(false);		 	
	    frame.setVisible(true);
	    frame.setTitle("Podaj x, o który chcesz obrócić figurę");
	}
	
	public void createMirrorBox() {
		frame = new JDialog();
	    frame.setLayout(null);
	    frame.setSize(330, 170);
	    frame.setLocation(300, 250);
	    checkBoxX = new JCheckBox();
	    JLabel xLabel = new JLabel("Odbicie względem osi x");
	    checkBoxY = new JCheckBox(); 	   
	    JLabel yLabel = new JLabel("Odbicie względem osi y");
	    okButton = new JButton("OK");
	    
	    checkBoxX.setSize(50, 25);
	    checkBoxY.setSize(50, 25);
	    xLabel.setSize(200, 25);
	    yLabel.setSize(200, 25);

	    okButton.setSize(75, 40);		 	    
	  
	    checkBoxX.setLocation(55, 5);		 	   
	    xLabel.setLocation(5, 35);
	    checkBoxY.setLocation(235, 5);
	    yLabel.setLocation(155, 35);
	    okButton.setLocation(105, 75);
	    
	    frame.add(okButton);		 	
	    frame.add(checkBoxX);
	    frame.add(checkBoxY);
	    frame.add(yLabel);
	    frame.add(xLabel);
	    frame.setResizable(false);		 	
	    frame.setVisible(true);
	    frame.setTitle("Podaj x i y");
	}
	
	public void createStretchBox() {
		frame = new JDialog();
	    frame.setLayout(null);
	    frame.setSize(230, 170);
	    frame.setLocation(300, 250);
	    x = new JTextField();
	    JLabel xLabel = new JLabel("Rozciąganie x");
	    okButton = new JButton("OK");
	    
	    x.setSize(50, 25);
	    xLabel.setSize(100, 25);  
	    okButton.setSize(75, 40);	 	    
	    x.setLocation(85, 5);		 	   
	    xLabel.setLocation(75, 35);	  
	    okButton.setLocation(75, 75);	    
	    frame.add(okButton);		 	
	    frame.add(x);  
	    frame.add(xLabel);
	    frame.setResizable(false);		 	
	    frame.setVisible(true);
	    frame.setTitle("Podaj współczynnik rozciągania x");
	}
	
}
