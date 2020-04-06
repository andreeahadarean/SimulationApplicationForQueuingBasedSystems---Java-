package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class View2 extends JFrame {

	public JTextField output1;
	public JTextField output2;
	public JTextField output3;
	public JTextField output4;
	public JTextField output5;
	public JTextField output6;
	public JTextField output7;
	public JTextField output8;
	public JTextField output9;

	public View2() {
		output1 = new JTextField(20);
		output1.setEditable(false);
		output2 = new JTextField(20);
		output2.setEditable(false);
		output3 = new JTextField(20);
		output3.setEditable(false);
		output4 = new JTextField(20);
		output4.setEditable(false);
		output5 = new JTextField(20);
		output5.setEditable(false);
		output6 = new JTextField(20);
		output6.setEditable(false);
		output7 = new JTextField(20);
		output7.setEditable(false);
		output8 = new JTextField(20);
		output8.setEditable(false);
		output9 = new JTextField(20);
		output9.setEditable(false);
		JLabel titlu = new JLabel("Simulare");
		JLabel l1 = new JLabel("\uD83D\uDCB0" + 0 + " ");
		JLabel l2 = new JLabel("\uD83D\uDCB0" + 1 + " ");
		JLabel l3 = new JLabel("\uD83D\uDCB0" + 2 + " ");
		JLabel l4 = new JLabel("\uD83D\uDCB0" + 0 + " timp mediu servire ");
		JLabel l5 = new JLabel("\uD83D\uDCB0" + 1 + " timp mediu servire ");
		JLabel l6 = new JLabel("\uD83D\uDCB0" + 2 + " timp mediu servire ");
		JLabel l7 = new JLabel("Timp asteptare mediu ");
		JLabel l8 = new JLabel("Timp coada goala mediu ");
		JLabel l9 = new JLabel("Ora de varf ");
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(titlu, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output1, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output2, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output3, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l4, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output4, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l5, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output5, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l6, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output6, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l7, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output7, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l8, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output8, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l9, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(output9, gbc);
		
		p.add(titlu);
		p.add(l1);
		p.add(output1);
		p.add(l2);
		p.add(output2);
		p.add(l3);
		p.add(output3);
		p.add(l4);
		p.add(output4);
		p.add(l5);
		p.add(output5);
		p.add(l6);
		p.add(output6);
		p.add(l7);
		p.add(output7);
		p.add(l8);
		p.add(output8);
		p.add(l9);
		p.add(output9);
		this.setContentPane(p);
		this.setTitle("Simulare");
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
