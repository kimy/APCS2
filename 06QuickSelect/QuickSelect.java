import java.util.*;

public class QuickSelect{


    public static void partition(int[]ary, int si, int ei){
	Random rand = new Random();	

	int[] D = new int[ary.length];
	for(int i = 0; i< ary.length; i++){
	    if(i < si || i > ei){
		D[i] = ary[i];
	}

	int pivotindex = rand.nextInt(ei-si+1) + si;

	int start = si;
	int end = ei;

	for(int i = si; i < ei + 1; i++){
	    if(ary[i] > ary[pivotindex]){
		D[end] = ary[i];
		end--;
	    }
	    if(ary[i] < ary[pivotindex]){
		D[start] = ary[i];
		start++;
	    }
	    if(ary[i] = ary[pivotindex]){
	    }
	}

    }

    public static void main(String[]args){


    }








}