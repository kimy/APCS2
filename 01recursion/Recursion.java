import java.util.*;

public class Recursion{

    public String name(){
	return "Kim,Yubin";
    }

    public boolean outOfRange(int n){
	if(n<0){
	    return true;
	}else{
	    return false;
	}
    }

    public int fact(int n){
	if(outOfRange(n)){
	    throw new IllegalArgumentException();
	}
	if(n==0 || n==1){
	    return 1;
	}else{
	    return n * fact(n-1);
	}
    }
    
    public int fib(int n){
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
    
    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}else{
	    return sqrth(n, 1);
	}
    } 
   
    public double setGuess(double n, double guess){
	guess = (n/guess + guess)/2;
	return guess;
    }

    public boolean goodRange(double n, double guess){
	if(Math.abs((n - guess*guess)/n) < 0.001){
	    return true;
	}else{
	    return false;
	}
    }

    public double sqrth(double n, double guess){
	if(goodRange(n, guess)){
	    return setGuess(n,guess);
	}else{
	    return sqrth(n, setGuess(n,guess));
	}

    }

}