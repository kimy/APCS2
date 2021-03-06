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
    public String name(){
	return "Kim,Yubin";
    }


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
	String ans = "";
	//build your knights tour here...
	for (int[] row : board) {
	    ans += "\n";
	    for (int n : row) {
		if (n < 100)
		    ans += " ";
		if (n < 10)
		    ans += " ";
		ans += n;
	    }
	    ans += "\n";
	}

	return hide + go(0,0) + ans + "\n" + show;
    }


    public KnightsTour(int size){
	board = new int[size][size];
	for(int i=0; i<board.length; i++){
	    for(int j=0; j<board[0].length; j++){
		board[i][j]=0;
	    }
	}			
    }
    
    public boolean solve(){
	return solve(0,0);				
    }

    public boolean solve(int startx, int starty){
	return solve(startx, starty, 1);

    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
	try{
	if(outofBounds(x) || outofBounds(y)){
	    return false;
	}

	if(board[x][y]== board.length * board.length -1){
	    return true;
	}
	if(board[x][y]>0){
	    return false;
	}
	if(board[x][y]<1){
	    board[x][y]=currentMoveNumber;
	}

	if(solve(x+2,y+1,currentMoveNumber+1) || solve(x+2,y-1,currentMoveNumber+1) || solve(x+1,y+2,currentMoveNumber+1) ||
	   solve(x-1,y+2,currentMoveNumber+1) || solve(x-2,y+1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1) ||
	   solve(x+1,y-2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1)){
	    return true;
	}
	board[x][y] = 0;
    }
	catch (Exception e){};
	return false;
       
    }

    public boolean outofBounds(int n){
	return n > board.length && n<0;
	    
    }

    public static void main(String[]args){
	KnightsTour k;
	k = new KnightsTour(Integer.parseInt(args[0]));
	k.solve();
	System.out.println(k);

    }


}