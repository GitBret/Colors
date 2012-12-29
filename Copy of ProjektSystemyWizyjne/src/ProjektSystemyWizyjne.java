import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProjektSystemyWizyjne {

	private JFrame frame;
	private JTextArea textArea;
	// private JPanel panel_1;
	private MyPanelSW myPanelSW;
	private int fileIndex = 0;
	private JPanel panel;
	private String[] colors = new String[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjektSystemyWizyjne window = new ProjektSystemyWizyjne();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjektSystemyWizyjne() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 20, 1036, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		myPanelSW = new MyPanelSW(fileIndex);
		myPanelSW.setBounds(106, 38, 900, 600);
		panel.add(myPanelSW);

		textArea = new JTextArea();
		textArea.setBackground(panel.getBackground());
		textArea.setBounds(10, 38, 86, 213);
		panel.add(textArea);

		final Button button_1 = new Button("Prev");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				fileIndex--;
				if (fileIndex == -1)
					fileIndex = 22;
				panel.remove(myPanelSW);
				myPanelSW = new MyPanelSW(fileIndex);
				myPanelSW.setBounds(106, 38, 900, 600);
				panel.add(myPanelSW);
				frame.repaint();
			}
		});
		button_1.setBounds(106, 10, 70, 22);
		panel.add(button_1);

		final Button button_3 = new Button("Next");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				fileIndex++;
				if (fileIndex == 23)
					fileIndex = 0;
				panel.remove(myPanelSW);
				myPanelSW = new MyPanelSW(fileIndex);
				myPanelSW.setBounds(106, 38, 900, 600);
				panel.add(myPanelSW);
				frame.repaint();
			}
		});
		button_3.setBounds(354, 10, 70, 22);
		panel.add(button_3);

		final Button button_2 = new Button("Read colors");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_1.setEnabled(false);
				button_2.setEnabled(false);
				button_3.setEnabled(false);
				myPanelSW.readColors(colors);
				for (int i = 0; i < 10; i++) {
					if (colors[i] != null && colors[i] != " ") {
						writeText(colors[i]);
						colors[i] = " ";
					}
				}
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
			}
		});
		button_2.setBounds(225, 10, 70, 22);
		panel.add(button_2);
	}

	public void writeText(String string) {
		String current = (String) textArea.getText();
		current = string + "\n" + current;
		if (current.length() > 300) {
			int truncPoint = current.lastIndexOf("\n");
			current = (String) current.subSequence(0, truncPoint);
		}
		textArea.setText(current);

	}
}
