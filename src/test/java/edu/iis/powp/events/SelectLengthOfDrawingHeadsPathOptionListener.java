package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.LengthOfDrawingHeadsPathState;
import edu.iis.powp.window.WindowXY;

public class SelectLengthOfDrawingHeadsPathOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY(new LengthOfDrawingHeadsPathState());

		int startingX = 0, startingY = 0, pathLength = 0; //x i y od którego liczymy pojedyncze wektory, oraz długość całej drogi
		int drawToX, drawToY; //x i y do którego liczymy pojedyncze wektory
    	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null) && (FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands().get(0).toString().contains("SetPositionCommand"))) {    
        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
			for (Object command : list) {
				if(command instanceof SetPositionCommand) {
					pathLength += Math.sqrt(Math.pow(startingX - ((SetPositionCommand) command).getPosX(), 2) + Math.pow(startingY - ((SetPositionCommand) command).getPosY(), 2));
					startingX = ((SetPositionCommand) command).getPosX();
					startingY = ((SetPositionCommand) command).getPosY();					
				} else if(command instanceof DrawToCommand){	
					drawToX = ((DrawToCommand) command).getPosX();
					drawToY = ((DrawToCommand) command).getPosY();
					pathLength += Math.sqrt(Math.pow(startingX - drawToX, 2) + Math.pow(startingY - drawToY, 2));
					startingX = drawToX;
					startingY = drawToY;
				}
			}
    	} else {
    		window.getFrame().dispose();
    	}
		window.getLabel().setText(Integer.toString(pathLength));
		window.getOkButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.getFrame().dispose();
				
			}
		});
	}

}
