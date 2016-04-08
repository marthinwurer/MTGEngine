import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 3/24/16.
 */
public interface MoveChooser {

    /**
     * Initialize the Move choser with the given player and player number
     * @param toControl The player object to Control.
     * @param playerNum The player number associated with the player to control.
     */
    void init(Player toControl, int playerNum);

    Choice priority(List<Choice> choices, MTGGame game);

    ArrayList<Creature> declareAtackers(List<Choice> choices, MTGGame game);

    ArrayList<BlockerChoice> declareBlockers(List<Choice> choices, MTGGame game);

    boolean mulligan(List<Card> hand, List<Card> decklist);

    Choice payMana(List<Choice> manaAbilities, int leftToPlay, int paid, MTGGame game);

}
