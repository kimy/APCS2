import java.util.*;
import java.io.*;

public class MyLinkedList<T> implements Iterable<T>  {

    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    
    
    public class MLLIterator<MyLinkedList> implements Iterator<T>{

	private LNode<T> current;

	public MLLIterator(LNode<T> data){
	    current = data;
	}

	public boolean hasNext(){
	    return current != null;
	}

	public T next(){
	    if(hasNext()){
		T data;
		data = current.getData();
		current = current.getNext();
		return data;
	    }else{
		throw new NoSuchElementException();
	    }

	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}


    }

    public Iterator<T> iterator(){
	return new MLLIterator<T>(head);

    }

    
    
    public String name(){
	return "Kim,Yubin";
    }

    public MyLinkedList(){
	size = 0;
    }

    public MyLinkedList(LNode<T> x){
	head = x;
	size = 1;
	while(x.getNext() != null){
	    size++;
	    x = head.getNext();
	}
	tail = x;
    }

    public LNode<T> get(int index){
	LNode<T> current = head;
	for(int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current;
    }

    public int size(){
	return size;
    }

    public int indexOf(T val){
	LNode<T> current = head;
	int i = 0;
	while(i<size() && !(current.getData().equals("" + val))){
	    current = current.getNext();
	    i++;
	}
	if(i>=size()) return -1;
	return i;
    }

    public void set(int index, T val){
	LNode<T> current = head;
	int i = 0;
	while(i != index){
	    current = current.getNext();
	    i++;
	}
	current.setData(val);
    }

    public boolean add(T val){
	LNode<T> current = new LNode<T>(val);
	tail.setNext(current);
	tail = current;
	size++;
	return true;
    }

    private boolean add(LNode<T> current){
	LNode<T> temp = head;
	while(temp.getNext() != null){
	    temp = temp.getNext();
	}
	temp.setNext(current);
	size++;
	return true;
    }

    public boolean add(int index, T val){
	LNode<T> current = head;
	LNode<T> add = new LNode<T>(val);

	int i = 0;

	while(i< index - 1){
	    current = current.getNext();
	    i++;
	}

	LNode<T> next = current.getNext();

	current.setNext(add);
	add.setNext(next);
	size++;

	if(index == size() - 1){
	    tail = add;
	}
	return true;
    }

    public T remove(int index){
	LNode<T> current = head;
	int i = 0;
	while(i < index - 1){
	    current = current.getNext();
	    i++;
	}
	if(i>=size()) throw new IndexOutOfBoundsException();
	LNode<T> next = current.getNext().getNext();
	T val = current.getNext().getData();
	current.setNext(next);
	size--;
	return val;
    }

    public String toString(){
	LNode<T> current = head;
	String ans = "[";
	while(current.getNext() != null){
	    ans+=current;
	    current = current.getNext();
	    ans+=",";
	}
	ans+=current + "]";
	return ans;
    }
}