import java.util.*;

public class MyStack<T>{

    private LinkedList<T> stack;

    public T push(T data){
	stack.add(0,data);
	return data;
    }

    public T pop(){
	T temp = stack.get(0);
	stack.remove(0);
	return temp;
    }

    public T peek(){
	return stack.get(0);
    }


    public boolean empty(){
	return stack.size() == 0;
    }




}