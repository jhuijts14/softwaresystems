package ss.week4.test;

import org.junit.Test;
import ss.week4.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {
    @Test
    public void testMergesortEmptyList() {
        List<Integer> sequence = new ArrayList<>(Collections.emptyList());
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Collections.emptyList());
    }

    @Test
    public void testMergesortSingleItem() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1));
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1));
    }

    @Test
    public void testMergesortSortedList() {
        List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5));

        sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testMergesortUnsortedList() {
    	List<Integer> sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 5, 4));
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5));

        sequence = new ArrayList<>(Arrays.asList(3, 2, 1, 6, 5, 4));
        MergeSort.mergesort(sequence);
        assertEquals(sequence, Arrays.asList(1, 2, 3, 4, 5, 6));
    }
    
    @Test
    public void testMerge() {
    	List<Integer> left4 = new ArrayList<>(Arrays.asList(1,4,6,9));
    	List<Integer> right4 = new ArrayList<>(Arrays.asList(3,5,8,9));
    	
    	List<Integer> left3 = new ArrayList<>(Arrays.asList(2,6,9));
    	List<Integer> right3 = new ArrayList<>(Arrays.asList(2,3,5));
    	
    	List<Integer> left4right4 = new ArrayList<>(Arrays.asList(1,3,4,5,6,8,9,9));
    	List<Integer> left3right3 = new ArrayList<>(Arrays.asList(2,2,3,5,6,9));
    	
    	List<Integer> left3right4 = new ArrayList<>(Arrays.asList(2,3,5,6,8,9,9));
    	List<Integer> left4right3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,9));
    	
    	List<Integer> temp6 = Arrays.asList(new Integer[6]);
    	List<Integer> temp7 = Arrays.asList(new Integer[7]);
    	List<Integer> temp8 = Arrays.asList(new Integer[8]);
    	
    	
    	MergeSort.merge(left4, right4, temp8);
    	
    	assertEquals(temp8, left4right4);
    	
    	MergeSort.merge(left3, right3, temp6);
    	
     	assertEquals(temp6, left3right3);	
     	
     	MergeSort.merge(left3, right4, temp7);
    	
     	assertEquals(temp7, left3right4);	
     	
     	MergeSort.merge(left4, right3, temp7);
    	
     	assertEquals(temp7, left4right3);	
    	
    	
    }
}
