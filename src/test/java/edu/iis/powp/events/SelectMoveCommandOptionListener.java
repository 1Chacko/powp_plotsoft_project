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
import edu.iis.powp.window.WindowXY;

public class SelectMoveCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		WindowXY window = new WindowXY("moveBox");
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {			        			        			        	
	        	window.getFrame().dispose();
	        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
	        	
				for (Object command : list) {
					if(command instanceof SetPositionCommand) {
						commands.add(new SetPositionCommand(((SetPositionCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((SetPositionCommand) command).getPosY() + Integer.parseInt(window.getY().getText())));					
					} else {				
						commands.add(new DrawToCommand(((DrawToCommand) command).getPosX() + Integer.parseInt(window.getX().getText()), ((DrawToCommand) command).getPosY() + Integer.parseInt(window.getY().getText())));
					}
				}		
				
				PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
				manager.setCurrentCommand(commands, "MoveCommand");
	        }
		
		});
	}

}
