public class MyLinkedList{

    private LNode head;
    private LNode current;


    public MyLinkedList(int size){


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
		return current;
	    }
	}


    } 

    public String toString(){
	String res = "";
	for(int i = 0; i< 

    }









}