public class NQueens{

    private final static String clear = "\033[2J";
    private final static String hide = "\033[?25l";
    private final static String show = "\033[?25h";

    private char[][] board;

    public String name(){
	return "Kim, Yubin";
    }

    //constructor
    public NQueens(int size){
	if(size == 2 || size == 3){
	    throw new Error();
	}
	board = new char[size][size];
	for(int i=0; i<size; i++){
	    for(int j=0; j<size; j++){
		board[i][j] = ' ';
	    }
	}
    }

    public void wait(int millis) {
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {}
    }

    public String toString() {
	String res = clear + "\n";
	for (int i = 0; i < board.length * 2 + 1; ++i) {
	    res += "_";
	}

	res += "\n";

	for (int i = 0; i < board.length; ++i) {
	    res += "|";
	    for (int j = 0; j < board[i].length; ++j) {
		if (board[i][j] == 'Q' || board[i][j] == 'x' || board[i][j] == ' ') {
		    res += board[i][j] + "|";
		} else {
		    res += board[i][j] + " |";
		}
	    }
	    res += "\n";
	}
	for (int i = 0; i < board.length * 2 + 1; ++i) {
	    res += "-";
	} 
	res += "\n" + show;
	return res;
    }

    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int x, int y){
	return solve(x,y,0);
    }

    public boolean solve(int x, int y, int numQ){
	System.out.println(this);
	wait(20);
	if(numQ == board.length){
	    return true;
	}
	if(y>= board.length){
	    return false;
	}else{
	board[x][y] = 'Q';
	numQ++;
	}
	//System.out.println(this);
	//wait(20);

	if(isValid(x, y)){
	    if(solve(x+1, 0, numQ--)) 
		return true;
	}else{
	board[x][y] = '.';
	numQ--;
	}

	if(solve(x, y+1, numQ--)){
	    return true;
	}else{
	    return false;
	}

    }
	
       
    
    public boolean isValid(int x, int y){
	int len = -1 * board.length;

	for (int i = len; i<board.length; i++){
		try{	
		    if(board[i+x][y] == 'Q'){
			return false;
		    }
		    if(board[x][y+i]== 'Q'){
			return false;
		    }
		    if(board[x+i][y-i] == 'Q'){
			return false;
		    }
		    if(board[x+i][y+i] == 'Q'){
			return false;
		    }
		}
		catch (Exception e){};
	    }
	
	return true;
    }



}