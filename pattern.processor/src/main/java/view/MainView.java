package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;

public class MainView {

	/**
	 * @wbp.parser.entryPoint
	 */
	public void showView() {
		JFrame frame = new JFrame("Pattern Processor");
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	
}
