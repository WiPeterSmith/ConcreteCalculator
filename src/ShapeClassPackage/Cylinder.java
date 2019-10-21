package ShapeClassPackage;

import PropertyProvider.PropertyProvider;

public class Cylinder extends Shape{
	public Cylinder(String name) {
		super(name);
	}
	
	protected double height;
	protected double radius;

	@Override
	public double volumeCalculation() {
		double heightInFeet = this.height/12;
		double radiusInFeet = this.radius/12;
		return (Math.PI * heightInFeet * radiusInFeet * radiusInFeet)/27;
	}

	@Override
	public void setProperties(PropertyProvider p) {
		this.height = p.setProp("height","INCHES");
		this.radius = p.setProp("radius","INCHES");
		this.cost = p.setProp("cost", "DOLLARS");
	}

	@Override
	public String getDimensions() {
		return "\n   Height: "+String.format("%.2f",this.height)+
				"\n   Radius: "+String.format("%.2f",this.radius)+"\n";
	}

}
