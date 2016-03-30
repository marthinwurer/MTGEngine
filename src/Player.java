import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Player {

	private int life;
	private int numMulligans;

	// zones
	private ArrayList<Card> hand;
	private LinkedList<Card> library;
	private ArrayList<Card> graveyard;
	private ArrayList<Card> battlefield;
	private ArrayList<Card> exile;

    private MoveChooser controller;

    private ArrayList<Card> decklist;

	public Player(LinkedList<Card> deck, int playerNum) {
		life = 0;
        numMulligans = 0;
		hand = new ArrayList<>();
		library = new LinkedList<>(deck);
		graveyard = new ArrayList<>();
		battlefield = new ArrayList<>();
		exile = new ArrayList<>();
        controller = new Expert();
        controller.init(this, playerNum);

        // deep copy the decklist
        decklist = new ArrayList<>(deck.size());
        for( Card card : deck){
            decklist.add( card.deepCopy());
        }
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

	public LinkedList<Card> getLibrary() {
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

    public void drawStartingHand(){
        drawToHandSize();
    }

    public int getNumMulligans(){
        return numMulligans;
    }

    /**
     * returns true if the player decides to mulligan
     * @return
     */
    public boolean mulligan(){
        boolean actuallyMulligan = controller.mulligan(hand, decklist);
        if( actuallyMulligan ) doMulligan();
        return actuallyMulligan;
    }

    private void doMulligan(){
        numMulligans--;
        for( Card card : hand){
            library.add(card);
        }
        Collections.shuffle(library);
        hand.clear();
        drawToHandSize();

    }

    private void drawToHandSize(){
        for( int ii = 0; ii < 7 - numMulligans; ii++ ){
            hand.add(library.pop());
        }
    }

	
	

}
