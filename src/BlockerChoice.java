/**
 * Created by benjamin on 4/6/16.
 */
public class BlockerChoice extends Choice{
    private Creature blocker;
    private Creature blocked;

    public BlockerChoice(Creature blocker, Creature blocked){
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public Creature getBlocker() {
        return blocker;
    }

    public Creature getBlocked() {
        return blocked;
    }
}
