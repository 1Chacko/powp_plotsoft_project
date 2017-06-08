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
import edu.iis.powp.window.MoveStrategy;
import edu.iis.powp.window.WindowXY;

/**
 * SelectMoveCommandOptionListener.
 */
public class SelectMoveCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		WindowXY window = new WindowXY(new MoveStrategy());
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>();
	        	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null)) {    
		        	window.getFrame().dispose();
		        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
		        	 
					for (Object command : list) {
						if(command instanceof SetPositionCommand) {
							commands.add(new SetPositionCommand(((SetPositionCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((SetPositionCommand) command).getPosY() + Integer.parseInt(window.getY().getText())));					
						} else {				
							commands.add(new DrawToCommand(((DrawToCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((DrawToCommand) command).getPosY() + Integer.parseInt(window.getY().getText())));
						}
					}		
					
					PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "MoveCommand");
	        	} else {
	        		window.getFrame().dispose();
	        		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "No command loaded");
	        	}
	        }
		
		});
	}

}
