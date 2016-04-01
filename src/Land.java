/**
 * Created by benjamin on 3/31/16.
 */
public class Land extends Card{

    public Land(){
        super("Land", 0);
        this.abilities.add(ManaAbility.getInstance());
        this.summoningSick = false;
    }
}
