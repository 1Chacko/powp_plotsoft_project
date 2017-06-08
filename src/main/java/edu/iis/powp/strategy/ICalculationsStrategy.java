package edu.iis.powp.strategy;

import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.window.WindowXY;

public interface ICalculationsStrategy {

	/**
	 * Metoda ustawiajaca głowice plottera w punkcie
	 * @param command
	 * @param window
	 * @return object of class SetPositionCommand
	 */
	public SetPositionCommand drawWithSetPositionCommand(Object command, WindowXY window);
	
	/**
	 * Metoda rysujaca od punktu A do punktu B
	 * @param command
	 * @param window
	 * @return object of class DrawToCommand
	 */
	public DrawToCommand drawWithDrawToCommand(Object command, WindowXY window);
}
