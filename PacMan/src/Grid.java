import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grid {

	private NodeState[][] gridLayout;
	
	private Point player;
	private List<IEnemy> enemies;
	
	private int gridBoundsX;
	private int gridBoundsY;
	
	public Grid(NodeState[][] gridLayout){
		enemies = new ArrayList<IEnemy>();
		this.gridLayout = gridLayout;
		gridBoundsX = gridLayout[0].length;
		gridBoundsY = gridLayout[1].length;
	}
	
	/**
	 * This method runs once per frame
	 * It takes the player position and updates the enemies
	 * @param player
	 */
	public void update(Player player){
		
	}
	
	public void addEnemy(IEnemy enemy){
		enemies.add(enemy);
	}
	
	private boolean checkInsidegrid(Point point){
		try{
			getNodeState(point.x, point.y);
		} catch(IndexOutOfBoundsException ex){
			return false;
		}
		return true;
	}
	
	public NodeState[][] getGridLayout(){
		return gridLayout;
	}
	
	private void setNodeState(int x, int y, NodeState state){
		gridLayout[x][y] = state;
	}
	
	private NodeState getNodeState(int x, int y){
		return gridLayout[x][y];
	}
}
