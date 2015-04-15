import java.util.*;

public class MyDeque<T>{

    private T[] deque;
    private int[] priority;
    private int head, tail, size;


    @SuppressWarnings("unchecked")    
    public MyDeque(int len){
	
	deque = (T[]) (new Object[len]);
	priority = new int[len];
	head = 0;
	tail = len - 1;
	size = 0;
	
    }
    
    public MyDeque(){
	this(10);
	priority = new int[10];
    }


    public int size(){

	return size;

    }
    
    @SuppressWarnings("unchecked")
	public void resize(){
	
	if(size == deque.length){
	    
	    T[] temp = (T[]) (new Object[size * 2]);
	    int[] prioritytemp = new int[size * 2];

	    for(int i=0; i<size; i++){
		temp[i] = deque[(head+i) % size];
		prioritytemp[i] = priority[(head+i) % size];
	    }
	    deque = temp;
	    priority = prioritytemp;

	    head = 0;
	    tail = size - 1;
	}
    }
    
    //priority queue
    public T removeSmallest(){
	int smallp = priority[0];
	for(int i = 0; i < size; i++){
	    if(priority[i] < smallp){
		smallp = priority[i];
	    }
	}	
	T smallest = deque[smallp];
	deque[smallp] = deque[head];
	priority[smallp] = priority[head];

	deque[head] = null;
	head = smallp;
	return smallest;
    }

    public T removeLargest(){
	int largep = priority[0];
	for(int i = 0; i < size; i++){
	    if(priority[i] > largep){
		largep = priority[i];
	    }
	}
	T largest = deque[largep];
	deque[largep] = deque[head];
	priority[largep] = priority[head];
	deque[head] = null;
	head = largep;

	return largest;

    }    

    public void add(T value, int n){

	if(value == null){
	    throw new NullPointerException();
	}
	addLast(value);
	priority[tail] = n;

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
