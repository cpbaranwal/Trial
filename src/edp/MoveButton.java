package edp;



public class MoveButton implements Button
{
Elevator elv;
Floor floor;

public MoveButton(Elevator elv, Floor floor)
{
this.elv=elv;
this.floor=floor;
}

public void pressButton()
{
if(this.floor.getFloorNum()==elv.currentFloor  &&  elv.movingDir.equals("Stationary"))
{//open door

}
else 
{
this.elv.floorListToServe.add(this.floor);
//this.floor.pressDown();
}
}

}