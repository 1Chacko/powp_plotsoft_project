package edu.iis.powp.command;

import java.util.List;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand implements PlotterCommand {	
 	
 	private List<PlotterCommand> list;
 	
	
	public ComplexCommand(List<PlotterCommand> list){
		super();
		this.list = list;
	}
	
	@Override
	public void execute(IPlotter driver) {
		for (Object command : list) {
			((PlotterCommand)command).execute(driver);
		}
	}
	
	public List<PlotterCommand> getList() {
		return list;
	}
	
	public void setList(List<PlotterCommand> list) {
		this.list = list;
	}
}
