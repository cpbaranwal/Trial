package designProblems.elevatorDesign;

import java.util.*;



public class Elevator implements Comparable<Elevator>   //for sorting on basis of current floor to retrieve nearest elevator when request is made from a floor
{
int weight;  // i am preferring weight instead of number of persons, and MAX_WEIGHT= 8*AVG_WEIGHT_PER_PERSON
String movingDir;  // can be {"Stationary","Down","Up","UnderMaintenance"}
int currentFloor;
Floor[] floors;
Button[] buttons;
private int MAX_WEIGHT;

List<Floor> floorListToServe;

public static int AVG_WEIGHT_PER_PERSON=65;
public static int MAX_NO_OF_FLOORS=10;

public  Elevator(int currFloor,int maxNoOfPersons,Floor[] floors)
{
 this.currentFloor=currFloor;
 this.MAX_WEIGHT= maxNoOfPersons*AVG_WEIGHT_PER_PERSON;
 int noOfFloors= floors.length;
buttons= new Button[noOfFloors+1];
 for(int i=0;i<noOfFloors;i++)
  {
    floors[i].elevList.add(this);
    buttons[i]=new MoveButton(this,floors[i]);
   }
 buttons[noOfFloors]= new EmergencyButton();
movingDir="Stationary";
floorListToServe=new ArrayList<Floor>();
}


public void moveDown()
{
if(currentFloor==0)
//stop the elvator

// elevator starts moving down; while passing each floor,it updates value of currentFloor and checks as below:
if(floors[currentFloor].downPressed==true  && floorListToServe.contains(floors[currentFloor]))
{  floorListToServe.remove(floors[currentFloor]);
//open door; update weight of elevator before closing

if(weight>MAX_WEIGHT)
{ // alarm
}
	else
	{		
//start moving down
	}
}
}

public void moveUp()
{
   //same logic as above method moveUp() but in the opposite sense
}



public int compareTo(Elevator o) {   // sorting in increasing order of value of CurrentFloor
	if(this.currentFloor<o.currentFloor)
		return -1;
	else if(this.currentFloor>o.currentFloor)
		return 1;
	
	return 0;
}

}