import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class myGUI {
	
	public static void main(String args[]) {

		ConcreteCalculator myCalculator = new ConcreteCalculator();
		JFrame f = new JFrame("A JFrame");
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setLocation(300,200);
		final JTextArea textArea = new JTextArea(10, 40);
		f.getContentPane().add(BorderLayout.CENTER, textArea);
		final JButton addButton = new JButton("Add Shape");
		final JButton removeButton = new JButton("Remove Shape");
		f.getContentPane().add(BorderLayout.NORTH, addButton);
		f.getContentPane().add(BorderLayout.AFTER_LAST_LINE, removeButton);
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = textArea.getText();
				textArea.append(myCalculator.addShapes(str));
				
				textArea.append("ADD Button was clicked\n");
				textArea.removeAll();
			}

		});

		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.append("REMOVE Button was clicked\n");

			}

		});
		
		f.setVisible(true);
	}
}
