package ss.week4;

import java.util.*;

/**
 * Sort a specified List<E> with a merge sort.
 * @author Joep Huijts
 * @version 1.0
 *
 */
public class MergeSort {
	
	//------------------------Commands----------------
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {

    	// First check if list is big enough;
    	if (list.size() > 1) {
    		
    	
    		//===== Split the list in two ========
    		List<E> left = new ArrayList<E>();
    		List<E> right = new ArrayList<E>();

    		int center = list.size() / 2;

    		// Copy all the element before center to the left list;
    		for (int i = 0; i < center; i++) {
    			left.add(list.get(i));
    		}

    		// Copy all the element after center to the right list;
    		for (int i = center; i < list.size(); i++) {
    			right.add(list.get(i));
    		}

    		// Split the lists further if needed;
    		mergesort(left);
    		mergesort(right);

    		//============== merge and sort the lists ======================
    		merge(left, right, list);
    	}
    	
    }
    	
    public static <E extends Comparable<E>> void merge(List<E> left, List<E> right, List<E> list) {
    	int indexL = 0; // Index for the left list;
    	int indexR = 0; // Index for the right list;
    	int indexList = 0; // Index for the entire list;
    	
    	while (indexL < left.size() && indexR < right.size()) {
    		
    		if (left.get(indexL).compareTo(right.get(indexR)) < 0) {
    			list.set(indexList, left.get(indexL));
    			indexL++;
    		} else {
    			list.set(indexList, right.get(indexR));
    			indexR++;
    		}
    		indexList++;
    	}
    	
    	// Check and add elements that are still left;
    	
    	int indexStillLeft;
    	List<E> leftOvers;
    	
    	if (indexL >= left.size()) {
    		// the left index is bigger/as big as left.size. So left was used up.
    		indexStillLeft = indexR;
    		leftOvers = right;
    		
    	} else {
    		// The right was used up already;
    		indexStillLeft = indexL;
    		leftOvers = left;
    	}
    	
    	// Add the left over elements to the list;
    	for (int i = indexStillLeft; i < leftOvers.size(); i++) {
    		list.set(indexList, leftOvers.get(i));
    		indexList++;
    	}
    	
    }

	
}
