package ShapeClassPackage;

import PropertyProvider.PropertyProvider;

public class EmptyShape extends Shape{

	public EmptyShape(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double volumeCalculation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setProperties(PropertyProvider p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDimensions() {
		// TODO Auto-generated method stub
		return null;
	}

}
