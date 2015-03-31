public class MyQueue<T>{

    private MyLinkedList<T> queue;


    public MyQueue(){

	queue = new MyLinkedList<T>();

    }

    public T dequeue(){
	if(queue.size() == 0){
	    throw new NullPointerException();
	}
	return queue.remove(0);

    }


    public void enqueue(T data){

	if(data == null){
	    throw new NullPointerException();
	}
	queue.add(data);	

    }






}