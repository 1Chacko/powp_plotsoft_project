package edu.iis.powp.strategy;

import javax.swing.JLabel;

import edu.iis.powp.window.WindowXY;

/**
 * LengthOfDrawingHeadsPathState
 */
public class LengthOfDrawingHeadsPathStrategy implements WindowXYStrategy {

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
		windowXY.getFrame().setSize(430, 170);
		windowXY.getFrame().setLocation(300, 250);
		JLabel lengthLabel = new JLabel("Sumaryczna długość drogi przebytej przez głowicę plottera:");
		windowXY.getLabel().setEditable(false);
		
		lengthLabel.setSize(350, 25);
		windowXY.getOkButton().setSize(75, 40);
		windowXY.getLabel().setSize(70,25);
		
		lengthLabel.setLocation(35, 15);	
		windowXY.getOkButton().setLocation(175, 90);
		windowXY.getLabel().setLocation(180, 45);
		
		windowXY.getFrame().add(lengthLabel);
		windowXY.getFrame().add(windowXY.getOkButton());
		windowXY.getFrame().add(windowXY.getLabel());
		
		windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Sumaryczna długość drogi przebytej przez głowicę plottera");
	}

}
