import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Card {

    public static final Card hiddenCard = new Card("Hidden", 0);

	protected String name;
	protected final int cost;
    protected final UUID id;

    protected boolean summoningSick = true;

    protected final ArrayList<ActivatedAbility> abilities = new ArrayList<>();

	public Card(String name, int cost) {
		this.name = name;
        this.cost = cost;
        id = UUID.randomUUID();
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public boolean isSummoningSick() {
        return summoningSick;
    }

    public void startOfOwnerTurn(){
        this.summoningSick = false;
    }

    public Card deepCopy(){
        return new Card(this.name, this.cost);
    }


    public List<ManaAbility> getManaAbilities(){
        List<ManaAbility> toReturn = new LinkedList<>();
        for(ActivatedAbility ability :  abilities ){
            if (ability instanceof ManaAbility){
                toReturn.add((ManaAbility) ability);
            }
        }
        return toReturn;
    }

    public PlaySpeed getSpeed(){
        return PlaySpeed.Sorcery;
    }
}
