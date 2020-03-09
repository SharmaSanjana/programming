package com.dfs;

public class Islands {

	static final int ROW=5,COL=5;
	
	//row and col should be in range and of value is 1 must not be visited --then safe
	boolean isSafe(int M[][],int row, int col, boolean visited[][]) {
		return (row>=0)&&(row<ROW)&&(col>=0)&&(col<COL)&&(M[row][col]==1 && !visited[row][col]);
	}
	
	void DFS(int M[][],int row, int col, boolean visited[][]) {
		//row and col numbers of 8 neighbors of given cell
		int rowNbr[] =  new int[] {-1, -1, -1,  0, 1 ,1  ,1   ,0};
		int colNbr[] =  new int[] {-1,  0,   1, 1, 1, 0, -1, -1}; 
		
		visited[row][col] = true;
		
		//recur for all connected neighbors
		for(int k=0;k<8;k++) {
			if(isSafe(M,row+rowNbr[k],col+colNbr[k],visited))
				DFS(M,row+rowNbr[k],col+colNbr[k],visited);
		}
	}
	private int countIslands(int[][] M) {
		int count = 0;
		boolean visited[][] = new boolean[ROW][COL];
		for(int i =0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(M[i][j]==1 && !visited[i][j]) {
					DFS(M,i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int M[][] = new int[][] {
									{1,1,0,0,0},
									{0,1,0,0,1},
									{1,0,0,1,1},
									{0,0,0,0,0},
									{1,0,1,0,1}
								};
		Islands isl = new Islands();
		int c= isl.countIslands(M);
		System.out.println("count is "+c);

	}

	

}
