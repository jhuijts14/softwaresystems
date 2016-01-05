package ss.week7;


public class QuickSort {
    int[] a; 
	
	public QuickSort(int[] x) {
    	int length = x.length;
    	
    	a = new int[length];
    	
		
    }
	
	public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            qsort(a, first, position - 1);
            qsort(a, position + 1, last);
        }
    }
    public static int partition(int[] a, int first, int last) {

        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void main(String[] args) {
    	
    	int[] a = new int[]{3, 5, 1, 7, 2, 4, 8, 1, 9};
    	
    	QSortRunnable r = new QSortRunnable(a);
    	
    	Thread thread = new Thread(r);
    	
    	thread.start();
    	
    	
    	
    }

}


class QSortRunnable implements Runnable {

	private int[] a;

	public QSortRunnable(int[] aArg) {
		this.a = aArg;
	}

	@Override
	public void run() {
		sort(a);

	}

	public static synchronized void sort(int[] aArg) {
		QuickSort.qsort(aArg);
	}

}
