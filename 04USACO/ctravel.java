import java.util.*;
import java.io.*;

public class ctravel{

    private char [][] pasture;
    private int T, r1, c1, r2, c2;
    private int howMany;

    public void importFile(String fileName) throws FileNotFoundException{
	Scanner s = null;
	s = new Scanner(new BufferedReader(new FileReader(fileName)));
	pasture = new char [Integer.parseInt(s.next())][Integer.parseInt(s.next())];
	T = Integer.parseInt(s.next());
	for(int a = 0; a < pasture.length; a++){
	    String c = s.next();
	    for(int b = 0; b < pasture[0].length; b++){
		pasture[a][b] = c.charAt(b);
	
	    }
	}
	r1 = Integer.parseInt(s.next())-1;
	c1 = Integer.parseInt(s.next())-1;
	r2 = Integer.parseInt(s.next())-1;
	c2 = Integer.parseInt(s.next())-1;
	

    }
 
    public String toString(){ 
	String ans = "";
	for(int a = 0; a < pasture.length; a++){
	    for(int b = 0; b < pasture[0].length; b++){
		ans += "" + pasture[a][b];
	    }
	    ans += "\n";
	}
	return ans;
    }

    public int go(){
	return goH(r1, c1, 0);
    }

    public int goH(int startx, int starty, int newT){

	if(startx < 0 ||
	      startx >= pasture.length ||
	      starty < 0 ||
	   starty >= pasture[0].length){
	    return 0;
	}

	if(newT == T && (startx != r2 || starty != c2)){
	    return 0;
	}

	if(newT == T && (startx == r2 || starty == c2)){
	    return 1;
	}

	if(pasture[startx][starty] == '*'){
	    return 0;
	}
	
	if(goH(startx+1, starty, newT+1) 
	   +goH(startx, starty+1, newT+1)
	   +goH(startx-1, starty+1, newT+1)
	   +goH(startx, starty-1, newT+1) != 0){
	    return goH(startx+1, starty, newT+1) 
		+goH(startx, starty+1, newT+1)
		+goH(startx-1, starty+1, newT+1)
		+goH(startx, starty-1, newT+1);
	} 
	return goH(startx+1, starty, newT+1) 
	    +goH(startx, starty+1, newT+1)
	    +goH(startx-1, starty+1, newT+1)
	    +goH(startx, starty-1, newT+1);
    }


    public ctravel(String fileName) throws FileNotFoundException{
	importFile(fileName);
    }

    public static void main(String[]args)throws FileNotFoundException{
	ctravel A = new ctravel("ctravel.in");
	PrintWriter writer = new PrintWriter("ctravel.out");
	writer.println(A.go());
	writer.close();
    }
}