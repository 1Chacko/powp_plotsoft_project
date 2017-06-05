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

public class SelectRotateCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY("rotateBox");
		window.getOkButton().addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {			        			        			        	
	        	window.getFrame().dispose();
	        	List<IPlotterCommand> list = FeaturesManager.getPlotterCommandManager().getCurrentListOfCommands();	        	
	        	List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
	        	
				for (Object command : list) {
					if(command instanceof SetPositionCommand) {		
						commands.add(new SetPositionCommand((int)Math.floor(((SetPositionCommand) command).getPosX()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))) - (int)Math.floor(((SetPositionCommand) command).getPosY()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))),
								(int)Math.floor((((SetPositionCommand) command).getPosX())*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))) + (int)Math.floor(((SetPositionCommand) command).getPosY()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText()))))));					
					} else {
						commands.add(new DrawToCommand((int)Math.floor((((DrawToCommand) command).getPosX())*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText())))) - (int)Math.floor(((DrawToCommand) command).getPosY()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))),
								(int)Math.floor(((DrawToCommand) command).getPosX()*Math.sin(Math.toRadians(Double.parseDouble(window.getX().getText())))) + (int)Math.floor(((DrawToCommand) command).getPosY()*Math.cos(Math.toRadians(Double.parseDouble(window.getX().getText()))))));
					}
				}		
				
				PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
				manager.setCurrentCommand(commands, "RotateCommand");
	        }
		
		});	   
	}
}