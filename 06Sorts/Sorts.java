public class Sorts{

    private static void quicksort(int[] a , int l , int h) {
        if (h >= a.length) {
            return;
        }
        if (l < 0) {
            return;
        }

        if (l >= h) {
            return;
        } else {
            int[] b = new int[a.length];
            System.arraycopy(a , 0 , b , 0 , a.length);
           
	    int pivotIndex = (int)(l + ((h - l) / 2));
            int pivot = a[pivotIndex];
            int lower = l;
            int higher = h;
          
	    for (int i = l ; i <= h ; i++) {
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

            quicksort(a , l , lower - 1);
            quicksort(a , lower + 1 , h);
        }
    }

    public static void quicksort(int[] a) {
        quicksort(a , 0 , a.length - 1);
    }

    public static int[] qsorted(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a , 0 , b , 0 , a.length);
        quicksort(b , 0 , a.length - 1);
        return b;
    }


}