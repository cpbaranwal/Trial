package designProblems.elevatorDesign;

import java.util.*;



/** Class Floor  **/
public class Floor
{
public boolean upPressed,downPressed;
private int floorNum;
private Elevator elevatorCalledForUp;
private Elevator elevatorCalledForDown;
public List<Elevator> elevList;

public Floor(int i,List<Elevator> elv)
{
 floorNum=i;
 elevList=elv;
elevatorCalledForUp=null;
elevatorCalledForDown=null;
}

public void pressUp()
{
upPressed=true;
//callLift();
callLiftListForUp();
}

public void pressDown()
{
downPressed=true;
//callLift();
callLiftListForDown();

}
private Elevator getMovingElvatorToBeConsideredForUp(List<Elevator> elevList)
{  // returning only that MOVING elevator which is at floors lower than current floor at nearest distance and moving up......elsereturning null
	
	int i=elevList.size();
	while(elevList.get(i).currentFloor>this.floorNum)
		{  i--;  }
	for(;i>=0;i--)
	{   if( elevList.get(i).movingDir.equals("UP"))
		return elevList.get(i);   
	}
	
	
	return null;
}

private Elevator getStationaryElvatorToBeConsideredForBothUpAndDown(List<Elevator> elevList)
{  // returning only that STATIONARY elevator which is nearest to current floor in both directions of current floor
	// this function will be common for finding stationary elevator for both in cases of moving UP or DOWN
	
	int i=elevList.size();
	while(elevList.get(i).currentFloor>this.floorNum)
		{  i--;  }
	int low=i;
	int high=i+1;
	while(low>=0 || high<=Elevator.MAX_NO_OF_FLOORS)
	{
		if(elevList.get(low).movingDir.equals("Stationary"))
			{return elevList.get(i);}
		low--;
		if(elevList.get(high).movingDir.equals("Stationary"))
		{return elevList.get(high);}
		high++;
	}
		
	return null;
}

public void callLiftListForUp()
{    
	Collections.sort(elevList);  //sorting elevators in order of their currentFloor number
	
	Elevator movingUpElevator=getMovingElvatorToBeConsideredForUp(elevList);  // getting only that Elevator which is at nearest floors lower than current floor and moving up
	   if(movingUpElevator!=null) 
        {    elevatorCalledForUp=movingUpElevator;
            elevatorCalledForUp.floorListToServe.add(this);
            return;
        }
    
    
    // logic when none of the elevator is moving in desired  direction,then look for a stationary elevator
    Elevator stationaryElevator=getStationaryElvatorToBeConsideredForBothUpAndDown(elevList); // returning only that STATIONARY elevator which is nearest to current floor in both directions of current floor
    if(stationaryElevator!=null)
    {
        if(stationaryElevator.currentFloor<floorNum)
            {  stationaryElevator.movingDir="Up";
               elevatorCalledForUp=stationaryElevator;
                       elevatorCalledForUp.floorListToServe.add(this);
                  return;
            }
           else
            {   stationaryElevator.movingDir="Down";
               elevatorCalledForUp=stationaryElevator;
                       elevatorCalledForUp.floorListToServe.add(this);
                  return;
            }
        
    }
    //  logic for the condition when all the elevators are running and thats too in opposite direction,we will have to wait till one lift becomes stationary and     

//again call this function recursively till it returns a favourable result; we can use some delay also before calling this function again.
    callLiftListForUp();


}


/*
private boolean checkElevatorForUp(Elevator elev)
{
    if(elev.movingDir.equals("Stationary") && elev.currentFloor==floorNum)
    { //open door
        return true;
    }
    if(elev.currentFloor<floorNum && elev.movingDir=="UP")
        {  return true;
        }
    return false;

}*/

//similar logic for elevatorCalledForDown as above two methods
public void callLiftListForDown()
{
	// logic as vice versa of callLiftListForUp
}

/*private void callLift(Elevator elevator)
{
if(elevator.movingDir.equals("Stationary"))
{
if(floorNum==elevator.currentFloor)
{//open door
}
else if(floorNum<elevator.currentFloor)
{elevator.moveDown();}
else
{elevator.moveUp();}
}
}*/

public int getFloorNum()
{ return floorNum;
}

}



