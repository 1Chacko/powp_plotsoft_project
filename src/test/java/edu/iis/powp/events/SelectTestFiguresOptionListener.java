package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.FactoryCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

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
			    JDialog frame = new JDialog();
			    frame.setLayout(null);
			    frame.setSize(230, 170);
			    frame.setLocation(300, 250);
			    JTextField x = new JTextField();
			    JLabel xLabel = new JLabel("Przesunięcie x");
			    JTextField y = new JTextField(); 	   
			    JLabel yLabel = new JLabel("Przesunięcie y");
			    JButton okButton = new JButton("OK");
			    
			    okButton.addActionListener (new ActionListener () {
			        public void actionPerformed(ActionEvent e) {			        			        			        	
			        	frame.dispose();
			        	FactoryCommand.createRectangle(-50, -50, 100, 200, 	Integer.parseInt(x.getText()), Integer.parseInt(y.getText())).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			        }
			    });	 	    
			    
			    x.setSize(50, 25);
			    y.setSize(50, 25);
			    xLabel.setSize(100, 25);
			    yLabel.setSize(100, 25);
			
			    okButton.setSize(75, 40);		 	    
			  
			    x.setLocation(25, 5);		 	   
			    xLabel.setLocation(5, 35);
			    y.setLocation(135, 5);
			    yLabel.setLocation(115, 35);
			    okButton.setLocation(65, 75);
			    
			    frame.add(okButton);		 	
			    frame.add(x);
			    frame.add(y);
			    frame.add(yLabel);
			    frame.add(xLabel);
			    frame.setResizable(false);		 	
			    frame.setVisible(true);
			    frame.setTitle("Podaj x i y");	

 			} else if(checkWhichTest.equals("RightTrapezoid")) {
 			  	JDialog frame = new JDialog();
			    frame.setLayout(null);
			    frame.setSize(230, 170);
			    frame.setLocation(300, 250);
			    JTextField x = new JTextField();
			    JLabel xLabel = new JLabel("Przesunięcie x");
			    JTextField y = new JTextField(); 	   
			    JLabel yLabel = new JLabel("Przesunięcie y");
			    JButton okButton = new JButton("OK");
			    
			    okButton.addActionListener (new ActionListener () {
			        public void actionPerformed(ActionEvent e) {			        			        			        	
			        	frame.dispose();
			        	FactoryCommand.createRightTrapezoid(-50, -50, 100, 200, Integer.parseInt(x.getText()), 	Integer.parseInt(y.getText())).execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			        }
			    });	 	    
			    
			    x.setSize(50, 25);
			    y.setSize(50, 25);
			    xLabel.setSize(100, 25);
			    yLabel.setSize(100, 25);
			
			    okButton.setSize(75, 40);		 	    
			  
			    x.setLocation(25, 5);		 	   
			    xLabel.setLocation(5, 35);
			    y.setLocation(135, 5);
			    yLabel.setLocation(115, 35);
			    okButton.setLocation(65, 75);
			    
			    frame.add(okButton);		 	
			    frame.add(x);
			    frame.add(y);
			    frame.add(yLabel);
			    frame.add(xLabel);
			    frame.setResizable(false);		 	
			    frame.setVisible(true);
			    frame.setTitle("Podaj x i y");	
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
