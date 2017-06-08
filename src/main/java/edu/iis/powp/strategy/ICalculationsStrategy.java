package edu.iis.powp.strategy;

import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.WindowXY;

public interface ICalculationsStrategy {

	public SetPositionCommand drawWithSetPositionCommand(Object command, WindowXY window);
	
	public DrawToCommand drawWithDrawToCommand(Object command, WindowXY window);
}
