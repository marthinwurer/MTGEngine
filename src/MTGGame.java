import java.util.ArrayList;


public class MTGGame {
	
    protected Player player1;
	protected Player player2;

    protected int currentPlayer;

    protected ArrayList<Card> stack;

	public MTGGame(ArrayList<Card> deck1, ArrayList<Card> deck2) {
        currentPlayer = 1;
        this.stack = new ArrayList<>();
	}

    private int mainLoop(){
        player1.drawStartingHand();
        player2.drawStartingHand();

        boolean done1 = true, done2 = true; // booleans for whether the given player is finished mulling.
        // do mulligan logic. mull until both players are done.
        while(done1 || done2){
            if(done1){
                done1 = player1.mulligan();
            }
            if(done2){
                done2 = player2.mulligan();
            }
        }

        boolean firstTurn = true;

        // main game loop



        return 0;
    }

    public Player getPlayer(int player){
        if( player == 1){
            return player1;
        }else{
            return player2;
        }
    }

}
