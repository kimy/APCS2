import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = int[size][size];			
    }

    
    public void solve(){
	solve(0,0);				
    }

    public void solve(int startx, int starty){
	board[starty][startx]==1;

    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	
	if(solveDone){
	    return true;
	}
	

		

	return false;
    }

    public boolean solveDone(){
	for(int i=0;i<board.length;i++){
	    for(int j=0; i<board[0].length; j++){
		if(board[i][j]==0){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean move(int x, int y){
      
    }

}