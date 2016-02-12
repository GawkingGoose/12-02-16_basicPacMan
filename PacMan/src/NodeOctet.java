import java.awt.Point;

public class NodeOctet {

	private NodeStateAndPoint[] nodes;
	
	public NodeOctet(NodeState[][] nodeLayout, int x, int y){
		nodes = new NodeStateAndPoint[8];
		nodes[0] = new NodeStateAndPoint(nodeLayout[x][y+1], new Point(x, y+1));//up
		nodes[1] = new NodeStateAndPoint(nodeLayout[x+1][y+1], new Point(x+1, y+1));//up right
		nodes[2] = new NodeStateAndPoint(nodeLayout[x+1][y], new Point(x+1, y));//right
		nodes[3] = new NodeStateAndPoint(nodeLayout[x+1][y-1], new Point(x+1, y-1));//down right
		nodes[4] = new NodeStateAndPoint(nodeLayout[x][y-1], new Point(x, y-1));//down
		nodes[5] = new NodeStateAndPoint(nodeLayout[x-1][y-1], new Point(x-1, y-1));//down left
		nodes[6] = new NodeStateAndPoint(nodeLayout[x-1][y], new Point(x-1, y));//left
		nodes[7] = new NodeStateAndPoint(nodeLayout[x-1][y+1], new Point(x-1, y+1));//up left
	}
	
	public NodeStateAndPoint[] getNodes(){
		return nodes;
	}
	
}
