public class MazeRunner {
	Maze mazeToSolve;
	A5Stack<MazeLocation> path;
	FilePrinter fileWriter;
	
	public MazeRunner(Maze aMaze) {
		mazeToSolve = aMaze;
		path = new A5Stack<MazeLocation>();
		fileWriter = new FilePrinter();
	}
	
	/*
	 * Purpose: Determines whether there is a path from start to finish in this maze
	 * Parameters: MazeLocation start - starting coordinates of this maze
	 *			   MazeLocation finish - finish coordinates of this maze
	 * Returns: true if there is a path from start to finish
	 */
	public boolean solve(MazeLocation start, MazeLocation finish) {
		fileWriter.println("Searching maze from start: "+start+" to finish: "+finish);
		path.push(start);
		return findPath(start, finish);
	}
	
	/*
	 * Purpose: Recursively determines if there is a path from cur to finish
	 * Parameters: MazeLocation cur - current cordinates in this maze
	 *			   MazeLocation finish - goal coordinates of this maze
	 * Returns: true if there is a path from cur to finish
	 *
	 * NOTE: This method updates the Maze's mazeData array when locations
	 *       are visited to an 'o', and further updates locations to an 'x'
	 *       if it is determined they lead to dead ends. If the finish 
	 *       location is found, the Stack named path should contain all of 
	 *       loations visited from the start location to the finish. 
	 */
	
	private boolean findPath(MazeLocation cur, MazeLocation finish) {
		int row = cur.getRow();
		int col = cur.getCol();
		int boundsrow = mazeToSolve.getRows();
		int boundscol = mazeToSolve.getCols();

		if (cur.equals(finish)){
			return true;
		}

		mazeToSolve.setChar(row, col, 'o');
		fileWriter.println("\n"+mazeToSolve.toString());
			

		MazeLocation right = new MazeLocation(row, col+1);
		MazeLocation left = new MazeLocation(row, col-1);
		MazeLocation up = new MazeLocation(row-1, col);
		MazeLocation down = new MazeLocation(row+1, col);
		
		boolean goRight = goRightHelper(right, boundsrow, boundscol);
		boolean goLeft = goLeftHelper(left, boundsrow, boundscol);
		boolean goUp = goUpHelper(up, boundsrow, boundscol);
		boolean goDown = goDownHelper(down, boundsrow, boundscol);

		if (goRight == true){
			path.push(right);
			mazeToSolve.setChar(row, col+1, 'o');
			fileWriter.println("Found path to the right" + right +"\n"+mazeToSolve.toString());
			return findPath(right, finish);
		}
		else if (goLeft == true){
			path.push(left);
			mazeToSolve.setChar(row, col-1, 'o');
			fileWriter.println("Found path to the left" + left +"\n"+mazeToSolve.toString());
			return findPath(left, finish);
		}
		else if (goUp == true){
			path.push(up);
			mazeToSolve.setChar(row-1, col, 'o');
			fileWriter.println("Found path up" + up +"\n"+mazeToSolve.toString());
			return findPath(up, finish);
		}
		else if (goDown == true){
			path.push(down);
			mazeToSolve.setChar(row+1, col, 'o');
			fileWriter.println("Found path down" + down +"\n"+mazeToSolve.toString());
			return findPath(down, finish);
		}
		else if(goRight == false && goLeft == false && goUp == false && goDown == false){
			MazeLocation deadEnd = deadEndHelper(cur, goRight, goLeft, goUp, goDown);
			mazeToSolve.setChar(row, col, 'x');
			fileWriter.println("No path found" + deadEnd +"\n"+mazeToSolve.toString());
			path.pop();
			if (deadEnd.equals(cur)){
				return false;
			}
			return findPath(deadEnd, finish);

		}
		else{
			return false;
		}
		
		
		 
	}
	
