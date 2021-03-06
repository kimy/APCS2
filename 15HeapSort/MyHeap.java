import java.util.*;
import java.io.*;

public class MyHeap{

    private int root;

    //private int size;
    private int[] heap;
    private boolean isMaxHeap;

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean isMax){
	isMaxHeap = isMax;
	heap = new int[8];
	//size = heap[0];
    }

    public String name(){

	return "Kim,Yubin";

    }


    public int getLeft(int i){
	return i * 2;
    }

    public int getRight(int i){
	return i * 2 + 1;
    }

    public int getParent(int i){
	return i / 2;
    }

    public int getSize(){
	return heap[0];
    }


    public void resize(){
	if(needResize()){

	    int[] newheap = new int[heap.length * 2];
	    for(int i = 0; i < heap.length; i++){
		newheap[i] = heap[i];
	    }

	    heap = newheap;
	}
    }

    
    public String toString(){
	String ans = "[";
	for(int i = 0; i < heap.length - 1; i++){
	    ans += heap[i] + ", ";
	}
	ans += heap[heap.length - 1] + "]";
	return ans;
    }

    /*
    //stolen from helen li
    public String toStringH(){
	String ans = "[";
	int place = 0;
	while (place < heap.length){
	    ans+= heap[place] + "  ";
	    place++;
	}
	ans+="]";
	return ans;
    }

    public String toString() {
	String ans = "";
	if (heap[0] > 0){
	    int level = getHeight();
	    int place = 0;
	    while (place <= level){
		ans += getLevel( place) + "\n";
		place++;
	    }
	    return ans;
	}
	return ans + "\n";
    }


    private int getHeight(){

	int times = 0;
	int sub = 0;
	while (sub < heap[0]){
	    sub += (int)Math.pow(2, times);
	    times++;
	}
	return times;

    }


    private String getLevel(int level) {
	if (level == 0){
	    return Integer.toString(heap[1]);
	}
	int start = (int)Math.pow(2, level);
	String ans = "";
	while (start <= heap[0] && start < (int)Math.pow(2,level+1)){
	    ans += heap[start] + "  ";
	    start++;
	}
	return ans;
    }

    */

    private void swap(int a, int b){
	int temp = heap[a];
	heap[a] = heap[b];
	heap[b] = temp;
    }

    
    public int remove(){
	if(isEmpty()){ // basecase for heap is empty
	    throw new NoSuchElementException("This Heap is Empty!");
	}
	int answer = heap[1];
	int size = heap[0];
	heap[1] = heap[size];
	heap[size] = 0;       
	heap[0] -= 1;

	removeHelp(1); //calls helper function 

	//heap[0] -= 1; //decreases size 

	return answer;
    }

    
    public void removeHelp(int index){

	int leftindex = index * 2 + 1;
	int rightindex = index * 2;

	if(index * 2 >= heap[0]){
	    return;
	}

	if(index < heap[0]){

	    if(!inOrder(index, rightindex) && inOrder(rightindex, leftindex)){
		swap(index, rightindex);
		removeHelp(rightindex);

	    }else{
		
		if(!inOrder(index,leftindex) && !inOrder(rightindex, leftindex)){
		    swap(index, leftindex);
		    removeHelp(leftindex);
		}
	    }
	}

    }


    public void add(int value){
	if(needResize()){
	    resize();
	}

	int index = heap[0] + 1;
	heap[index] = value;

	while(index != 1 && !inOrder(index/2, index)){
	    swap(index/2, index);
	    index = index / 2;
	}

	heap[0] += 1;

    }




    public boolean isEmpty(){ //returns if heap is empty
	return heap[0] == 0;

    }

    public boolean inOrder(int x, int y){
	if(isMaxHeap){
	    return heap[x] > heap[y];
	}else{
	    return heap[x] < heap[y];
	}

    }

    public boolean needResize(){
	return heap[0] >= heap.length - 1;
    }

    public int get(int index){
	return heap[index];
    }


    public int peek(){
	return heap[1]; 
    }



    public static void main(String[] args){
	MyHeap x = new MyHeap();

	x.add(5);
	x.add(3);
	x.add(22);
	x.add(56);
	x.add(23);

	System.out.println(x.toString());

	x.remove();
	x.remove();
	System.out.println(x.toString());


    }


}