import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 3/28/16.
 */
public class Expert implements MoveChooser {

    @Override
    public void init(Player toControl, int playerNum) {

    }

    @Override
    public Choice priority(List<Choice> choices, MTGGame game) {
        return null;
    }

    @Override
    public ArrayList<Creature> declareAtackers(List<Choice> choices, MTGGame game) {
        return null;
    }

    @Override
    public Choice declareBlockers(List<Choice> choices, MTGGame game) {
        return null;
    }
}
