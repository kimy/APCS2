import java.util.*;

public class Sorts{

    public static void mergesort(int[]array){
	//make an ArrayList
	ArrayList <Comparable> aL = new ArrayList <Comparable>();
	//copy the values over 

	for(int a = 0 ; a < array.length ; a++){
	    aL.add(array[a]);
	}

	mhelp(aL);

	for(int b = 0 ; b < aL.size() ; b++){
	    array[b] = (int)(aL.get(b));
	}

    }

    public static void mhelp(ArrayList <Comparable> aL){
	if(aL.size() < 2){
	    return;
	}

	//split array
	ArrayList <Comparable> a = new ArrayList <Comparable>();
	ArrayList <Comparable> b = new ArrayList <Comparable>();
	boolean temp = true;
	
	if(temp = !temp){
	    a.add(aL.remove(0));
	}else{
	    b.add(aL.remove(0));
	}

	//sort each half
	mhelp(a);
	mhelp(b);

	//merge them
	while(a.size() > 0 && b.size() > 0){
	    if(a.get(0).compareTo(b.get(0)) > 0){
	    aL.add(a.remove(0));
	    }else{
		aL.add(b.remove(0));
	    }
	}
	aL.addAll(a);
	aL.addAll(b);
    }

}