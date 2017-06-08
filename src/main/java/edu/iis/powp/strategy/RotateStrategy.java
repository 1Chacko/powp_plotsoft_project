package edu.iis.powp.strategy;

import javax.swing.JLabel;

import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.WindowXY;

/**
 * RotateStrategy
 */
public class RotateStrategy implements WindowXYStrategy, ICalculationsStrategy{

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

	@Override
	public SetPositionCommand drawWithSetPositionCommand(Object command, WindowXY window) {
		return new SetPositionCommand((int)Math.floor(((SetPositionCommand) command).getPosX()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))) - (int)Math.floor(((SetPositionCommand) command).getPosY()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))),
				(int)Math.floor((((SetPositionCommand) command).getPosX())*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))) + (int)Math.floor(((SetPositionCommand) command).getPosY()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))));
		
	}

	@Override
	public DrawToCommand drawWithDrawToCommand(Object command, WindowXY window) {
		return new DrawToCommand((int)Math.floor((((DrawToCommand) command).getPosX())*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))) - (int)Math.floor(((DrawToCommand) command).getPosY()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))),
				(int)Math.floor(((DrawToCommand) command).getPosX()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))) + (int)Math.floor(((DrawToCommand) command).getPosY()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))));
		
	}

}
