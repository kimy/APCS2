public class MyLinkedList{

    private LNode head;
    private LNode current;


    public MyLinkedList(){
	setHead(null);
	setCurrent(head);
    }

    public void set(int index, LNode value){ 	
	LNode temp;
	int count =0;
	setCurrent(head);
	while(current.getNext() != null){
	    if(count != index){
		setCurrent(current.getNext());
		count++;
	    }else{
		current = value;
		break;
	    }
	}

    }

    public void setHead(int value){
	head.setValue(value);
    }

    public LNode getHead(){
	return head;
    }

    public void setCurrent(LNode n){
	current = n;
    }

    public LNode getCurrent(){
	return current;
    }

    public LNode get(int index){
	int count = 0;
	setCurrent(head);
	while(current.getNext() != null){
	    if(count != index){
		count ++;
	    }else{
		break;
	    }
	}
	return current;

    } 


    public String toString(){
	String res = "[";
	LNode temp = head;
	while(temp.getNext() != null){
	    res += " " +  temp.getValue();
	    temp = temp.getNext();
	}
	res += "]";
	return res;

    }





}