package ss.week4;

public class DoublyLinkedList<E> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, E element) {
    	Node newNode = new Node(element);
    	Node oldNode = getNode(index);
    	if (this.size() == 0) {
    		newNode.previous = head;
    		newNode.next = head;
    		head.next = newNode;
    		head.previous = newNode;
    		size++;
    	} else {
    		newNode.previous = getNode(index - 1);
    		newNode.next = oldNode;
    		oldNode.previous = newNode;
    		getNode(index - 1).next = newNode;
    		size++;
    	}
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        if (size == 1) {
        	head.next = head;
        	head.previous = head;
        } else if (index == 0) {
        	getNode(index + 1).previous = head;
        	head.next = getNode(index + 1);
        } else if (index == this.size()) {
        	getNode(index - 1).next = head;
        	head.next = getNode(index - 1);
        } else {
        	Node temp1 = getNode(index - 1);
        	Node temp2 = getNode(index + 1);
        	temp1.next = temp2;
        	temp2.previous = temp1;
        }
        
        size--;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public E get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    
    public class Node {
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private E element;
        public Node next;
        public Node previous;

        public E getElement() {
            return element;
        }
    }
}
