package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Client.Client;
import Magazin.*;

public class Controller implements ActionListener {
	public View1 view1;
	public View2 view2;
	public ArrayList<Casa> caseDeschise = new ArrayList<Casa>(3);
	public int timpSimulare;
	public int timpMaxServ;
	public int timpMinServ;
	public int timpMaxSos;
	public int timpMinSos;
	public int nrCase = 3;
	public int nrClienti;

	public Controller(View1 view1, View2 view2, ArrayList<Casa> caseDeschise) {
		this.view1 = view1;
		this.view2 = view2;
		this.caseDeschise = caseDeschise;
		view1.addText1Listener(new SimListener());
		view1.addText2Listener(new SimListener());
		view1.addText3Listener(new SimListener());
		view1.addText4Listener(new SimListener());
		view1.addText5Listener(new SimListener());
		view1.addText6Listener(new SimListener());
		view1.addText7Listener(new SimListener());
		view1.addButton1Listener(new SimListener());
		view1.addButton2Listener(this);
	}

	class SimListener implements ActionListener {

		public void actionPerformed(ActionEvent action) {
			timpSimulare = Integer.parseInt(view1.timpSimulare.getText());
			timpMaxServ = Integer.parseInt(view1.timpMaxServ.getText());
			timpMinServ = Integer.parseInt(view1.timpMinServ.getText());
			timpMaxSos = Integer.parseInt(view1.timpMaxSos.getText());
			timpMinSos = Integer.parseInt(view1.timpMinSos.getText());
			nrCase = Integer.parseInt(view1.nrCase.getText());
			nrClienti = Integer.parseInt(view1.nrClienti.getText());
		}
	}

	public void actionPerformed(ActionEvent e) {
		view2.setVisible(true);
		final Timer t1 = new Timer();
		t1.scheduleAtFixedRate(new TimerTask() {
			float goala = 0;
			int timpCurent = 0;
			int nrMaximClienti = 0;
			int timpVarf;

			@Override
			public void run() {
				goala = goala + caseDeschise.get(0).esteCasaGoala() + caseDeschise.get(1).esteCasaGoala()
						+ caseDeschise.get(2).esteCasaGoala();
				timpCurent++;
				int nrTotalClienti = 0;
				for (int i = 0; i < nrCase; i++) {
					nrTotalClienti = nrTotalClienti + caseDeschise.get(i).coada.size();
					if (nrTotalClienti > nrMaximClienti) {
						nrMaximClienti = nrTotalClienti;
						timpVarf = timpCurent;
					}
				}
				view2.output1.setText(caseDeschise.get(0).toString());
				view2.output2.setText(caseDeschise.get(1).toString());
				view2.output3.setText(caseDeschise.get(2).toString());
				view2.output4.setText("" + caseDeschise.get(0).timpMediuServire1 / caseDeschise.get(0).numarTotalClienti);
				view2.output5.setText("" + caseDeschise.get(1).timpMediuServire1 / caseDeschise.get(1).numarTotalClienti);
				view2.output6.setText("" + caseDeschise.get(2).timpMediuServire1 / caseDeschise.get(2).numarTotalClienti);
				view2.output8.setText("" + goala / nrCase);
				view2.output9.setText("" + timpVarf + " cu " + nrMaximClienti + " clienti ");
				if (caseDeschise.get(0).coada.size() == 0 && caseDeschise.get(1).coada.size() == 0
						&& caseDeschise.get(2).coada.size() == 0)
					t1.cancel();
			}
		}, 1000, 1000);
	}
}
