package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.window.ScaleState;
import edu.iis.powp.window.WindowXY;

/**
 * SelectScaleCommandOptionListener.
 */
public class SelectScaleCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY(new ScaleState());
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {	
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
	        	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null)) {    
		        	window.getFrame().dispose();
		        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	       	
		        	
					for (Object command : list) {
						if(command instanceof SetPositionCommand) {						
							commands.add(new SetPositionCommand((int)Math.floor((((SetPositionCommand) command).getPosX() * Double.parseDouble(window.getX().getText()))), (int)Math.floor((((SetPositionCommand) command).getPosY() * Double.parseDouble(window.getX().getText())))));					
						} else {				
							commands.add(new DrawToCommand((int)Math.floor((((DrawToCommand) command).getPosX() * Double.parseDouble(window.getX().getText()))), (int)Math.floor((((DrawToCommand) command).getPosY() * Double.parseDouble(window.getX().getText())))));
						}
					}		
					
					PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "ScaleCommand");
	        	} else {
	        		window.getFrame().dispose();
	        		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "No command loaded");
	        	}
	        }
		
		});	   
	}

}
