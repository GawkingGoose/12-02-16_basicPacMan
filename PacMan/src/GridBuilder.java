
public class GridBuilder {

	public NodeState[][] getNewSmallBasicGrid(){
		return new NodeState[][] {
			{NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.blocked,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.blocked,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.blocked,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.blocked},
			{NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked,NodeState.blocked},
		};
	}
	
	public NodeState[][] getNewOpenGrid(){
		return new NodeState[][] {
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
			{NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty,NodeState.empty},
		};
	}
	
}
