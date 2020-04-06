package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View1 extends JFrame {
	public JTextField timpSimulare, timpMaxServ, timpMinServ, timpMaxSos, timpMinSos, nrCase, nrClienti;
	public JButton start;
	public JButton simuleaza;

	public View1() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(gbag);
		timpSimulare = new JTextField(20);
		timpMaxSos = new JTextField(20);
		timpMinSos = new JTextField(20);
		timpMaxServ = new JTextField(20);
		timpMinServ = new JTextField(20);
		nrCase = new JTextField(20);
		nrClienti = new JTextField(20);
		JLabel titlu = new JLabel("Initializare");
		JLabel l1 = new JLabel("Timp simulare  ");
		JLabel l2 = new JLabel("Timp maxim sosire  ");
		JLabel l3 = new JLabel("Timp minim sosire  ");
		JLabel l4 = new JLabel("Timp maxim servire  ");
		JLabel l5 = new JLabel("Timp minim servire  ");
		JLabel l6 = new JLabel("Numar case  ");
		JLabel l7 = new JLabel("Numar clienti  ");
		start = new JButton("Initializeaza");
		simuleaza = new JButton("Simuleaza");

		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(titlu, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l1, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(timpSimulare, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l2, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(timpMaxSos, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l3, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(timpMinSos, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l4, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(timpMaxServ, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l5, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(timpMinServ, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l6, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(nrCase, gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(l7, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(nrClienti, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(start, gbc);
		gbc.gridwidth = GridBagConstraints.CENTER;
		gbag.setConstraints(simuleaza, gbc);
		
		p.add(titlu);
		p.add(l1);
		p.add(timpSimulare);
		p.add(l2);
		p.add(timpMaxSos);
		p.add(l3);
		p.add(timpMinSos);
		p.add(l4);
		p.add(timpMaxServ);
		p.add(l5);
		p.add(timpMinServ);
		p.add(l6);
		p.add(nrCase);
		p.add(l7);
		p.add(nrClienti);
		p.add(start);
		p.add(simuleaza);
		this.setContentPane(p);
		this.setTitle("Simulare");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addText1Listener(ActionListener a) {
		timpSimulare.addActionListener(a);
	}

	public void addText2Listener(ActionListener a) {
		timpMaxSos.addActionListener(a);
	}

	public void addText3Listener(ActionListener a) {
		timpMinSos.addActionListener(a);
	}

	public void addText4Listener(ActionListener a) {
		timpMaxServ.addActionListener(a);
	}

	public void addText5Listener(ActionListener a) {
		timpMinServ.addActionListener(a);
	}

	public void addText6Listener(ActionListener a) {
		nrCase.addActionListener(a);
	}

	public void addText7Listener(ActionListener a) {
		nrClienti.addActionListener(a);
	}

	public void addButton1Listener(ActionListener a) {
		start.addActionListener(a);
	}

	public void addButton2Listener(ActionListener a) {
		simuleaza.addActionListener(a);
	}

}
