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
 			//skalowanie o jaką wartość, teraz dla przykładu 2
 			double scale = 1.5;
 			commandArrayList.add(new CommandSetPosition((int)Math.floor(x*scale), (int)Math.floor(y*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x + width)*scale), (int)Math.floor(y*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x + width)*scale), (int)Math.floor((y + height)*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor(x*scale), (int)Math.floor((y + height)*scale)));
 	  		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor(x*scale), (int)Math.floor(y*scale)));
 		} else if(command.equals("MirrorCommand")) {
 			commandArrayList.add(new CommandSetPosition(x, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y));
 	  		commandArrayList.add(new CommandDrawLineToPosition(x, y));
 		} else if(command.equals("RotateCommand")) {
 			//dodac zapytanie o jaki kąt ma być rotacja, teraz dla 45
 			commandArrayList.add(new CommandSetPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x+width)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x+width)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x+width)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y+height)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x+width)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y+height)*Math.cos(Math.toRadians(45)))));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y+height)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y+height)*Math.cos(Math.toRadians(45)))));
 	  		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 		} else if(command.equals("StretchCommand")) {
 			//który bok rozciągamy ?
 			int stretch = 2;
 			commandArrayList.add(new CommandSetPosition(x, y * stretch));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y * stretch));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y + height));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y + height));
 	  		commandArrayList.add(new CommandDrawLineToPosition(x, y*stretch));
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
 			commandArrayList.add(new CommandSetPosition(x + xMove, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width, y + yMove));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove + width - (width / 3), y + yMove + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + xMove, y + yMove));
 		} else if(command.equals("ScaleCommand")) {
 			//skalowanie o jaką wartość, teraz dla przykładu 2
 			double scale = 1.5;
 			commandArrayList.add(new CommandSetPosition((int)Math.floor(x*scale), (int)Math.floor(y*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x + width)*scale), (int)Math.floor(y*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x + width - width/3)*scale), (int)Math.floor((y + height)*scale)));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor(x*scale), (int)Math.floor((y + height)*scale)));
 	  		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor(x*scale), (int)Math.floor(y*scale)));
 		} else if(command.equals("MirrorCommand")) {
 			//ewentualne pytanie wokół której osi X czy Y
 			//Przykladowo dla osi Y
 			commandArrayList.add(new CommandSetPosition(x, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + (width / 3), y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y));
 		} else if(command.equals("RotateCommand")) {
 			//dodac zapytanie o jaki kąt ma być rotacja, teraz dla 45
 			commandArrayList.add(new CommandSetPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x+width)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x+width)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x+width-width/3)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y+height)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x+width-width/3)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y+height)*Math.cos(Math.toRadians(45)))));		
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y+height)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y+height)*Math.cos(Math.toRadians(45)))));		
 	 		commandArrayList.add(new CommandDrawLineToPosition((int)Math.floor((x)*Math.cos(Math.toRadians(45))) - 
 					(int)Math.floor((y)*Math.sin(Math.toRadians(45))), 
 					(int)Math.floor((x)*Math.sin(Math.toRadians(45))) + 
 					(int)Math.floor((y)*Math.cos(Math.toRadians(45)))));
 		} else if(command.equals("StretchCommand")) {
 			//który bok rozciągamy ?
 			int stretch = 2;
 			commandArrayList.add(new CommandSetPosition(x, y*stretch));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width, y*stretch));
 	 		commandArrayList.add(new CommandDrawLineToPosition(x + width - (width / 3), y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x , y + height));		
 	 		commandArrayList.add(new CommandDrawLineToPosition(x, y*stretch));
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
