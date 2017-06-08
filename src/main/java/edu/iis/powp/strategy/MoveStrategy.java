package edu.iis.powp.strategy;

import javax.swing.JLabel;

import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.WindowXY;

/**
 * MoveStrategy
 */
public class MoveStrategy implements WindowXYStrategy, ICalculationsStrategy {

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
	    windowXY.getFrame().setSize(230, 170);
	    windowXY.getFrame().setLocation(300, 250);
	    JLabel xLabel = new JLabel("Przesunięcie x");
	    JLabel yLabel = new JLabel("Przesunięcie y");
	    
	    windowXY.getX().setSize(50, 25);
	    windowXY.getY().setSize(50, 25);
	    xLabel.setSize(100, 25);
	    yLabel.setSize(100, 25);

	    windowXY.getOkButton().setSize(75, 40);		 	    
	  
	    windowXY.getX().setLocation(25, 5);		 	   
	    xLabel.setLocation(5, 35);
	    windowXY.getY().setLocation(135, 5);
	    yLabel.setLocation(115, 35);
	    windowXY.getOkButton().setLocation(65, 75);
	    
	    windowXY.getFrame().add(windowXY.getOkButton());		 	
	    windowXY.getFrame().add(windowXY.getX());
	    windowXY.getFrame().add(windowXY.getY());
	    windowXY.getFrame().add(yLabel);
	    windowXY.getFrame().add(xLabel);
	    windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Podaj x i y");
	}

	@Override
	public SetPositionCommand drawWithSetPositionCommand(Object command, WindowXY window) {
		return new SetPositionCommand(((SetPositionCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((SetPositionCommand) command).getPosY() + Integer.parseInt(window.getY().getText()));
		
	}

	@Override
	public DrawToCommand drawWithDrawToCommand(Object command, WindowXY window) {
		return new DrawToCommand(((DrawToCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((DrawToCommand) command).getPosY() + Integer.parseInt(window.getY().getText()));
		// TODO Auto-generated method stub
		
	}

}
