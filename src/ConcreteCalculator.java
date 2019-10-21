import java.util.ArrayList;
import java.util.HashMap;

import PropertyProvider.ConsolePropertyProvider;
import ShapeClassPackage.*;

public class ConcreteCalculator {
	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
	private ShapeFactory shapeFactory = new ShapeFactory();
	private ConsolePropertyProvider p;
	private String commands[] = {"add","remove","display"};
//	HashMap<String, Shape> shapeMap = new HashMap<>(); 
	
	public String addShapes(String shapeName) {

		if(shapeFactory.createShape(shapeName,"")==null)
			return "No shape created.";
		else {
			Shape shape = shapeFactory.createShape(shapeName, "-"+shapeList.size());
			p = new ConsolePropertyProvider(shape.getName());

			shape.setProperties(p);
			shapeList.add(shape);
			return "Successfully created shape.";
		}
	}

	public String command(String str) {
		int array[] = {1,2,3};
		for(int i =0; i < array.length;i++) {
			
		}
		String inputs[] = str.split(" ");
		
		if(inputs[0].equalsIgnoreCase(commands[0])&&inputs.length>1) {
			return addShapes(inputs[1]);
		}
		else if(inputs[0].equalsIgnoreCase(commands[1])&&inputs.length>1) {
			return removeShape(inputs[1]);
		}
		else if(inputs[0].equalsIgnoreCase(commands[2])) {
			return displayAllShapes();
		}
		else{
			return "Enter valid command followed by valid shape name if required.";
		}
	}

	public String size() {
		return ""+shapeList.size();
	}

	public String removeShape(String shapeName) {

		for(Shape shape : shapeList) {
			if(shape.getName().equalsIgnoreCase(shapeName)) {
				shapeList.remove(shape);
				return "Shape "+shape.getName()+" has been removed!";
			}
		}

		return "No such shape with name "+shapeName+" exists.";
	}

	public String getTotalVolume() {
		double totalVolume = 0.0;

		for(Shape x : shapeList) {
			totalVolume += x.volumeCalculation();
		}

		return String.format("%.2f", totalVolume);
	}

	public String getTotalCost() {
		double totalCost = 0.0;

		for(Shape shape : shapeList) {
			totalCost += shape.getCostOfShape()*shape.volumeCalculation();
		}

		return String.format("%.2f", totalCost);
	}

	public String displayAllShapes() {
		String str = "";
		double totalVolume = 0;
		double totalCost = 0;
		
		for(Shape shape : shapeList) {
			totalVolume += shape.volumeCalculation();
			totalCost += shape.getCostOfShape();
			str += shape.getName()+shape.getDimensions()+
					"\n   Volume for this shape: "+String.format("%.2f", shape.volumeCalculation())+
					"\n   Cost per cubic yard: "+String.format("%.2f", shape.getCost())+
					"\n   Cost for this shape: "+String.format("%.2f", shape.getCostOfShape())+"\n";
		}
		return str += "\nTOTAL VOLUME: "+String.format("%.2f", totalVolume)+"\nTOTAL COST: $"+String.format("%.2f", totalCost);
	}
}
