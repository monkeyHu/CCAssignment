package ch8;
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution02 {
	    static int L,C;//store the row and column of the map
	    static long [][] map;//store the grid of map
	    static long [][] steps;//store the steps of reaching each grid
	    static int MOD = 1000000007;
	    static class Position{
	        int x,y;
	        Position(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
	    
	    static LinkedList<Position> q = new LinkedList<Position>();//store visited grid
	   
	    static void check(int x, int y, long lastStep, long lastCount){
	        if(x < 0 || x >= L) return;//Array Index out of boundary
	        if(y < 0 || y >= C) return;//Array Index out of boundary
	        
	        if(map[x][y] == -2) return;//No way here
	        
	         if(map[x][y] > 0){
	             if(lastStep + 1 == steps[x][y]){//If visited and has one step to go, then add the count to it
	                 map[x][y] += lastCount%MOD;
	           }
	         }
	        if(map[x][y] == -1){ //Hasn't been visited
	            q.add(new Position(x,y));//Add to the list
	            map[x][y] = lastCount%MOD;
	            steps[x][y] = lastStep + 1;
	        }   
	    }
	    
	    static void findPath(){
	        q.add(new Position(0,0));//Add the (0,0) position to the list
	        map[0][0] = 1;
	        steps[0][0] = 0;
	        while(q.size() != 0 ){//BFS
	            Position temp = q.poll();
	            int x = temp.x;
	            int y = temp.y;
	            if((x == L-1) && (y == C -1))//if reached the most right bottom position and all its counts has been added 
	                return;
	            long lastStep = steps[x][y];
	            long lastCount = map[x][y];
	            //Check left,right,down,up
	            check(x-1,y,lastStep,lastCount);
	            check(x+1,y,lastStep,lastCount);
	            check(x,y-1,lastStep,lastCount);
	            check(x,y+1,lastStep,lastCount);
	        }
	        
	    }
	    public static void main(String[] args) throws IOException{
	       /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        Scanner in = new Scanner(System.in);
	        String[] split = in.nextLine().split(" ");
	        L = Integer.parseInt(split[0]);
	        C = Integer.parseInt(split[1]);
	    
	        map = new long[L][C];
	        steps = new long[L][C];
	    
	        for(int i = 0;i < L;i++){
	            String line = in.nextLine();
	            for(int j = 0;j<line.length();j++){
	                if(line.charAt(j)=='o'){
	                    map[i][j] = -1;
	                }
	                else{
	                    map[i][j] = -2;
	                }
	                steps[i][j] = -1; 
	            }
	        }
	        in.close();
	        findPath();
	    
	        if(map[L-1][C-1] < 0)  //if there is no way 
	           map[L-1][C-1] = 0;
	        System.out.println(map[L-1][C-1]%MOD);
	        System.out.println(steps[L-1][C-1]);
	    }
}

