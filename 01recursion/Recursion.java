import java.util.*;

public class Recursion{
   public static  double guess = 1;


    public String name(){
	return "Kim,Yubin";
    }

    public static boolean outOfRange(int n){
	if(n<0){
	    return true;
	}else{
	    return false;
	}
    }

    public static int fact(int n){
	if(outOfRange(n)){
	    throw new IllegalArgumentException();
	}
	if(n==0 || n==1){
	    return 1;
	}else{
	    return n * fact(n-1);
	}
    }
    
    public static int fib(int n){
	if(outOfRange(n)){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}else{
	    if(n==1){
		return 1;
	    }else{
		return fib(n-1) + fib(n-2);
	    }
	}
    }
    
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 0;
	}else{
	    if(guess*guess/n > .9999999999999999999){
		setGuess(n);
		sqrt(n);
	    }else{
		return guess;
	    }
	}
    } 
   
    public static void setGuess(double n){
	guess = (n/guess + guess)/2;
    }
    
    public static void main(String[] args){
	System.out.println(sqrt(100));
    }







}