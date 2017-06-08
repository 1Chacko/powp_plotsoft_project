package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.strategy.LengthOfDrawnLinesStrategy;
import edu.iis.powp.window.WindowXY;

/**
 * SelectLengthOfDrawnLinesOptionListener.
 */
public class SelectLengthOfDrawnLinesOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY(new LengthOfDrawnLinesStrategy());
		
		int startingX = 0, startingY = 0, lineLength = 0; //x i y od którego liczymy pojedyncze wektory, oraz długość całej linii
		int drawToX, drawToY; //x i y do którego liczymy pojedyncze wektory
    	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null) && (FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands().get(0).toString().contains("SetPositionCommand"))) {    
        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
			for (Object command : list) {
				if(command instanceof SetPositionCommand) {
					startingX = ((SetPositionCommand) command).getPosX();
					startingY = ((SetPositionCommand) command).getPosY();					
				} else if(command instanceof DrawToCommand){	
					drawToX = ((DrawToCommand) command).getPosX();
					drawToY = ((DrawToCommand) command).getPosY();
					lineLength += Math.sqrt(Math.pow(startingX - drawToX, 2) + Math.pow(startingY - drawToY, 2));
					startingX = drawToX;
					startingY = drawToY;
				}
			}
    	} else {
    		window.getFrame().dispose();
    	}
		window.getLabel().setText(Integer.toString(lineLength));
		window.getOkButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.getFrame().dispose();
				
			}
		});

	}

}
