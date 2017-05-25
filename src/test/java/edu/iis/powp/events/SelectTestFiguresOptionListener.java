package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.FactoryCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.window.WindowXY;

public class SelectTestFiguresOptionListener implements ActionListener{
	
	String checkWhichTest;	
	
	public SelectTestFiguresOptionListener(String string) {
 		this.checkWhichTest = string;
 	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		PlotterCommandManager pcm = FeaturesManager.getPlotterCommandManager(); 		
 		String command = pcm.getCurrentCommandString();
 		
 		if(command.equals("MoveCommand")) {
 			if(checkWhichTest.equals("Rectangle")) {	
 				WindowXY window = new WindowXY();
			    
			    window.getOkButton().addActionListener (new ActionListener () {
			        public void actionPerformed(ActionEvent e) {			        			        			        	
			        	window.getFrame().dispose();
			        	FactoryCommand.createRectangle(-50, -50, 100, 200, 	Integer.parseInt(window.getX().getText()), Integer.parseInt(window.getY().getText())).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			        }
			    });	 	    
			    
			   	

 			} else if(checkWhichTest.equals("RightTrapezoid")) {
 				WindowXY window = new WindowXY();
			    
 				window.getOkButton().addActionListener (new ActionListener () {
			        public void actionPerformed(ActionEvent e) {			        			        			        	
			        	window.getFrame().dispose();
			        	FactoryCommand.createRightTrapezoid(-50, -50, 100, 200, Integer.parseInt(window.getX().getText()), 	Integer.parseInt(window.getY().getText())).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			        }
			    });	     
 
 			}	
 		} else {
 			if(checkWhichTest.equals("Rectangle")) {		
 				FactoryCommand.createRectangle(-50, -50, 100, 200, 	0, 0).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
 			} else if(checkWhichTest.equals("RightTrapezoid")) {
 				FactoryCommand.createRightTrapezoid(-50, -50, 100, 200, 0, 0).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
 			}
 		}
		
	}

}
