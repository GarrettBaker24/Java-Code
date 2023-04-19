package lecture;

public class Car 
{
	//instance variables
	private String make;
	private String model;
	private int milage;
	private int year;
	
	private double maintenanceMultiplier;
	
	
	//constructors
	//default constructor
	public Car()
	{
		make = "N/A";
		model = "N/A";
		milage = -1;
		year = -1;
		maintenanceMultiplier = 1.;
	}
	
	public Car(String make, String model, int year)
	{
		this.make = make;
		this.model = model;
		this.milage = 0;
		this.year = year;
		maintenanceMultiplier = 1.0;
	}
	
	//full constructor
	public Car(String make, String model, int milage, int year)
	{
		this.make = make;
		this.model = model;
		this.milage = milage;
		this.year = year;
		maintenanceMultiplier = 1.0;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMilage() {
		return milage;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake()
	{
		return make;
	}
	
	public void setMake(String make)
	{
		this.make = make;
	}
	
	public double getMaintenanceMultiplier()
	{
		return maintenanceMultiplier;
	}
	
	public void setMaintenanceMultiplier(double maintenanceMultiplier)
	{
		 this.maintenanceMultiplier = maintenanceMultiplier;
	}
	
	
	//Function that returns after how many miles I should get maintenance
	public int recommendedMaintenance()
	{
		int standard = 5000;
		return  (int)(standard * maintenanceMultiplier);
	}
	
	
	//@Override
	public String toString()
	{
		String str =  make + ", " + model + ", " + milage + ", " + year;
		return str;
		
	}
	
	
	
	
	

}
