package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class SelectStretchCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		
		//wypelnic poleceniami
		
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		manager.setCurrentCommand(commands, "StretchCommand");

	}

}
