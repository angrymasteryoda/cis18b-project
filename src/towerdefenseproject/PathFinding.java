package towerdefenseproject;

public class PathFinding {
	
	// TODO LIST - Add level folder and one test level to start work on creating solid blocks and enemy AI pathfinding
	
	public static int[] nodeListX = new int[1250];
	public static int[] nodeListY = new int[1250];
	public static int[] gridList = new int[1250];
	
	public static void GridList() {
		// Record which grid squares are open (0) and which are blocked for movement (1)
		for (int x = 0; x<1250;x++){
			gridList[x] = 0;
		}
	}
	
	public static void NodeList() {
		int counter = 0;
		for (int x = 0; x < 50; x++ ) {
			for ( int y = 0; y < 25; y++ ) {
				nodeListX[counter] = ( ( Screen.windowW - ( Screen.gridW * 55 ) ) / 2 + ( x * Screen.gridW )) + (Screen.gridW/2) - 1;
				nodeListY[counter] = ( ( Screen.windowH - Screen.revertBorder ) - ( Screen.gridW * 25 ) ) / 2 + ( y * Screen.gridW ) + (Screen.gridW/2) - 1;
				counter++;
			}
		}
	}
	
	public static int GridCheck(int num) {
		if (gridList[num]==0){
			return 1;	// Space is free
		} else {
			return 0;	// Space is blocked
		}
	}
	/* Print out (x,y) of the current path node list
	for (int x = 0; x<1250;x++){
			System.out.println("("+PathFinding.nodeListX[x]+","+PathFinding.nodeListY[x]+")");
		}
	*/
}