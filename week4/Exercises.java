package ss.week4;

/**
 * A Test class for the problem 13.1 in Nino & Hosch.
 * @author Joep Huijts
 * @version Version 1.0
 *
 */
public class Exercises {
	
	//----------------------------Queries------------------------------------------
	/**
	 * Returns the negative values in an array.
	 * @param arr - an int[] containing different int values.
	 * @return result - an int[] containing the 
	 * negative values of an input array.
	 */
	//@ requires arr != null;
    public static int countNegativeNumbers(int[] arr) {
        
    	assert arr != null; // assert that arr is not null;
    	 
    	int negCount = 0; // Create and initialized negative value counter;
    	
    	// For loop to check every int in the array;
    	for (int i = 0; i < arr.length; i++) {
    		// If the ith variable in arr contains a negative value, the negCount is incremented;
    		if (arr[i] < 0) {
    			negCount++;
    		}
    	}
    	
    	return negCount;
    }
    
    /**
	 * Returns the input array with all the values reversed.
	 * @param ints - an int[] containing different int values.
	 * @return result - an int[] containing the 
	 * values of the input array, but those values are reversed 
	 * with the first becoming the last etc.
	 */
	//@ requires ints != null;
    public static void reverseArray(int[] ints) {
    	
    	assert ints != null;
    	
    	int temp; // A temporary int variable to store a value of ints;
    	int begin = 0;
    	int end = ints.length - 1;
    	
    	while (begin < end) {
    		temp = ints[begin]; // temp stores the value of ints at index begin;
    		
    		ints[begin] = ints[end]; // Switch the first variable with the later one;
    		ints[end] = temp;  // Swith the later variable with the first one;
    		
    		begin++; // Increment begin;
    		end--; // Decrement end;
    	}
        
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
