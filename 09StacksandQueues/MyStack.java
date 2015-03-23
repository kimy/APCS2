import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> stack;

    public T push(T data){
	stack.add(0,data);
	return data;
    }

    public T pop(){
	LNode<T> temp = stack.get(0);
	stack.remove(0);
	return temp.getData();
	
    }

    public T peek(){
	return stack.get(0).getData();
    }


    public boolean empty(){
	return stack.size() == 0;
    }




}