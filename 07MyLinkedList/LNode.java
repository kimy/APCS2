public class LNode<T> {

    private T value;
    private LNode<T> next;

    public LNode<T> (T val){
	setValue(val);
    }

    public LNode<T>(T val, LNode nex){
	setValue(val);
	setNext(nex);
    }

    public void setValue(T val){
	value = val;
    }

    public T getValue(){
	return value;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "" + value;

    }


}