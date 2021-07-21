package com.gs.low;

public class Deque {
	
	int arr[];
	int front;
	int rear;
	int size;
	
	
	/*
	 * // Operations on Deque: void insertfront(int key); void insertrear(int key);
	 * void deletefront(); void deleterear(); bool isFull(); bool isEmpty(); int
	 * getFront(); int getRear();
	 */
	
	
	public Deque() {
		// TODO Auto-generated constructor stub
	}
	
	Deque(int size){
		this.arr = new int[size];
		this.size = size;
		this.front = this.rear = -1;
	}
	
	boolean isFull() {
		if((front == 0 && rear == size -1) || front == rear + 1) {
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if(front == -1) {
			return true;
		}
		return false;
	}
	
	void insertfront(int data) {
		
		if(isFull()) {
			return;
		}
		
		if(isEmpty()) {
			front= rear = 0;
		}else if(front == 0) {
			front  = size -1;
		}else {
			front--;
		}
		
		arr[front] = data;
	}
	
	void insertrear(int data) {
		if(isFull()) {
			return;
		}
		
		if(isEmpty()) {
			front= rear = 0;
		}else if(rear == size -1 ) {
			rear  = 0;
		}else {
			rear++;
		}
		
		arr[rear] = data;
	}
	
	
	void deleterear() {
		if(isEmpty()) {
			return;
		}
		
		if(rear == front) {
			rear = -1;
			front = -1;
		}else if(rear == 0 ) {
			rear  = size - 1;
		}else {
			rear--;
		}
		
	}
	
	void deletefront() {
		if(isEmpty()) {
			return;
		}
		
		if(rear == front) {
			rear = -1;
			front = -1;
		}else if(front == size-1 ) {
			front  =  0;
		}else {
			front ++;
		}
		
	}
	
	 int getFront()
	    {
	        // check whether Deque is empty or not
	        if (isEmpty())
	        {
	            System.out.println(" Underflow");
	            return -1 ;
	        }
	        return arr[front];
	    }

	    // function return rear element of Deque
	    int getRear()
	    {
	        // check whether Deque is empty or not
	        if(isEmpty() || rear < 0)
	        {
	            System.out.println(" Underflow\n");
	            return -1 ;
	        }
	        return arr[rear];
	    }

	    // Driver program to test above function
	    public static void main(String[] args)
	    {

	        Deque dq = new Deque(5);

	        System.out.println("Insert element at rear end : 5 ");
	        dq.insertrear(5);

	        System.out.println("insert element at rear end : 10 ");
	        dq.insertrear(10);

	        System.out.println("get rear element : "+ dq.getRear());

	        dq.deleterear();
	        System.out.println("After delete rear element new rear become : " +
	                dq.getRear());

	        System.out.println("inserting element at front end");
	        dq.insertfront(15);

	        System.out.println("get front element: " +dq.getFront());

	        dq.deletefront();

	        System.out.println("After delete front element new front become : " +
	                + dq.getFront());

	    }

}
