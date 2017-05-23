package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.FactoryCommand;

public class SelectTestFiguresOptionListener implements ActionListener{
	
	String checkWhichTest;
	
	public SelectTestFiguresOptionListener(String string) {
 		this.checkWhichTest = string;
 	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(checkWhichTest.equals("Rectangle")) {
			FactoryCommand.createRectangle(0, 0, 100, 200).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
 		} else if(checkWhichTest.equals("RightTrapezoid")) {
 			FactoryCommand.createRightTrapezoid(0, 0, 100, 200).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
 		}
		
		
		
	}

}
