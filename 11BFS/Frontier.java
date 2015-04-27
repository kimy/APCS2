public class Frontier{

    private MyDeque<Coor> front;

    //modes
    private int DFS = 0;
    private int BFS = 1;
    private int BEST = 2;
    private int ASTAR = 3;
    private int endx, endy;

    private int mode;

    public Frontier(int m, int endex, int endwhy){
	mode = m;
	if(mode < 0 || mode > 3){
	    mode = 0;
	}
	endx = endex;
	endy = endwhy;
	front = new MyDeque<Coor>();

    }

    public void add(Coor c){
	int x = c.getX();
	int y = c.getY();

	if(mode == DFS){
	    front.addFirst(c);
	}
	if(mode == BFS){
	    front.addLast(c);
	}
	if (mode == BEST){
	    front.add(c, Math.abs(endx - x) + Math.abs(endy - y));
	}
	if(mode == ASTAR){
	    front.add(c, Math.abs(endx - x) + Math.abs(endy - y) + c.getSteps());
	}

    }

    public Coor remove(){
	if(mode == DFS || mode == BFS){
	    return front.removeFirst();
	}
	if(mode == BEST || mode == ASTAR){
	    return front.removeSmallest();
	}
	return front.removeFirst();
    }

    public boolean isEmpty(){
	return front.size() == 0;
    }

    /*
    public double dist(Coor a, Coor b){
	x1 = a.getX();
	x2 = b.getX();
	y1 = a.getY();
	y2 = b.getY();

	return x1;

    }
    */


}