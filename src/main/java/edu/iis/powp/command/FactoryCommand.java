package edu.iis.powp.command;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class FactoryCommand {	
		 	
 	public static ComplexCommand createRectangle(int x, int y, int height, int width ) {
 		//zapytanie o wartosci i kierunki przesuniec, odbic itd.
 		PlotterCommandManager pcm = FeaturesManager.getPlotterCommandManager(); 		
 		String command = pcm.getCurrentCommandString();
 		List<PlotterCommand> commandArrayList = new ArrayList<PlotterCommand>();
 		
 		if(command.equals("MoveCommand")){ 
 			//tu powinno byc zapytanie o ile przesunac, zeby mozna bylo wpisac wartosci w oznaczonym przez "move" miejscu
 			int move = -75;
 			commandArrayList.add(new CommandSetPosition(x + move, y + move));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move + width, y + move));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move + width, y + move + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move, y + move + height));
 	  		commandArrayList.add(new CommandDrawLineToPosition(x + move, y + move));
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
 	
 	public static ComplexCommand createRightTrapezoid(int x, int y, int height, int width ) {
 		
 		PlotterCommandManager pcm = FeaturesManager.getPlotterCommandManager(); 		
 		String command = pcm.getCurrentCommandString();
 		List<PlotterCommand> commandArrayList = new ArrayList<PlotterCommand>();
 		
 		if(command.equals("MoveCommand")){ 
 			//tu powinno byc zapytanie o ile przesunac, zeby mozna bylo wpisac wartosci w oznaczonym przez "move" miejscu
 			int move = -75;
 			commandArrayList.add(new CommandSetPosition(x + move, y + move));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move + width, y + move));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move + width - (width / 3), y + move + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move, y + move + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + move, y + move));
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
