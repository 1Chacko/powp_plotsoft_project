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
import edu.iis.powp.strategy.ICalculationsStrategy;
import edu.iis.powp.strategy.MoveStrategy;
import edu.iis.powp.strategy.WindowXYStrategy;
import edu.iis.powp.window.WindowXY;

public class SelectTranslationCommandOptionListener implements ActionListener {
	
	private WindowXYStrategy strategy;
	private ICalculationsStrategy calculation;
	
	public SelectTranslationCommandOptionListener(WindowXYStrategy strategy) {
		this.strategy = strategy;
		this.calculation = (ICalculationsStrategy) strategy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		WindowXY window = new WindowXY(strategy);
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>();
	        	if(!(FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands() == null)) {
	        		if(window.getcheckBoxX().isSelected()) {
	        			window.setOsX(-1);
	        		} 
	        		if(window.getcheckBoxY().isSelected()) {
	        			window.setOsY(-1);
	        		}	   
		        	window.getFrame().dispose();
		        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
		        	 
					for (Object command : list) {
						if(command instanceof SetPositionCommand) {
							commands.add(calculation.drawWithSetPositionCommand(command, window));					
						} else {				
							commands.add(calculation.drawWithDrawToCommand(command, window));
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
