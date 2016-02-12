import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Grid {

	private NodeState[][] startingGridLayout;
	private NodeState[][] gridLayout;
	
	private List<IEnemy> enemies;
	
	private GridBuilder gridBuilder;
	
	public Grid(NodeState[][] gridLayout, GridBuilder gridBuilder){
		enemies = new ArrayList<IEnemy>();
		this.startingGridLayout = gridLayout;
		this.gridLayout = startingGridLayout;
		this.gridBuilder = gridBuilder;
	}
	
	/**
	 * This method runs once per frame
	 * It takes the player position and updates the enemies
	 * @param player
	 * @return the state that the player landed on
	 */
	public NodeState update(Player player){
		resetGridNodes();
		setNodeState(player.getCurrentPosition(), NodeState.player);
		for (IEnemy enemy : enemies) {
			if(enemy.getCurrentPosition().equals(player.getCurrentPosition())){
				return NodeState.ghost;
			}
			if(enemy.getNewPosition(new NodeOctet(gridLayout, enemy.getCurrentPosition().x, enemy.getCurrentPosition().y)).equals(player.getCurrentPosition())){
				return NodeState.ghost;
			}
			setNodeState(enemy.getCurrentPosition(), NodeState.ghost);
		}
		
		return getNodeState(player.getCurrentPosition());
	}
	
	private void resetGridNodes(){
//		gridLayout = startingGridLayout;
		gridLayout = gridBuilder.getNewSmallBasicGrid();
	}
	
	public void addEnemy(IEnemy enemy){
		enemies.add(enemy);
	}
	
	private boolean checkInsidegrid(Point point){
		try{
			getNodeState(point);
		} catch(IndexOutOfBoundsException ex){
			return false;
		}
		return true;
	}
	
	public NodeState[][] getGridLayout(){
		return gridLayout;
	}
	
	private void setNodeState(Point position, NodeState state){
		gridLayout[position.x][position.y] = state;
	}
	
	private NodeState getNodeState(Point position){
		return gridLayout[position.x][position.y];
	}
}
