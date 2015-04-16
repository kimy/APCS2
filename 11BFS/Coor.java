public class Coor{

    private int x, y;
    private Coor previous;

    public Coor(int i1, int i2){
	x = i1;
	y = i2;
    }

    public void setPrevious(Coor prev){
	previous = prev;
    }

    public Coor getPrevious(){
	return previous;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }


    public String toString(){
	return "[ " + x + ", " +  y  + " ]";


    }










}