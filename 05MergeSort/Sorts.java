import java.util.*;

public class Sorts{

    public static void mergesort(int[]array){
	int[] p = Sorts.split(array);
	for(int i=0; i<p.length; i++){
	    array[i] = p[i];
	}

    }

    public static int[] split(int[]ary){
	if(ary.length == 1){
	    return ary;
	}

	int[]a = new int[ary.length/2];
	int[]b = new int[ary.length - a.length/2];
	a = Arrays.copyOfRange(ary, 0, ary.length/2);
	b = Arrays.copyOfRange(ary, ary.length/2, ary.length);
	return merge(split(a), split(b));
    }

    public static int[] merge(int[]a, int[]b){
	int[] res = new int[a.length + b.length];
	int x1 = 0;
	int x2 = 0;

	while(x1<=a.length && x2 <=b.length){
	    if(x1== a.length){
		for(; x2 < b.length; x2++){
		    res[x1 + x2] = b[x2];
		}
		return res;
	    }
	    if(x2 == b.length){
		for(;x1 < a.length; x1++){
		    res[x1+x2] = a[x1];
		}
		return res;
	    }
	    if(a[x1] < b[x2]){
		res[x1+x2] = a[x1];
		x1++;
	    }else{
		res[x1+x2] = b[x2];
		x2++;
	    }

	}
	return res;

    }

    public static void main(String[] args){
	Random r = new Random();

	int[] x = new int[Integer.parseInt(args[0])];
	for(int i = 0; i < x.length; i++){
	    x[i] = r.nextInt(x.length * x.length) - x.length;
	}

	if(Integer.parseInt(args[1]) == 1){
	    Sorts.mergesort(x);
	}else{
	    Arrays.sort(x);
	}


    }
   

}