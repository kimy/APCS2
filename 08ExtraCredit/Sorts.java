public class Sorts{


    public static String name(){
	return "Kim, Yubin";
    }



    private static void quicksort(int[] a , int low , int high) {
        if (high >= a.length) {
            return;
        }
        if (low < 0) {
            return;
        }

        if (low >= high) {
            return;
        } else {
            int[] b = new int[a.length];
            System.arraycopy(a , 0 , b , 0 , a.length);
           
	    int pivotIndex = (int)(low + ((high - low) / 2));
            int pivot = a[pivotIndex];
            int lower = low;
            int higher = high;
          
	    for (int i = low ; i <= high ; i++) {
                if (a[i] > pivot) {
                    b[higher] = a[i];
                    higher--;
                } else if (a[i] < pivot) {
                    b[lower] = a[i];
                    lower++;
                }
            }
            for (int i = Integer.valueOf(lower); i <= higher; i++) {
                b[i] = pivot;
            }

            System.arraycopy(b , 0 , a , 0 , a.length);

            quicksort(a , low , lower - 1);
            quicksort(a , lower + 1 , high);
        }
    }

    public static void quicksort(int[] a) {
        quicksort(a , 0 , a.length - 1);
    }



    public static void mergesort(int[]array){
	int[] p = Sorts.split(array);
	for(int i=0; i<p.length; i++){
	    array[i] = p[i];
	}

    }

    public static int[] split(int[]ary){
	if(ary.length == 1){
	    return ary;
	}

	int[]a = new int[ary.length/2];
	int[]b = new int[ary.length - a.length/2];
	a = Arrays.copyOfRange(ary, 0, ary.length/2);
	b = Arrays.copyOfRange(ary, ary.length/2, ary.length);
	return merge(split(a), split(b));
    }

    public static int[] merge(int[]a, int[]b){
	int[] res = new int[a.length + b.length];
	int x1 = 0;
	int x2 = 0;

	while(x1<=a.length && x2 <=b.length){
	    if(x1== a.length){
		for(; x2 < b.length; x2++){
		    res[x1 + x2] = b[x2];
		}
		return res;
	    }
	    if(x2 == b.length){
		for(;x1 < a.length; x1++){
		    res[x1+x2] = a[x1];
		}
		return res;
	    }
	    if(a[x1] < b[x2]){
		res[x1+x2] = a[x1];
		x1++;
	    }else{
		res[x1+x2] = b[x2];
		x2++;
	    }

	}
	return res;

    }








}