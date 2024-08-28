package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.CounterListenter;
import model.CounterModel;

public class CounterView extends JFrame {

	private CounterModel counterModel;
	private JButton jbtn_up;
	private JButton jbtn_down;
	private JButton jbtn_reset;
	private JLabel jlabel;

	public CounterView() {
		// TODO Auto-generated constructor stub
		counterModel = new CounterModel();
		init();
		this.setVisible(true);
	}

	public void init() {
		this.setTitle("Counter Application");
		this.setSize(350, 350);
		this.setLocationRelativeTo(null);

		// Label: value of count
		jlabel = new JLabel(counterModel.getValue() + "", JLabel.CENTER);

		// create buttons
		jbtn_up = new JButton("UP");
		jbtn_down = new JButton("DOWN");
		jbtn_reset = new JButton("RESET");

		// create panel
		JPanel jpanel = new JPanel();
		// Padding: top, left, bottom, right
		jpanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		jpanel.setLayout(new BorderLayout());

		// add components to jpanel
		jpanel.add(jbtn_up, BorderLayout.WEST);
		jpanel.add(jlabel, BorderLayout.CENTER);
		jpanel.add(jbtn_down, BorderLayout.EAST);
		jpanel.add(jbtn_reset, BorderLayout.SOUTH);

		// set layout for view, then add jpanel to view
		this.setLayout(new BorderLayout());
		this.add(jpanel, BorderLayout.CENTER);

		// add CounterListener
		ActionListener ac = new CounterListenter(this);
		jbtn_up.addActionListener(ac);
		jbtn_down.addActionListener(ac);
		jbtn_reset.addActionListener(ac);

		// close view
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void increment() {
		this.counterModel.increment();
		this.jlabel.setText(this.counterModel.getValue() + "");

	}

	public void decrement() {
		this.counterModel.decrement();
		this.jlabel.setText(this.counterModel.getValue() + "");

	}

	public void reset() {
		this.counterModel.reset();
		this.jlabel.setText(this.counterModel.getValue() + "");

	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new CounterView();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
