package edu.iis.powp.command;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class FactoryCommand {	
		 	
 	public static ComplexCommand createRectangle(int x, int y, int height, int width, int xMove, int yMove ) {
 		//zapytanie o wartosci i kierunki przesuniec, odbic itd.
 		PlotterCommandManager pcm = FeaturesManager.getPlotterCommandManager(); 		
 		String command = pcm.getCurrentCommandString();
 		List<PlotterCommand> commandArrayList = new ArrayList<PlotterCommand>();
 		
 		if(command.equals("MoveCommand")){ 
 			//tu powinno byc zapytanie o ile przesunac, zeby mozna bylo wpisac wartosci w oznaczonym przez "move" miejscu 	
 			commandArrayList.add(new CommandSetPosition(x + xMove, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width, y + yMove + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove + height));
 	  		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove));
 		} else if(command.equals("ScaleCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("MirrorCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("RotateCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("StretchCommand")) {
 			//funkcjonalnosc
 		} else {
 			commandArrayList.add(new CommandSetPosition(x, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y + height));
 	  		commandArrayList.add(new CommandDrawLineToPosition(x, y));
 		}	
   		return new ComplexCommand(commandArrayList);
  	}
 	
 	public static ComplexCommand createRightTrapezoid(int x, int y, int height, int width, int xMove, int yMove ) {
 		
 		PlotterCommandManager pcm = FeaturesManager.getPlotterCommandManager(); 		
 		String command = pcm.getCurrentCommandString();
 		List<PlotterCommand> commandArrayList = new ArrayList<PlotterCommand>();
 		
 		if(command.equals("MoveCommand")){ 
 			//tu powinno byc zapytanie o ile przesunac, zeby mozna bylo wpisac wartosci w oznaczonym przez "move" miejscu
 			int move = -75;
 			commandArrayList.add(new CommandSetPosition(x + xMove, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width - (width / 3), y + yMove + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove));
 		} else if(command.equals("ScaleCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("MirrorCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("RotateCommand")) {
 			//funkcjonalnosc
 		} else if(command.equals("StretchCommand")) {
 			//funkcjonalnosc
 		} else {
 			commandArrayList.add(new CommandSetPosition(x, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width - (width / 3), y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x , y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y));
 		}
  		return new ComplexCommand(commandArrayList);
 	}
		 	
		  
}
