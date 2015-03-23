import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> stack;

    public T push(T data){
	stack.add(0,data);
	return data;
    }

    public LNode pop(){
	LNode<T> temp = stack.get(0);
	stack.remove(0);
	return temp;
	
    }

    public LNode<T> peek(){
	return stack.get(0);
    }


    public boolean empty(){
	return stack.size() == 0;
    }




}