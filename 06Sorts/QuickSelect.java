import java.util.*;

public class QuickSelect{

    public static void quickselect(int[]ary, int si, int ei){
	Random rand = new Random();
	int pivotindex = rand.nextInt(ei-si+1) + si;
	int pivot = ary[pivotindex];




    }


    public static void partition(int[]ary, int si, int ei){
	Random rand = new Random();	

	System.out.println(Arrays.toString(ary));

	int[] D = new int[ary.length];
	for(int i = 0; i< ary.length; i++){
	    if(i < si || i > ei){
		D[i] = ary[i];
	    }
	}

	int pivotindex = rand.nextInt(ei-si+1) + si;
	int pivot = ary[pivotindex];
	int start = si;
	int end = ei;

	System.out.println(pivot);
	for(int i = start; i < end+1; i++){
	    System.out.println(Arrays.toString(D));
	    //System.out.println(i);
	    if(ary[i] > pivot){
		D[ei] = ary[i];
		ei--;
	    }
	    if(ary[i] < pivot){
		D[si] = ary[i];
		si++;
	    }    
	}
	D[si] = pivot;
	System.out.println(Arrays.toString(D));
    }


    public static void main(String[] args){
	int[] tester = {19,38,7,13,42,5,2,10,9};
	partition(tester, 0, 8);

    }


}