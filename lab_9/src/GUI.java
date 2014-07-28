import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI implements Runnable {

	private JFrame _mainWindow;
	private Container pane;
	private JPanel _form;
	private JPanel _buttons;
	private JPanel _type;
	private JButton oldButton;
	private JButton newButton;
	private JButton searchButton;
	private JButton createButton;
	private GridBagConstraints c;
	private GridBagConstraints d;
	private JCheckBox mulButton;
	private JCheckBox watButton;
	private JTextField porch;
	private JTextField yard;
	private JCheckBox foodButton;
	private JCheckBox resButton;
	private JCheckBox parkButton;
	private JRadioButton officeButton;
	private JRadioButton retailButton;
	private static Property[] database = new Property[64];

	@Override
	public void run() {
		_mainWindow = new JFrame("CSE116 – Lab 9 – Real Estate");
		_mainWindow.setSize(347, 450);
		_mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// GroupLayout formLayout = new GroupLayout(_form);
		// _form.setLayout(formLayout);
		pane = _mainWindow.getContentPane();
		pane.setLayout(new BorderLayout());
		_form = new JPanel();
		_buttons = new JPanel();
		_type = new JPanel();
		_type.setLayout(new GridBagLayout());
		d = new GridBagConstraints();
		_buttons.setLayout(new FlowLayout());
		_form.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		pane.add(_form, BorderLayout.EAST);
		pane.add(_buttons, BorderLayout.SOUTH);

		ImageIcon rs = new ImageIcon("image.jpg");

		newButton = new JButton("Add New Property");

		newButton.addActionListener(new ActionListener() {

			private JTextField add;
			private JComboBox typeList;
			private JTextField num;
			private JTextField age;

			@Override
			public void actionPerformed(ActionEvent e) {
				_form.removeAll();
				c.gridx = 0;
				c.gridy = 0;

				JLabel addLabel = new JLabel("Address:");
				c.gridx = 0;
				c.gridy = 0;
				_form.add(addLabel, c);
				add = new JTextField("Enter Address", 20);
				c.gridx = 1;
				c.gridy = 0;
				_form.add(add, c);

				JLabel numLabel = new JLabel("Stories:");
				c.gridx = 0;
				c.gridy = 1;
				_form.add(numLabel, c);
				num = new JTextField("0", 5);
				c.gridx = 1;
				c.gridy = 1;
				_form.add(num, c);

				JLabel ageLabel = new JLabel("Age of Property:");
				c.gridx = 0;
				c.gridy = 2;
				_form.add(ageLabel, c);
				age = new JTextField("0", 5);
				c.gridx = 1;
				c.gridy = 2;
				_form.add(age, c);

				JLabel typeLabel = new JLabel("Type of Property:");
				c.gridx = 0;
				c.gridy = 3;
				_form.add(typeLabel, c);
				String[] typeStrings = { " ", "Residential", "Commercial" };
				typeList = new JComboBox(typeStrings);
				c.gridx = 1;
				c.gridy = 3;
				typeList.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						if (typeList.getSelectedIndex() == 1) {

							_type.removeAll();
							d.gridx = 0;
							d.gridy = 0;
							mulButton = new JCheckBox("Multiple Dwelling");

							d.gridx = 0;
							d.gridy = 5;
							_type.add(mulButton, d);
							watButton = new JCheckBox("External Water Faucet");
							d.gridx = 1;
							d.gridy = 5;
							_type.add(watButton, d);

							JLabel porchLabel = new JLabel("Porch Size (sqft):");
							d.gridx = 0;
							d.gridy = 6;
							_type.add(porchLabel, d);
							porch = new JTextField("0", 5);
							d.gridx = 1;
							d.gridy = 6;
							_type.add(porch, d);

							JLabel yardLabel = new JLabel("Yard Size (sqft):");
							d.gridx = 0;
							d.gridy = 7;
							_type.add(yardLabel, d);
							yard = new JTextField("0", 5);
							d.gridx = 1;
							d.gridy = 7;
							_type.add(yard, d);
							c.gridx = 0;
							c.gridy = 6;
							_form.add(_type, c);
							_form.updateUI();
							_mainWindow.pack();
						}
						if (typeList.getSelectedIndex() == 2) {
							_type.removeAll();
							d.gridx = 0;
							d.gridy = 0;
							foodButton = new JCheckBox("Serves Food");
							d.gridx = 0;
							d.gridy = 5;
							_type.add(foodButton, d);
							resButton = new JCheckBox("Include Residence");
							d.gridx = 1;
							d.gridy = 5;
							_type.add(resButton, d);
							parkButton = new JCheckBox("off-street parking");
							d.gridx = 0;
							d.gridy = 6;
							// d.gridwidth = 2;
							_type.add(parkButton, d);

							officeButton = new JRadioButton("Office");
							retailButton = new JRadioButton("Retail");

							ButtonGroup group = new ButtonGroup();
							group.add(officeButton);
							group.add(retailButton);
							// d.gridwidth = 0;
							d.gridx = 0;
							d.gridy = 7;

							_type.add(officeButton, d);

							d.gridx = 1;
							d.gridy = 7;
							_type.add(retailButton, d);

							c.gridx = 0;
							c.gridy = 6;
							_form.add(_type, c);
							_form.updateUI();
							_mainWindow.pack();
						}

						// _form.add(_type, c);
					}
				});
				_form.add(typeList, c);

				createButton = new JButton("Create Listing");
				c.gridx = 1;
				c.gridy = 9;
				// c.gridwidth = 3;
				// c.ipadx = 100;
				createButton.addActionListener(new ActionListener() {

					private Commercial com;
					private Residential r;
					private int number;
					private int agee;

					@Override
					public void actionPerformed(ActionEvent e) {
						_form.removeAll();
						String address = add.getText();
						boolean conIn = true;
						
						try {
							number = Integer.parseInt(num.getText());
							if(number<0){
								_form.removeAll();
								typeList.setSelectedIndex(0);
								_form.add(new JLabel("The number of Stories cannot be negative try again"), d);
								_form.updateUI();
								_mainWindow.pack();
							}
							conIn=false;
						} catch (NumberFormatException ex) {
							_form.removeAll();
							typeList.setSelectedIndex(0);
							_form.add(new JLabel("The number of Stories is not a number try again"), d);
							_form.updateUI();
							_mainWindow.pack();
							//System.out.println("The number of Stories is not a number try again");
							
						}
						
						try {
							agee = Integer.parseInt(age.getText());
							if(number<0){
								_form.removeAll();
								typeList.setSelectedIndex(0);
								_form.add(new JLabel("Age cannot be negative try again"), d);
								_form.updateUI();
								_mainWindow.pack();
							}
						} catch (NumberFormatException ex) {
							_form.removeAll();
							typeList.setSelectedIndex(0);
							_form.add(new JLabel("The Age is not a number try again"), d);
							_form.updateUI();
							_mainWindow.pack();
							
						}
						
						if (typeList.getSelectedIndex() == 1) {
							r = new Residential();
							r.setPurp(true);
							// store variables
							r.setADD(address);
							r.setNum(number);
							r.setAge(agee);
							r.setMul(mulButton.isSelected());
							r.setExtWat(watButton.isSelected());
							try{
							r.setPorchSize(Integer.parseInt(porch.getText()));
							if(Integer.parseInt(porch.getText())<0){
								_form.removeAll();
								typeList.setSelectedIndex(0);
								_form.add(new JLabel("Porch Size cannot be negative try again"), d);
								_form.updateUI();
								_mainWindow.pack();
							}
						} catch (NumberFormatException ex) {
							_form.removeAll();
							typeList.setSelectedIndex(0);
							_form.add(new JLabel("Porch Size is not a number try again"), d);
							_form.updateUI();
							_mainWindow.pack();
							
						}
							try{
							r.setYardSize(Integer.parseInt(yard.getText()));
							if(Integer.parseInt(yard.getText())<0){
								_form.removeAll();
								typeList.setSelectedIndex(0);
								_form.add(new JLabel("Yard Size cannot be negative try again"), d);
								_form.updateUI();
								_mainWindow.pack();
							}
						} catch (NumberFormatException ex) {
							_form.removeAll();
							typeList.setSelectedIndex(0);
							_form.add(new JLabel("Yard Size is not a number try again"), d);
							_form.updateUI();
							_mainWindow.pack();
							
						}
							// update database
							for (int i = 0; i < 63; i++) {
								if (database[i] == null) {
									database[i] = r;
									// System.out.println("Residential Property added at Array index "
									// + i);
									break;
								}
							}
							_form.add(new JLabel("Listing Created"), d);
							_form.updateUI();
							_mainWindow.pack();
						}
						if (typeList.getSelectedIndex() == 2) {
							com = new Commercial();
							com.setPurp(false);
							com.setADD(address);
							com.setNum(number);
							com.setAge(agee);
							com.setFood(foodButton.isSelected());
							com.setResAlso(resButton.isSelected());
							com.setParking(parkButton.isSelected());
							if (officeButton.isSelected()) {
								com.setMode(0);
							}
							if (retailButton.isSelected()) {
								com.setMode(1);
							}

							// update database
							for (int i = 0; i < 63; i++) {
								if (database[i] == null) {
									database[i] = com;
									// System.out.println("Commercial Property added at Array index "
									// + i);
									break;
								}
							}
							_form.add(new JLabel("Listing Created"), d);
							_form.updateUI();
							_mainWindow.pack();
						}

						c.gridx = 0;
						c.gridy = 10;

						
						_form.updateUI();
						_mainWindow.pack();

					}

				});
				_form.add(createButton, c);
				_form.updateUI();
				_mainWindow.pack();
			}

		});

		oldButton = new JButton("Look up Property");

		oldButton.addActionListener(new ActionListener() {

			private JTextField index;

			@Override
			public void actionPerformed(ActionEvent e) {
				_form.removeAll();
				JLabel indexLabel = new JLabel("Enter Index:");
				c.gridx = 0;
				c.gridy = 0;
				_form.add(indexLabel, c);
				index = new JTextField("0", 5);
				c.gridx = 1;
				c.gridy = 0;
				_form.add(index, c);

				searchButton = new JButton("Search");

				searchButton.addActionListener(new ActionListener() {

					@SuppressWarnings("unused")
					@Override
					public void actionPerformed(ActionEvent e) {
						_form.removeAll();
						// System.out.println("entered lookup");
						if(Integer.parseInt(index
								.getText())>63){
							_form.removeAll();
							_form.add(new JLabel("You cant do that"), d);
							_form.updateUI();
							_mainWindow.pack();
						}
						Property prop = database[Integer.parseInt(index
								.getText())];
						
						if (prop == null) {
							_form.removeAll();
							JLabel nullLabel = new JLabel(
									"There is no entry stored here");
							c.gridx = 0;
							c.gridy = 0;
							_form.add(nullLabel, c);
							_form.updateUI();
							_mainWindow.pack();
						}
						// System.out.println("Got res at index " +
						// index.getText());
						if (prop.getPurp()) {
							Residential res = (Residential) prop;
							JLabel addLabel = new JLabel("Address: "
									+ res.getADD());
							c.gridx = 0;
							c.gridy = 0;
							_form.add(addLabel, c);

							JLabel numLabel = new JLabel("Stories: "
									+ res.getNum());
							c.gridx = 0;
							c.gridy = 1;
							_form.add(numLabel, c);

							JLabel ageLabel = new JLabel("Age of Property: "
									+ res.getAge() + " years");
							c.gridx = 0;
							c.gridy = 2;
							_form.add(ageLabel, c);

							JLabel porchLabel = new JLabel(
									"Porch Size (sqft): " + res.getPorchSize()
											+ " sqft");
							c.gridx = 0;
							c.gridy = 3;
							_form.add(porchLabel, c);

							JLabel yardLabel = new JLabel("Yard Size (sqft): "
									+ res.getYardSize() + " sqft");
							c.gridx = 0;
							c.gridy = 4;
							_form.add(yardLabel, c);

							JLabel mulLabel = new JLabel("Multiple Dwelling: "
									+ res.getMul());
							c.gridx = 0;
							c.gridy = 5;
							_form.add(mulLabel, c);

							JLabel watLabel = new JLabel("External Water: "
									+ res.getExtWat());
							c.gridx = 0;
							c.gridy = 6;
							_form.add(watLabel, c);

							_form.updateUI();
							_mainWindow.pack();
							// System.out.println(res.getMul());
						}
						if (prop.getPurp() == false) {
							_form.removeAll();
							Commercial com = (Commercial) prop;
							JLabel addLabel = new JLabel("Address: "
									+ com.getADD());
							c.gridx = 0;
							c.gridy = 0;
							_form.add(addLabel, c);

							JLabel numLabel = new JLabel("Stories: "
									+ com.getNum());
							c.gridx = 0;
							c.gridy = 1;
							_form.add(numLabel, c);

							JLabel ageLabel = new JLabel("Age of Property: "
									+ com.getAge() + " years");
							c.gridx = 0;
							c.gridy = 2;
							_form.add(ageLabel, c);

							JLabel foodLabel = new JLabel("Multiple Dwelling: "
									+ com.getFood());
							c.gridx = 0;
							c.gridy = 3;
							_form.add(foodLabel, c);

							JLabel resLabel = new JLabel("Includes Residence: "
									+ com.getResAlso());
							c.gridx = 0;
							c.gridy = 4;
							_form.add(resLabel, c);

							JLabel parkLabel = new JLabel(
									"Off Street Parking: " + com.getParking());
							c.gridx = 0;
							c.gridy = 5;
							_form.add(parkLabel, c);

							JLabel officeLabel = new JLabel(
									"Office(0)/Retail(1) : " + com.getMode());
							c.gridx = 0;
							c.gridy = 6;
							_form.add(officeLabel, c);

							_form.updateUI();
							_mainWindow.pack();

						}

						_form.updateUI();
						_mainWindow.pack();
					}

				});
				_form.add(searchButton);
				_form.updateUI();
				_mainWindow.pack();
			}

		});
		JLabel image = new JLabel(rs);
		_mainWindow.add(image);
		_buttons.add(newButton);
		_buttons.add(oldButton);

		_mainWindow.setVisible(true);

	}

}
