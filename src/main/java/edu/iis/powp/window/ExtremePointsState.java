package edu.iis.powp.window;

import javax.swing.JLabel;

public class ExtremePointsState implements WindowXYState {

	@Override
	public void createBox(WindowXY windowXY) {
		windowXY.getFrame().setLayout(null);
		windowXY.getFrame().setSize(330, 230);
		windowXY.getFrame().setLocation(300, 250);
		JLabel extremePointsLabel = new JLabel("Najbardziej wysunięte punkty rysunku:");
		JLabel plusX = new JLabel("max(x):");
		JLabel plusY = new JLabel("max(y):");
		JLabel minusX = new JLabel("min(x):");
		JLabel minusY = new JLabel("min(y):");
		windowXY.getX().setEditable(false);
		windowXY.getY().setEditable(false);
		windowXY.getLabel().setEditable(false);
		windowXY.getSecondLabel().setEditable(false);
		
		extremePointsLabel.setSize(250, 25);
		windowXY.getOkButton().setSize(75, 40);
		plusX.setSize(100,25);
		plusY.setSize(100,25);
		minusX.setSize(100,25);
		minusY.setSize(100,25);
		windowXY.getX().setSize(50, 25);
		windowXY.getY().setSize(50, 25);
		windowXY.getLabel().setSize(50, 25);
		windowXY.getSecondLabel().setSize(50, 25);
		
		extremePointsLabel.setLocation(35, 10);	
		windowXY.getOkButton().setLocation(125, 155);
		plusX.setLocation(60, 35);
		plusY.setLocation(200, 35);
		windowXY.getX().setLocation(60, 60);
		windowXY.getY().setLocation(200, 60);
		minusX.setLocation(60, 100);
		minusY.setLocation(200, 100);
		windowXY.getLabel().setLocation(60, 125);
		windowXY.getSecondLabel().setLocation(200, 125);
		
		windowXY.getFrame().add(extremePointsLabel);
		windowXY.getFrame().add(windowXY.getOkButton());
		windowXY.getFrame().add(plusX);
		windowXY.getFrame().add(plusY);
		windowXY.getFrame().add(windowXY.getX());
		windowXY.getFrame().add(windowXY.getY());
		windowXY.getFrame().add(minusX);
		windowXY.getFrame().add(minusY);
		windowXY.getFrame().add(windowXY.getLabel());
		windowXY.getFrame().add(windowXY.getSecondLabel());
		
		windowXY.getFrame().setResizable(false);		 	
	    windowXY.getFrame().setVisible(true);
	    windowXY.getFrame().setTitle("Najbardziej wysunięte punkty rysunku");

	}

}
