package assignment;

public class Icecream extends DessertItem {
	double cost;

	public Icecream() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Icecream(String name) {
		super(name);
		this.cost=100;
	}
	
	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return this.cost;
	}

}
