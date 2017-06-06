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

/**
 * SelectLoadRectangleCommandOptionListener.
 */
public class SelectLoadRectangleCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e)
	{
	    List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		commands.add(new SetPositionCommand(-50, -50));
		commands.add(new DrawToCommand(150, -50));		
		commands.add(new DrawToCommand(150, 50));		
		commands.add(new DrawToCommand(-50, 50));	
		commands.add(new DrawToCommand(-50, -50));	
		
	    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "RectangleCommand");
	}
	
		
}
