import javax.swing.event.ListDataEvent;
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

    Choice declareAtackers(List<Choice> choices, MTGGame game);

    Choice declareBlockers(List<Choice> choices, MTGGame game);

    boolean mulligan(List<Card> hand, List<Card> decklist);

}
