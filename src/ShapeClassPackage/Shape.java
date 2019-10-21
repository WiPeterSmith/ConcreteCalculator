package ShapeClassPackage;
import PropertyProvider.PropertyProvider;

public abstract class Shape {
	protected double cost;
	private final String name;
	
	public Shape(String name) {
		this.name = name;
	}

	public double getCost() {
		return this.cost;
	}
	
	public double getCostOfShape() {
		return this.cost * volumeCalculation();
	}
	public String setCost(PropertyProvider p) {
		this.cost = p.setProp("cost", "DOLLARS per CUBIC YARD"); 
		return "New cost is "+this.cost;
	}
	public String getName() {
		return this.name;
	}
	
	public abstract double volumeCalculation();
	public abstract void setProperties(PropertyProvider p);
	public abstract String getDimensions();
}
