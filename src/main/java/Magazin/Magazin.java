package Magazin;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;
import Client.Client;
import GUI.*;

public class Magazin {
	public int timpLimita;
	public int timpMaximServire;
	public int timpMinimServire;
	public int timpMaximSosire;
	public int timpMinimSosire;
	public int numarCase = 3;
	public int numarClienti;
	public int nrClientiPerCoada = 0;
	public int ID = 0;
	public float timpMediuAsteptare = 0;
	public ArrayList<Casa> caseDeschise = new ArrayList<Casa>(numarCase);;
	View1 v1 = new View1();
	View2 v2 = new View2();
	public Controller c;
	public static Logger logger = LogManager.getLogger(Magazin.class);

	public Magazin(int zero) throws InterruptedException {
		initializeaza();
		deschideCase();
		genereazaClienti();
		inchideCase();
	}

	public void initializeaza() throws InterruptedException {
		v1.setVisible(true);
		c = new Controller(v1, v2, caseDeschise);
		TimeUnit.SECONDS.sleep(20);
		System.out.println("Puteti apasa INITIALIZEAZA si apoi SIMULEAZA");
		TimeUnit.SECONDS.sleep(3);
		timpLimita = c.timpSimulare;
		timpMaximServire = c.timpMaxServ;
		timpMinimServire = c.timpMinServ;
		timpMaximSosire = c.timpMaxSos;
		timpMinimSosire = c.timpMinSos;
		numarClienti = c.nrClienti;
	}

	public void deschideCase() throws InterruptedException {
		for (int i = 0; i < numarCase; i++) {
			caseDeschise.add(i, new Casa("" + i));
			caseDeschise.get(i).start();
		}
		TimeUnit.SECONDS.sleep(1);
	}

	public int alegeCasa() {
		int timpMinimServire = Integer.MAX_VALUE;
		int indexCasa = 0;
		for (int i = 0; i < numarCase; i++) {
			caseDeschise.get(i).determinaTimpulDeServire();
			if (caseDeschise.get(i).determinaTimpulDeServire() < timpMinimServire) {
				timpMinimServire = caseDeschise.get(i).determinaTimpulDeServire();
				indexCasa = i;
			}
		}
		return indexCasa;
	}

	public void genereazaClienti() throws InterruptedException {
		int timpCurent = 0;
		while (timpCurent < timpLimita) {
			if (nrClientiPerCoada == numarClienti)
				break;
			timpCurent++;
			nrClientiPerCoada++;
			Random rand = new Random(); 
			int timpServire = rand.nextInt((timpMaximServire - timpMinimServire) + 1) + timpMinimServire;
			Client c = new Client(++ID, timpServire);
			int indexCoada = alegeCasa();
			timpMediuAsteptare = timpMediuAsteptare + caseDeschise.get(indexCoada).determinaTimpulDeServire();
			final Timer t1 = new Timer();
			t1.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					v2.output7.setText("" + timpMediuAsteptare / nrClientiPerCoada);
					for (int i = 0; i < numarCase; i++) {
						if (caseDeschise.get(i).coada.size() == 0) {
							t1.cancel();
						}
					}
				}
			}, 2000, 2000);
			caseDeschise.get(indexCoada).adaugaClient(c);
			int timpSosire = rand.nextInt((timpMaximSosire - timpMinimSosire) + 1) + timpMinimSosire;
			TimeUnit.SECONDS.sleep(timpSosire);
		}
	}

	public void inchideCase() {
		for (int i = 0; i < numarCase; i++) {
			if (caseDeschise.get(i).coada.size() == 0) {
				logger.info("Casa " + i + " este inchisa");
				caseDeschise.get(i).interrupt();
			}
		}
	}
}
