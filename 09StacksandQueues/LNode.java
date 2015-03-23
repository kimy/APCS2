public class LNode<T> {

    private T data;
    private LNode<T> next;

    public LNode (T val){
	setData(val);
    }

    public LNode(T val, LNode<T> nex){
	setData(val);
	setNext(nex);
    }

    public void setData(T val){
	data = val;
    }

    public T getData(){
	return data;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "" + data;

    }


}