public class Frontier{

    private MyDeque<Coor> front;
    private int DFS = 0;
    private int BFS = 1;
    private int mode;

    public Frontier(int m){
	mode = m;
	front = new MyDeque<Coor>();

    }

    public void add(Coor c){
	if(mode == DFS){
	    front.addFirst(c);
	}
	if(mode == BFS){
	    front.addLast(c);
	}
    }

    public Coor remove(){
	    return front.removeFirst();
	
    }

    public boolean isEmpty(){
	return front.size() == 0;
    }



}