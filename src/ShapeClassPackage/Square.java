package ShapeClassPackage;

import PropertyProvider.PropertyProvider;

public class Square extends Shape{

	public Square(String name) {
		super(name);
	}

	private double sideLength;
	private double height;
	
	@Override
	public double volumeCalculation() {
		return ((this.height/12)*this.sideLength*this.sideLength)/27;
	}

	@Override
	public void setProperties(PropertyProvider p) {
		this.height = p.setProp("height", "INCHES");
		this.sideLength = p.setProp("side length","FEET");
		this.cost = p.setProp("cost", "DOLLARS");
	}

	@Override
	public String getDimensions() {
		return "\n   SideLength: "+String.format("%.2f",this.sideLength)+
			   "\n   Height: "+String.format("%.2f", this.height)+"\n";
	}

}
