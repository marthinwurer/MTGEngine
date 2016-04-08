import java.util.ArrayList;
import java.util.List;


public class MTGGame {
	
    protected Player player1; // player0
	protected Player player2; // player1

    protected int currentPlayer, priorityPlayer; // zero-indexed

    protected ArrayList<Card> stack;

    protected Phase currentPhase;

    protected ArrayList<AttackerInfo> attackers;

	public MTGGame(ArrayList<Card> deck1, ArrayList<Card> deck2) {
        currentPlayer = 0;
        priorityPlayer = 1;
        this.stack = new ArrayList<>();
        currentPhase = Phase.START_TURN;
        attackers = new ArrayList<>();
	}

    public int mainLoop(){
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

        while( !this.finished()){

            // start of phase stuff

            switch (this.currentPhase){
                case START_TURN:
                    // switch the current player
                    if( !firstTurn){
                        this.currentPlayer = getOpponent();
                    }
                    break;

                case DRAW:
                    if( !firstTurn){
                        getPlayer(this.currentPlayer).drawCard();
                    }
                    break;

                case DECLARE_ATTACKERS:
                    ArrayList<Choice> possibleAttackers = getPlayer(this.currentPlayer).getPossibleAttackers(this);

                    // no attackers
                    if (possibleAttackers.size() < 1){
                        break;
                    }


                    ArrayList<Creature> chosenAttackers = getPlayer(this.currentPlayer).getController().declareAtackers(possibleAttackers, this);
                    for( Creature attacker:chosenAttackers) {
                        attackers.add(new AttackerInfo(attacker, getOpponent()));
                    }

                    break;

                case DECLARE_BLOCKERS:




            }

            // regular priority
            for ( priorityPlayer = currentPlayer;
                  stack.size() > 0 || priorityPlayer == currentPlayer;
                  currentPlayer = getOpponent()){

                // get the possible choices for the current player.
                List<Choice> choices = getChoices(currentPlayer);
                // prompt the player to make a choice
                getPlayer(currentPlayer).getController().priority(choices, this);

                // execute the choice


            }

        }



        return 0;
    }

    private List<Choice> getChoices(int currentPlayer) {
        return new ArrayList<>();
    }

    private boolean finished() {
        return false;
    }

    private boolean canPlay( Card toCast, int player){
        Player currentPlayerObject = getPlayer(player);
        boolean sorceryspeed = (player == currentPlayer) && stack.size() == 0 && currentPhase.canCastSorcery();
        if( toCast instanceof Land && sorceryspeed){
           return true;
        }
        if( currentPlayerObject.getManaProducable() >= toCast.getCost()){
            if( sorceryspeed && toCast.getSpeed() == PlaySpeed.Sorcery){
                return true;
            }
            if( toCast.getSpeed() == PlaySpeed.Instant){
                return true;
            }
        }
        return false;
    }

    public Player getPlayer(int player){
        if( player == 0){
            return player1;
        }else{
            return player2;
        }
    }

    public int getOpponent(){
        return (currentPlayer + 1) % 2;
    }
}
