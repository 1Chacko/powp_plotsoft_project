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
import edu.iis.powp.window.MirrorStrategy;
import edu.iis.powp.window.WindowXY;

/**
 * SelectMirrorCommandOptionListener.
 */
public class SelectMirrorCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY(new MirrorStrategy());		
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
	        	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null)) {
	        		int x = 1, y = 1;
	        		if(window.getcheckBoxX().isSelected()) {
	        			x = -1;
	        		} 
	        		if(window.getcheckBoxY().isSelected()) {
	        			y = -1;
	        		}	        		
		        	window.getFrame().dispose();
		        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	       	
		        	
		        	for (Object command : list) {
						if(command instanceof SetPositionCommand) {
							commands.add(new SetPositionCommand(((SetPositionCommand) command).getPosX() * y, ((SetPositionCommand) command).getPosY() * x));					
						} else {				
							commands.add(new DrawToCommand(((DrawToCommand) command).getPosX() * y, ((DrawToCommand) command).getPosY() * x));
						}
					}	
					
					PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "MirrorCommand");
	        	} else {
	        		window.getFrame().dispose();
	        		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
					manager.setCurrentCommand(commands, "No command loaded");
	        	}
	        }
		
		});	 
	}

}
