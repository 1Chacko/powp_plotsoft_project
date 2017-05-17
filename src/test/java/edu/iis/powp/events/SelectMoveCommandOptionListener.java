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

public class SelectMoveCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		commands.add(new SetPositionCommand(30, 0));
		commands.add(new DrawToCommand(30, 0));
		commands.add(new SetPositionCommand(30, 10));
		commands.add(new DrawToCommand(30, 100));
		commands.add(new SetPositionCommand(50, 0));
		commands.add(new DrawToCommand(50, 0));
		commands.add(new SetPositionCommand(50, 10));
		commands.add(new DrawToCommand(50, 100));
		commands.add(new SetPositionCommand(120, 0));
		commands.add(new DrawToCommand(70, 0));
		commands.add(new DrawToCommand(70, 50));
		commands.add(new DrawToCommand(120, 50));
		commands.add(new DrawToCommand(120, 100));
		commands.add(new DrawToCommand(70, 100));		
		
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		manager.setCurrentCommand(commands, "MoveCommand");

	}

}
