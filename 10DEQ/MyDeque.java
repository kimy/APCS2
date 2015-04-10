import java.util.*;

public class MyDeque{

    private int[] deque;
    private int head, tail, size;

    
    public MyDeque(int len){
	
	deque = new int[len];
	head = 0;
	tail = len - 1;
	size = 0;
	
    }
    
    public MyDeque(){
	this(10);
    }


    public int size(){

	return size;
    }

    
    public void resize(){

	if(size == deque.length){
	    int[] temp = new int[size * 2];
	    for(int i=0; i<size; i++){
		temp[i] = deque[(head+i) % size];
	    }
	    deque = temp;
	    head =0;
	    tail = size - 1;
	}


    }    
    
    public void addFirst(int val){
	resize();
	head --;
	if(head < 0){
	    head += deque.length;
	}
	deque[head] = val;
	size += 1;
	
    }

    public void addLast(int val){
	resize();
	tail++;
	if(tail != 0 && tail >= deque.length){
	    tail -= deque.length;

	}
	deque[tail] = val;
	size += 1;
    }


    public int removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	int value = deque[head];
	deque[head] = 0;
	head ++;
	if(head >= deque.length){
	    head -= deque.length;
	}
	size --;
	return value;

    }



    public int removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	int value = deque[tail];
	deque[tail] = 0;
	tail --;
	if(tail < 0){
	    tail += deque.length;
	}
	size --;
	return value;

    }

    public int getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return deque[head];


    }

    public int getLast(){
	if(size== 0){
	    throw new NoSuchElementException();
	}
	return deque[tail];

    }



}
