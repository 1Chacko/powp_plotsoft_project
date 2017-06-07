package edu.iis.powp.window;

import javax.swing.JLabel;

/**
 * MirrorState
 */
public class MirrorState implements WindowXYState {

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
		windowXY.getFrame().setSize(330, 170);
		windowXY.getFrame().setLocation(300, 250);
	    JLabel xLabel = new JLabel("Odbicie względem osi x");
	    JLabel yLabel = new JLabel("Odbicie względem osi y");
	    
	    windowXY.getcheckBoxX().setSize(50, 25);
	    windowXY.getcheckBoxY().setSize(50, 25);
	    xLabel.setSize(200, 25);
	    yLabel.setSize(200, 25);

	    windowXY.getOkButton().setSize(75, 40);		 	    
	  
	    windowXY.getcheckBoxX().setLocation(55, 5);		 	   
	    xLabel.setLocation(5, 35);
	    windowXY.getcheckBoxY().setLocation(235, 5);
	    yLabel.setLocation(155, 35);
	    windowXY.getOkButton().setLocation(105, 75);
	    
	    windowXY.getFrame().add(windowXY.getOkButton());		 	
	    windowXY.getFrame().add(windowXY.getcheckBoxX());
	    windowXY.getFrame().add(windowXY.getcheckBoxY());
	    windowXY.getFrame().add(yLabel);
	    windowXY.getFrame().add(xLabel);
	    windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Podaj x i y");
		
	}

}
