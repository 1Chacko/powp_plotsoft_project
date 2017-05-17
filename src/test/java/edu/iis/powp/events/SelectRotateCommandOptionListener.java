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

public class SelectRotateCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		commands.add(new SetPositionCommand(-50, -20));
		commands.add(new DrawToCommand(-50, -20));
		commands.add(new SetPositionCommand(-40, -20));
		commands.add(new DrawToCommand(50, -20));
		commands.add(new SetPositionCommand(-50, 0));
		commands.add(new DrawToCommand(-50, 0)); //s
		commands.add(new SetPositionCommand(-40, 0));
		commands.add(new DrawToCommand(50, 0));
		commands.add(new SetPositionCommand(-50, 70));
		commands.add(new DrawToCommand(-50, 20));
		commands.add(new DrawToCommand(0, 20));
		commands.add(new DrawToCommand(0, 70));
		commands.add(new DrawToCommand(50, 70));
		commands.add(new DrawToCommand(50, 20));
		
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		manager.setCurrentCommand(commands, "RotateCommand");
	}

}
