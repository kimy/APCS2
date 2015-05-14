import java.util.*;
import java.io.*;

public class MyHeap{


    private int[] heap;
    private boolean isMaxHeap;

    public MyHeap(){
	isMaxHeap = true;
	heap = new int[8];
    }

    public MyHeap(boolean isMax){
	isMaxHeap = isMax;
	heap = new int[8];
    }


    public String toString(){
	String ans = "[";
	for(int i = 0; i < heap.length - 1; i++){
	    ans += heap[i] + ", ";
	}
	ans += heap[heap.length - 1] + "]";
	return ans;
    }

    public int remove(){

	return 0;

    }

    public void add(int n){
	heap[0] += 1;


    }

    public int peek(){
	return heap[1]; 

    }

    public static void main(String[] args){
	x = newMyHeap();



    }


}