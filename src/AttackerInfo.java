import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 4/6/16.
 */
public class AttackerInfo {
    private Creature creature;
    private int toAttack;
    private ArrayList<Creature> blockers;

    public AttackerInfo(Creature creature, int toAttack){
        this.creature = creature;
        this.toAttack = toAttack;
        this.blockers = new ArrayList<>();
    }

    public void addBlocker(Creature blocker){
        blockers.add(blocker);
    }

    public List<Creature> getBlockers(){
        return blockers;
    }

    private Creature getAttacker(){
        return creature;
    }

    private int getDefender(){
        return toAttack;
    }
}
