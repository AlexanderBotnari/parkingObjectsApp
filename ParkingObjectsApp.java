
public class ParkingObjectsApp {

	public static void main(String[] args) {
        
		Parking object = new Parking();
		Car my_car = new Car("BMW", "BA-012");
        Car brother_car = new Car("Mercedes", "AV-777");
        object.parkCar(my_car ,"1A");
        object.parkCar(brother_car ,"1B");
        object.printMap();
        System.out.println(" The free places is : "+object.getFreePlaces());
	}
}
class Parking extends Car{
    private byte freePlaces; 
    private  Car place1A;
    private  Car place1B;
    private  Car place1C;
    private  Car place2A;
    private  Car place2B;
    private  Car place2C;
        ///an array
    Car [] [] mas = {{place1A,place2A},{place1B,place2B},
    {place1C,place2C}};
   
    //Constructor for freeplaces
    public Parking() {
    	this.freePlaces = 6;
    }
    public  void parkCar(Car c,String place) {
		place = place.toUpperCase();        ////use method java string toUpperCase() It returns the String
		 int x = caseName(place);       
	     int y = Character.getNumericValue(place.charAt(0)) - 1;//getNumericValue() method of character class 
	     if(c.getModel() != null && c.getId() != null) {        //returns the int value of the specified character
	          if(mas[x][y] == null) {                               
                mas[x][y] = c;
				printParking(c,place);
				freePlaces -= 1;	
			  }else {
				System.err.println("This place is occupied!");
			  }
	     }else{  	
			    System.err.println("Parking is not intended for such a model!");
		}
}
	public int caseName(String place) {
	    switch(place.charAt(1)) { ///method java string charAt()return char value       
			case 'A':
				return 0;
			case 'B':
				return 1;
			case 'C':
				return 2;
			default:
				return 3;
		}
	}
	public byte getFreePlaces() {
		return freePlaces;
	} 
	public void printMap() {   		
		System.out.println("---------------------------");
	
	for(int i = 0 ; i < mas.length; i++) {
		printModel(mas[i][0]);
		printModel(mas[i][1]);
		System.out.println("|");
		printId(mas[i][0]);
		printId(mas[i][1]);
		System.out.println("|");
		System.out.println("---------------------------");
		}
	}
    public void printParking(Car c, String y) {
	System.out.println("The " + c.getModel() + " is parked in the place " + y + " with ID : "+ c.getId());
    }
}
class Car{
    private String model;
    private String id;
    public Car() {}
	public Car(String model , String id) {
		setModel(model);
			setId(id);
	}
    public  void printModel() {
    	System.out.println(getModel());
}
    public void printModel(Car c) {
	  if(c != null) { 
		  System.out.printf("| %-10s ", c.getId());
	  }else{
		  System.out.printf("| %-10.0f ", 0f);  	
	}
}
    public void printId() {
		System.out.println(getId());
}
    public void printId(Car c){
	if(c != null) {
		System.out.printf("| %-10s ", c.getId());
	}else {
		System.out.printf("| %-10.0f ", 0f);
    }
}
    public void setModel(String model) {
	if(model.equals("BMW") || model.equals("Mercedes") || model.equals("Fiat")) {
		this.model = model;
    }else{
		System.err.println("Parking is not intended for such a model!");		
    }
}
    public void setId(String id) {
	this.id = id.toUpperCase();
}
    public String getModel() {
		return model;
}
    public String getId() {
		return id;
    }
} 
   
