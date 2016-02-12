import java.awt.Point;

public class NodeStateAndPoint {

	private Point position;
	private NodeState state;
	
	public NodeStateAndPoint(NodeState state, Point position){
		this.position = position;
		this.state = state;
	}
	
	public Point getPoint(){
		return position;
	}
	
	public NodeState getState(){
		return state;
	}
	
}
