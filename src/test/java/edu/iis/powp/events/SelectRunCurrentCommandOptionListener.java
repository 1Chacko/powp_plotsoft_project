package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class SelectRunCurrentCommandOptionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null)) {   
			IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
		} else {    		
    		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
			manager.setCurrentCommand(commands, "No command loaded");
    	}
	}
}