package edu.iis.powp.strategy;

import javax.swing.JLabel;

import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.WindowXY;

/**
 * MirrorStrategy
 */
public class MirrorStrategy implements WindowXYStrategy, ICalculationsStrategy {

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

	@Override
	public SetPositionCommand drawWithSetPositionCommand(Object command, WindowXY window) {
		if(window.getcheckBoxX().isSelected()) {
			window.setOsX(-1);
		} 
		if(window.getcheckBoxY().isSelected()) {
			window.setOsY(-1);
		}	
		return new SetPositionCommand(((SetPositionCommand) command).getPosX() * window.getOsY(), ((SetPositionCommand) command).getPosY() * window.getOsX());
		
	}

	@Override
	public DrawToCommand drawWithDrawToCommand(Object command, WindowXY window) {
		if(window.getcheckBoxX().isSelected()) {
			window.setOsX(-1);
		} 
		if(window.getcheckBoxY().isSelected()) {
			window.setOsY(-1);
		}	
		return new DrawToCommand(((DrawToCommand) command).getPosX() * window.getOsY(), ((DrawToCommand) command).getPosY() * window.getOsX());
		
	}

}
