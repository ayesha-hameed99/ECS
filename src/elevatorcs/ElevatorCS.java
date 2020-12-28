/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorcs;

import java.util.Scanner;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author asima
 */
class calculateWeight{
    Scanner input=new Scanner(System.in);
    double weight;
    int i=0;
   
boolean Weight(int p){
double sum=0;
    for(int i=1; i<=p;i++){
System.out.println("Enter weight of "+i +" person");
weight=input.nextDouble();

    sum+=weight;
    }
if(sum<=600){
System.out.println("Elevator can start");
return true;
}else   
{   
Beep();
System.out.println("Overweight elevatror");
 Beep();
 return false;
}

}
 void Beep(){
     Toolkit.getDefaultToolkit().beep();}
}


 class Button {
    Boolean open;
    Boolean close;
    public  boolean open(){
        System.out.println("Successfully!The door is opened");
        return true;
    }
     public  boolean close(){
        System.out.println("Successfully!The door is closed");
                 return   true;           
    }
}
 class EmergencyCall {
    

    public EmergencyCall (){
        
    }
   
    public void Notify()
    {
       System.out.println("Please help ,Something went wrong");
    }
    
      public void call()
    {
         System.out.println("Connecting to  control room ...");
    }
}

class level{
    Scanner input=new Scanner(System.in);
    final int MaxPeople = 20;
	final int MaxFloors = 5;
	final int MinPeople = 1;
	final int MinFloor = 1;
	
	int currentFloor = 1;
	int destinationFloor = 0;
	int desiredFloor = 0;
	int NoOfPeople = 0;
	  ArrayList<Integer> listOfFloors;
   calculateWeight w=new calculateWeight();
	int[] destination_lists = new int[MaxFloors];
         int people;
    void includePerson(){
       
    System.out.println("Enter total number of people: ");
    people=input.nextInt();
    if(people>10 || people<0){
        System.out.println("Not more than 10 people are allowed");
    }
    else{
    System.out.println("Wait till your weight is calculated");
    w.Weight(people);}
    displayLevel();
    listOfFloors = new ArrayList<>();
     for(int a = 0; a < people; a ++) {
         
        
		 int floors=askPassengerFloor(a);
                 if(!listOfFloors.contains(floors)) listOfFloors.add(floors);
                            
			}
     initialize_elevator();
    }
    
    void displayLevel(){
        for(int i=1; i<=MaxFloors;i++){
    System.out.println("Level "+i);}
    }
    int askPassengerFloor(int n) {
		boolean isValidEntry = false;
		int floor=0;
		while(!isValidEntry) {
			System.out.println("Person No.: "+ (n+1) + " Enter your floor: ");
			floor = input.nextInt();
                       
			if(floor < MinFloor || floor > MaxFloors) {
				System.out.println("Error. You have entered out of range floor. Valid [1-5]");
			} else if(floor == currentFloor) {
				System.out.println("You are already in the " + currentFloor + "F.");
			} else {
				destination_lists[floor-1]++;
				isValidEntry = true;
			}
		}
		return floor;
	}
    void delay(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {}
	}
    void MoveUp(){
      
        { System.out.println(currentFloor++ +" Elevator is going up");
        delay(1000);}
       // System.out.println("Level "+level+" arrived");
         Beep();
      //   delay(600);
    }
    
     void MoveDown(){
    System.out.println(currentFloor-- +" Elevator is going down");
     //  LocalTime lt= LocalTime.now();
       // long millis=System.currentTimeMillis();
    //    System.out.println(floor);
        delay(1000);
     //   System.out.println("Level "+level+" arrived");
         Beep();
       //  delay(600);
    }
    void notify(int num){
    System.out.println("");
    }
    void Beep(){
     Toolkit.getDefaultToolkit().beep();}
    
    
    
    	int findShortest() {
        
		int shortest = Math.abs(currentFloor - listOfFloors.get(0));
		int id = 0;
		for(int a = 1; a < listOfFloors.size(); a ++) {
			if(shortest > Math.abs(currentFloor - listOfFloors.get(a))) {
				shortest = Math.abs(currentFloor - listOfFloors.get(a));
				id = a;
			}
		}
		shortest = listOfFloors.get(id);
		listOfFloors.set(id, 100);
		return shortest;
	}
        void initialize_elevator() {
		for(int a = 0; a < listOfFloors.size(); a ++) {
			int shortest = findShortest();
			System.out.println("Next destination: "+ shortest + "Floor");
                        System.out.println("Amount of People: " + destination_lists[shortest-1]);
			delay(1500);
			while(currentFloor < shortest) {
				MoveUp();
			}
			while(currentFloor > shortest) {
				MoveDown();
			}
                         System.out.println("Arrived at: "+currentFloor+" Floor");
			while(destination_lists[shortest-1] > 0) {
                           
				System.out.println( "Unloading person "+destination_lists[shortest-1]-- + " at " + currentFloor + " Floor");
				delay(1500);
			}
		}
		includePerson();
	}
}


/*interface user{
    void Beep();
    void MoveUp(int l);
    void MoveDown();
    void Weight();
    void displayLevel();
} */


public class ElevatorCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       // TODO code application logic here
            Scanner input= new Scanner(System.in);
      calculateWeight w=new calculateWeight();
      Button b=new Button();
      EmergencyCall EC=new EmergencyCall();
     level l=new level();
   
     b.open();  
     l.includePerson();
    l.delay(600);
   // if(w.Weight()){
        b.close();
        l.displayLevel();
        	//l.askPassengerFloor(w.people);
               // l.floorList(w.people);
             //   l.initialize_elevator();
			
     
    // w.Weight();
    // b.close();
     
  //  l.MoveDown(3);
    }
    }
    

