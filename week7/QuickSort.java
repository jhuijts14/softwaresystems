package ss.week7;

import java.util.Arrays;

public class QuickSort {
    int[] a; 
	
	public QuickSort(int[] x) {
    	int length = x.length;
    	
    	a = new int[length];
    	
		
    }
	
	public static void qsort(int[] a) {
        

        QSortRunnable r = new QSortRunnable(a, 0, a.length - 1);
    	
    	r.run();
    	
    }
	
	
    public static void qsort(int[] a, int first, int last) {
        
    	
    	if (first < last) {
            int position = partition(a, first, last);
            
            QSortRunnable r = new QSortRunnable(a, first, position - 1);
        	r.start();
        	qsort(a, position + 1, last);
        	try { 
        		r.join();
        	} catch (InterruptedException e) {
        		e.printStackTrace();
        	}
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
    	
    	qsort(a);
    	
    	System.out.println(Arrays.toString(a));
    	
    	
    }

}


class QSortRunnable extends Thread implements Runnable {

	private int[] a;
	private int first, last;

	public QSortRunnable(int[] aArg, int firstArg, int lastArg) {
		this.a = aArg;
		this.first = firstArg;
		this.last = lastArg;
		
	}

	@Override
	public void run() {
		QuickSort.qsort(a, first, last);

	}

	

}
