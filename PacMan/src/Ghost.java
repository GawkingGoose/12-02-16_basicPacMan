import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Ghost implements IEnemy {

	private Point currentPosition;
	
	public Ghost(Point startingPoint){
		currentPosition = startingPoint;
	}
	
	public Point getCurrentPosition(){
		return currentPosition;
	}
	
	@Override
	public Point getNewPosition(NodeOctet octet) {
		// Create a list of the reachable positions
		ArrayList<Point> points = new ArrayList<Point>();
		for (NodeStateAndPoint node : octet.getNodes()) {
			if(node.getState() != NodeState.blocked && node.getState() != NodeState.ghost){
				if(!checkIfDiagonal(node.getPoint()))
					points.add(node.getPoint());
			}
		}
		
		Random rand = new Random();
		if(points.size() > 0)
			currentPosition = points.get(rand.nextInt(points.size()));
		return currentPosition;
	}
	
	// Rubbish way of doing it but im tired
	private boolean checkIfDiagonal(Point point){
		if(point.getX() == currentPosition.getX()){
			return false;
		}
		if(point.getY() == currentPosition.getY()){
			return false;
		}
		return true;
	}
}
