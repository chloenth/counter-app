package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CounterView;

public class CounterListenter implements ActionListener {

	private CounterView cv;

	public CounterListenter(CounterView cv) {
		// TODO Auto-generated constructor stub
		this.cv = cv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();

		if (src.equals("UP")) {
			cv.increment();
		} else if (src.equals("DOWN")) {
			cv.decrement();
		} else if (src.equals("RESET")) {
			cv.reset();
		}

	}

}
