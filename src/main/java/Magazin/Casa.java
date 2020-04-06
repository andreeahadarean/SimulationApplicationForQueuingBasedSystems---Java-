package Magazin;

import java.util.concurrent.*;
import org.apache.logging.log4j.*;

import Client.*;
import GUI.View2;

public class Casa extends Thread {

	public BlockingQueue<Client> coada = new LinkedBlockingQueue<Client>();
	public float timpMediuServire1 = 0;
	public int numarTotalClienti = 0;
	public static Logger logger = LogManager.getLogger(Casa.class);

	public Casa(String nume) {
		setName(nume);
	}

	public void adaugaClient(Client c) {
		logger.info("Clientul " + c.ID + " s-a asezat la " + getName());
		coada.add(c);
		logger.info("La " + getName() + " sunt " + coada.size() + " clienti");
	}

	public int determinaTimpulDeServire() {
		int timpServire = 0;
		for (Client c : coada)
			timpServire = timpServire + c.timpServire;
		return timpServire;
	}

	public void run() {
		logger.info(getName() + " este deschisa");
		while (true) {
			if (!coada.isEmpty()) {
				Client c;
				c = coada.peek();
				numarTotalClienti++;
				timpMediuServire1 = timpMediuServire1 + c.timpServire;
				try {
					TimeUnit.SECONDS.sleep(c.timpServire);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info(
						"Clientul " + c.ID + " este servit la " + getName() + " pentru " + c.timpServire + " secunde");
				coada.remove(c);
				logger.info("Clientul " + c.ID + " a parasit coada");
				logger.error("La " + getName() + " sunt " + coada.size() + " clienti");
			}
		}
	}

	public int esteCasaGoala() {
		if (coada.size() == 0) {
			return 1;
		} else
			return 0;
	}

	public String toString() {
		String string = new String("");
		for (Client c : coada)
			string = string + c.toString();
		return string;
	}
}