	private boolean goRightHelper(MazeLocation cur, int boundr, int boundc){
		int row = cur.getRow();
		int col = cur.getCol();
		if ((row < boundr && row >= 0) && (col < boundc && col >= 0)){
			char test = mazeToSolve.getChar(row, col);
			if ((test == 'H' || test == 'x' || test == 'o')){
				return false;
			}
			else{
				return true;
			}
		}
		else if (col == boundc-1){
			return false;
		}
		return false;
		
	}
	
	private boolean goLeftHelper(MazeLocation cur, int boundr, int boundc){
		int row = cur.getRow();
		int col = cur.getCol();
		if ((row < boundr && row >= 0) && (col < boundc && col >= 0)){
			char test = mazeToSolve.getChar(row, col);
			if ((test == 'H' || test == 'x' || test == 'o')){
				return false;
			}
			else{
				return true;
			}
		}
		else if (col == boundc-1){
			return false;
		}
		return false;
		
	}
	
	private boolean goUpHelper(MazeLocation cur, int boundr, int boundc){
		int row = cur.getRow();
		int col = cur.getCol();
		if ((row < boundr && row >= 0) && (col < boundc && col >= 0)){
			char test = mazeToSolve.getChar(row, col);
			if ((test == 'H' || test == 'x' || test == 'o')){
				return false;
			}
			else{
				return true;
			}
		}
		else if (row == boundr-1){
			return false;
		}
		return false;
		
	}
	
	private boolean goDownHelper(MazeLocation cur, int boundr, int boundc){
		int row = cur.getRow();
		int col = cur.getCol();
		if ((row < boundr && row >= 0) && (col < boundc && col >= 0)){
			char test = mazeToSolve.getChar(row, col);
			if ((test == 'H' || test == 'x' || test == 'o')){
				return false;
			}
			else{
				return true;
			}
		}
		else if (row == boundr-1){
			return false;
		}
		return false;
	}

	private MazeLocation deadEndHelper(MazeLocation cur,  boolean right, boolean left, boolean up, boolean down){
		int row = cur.getRow();
		int col = cur.getCol();
		int boundr = mazeToSolve.getRows();
		int boundc = mazeToSolve.getCols();
		MazeLocation s = new MazeLocation(row, col);
		
		if ((row < boundr && row >= 0) && (col < boundc && col >= 0)){
			MazeLocation backright = new MazeLocation(row, col+1);
			MazeLocation backleft = new MazeLocation(row, col-1);
			MazeLocation backup = new MazeLocation(row-1, col);
			MazeLocation backdown = new MazeLocation(row+1, col);
			if (col+1 == boundc){
				return s;
			}
			
			if (col-1 == boundc){
				return s;
			}
			
			if (row+1 == boundr){
				return s;
			}
			
			if (row-1 == boundr){
				return s;
			}
			char reverser = mazeToSolve.getChar(row, col+1);
			char reversel = mazeToSolve.getChar(row, col-1);
			char reverseu = mazeToSolve.getChar(row-1, col);
			char reversed = mazeToSolve.getChar(row+1, col);

			if (reverser == 'o'){
				return backright;
			}
			else if (reversel == 'o'){
				return backleft;
			}
			else if (reverseu == 'o'){
				return backup;
			}
			else if (reversed == 'o'){
				return backdown;
			}
			
		}
		
		return cur;
	}

	/*
	 * Purpose: Creates a string of maze locations found in the stack 
	 * Parameters: None
	 * Returns: A String representation of maze locations
	 */
	public String getPathToSolution() {
		String details = "";
		while(!path.isEmpty()) {
			details = path.pop() + "\n" + details;
		}	
		return details;
	}
	
	/*
	 * Purpose: Print the results of the maze run. Outputs the locations 
	 *          visited on the path from start to finish if the maze is 
	 *          solvable, or that no path was found if it is not.
	 * Parameters: boolean - whether or not the maze was solved
	 * Returns void - nothing
	 */
	public void printResults(boolean solved) {
		if (solved) {
			fileWriter.println("\n*** Maze Solved ***");
			fileWriter.println(getPathToSolution());
		} else {
			fileWriter.println("\n--- No path to solution found ---");
		}
		fileWriter.close();
	}
}