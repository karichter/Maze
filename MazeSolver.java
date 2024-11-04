/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		wl.add(maze.start);
		maze.start.visit();
		Square neighbor;
		while(wl.isEmpty() == false) {
			Square current = wl.remove();
			current.visit();
			if(current.equals(maze.finish)) {
				return current;
			}
			else {
				//North
				if(availableNeighbor(maze.contents, current,-1,0) == true) {
					neighbor = maze.contents[current.getRow()-1][current.getCol()];
					neighbor.visit();
					neighbor.setPrevious(current);
					wl.add(neighbor);
				}
				//South
				if(availableNeighbor(maze.contents, current,1,0) == true) {
					neighbor = maze.contents[current.getRow()+1][current.getCol()];
					neighbor.visit();
					neighbor.setPrevious(current);
					wl.add(neighbor);
				}
				//East
				if(availableNeighbor(maze.contents, current,0,1) == true) {
					neighbor = maze.contents[current.getRow()][current.getCol()+1];
					neighbor.visit();
					neighbor.setPrevious(current);
					wl.add(neighbor);
				}
				//West
				if(availableNeighbor(maze.contents, current,0,-1) == true) {
					neighbor = maze.contents[current.getRow()][current.getCol()-1];
					neighbor.visit();
					neighbor.setPrevious(current);
					wl.add(neighbor);
				}
			}
		}
	return null;
	}

	public static boolean availableNeighbor(Square[][] contents, Square s, int rowOffset, int colOffset) {
		//return true if location of s, offset by rowoffset and coloffset is in bounds and not a wall, false otherwise
		int newRow = s.getRow() + rowOffset;
		int newCol = s.getCol() + colOffset;
		if((newRow < contents.length) && (newRow >= 0) && (newCol < contents[0].length) && 
		(newCol >= 0) && (contents[newRow][newCol].getIsWall() == false) && (contents[newRow][newCol].isVisited() == false)) {
			return true;
		}
		return false;
	}
}
