package edu.iis.powp.window;

import javax.swing.JLabel;

/**
 * ScaleStrategy
 */
public class ScaleStrategy implements WindowXYStrategy{

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
		windowXY.getFrame().setSize(230, 170);
		windowXY.getFrame().setLocation(300, 250);
	    JLabel xLabel = new JLabel("Skala x");
	    
	    windowXY.getX().setSize(50, 25);
	    xLabel.setSize(100, 25);  
	    windowXY.getOkButton().setSize(75, 40);	 	    
	    windowXY.getX().setLocation(85, 5);		 	   
	    xLabel.setLocation(85, 35);	  
	    windowXY.getOkButton().setLocation(75, 75);	     
	    windowXY.getFrame().add(windowXY.getOkButton());		 	
	    windowXY.getFrame().add(windowXY.getX());  
	    windowXY.getFrame().add(xLabel);
	    windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Podaj skale x");
		
	}

}
