package example1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TabbedIntegratedScreens extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabbedIntegratedScreens frame = new TabbedIntegratedScreens();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	private KidsGuessGame panel;
	private JTabbedPane tabbedPane;
	private ComputerGuessGame panel_1;
	
	public TabbedIntegratedScreens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_0 = new JPanel();
		tabbedPane.addTab("Start Screen", null, panel_0, null);
		
		JSplitPane splitPane = new JSplitPane();
		panel_0.add(splitPane);
		
		JButton btnNewButton = new JButton("Kids Guess Mode");
		
		splitPane.setLeftComponent(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Computer Guess Mode");
		splitPane.setRightComponent(btnNewButton_1);
		
		panel = new KidsGuessGame();
		tabbedPane.addTab("Kids Game", null, panel, null);
		
		panel_1 = new ComputerGuessGame();
		tabbedPane.addTab("Computer Game", null, panel_1, null);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedComponent(panel);
			}});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedComponent(panel_1);
			}
		}
		);
	}

}
