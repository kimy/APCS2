public class RunningMedian{

    private MyHeap smallHeap, bigHeap;
    private double median;
    //private int smallRoot, bigRoot;
    private int size;
    //private boolean balanced;

    public String name(){
	return "Kim,Yubin";
    }

    public RunningMedian(){

	smallHeap = new MyHeap(); //maxheap
	bigHeap = new MyHeap(false); //minheap

	//size = smallHeap.size() + bigHeap.getize();
    }


    public void add(int value){

	if(isEmpty()){
	    smallHeap.add(value);	
	}

	median = getMedian();

	if(value > median){
	    bigHeap.add(value);
	}else{
	    smallHeap.add(value);
	}

	setBalance();

    }


    public void setBalance(){
	if(Math.abs(smallHeap.getSize() - bigHeap.getSize()) >= 2){
	    if(smallHeap.getSize() > bigHeap.getSize()){
		bigHeap.add(smallHeap.remove());
	    }else{
		smallHeap.add(bigHeap.remove());
	    }
	}
    }


    public double getMedian(){

	//doublie med;

	if(smallHeap.getSize() > bigHeap.getSize()){
	    median = smallHeap.peek();
	}
	if(smallHeap.getSize() < bigHeap.getSize()){
	    median = bigHeap.peek();
	}
	if(smallHeap.getSize() == bigHeap.getSize()){
	    median = (double) (bigHeap.peek() + smallHeap.peek() / 2);
	}

	return median;

    }


    public boolean isEmpty(){
	return bigHeap.getSize() + smallHeap.getSize() == 0;
    }


    public static void main(String[] args){
	RunningMedian m = new RunningMedian();

	m.add(256);
	m.add(-4);
	m.add(55);
	m.add(1);
	m.add(2);
	System.out.println(m.getMedian());

    }


}