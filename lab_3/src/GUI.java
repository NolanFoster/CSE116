import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI implements Runnable {
	private JFrame _mainWindow;
	private Container pane;
	private JPanel _words;
	private Main m;
	private JButton nameButton;
	private JButton newButton;

	@Override
	public void run() {
		_mainWindow = new JFrame("CSE116 – Lab 2 – Nolan Foster");
		_mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = _mainWindow.getContentPane();
		pane.setLayout(new FlowLayout());
		_words = new JPanel();
		_words.setLayout(new FlowLayout());
		pane.add(_words);
		try {
			m = new Main();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		newButton = new JButton("Add New Player");

		newButton.addActionListener(new ActionListener() {

			private String id;
			private String skill;

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean cinput = true;
				boolean mainput = true;
				while (mainput) {
					while (cinput) {
						try {
							id = JOptionPane
									.showInputDialog(null,
											"Select a Player ID (it must be a number between 1-20):");
							int ID = Integer.parseInt(id);
							if (ID > 20 || ID < 1) {
								System.out
										.println("The ID must be between 1 and 20");

								cinput = true;
							}

							else {

								cinput = false;
							}
						} catch (NumberFormatException ex) {
							System.out.println("This is not a number");
							id = JOptionPane
									.showInputDialog(null,
											"Select a Player ID (it must be a number between 1-20):");
						}

					}
					String name = JOptionPane.showInputDialog(null,
							"What is the players name?");

					String team = JOptionPane.showInputDialog(null,
							"What is the team name?");

					String date = JOptionPane.showInputDialog(null,
							"What is todays date?");
					cinput = true;
					while (cinput) {
						try {
							skill = JOptionPane.showInputDialog(null,
									"What is thier skill level 0-99");
							int skint = Integer.parseInt(skill);
							if (skint > 99 || skint < 0) {
								System.out
										.println("The Skill level must be between 0 and 99");

								cinput = true;
							} else {
								cinput = false;
							}

						} catch (NumberFormatException ex) {
							System.out.println("This is not a number");

						}
					}
					try {
						m.writeToFile(id, name, skill, team, date);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainput = false;
				}
				_words.updateUI();
				_mainWindow.pack();
			}

		});

		nameButton = new JButton("Choose a File Name");

		nameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// choose a file location and store the value
				_words.removeAll();
				String name = JOptionPane.showInputDialog(null,
						"Input file Name:");
				m.setFileName(name);
				try {
					m.createFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				_mainWindow.add(newButton);
				_words.add(new JLabel("file was saved to "
						+ m.getFileLoc().toString() + "/" + name));
				_words.updateUI();
				_mainWindow.pack();
			}

		});

		JButton filelocButton = new JButton("Choose File Location");

		filelocButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// choose a file location and store the value
				_words.removeAll();
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Select a File Location");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					m.setFileLocation(chooser.getSelectedFile().toString());

				} else {
					System.out.println("No Selection was made");
				}

				_mainWindow.add(nameButton);
				_words.updateUI();
				_mainWindow.pack();
			}

		});

		JButton IDButton = new JButton("Search by ID");

		IDButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// choose a file location and store the value
				_words.removeAll();
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Select a File");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					m.setFileLocation(chooser.getSelectedFile().toString());
					try {
						m.openFile(chooser.getSelectedFile().toString());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					System.out.println("No Selection was made");
				}
				String where = JOptionPane.showInputDialog(null,
						"Input ID number");
				int id = Integer.parseInt(where);
				try {
					m.findByID(id);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				_words.updateUI();
				_mainWindow.pack();
			}

		});

		JButton OpenButton = new JButton("Open Old File");

		OpenButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// choose a file location and store the value
				_words.removeAll();
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Select a File");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					m.setFileLocation(chooser.getSelectedFile().toString());
					try {
						m.openFile(chooser.getSelectedFile().toString());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					System.out.println("No Selection was made");
				}

				_mainWindow.add(newButton);
				_words.updateUI();
				_mainWindow.pack();
			}

		});

		_mainWindow.add(IDButton);
		_mainWindow.add(OpenButton);
		_mainWindow.add(filelocButton);
		_mainWindow.pack();
		_mainWindow.setVisible(true);

	}
}
