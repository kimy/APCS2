import java.util.*;

public class Sorts{

    public static void mergesort(int[]array){
	if(int.length < 2){
	    return;
	}

	int[]a = new int[array.length /2];
	int[]b = new int[array.length = a.length];

	

    }

    public static int[] split(int[]ary){
	if(ary.length == 1){
	    return ary;
	}

	int[]a = Arrays.CopyOfRange(ary, 0, ary.length/2);
	int[]b = Arrays.CopyOfRange(ary, ary.length/2, ary.length);
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

   

}