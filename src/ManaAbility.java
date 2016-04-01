/**
 * Created by benjamin on 3/31/16.
 */
public class ManaAbility extends ActivatedAbility{
    private static ManaAbility instance;
    private int manaProduced = 1;

    public int getManaProduced() {
        return manaProduced;
    }

    public static ManaAbility getInstance(){
        if( instance == null){
            instance = new ManaAbility();
        }
        return instance;
    }
}
