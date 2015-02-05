import java.util.*;

public class Recursion{

    public String name(){
	return "Kim,Yubin";
    }

    public static int fact(int n){
	if( n < 0){
	    throw new IllegalArgumentException();
	}
	if(n==0 || n==1){
	    return 1;
	}else{
	    return n * fact(n-1);
	}
    }

    public static void main(String[] args){
	System.out.println(fact(0));
	System.out.println(fact(1));
	System.out.println(fact(10));
	System.out.println(fact(23));
    }







}