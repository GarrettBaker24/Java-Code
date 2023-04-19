package lecture;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Zoo 
{
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		Animal rhino = new Mammal("Rhino", 4, false, true, true);
		Animal gecko = new Reptile("Geico", 4, true, false);
	
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		
		animalList.add(rhino);
		animalList.add(gecko);
		
		int userChoice;
		
		//Run the program until user chooses to exit
		do
		{
			userChoice = menuChoice(keyboard);
			
			switch(userChoice)
			{
				case 1:
					addAnimal(keyboard, animalList);
					break;
				case 2:
					printAnimalList(animalList);
					break;
			
			
			}
			
			
			
			
		}
		while(userChoice != 3);
		
		
		

	}
	
	public static void addAnimal(Scanner keyboard, ArrayList<Animal> animalList)
	{
		System.out.println("1. Mammal");
		System.out.println("2. Reptile");
		System.out.print("Which kind of animal? ");
		int animalType = keyboard.nextInt();
		
		if(animalType == 1)
		{
			System.out.print("Enter the name of the animal: ");
			String name = keyboard.next();
			System.out.print("Enter the number of legs: ");
			int numLegs = keyboard.nextInt();
			System.out.print("Do they eat meat: ");
			boolean eatsMeat = keyboard.nextBoolean();
			System.out.print("Do they have fur: ");
			boolean hasFur = keyboard.nextBoolean();
			System.out.print("Are they born with teeth: ");
			boolean bornTeethers = keyboard.nextBoolean();
			
			
			animalList.add(new Mammal(name, numLegs, hasFur, eatsMeat, bornTeethers));
		}
		else
		{
			System.out.print("Enter the name of the animal: ");
			String name = keyboard.next();
			System.out.print("Enter the number of legs: ");
			int numLegs = keyboard.nextInt();
			System.out.print("Do they eat meat: ");
			boolean eatsMeat = keyboard.nextBoolean();

			System.out.print("Are they posionous: ");
			boolean posionous = keyboard.nextBoolean();
			
			
			animalList.add(new Reptile(name, numLegs, eatsMeat,  posionous));
		
		}
		
	}
	
	
	

	public static int menuChoice(Scanner keyboard)
	{
		//1. Add animal
		//2. Display animals
		//3. Exit
		
		int userChoice = 0;
		
		while((userChoice < 1 || userChoice > 3)) //while user choice is not valid  // while user choice is ! (userChoice >= 1 && userChoice <= 3) 
		{
			System.out.println("Menu");
			System.out.println("1. Add Animal");
			System.out.println("2. Display Animals");
			System.out.println("3. Exit");
			System.out.print("Enter a choice: ");
			
			
			try
			{
				userChoice = keyboard.nextInt();
			}
			catch(InputMismatchException e)
			{
				keyboard.next();
				userChoice = 0;
			}
		
		
		
		
		
		}
		
		
		return userChoice;
		
	}
	
	
	
	public static void printAnimalList(ArrayList<Animal> animalList)
	{
		for(Animal thisAnimal: animalList)
		{
			System.out.println(thisAnimal);
		}
		
		
	}

}
