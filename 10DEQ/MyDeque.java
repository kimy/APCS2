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


}
