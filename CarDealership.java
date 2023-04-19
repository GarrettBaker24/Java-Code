package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class CarDealership 
{

	public static void main(String[] args) 
	{
		//System.out.println("Hello " + (1+1));
		
		
		
		
		
		
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		//Polymorphism
		ArrayList<Car> stock = new ArrayList<Car>();
		int totalProfit = 0;
		
		stock.add(new Truck("Ford", "F150", 100000, 2005, 265));
		stock.add(new Sedan("Chevy", "Malibu", 40000, 2019, true));
		stock.add(new Coup("Honda", "Fit", 193000, 2013, 42));
		stock.add(new Truck());
		
		int userChoice = menu(keyboard);
		
		while(userChoice != 4)
		{
			switch(userChoice)
			{
				case 1: 
					//add car to stock
					addCar(stock, keyboard);
					break;
				case 2:
					//sell a car from the stock
					totalProfit += sellCar(stock, keyboard);
					break;
				case 3:
					printStock(stock);
					break;
			}
			
			userChoice = menu(keyboard);
		}
		System.out.println("Thanks for using Car Dealership Tracker 1.0");
		System.out.println("You made: $" + totalProfit);
		//Keep track of my stock of cars (car info and cost)
		//1. Add cars to the stock
		//2. Sell cars (add to a bank account)
		//3. Display car info of the stock
			
	}
	
	//display menu and get user choice
	public static int menu(Scanner keyboard)
	{
		System.out.println("Car Dealership Tracker 1.0");
		System.out.println("1. Add a car to your stock.");
		System.out.println("2. Sell a car from your stock.");
		System.out.println("3. Display your stock information.");
		System.out.println("4. Exit");
		
		System.out.print("Menu choice: ");
		int userChoice = keyboard.nextInt();
		
		return userChoice;
		
	}
	
	//add a car to the stock
	public static void addCar(ArrayList<Car> stock, Scanner keyboard)
	{
		
		
		//Make the car
		System.out.print("Enter the make of the car: ");
		String make = keyboard.next();
		System.out.print("Enter the model of the car: ");
		String model = keyboard.next();
		System.out.print("Enter the year of the car: ");
		int year = keyboard.nextInt();
		System.out.print("Enter the milage of the car: ");
		int milage = keyboard.nextInt();
		
		
		System.out.println("1. Truck");
		System.out.println("2. Sedan");
		System.out.println("3. Coup");
		
		System.out.print("What kind of car is it? ");
		int choice = keyboard.nextInt();
		
		switch(choice)
		{
			case 1:
				System.out.println("Enter the torque of the truck: ");
				int torque = keyboard.nextInt();
				Truck newTruck = new Truck(make, model, milage, year, torque);
				stock.add(newTruck);
				break;
			case 2:
				System.out.println("Does your sudan have lots of legroom? ");
				boolean isLegroom = keyboard.nextBoolean();
				Sedan newSedan = new Sedan(make, model, milage, year, isLegroom);
				stock.add(newSedan);
				break;
			case 3: 
				System.out.println("Enter the miles per gallon of the coup: ");
				int mpg = keyboard.nextInt();
				Coup newCoup = new Coup(make, model, milage, year, mpg);
				stock.add(newCoup);
				break;
		}
		
		
		//Car newCar = new Car(make, model, milage, year);
		//stock.add(newCar);
		
		
	}
	//sell a car from the stock and return the profit
	public static int sellCar(ArrayList<Car> stock, Scanner keyboard)
	{
		//Give every car a number and print them
		for(int i = 0; i < stock.size(); i++)
		{
			Car currCar = stock.get(i);
			System.out.println((i+1) + " " + currCar.toString());
		}
		
		System.out.print("Which car is sold? ");
		int carNum = keyboard.nextInt();
		
		//Remove the car from the stock
		stock.remove(carNum-1);
		
		System.out.println("Enter the profit: ");
		int profit = keyboard.nextInt();
		
		
		
		return profit;
		
	}


	public static void printStock(ArrayList<Car> stock)
	{
		System.out.println("Current Stock:");
		for (Car tempCar: stock) 
		{
			System.out.println(tempCar);
			System.out.println(tempCar.recommendedMaintenance());
		}
		
		
	}
}
