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
		ArrayList<Point> points = new ArrayList<Point>();
		for (NodeStateAndPoint node : octet.getNodes()) {
			if(node.getState() != NodeState.blocked){
				points.add(node.getPoint());
			}
		}
		
		Random rand = new Random();
		currentPosition = points.get(rand.nextInt(points.size()));
		return currentPosition;
	}
}
