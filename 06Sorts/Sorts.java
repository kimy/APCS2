public class Sorts{

    public static String name(){

	String name = "Kim, Yubin";
	return name;

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

}