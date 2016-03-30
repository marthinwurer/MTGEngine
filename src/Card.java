import java.util.UUID;

public class Card {

    public static final Card hiddenCard = new Card("Hidden", 0);

	protected String name;
	protected final int cost;
    protected final UUID id;

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

    public Card deepCopy(){
        return new Card(this.name, this.cost);
    }
}
