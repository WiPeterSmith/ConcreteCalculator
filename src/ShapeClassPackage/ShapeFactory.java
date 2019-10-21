package ShapeClassPackage;

public class ShapeFactory {
	public Shape createShape(String shapeType, String name) {
		if(shapeType == null)
			return null;
		
		if(shapeType.equalsIgnoreCase("rectangle"))
			return new Rectangle(shapeType.toUpperCase()+name);
		else if(shapeType.equalsIgnoreCase("cylinder"))
			return new Cylinder(shapeType.toUpperCase()+name);
		else if(shapeType.equalsIgnoreCase("square"))
			return new Square(shapeType.toUpperCase()+name);
		
		return null;
	}
}
