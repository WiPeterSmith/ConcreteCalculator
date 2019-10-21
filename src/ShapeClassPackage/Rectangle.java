package ShapeClassPackage;

import PropertyProvider.PropertyProvider;

public class Rectangle extends Shape{
	public Rectangle(String name) {
		super(name);
	}

	private double height, width, length;

	@Override
	public double volumeCalculation() {
		return (this.height * this.width * this.length)/27;
	}

	@Override
	public void setProperties(PropertyProvider p) {
		this.height = p.setProp("height","INCHES")/12;
		this.width = p.setProp("width","FEET");
		this.length = p.setProp("length","FEET");
		this.cost = p.setProp("cost", "DOLLARS");
	}

	@Override
	public String getDimensions() {
		return "\n   Height: "+String.format("%.2f",this.height)+"\n   Width: "+String.format("%.2f",this.width)+
				"\n   Length: "+String.format("%.2f",this.length)+"\n";
	}

}
