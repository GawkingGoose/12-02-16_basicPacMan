import java.awt.Point;

public interface IEnemy {

	/**
	 * Everytime this method is called the enemies position should update
	 * @return the new position
	 */
	public Point getNewPosition(NodeOctet octet);
	
	public Point getCurrentPosition();
}
