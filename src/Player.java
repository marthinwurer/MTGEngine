import java.util.ArrayList;


public class Player {

	private int life;
	
	
	// zones
	private ArrayList<Card> hand;
	private ArrayList<Card> library;
	private ArrayList<Card> graveyard;
	private ArrayList<Card> battlefield;
	private ArrayList<Card> exile;

	public Player() {
		life = 0;
		hand = new ArrayList<>();
		library = new ArrayList<>();
		graveyard = new ArrayList<>();
		battlefield = new ArrayList<>();
		exile = new ArrayList<>();
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public ArrayList<Card> getLibrary() {
		return library;
	}

	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}

	public ArrayList<Card> getBattlefield() {
		return battlefield;
	}

	public ArrayList<Card> getExile() {
		return exile;
	}

	
	

}
