import java.util.*;

public class MyDeque<T>{

    private T[] deque;
    private int head, tail, size;


    @SuppressWarnings("unchecked")    
    public MyDeque(int len){
	
	deque = (T[]) (new Object[len]);
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

    
    @SuppressWarnings("unchecked")
    public void resize(){

	if(size == deque.length){

	    T[] temp = (T[]) (new Object[size * 2]);
	    for(int i=0; i<size; i++){
		temp[i] = deque[(head+i) % size];

	    }

	    deque = temp;
	    head = 0;
	    tail = size - 1;
	}


    }    
    
    public void addFirst(T val){
	if(val == null){
	    throw new NullPointerException();
	}
	resize();
	head --;
	if(head < 0){
	    head += deque.length;
	}
	deque[head] = val;
	size += 1;
	
    }

    public void addLast(T val){
	if(val == null){
	    throw new NullPointerException();
	}
	resize();
	tail++;
	if(tail != 0 && tail >= deque.length){
	    tail -= deque.length;

	}
	deque[tail] = val;
	size += 1;
    }


    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T value = deque[head];
	deque[head] = null;
	head ++;
	if(head >= deque.length){
	    head -= deque.length;
	}
	size --;
	return value;

    }



    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}

	T value = deque[tail];
	deque[tail] = null;
	tail --;

	if(tail < 0){
	    tail += deque.length;
	}

	size --;
	return value;

    }

    public T getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return deque[head];

    }

    public T getLast(){
	if(size== 0){
	    throw new NoSuchElementException();
	}
	return deque[tail];

    }



}
