/**
 * This class represents a basic, vanilla creature in Magic: the Gathering
 */
public class Creature {
	
	private int power; // the creature's power
	private int toughness; // the creature's toughness
	private int damage; // the amount of damage that has been marked on the creature
	private boolean tapped; // whether this creature is tapped or not

	public Creature(int power, int toughness) {
		this.power = power;
		this.toughness = toughness;
		this.damage = 0;
		this.tapped = false;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isTapped() {
		return tapped;
	}
	
	public void tap(){
		this.tapped = true;
	}
	
	public void untap(){
		this.tapped = false;
	}

	public void setTapped(boolean tapped) {
		this.tapped = tapped;
	}

}
