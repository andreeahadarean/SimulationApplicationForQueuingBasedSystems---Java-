package Client;

public class Client {

	public int ID; 
	public int timpServire; 

	public Client(int ID,int timpServire) {
		this.ID = ID; 
		this.timpServire = timpServire; 
	}
	
	public String toString() {
		return 	"\u263A" + " " + ID + "[" + timpServire + "] "; 
	}

}
