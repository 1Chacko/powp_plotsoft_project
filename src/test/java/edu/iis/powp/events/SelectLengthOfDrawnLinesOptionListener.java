package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.window.LengthOfDrawnLinesState;
import edu.iis.powp.window.WindowXY;

public class SelectLengthOfDrawnLinesOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WindowXY window = new WindowXY(new LengthOfDrawnLinesState());
		window.getOkButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				window.getFrame().dispose();
				
			}
		});

	}

}
