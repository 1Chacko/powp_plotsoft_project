package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.ExtremePointsState;
import edu.iis.powp.window.WindowXY;

public class SelectExtremePointsOptionListener implements ActionListener {

	private int maxX = 0, minX = 0, maxY = 0, minY = 0;
	private int currentX, currentY;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		WindowXY window = new WindowXY(new ExtremePointsState());

    	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null) && (FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands().get(0).toString().contains("SetPositionCommand"))) {    
        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
			for (Object command : list) {
				if(command instanceof SetPositionCommand) {
					currentX = ((SetPositionCommand) command).getPosX();
					currentY = ((SetPositionCommand) command).getPosY();	
					testIfNewExtremePoints(currentX, currentY);
				} else if(command instanceof DrawToCommand){	
					currentX = ((DrawToCommand) command).getPosX();
					currentY = ((DrawToCommand) command).getPosY();
					testIfNewExtremePoints(currentX, currentY);
				}
			}
    	} else {
    		window.getFrame().dispose();
    	}
    	window.getX().setText(Integer.toString(maxX));
    	window.getY().setText(Integer.toString(maxY));
    	window.getLabel().setText(Integer.toString(minX));
    	window.getSecondLabel().setText(Integer.toString(minY));
    	maxX = 0;
    	minX = 0;
    	maxY = 0;
    	minY = 0;
		window.getOkButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.getFrame().dispose();
				
			}
		});

	}

	private void testIfNewExtremePoints(int currentX, int currentY) {
		if(currentX > maxX){
			maxX = currentX;
		}else if(currentX < minX){
			minX = currentX;
		}
		if(currentY > maxY){
			maxY = currentY;
		}else if(currentY < minY){
			minY = currentY;
		}
		
	}

}
