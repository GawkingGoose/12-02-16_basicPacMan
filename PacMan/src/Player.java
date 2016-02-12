import java.awt.Point;

public class Player {

	private Point currentPosition;
	
	public Player(Point startingPoint){
		currentPosition = startingPoint;
	}
	
	public Point getNewPosition(Direction direction, NodeOctet octet){
		Point newPos = currentPosition;
		switch(direction){
			case up:
				newPos = new Point(currentPosition.x,currentPosition.y+1);
			case down:
				newPos = new Point(currentPosition.x,currentPosition.y-1);
			case right:
				newPos = new Point(currentPosition.x+1,currentPosition.y);
			case left:
				newPos = new Point(currentPosition.x-1,currentPosition.y);
		}
		//check direction against octect, 
		for (NodeStateAndPoint node : octet.getNodes()) {
			if(node.getPoint().equals(newPos)){
				if(node.getState() != NodeState.blocked){
					currentPosition = newPos;
					continue;
				}
			}
		}
		//if ok pass new position based on octet,
		//if not then return current position with no change
		return currentPosition;
	}
	
	public Point getCurrentPosition(){
		return currentPosition;
	}
	
}
