import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static Direction keyDirection = Direction.none;
	
	public static void main(String[] args) {

		GridBuilder gridBuilder = new GridBuilder();
		Grid grid = new Grid(gridBuilder.getNewSmallBasicGrid(), gridBuilder);
		
		Player player = new Player(new Point(1,1));
		
		grid.addEnemy(new Ghost(new Point(4,3)));
		grid.addEnemy(new Ghost(new Point(4,4)));
		grid.addEnemy(new Ghost(new Point(4,5)));
		
		GridRenderer renderer = new GridRenderer(grid);
		
        JFrame window = new JFrame();
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(renderer);
        window.setVisible(true);
		window.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
		            keyDirection = Direction.right;
		    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
		            keyDirection = Direction.left;
		    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            keyDirection = Direction.up;
		    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            keyDirection = Direction.down;
		    }
			}
		});
        
		System.out.println("loaded");
		boolean run = true;
		int score = 0;
		long speed = 800;
		while (run) {
//			System.out.println("running");
			Point playerPoint = player.getCurrentPosition();
			System.out.println(playerPoint);
			NodeState state = grid.update(player.getNewPosition(keyDirection, new NodeOctet(grid.getGridLayout(), playerPoint.x, playerPoint.y)));
//			System.out.println(state);
			if(state.equals(NodeState.empty)){
				//Do nothing
			}else if(state.equals(NodeState.food)){
				score++;
			}else if(state.equals(NodeState.ghost)){
				run = false;
				window.repaint();
				continue;
			}
			window.repaint();

			sleep(speed/2);
			
			window.repaint();
			
			sleep(speed/2);
		}
		
		if(!run){
			System.out.println("END GAME");
			JOptionPane.showMessageDialog(window, "You lose! Your score is " + score);
//			JOptionPane.showMessageDialog(window, "End of game");
		}
		System.exit(0);
	}

	public static void sleep(long time){
		try{
			 Thread.sleep(time);
		}catch(InterruptedException ex){
			 System.out.println("thread broke");
		}
	}
}
