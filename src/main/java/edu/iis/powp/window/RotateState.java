package edu.iis.powp.window;

import javax.swing.JLabel;

/**
 * RotateState
 */
public class RotateState implements WindowXYState{

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
	    windowXY.getFrame().setSize(230, 170);
	    windowXY.getFrame().setLocation(300, 250);
	    JLabel xLabel = new JLabel("Rotacja (stopnie) x");
	    
	    windowXY.getX().setSize(50, 25);
	    xLabel.setSize(200, 25);  
	    windowXY.getOkButton().setSize(75, 40);	 	    
	    windowXY.getX().setLocation(75, 5);		 	   
	    xLabel.setLocation(50, 35);	  
	    windowXY.getOkButton().setLocation(65, 75);	    
	    windowXY.getFrame().add(windowXY.getOkButton());		 	
	    windowXY.getFrame().add(windowXY.getX());  
	    windowXY.getFrame().add(xLabel);
	    windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Podaj x, o który chcesz obrócić figurę");
		
	}

}
