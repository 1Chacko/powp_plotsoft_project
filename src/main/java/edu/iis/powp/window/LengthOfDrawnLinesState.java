package edu.iis.powp.window;

import javax.swing.JLabel;

public class LengthOfDrawnLinesState implements WindowXYState {

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
		windowXY.getFrame().setSize(330, 170);
		windowXY.getFrame().setLocation(300, 250);
		JLabel lengthLabel = new JLabel("Sumaryczna długość narysowanych linii:");
		JLabel sumValueLabel = new JLabel("val");
		
		lengthLabel.setSize(250, 25);
		windowXY.getOkButton().setSize(75, 40);
		sumValueLabel.setSize(50, 25);
		
		lengthLabel.setLocation(35, 15);	
		windowXY.getOkButton().setLocation(125, 90);
		sumValueLabel.setLocation(155, 45);
		
		windowXY.getFrame().add(lengthLabel);
		windowXY.getFrame().add(windowXY.getOkButton());
		windowXY.getFrame().add(sumValueLabel);
		
		windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Sumaryczna długość narysowanych linii");
	}

}
