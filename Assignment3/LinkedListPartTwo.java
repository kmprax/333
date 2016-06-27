/*
 * Kimberly M. Praxel
 * 5/7/16
 * ListImplementationPartTwo.java
 * My attempt at a custom LinkedList 
 */

package edu.greenriver.tech.it.listparttwo;


import java.util.*;


public class LinkedListPartTwo<T> implements List<T>{
	private Node<T> head; // first node in list
	private Node<T> tail; // last node in list
	private int size; // holds size of list


	/**
	 * LinkedList Node
	 * 
	 * @author Kimberly M. Praxel
	 * @version 1.0
	 */
	private class Node<T> {
		public T info; // info stored in node
		public Node<T> next; // goes to next node
		public boolean removed; // true if working node false if deleted


		public T getInfo(){
			return info;// gets info
		}


		public void setInfo(T info){
			this.info = info;// set info
		}


		public Node<T> getNext(){
			return next;// gets next
		}


		public void setNext(Node<T> next){
			this.next = next;// set next
		}


		public void setRemoved(boolean removed){
			this.removed = removed; // sets removed
		}


		public T getValue(){
			// TODO Auto-generated method stub
			return null;
		}
	}

	
	public class ListIterator<T> implements Iterator<T>{
		
		private Node<T> currentNode;
		private Node<T> previous;
		
		public ListIterator(){
			super();
			this.currentNode = (Node<T>) head;
			this.previous = null;
		}
		
		@Override
        public boolean hasNext() {
            if (currentNode != null && currentNode.next != null)
                return true;
            else
                return false;
        }
		
		@Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            if ( previous == null )
            {
                previous = currentNode;
                return previous.info;
            }
            T node = currentNode.info;
            currentNode = currentNode.next;
            return currentNode.info;
        }
		
		@Override
        public void remove() {
			if(currentNode != null){
				if(previous != null){
					previous.next = currentNode.next;
				}
			}
        }
	}


	// part #1 methods below...

	/**
	 * adds new node to LinkedListPartTwo
	 * 
	 * @param newElement
	 *            holds info for inside link
	 * @return true;
	 */
	@Override
	public boolean add(T newElement){
		Node<T> element = new Node<T>(); // creates a new node
		element.setInfo(newElement); // fills new node with info
		element.setNext(null); // set it to the back of the list
		element.setRemoved(false); // its not deleted yet so set to false

		if(isEmpty()){ // checks if list is empty
			head = element; // adds element to list
		}else{
			tail.setNext(element);// puts last in list to new node
		}
		tail = element; // sets tail to the new node
		size++; // size up by 1
		return true;
	}


	/**
	 * adds new node to linkedlist and pushes the rest down
	 * 
	 * @param newElement
	 *            holds info for inside link
	 * @param index
	 *            holds the int to place newElement in
	 */
	@Override
	public void add(int index, T newElement){
		Node<T> previous = null;
		Node<T> current = head;
		if(index < 0 || index > size()){ // checks if the index is out of range
			throw new IndexOutOfBoundsException("index doesn't exist");
		}else if(index == size()){ // checks to see if index being called is
									// last
			add(newElement);
		}else{
			for(int i = 0; i < index; i++){ // loop searching for correct index
				previous = current;
				current = current.getNext();
			}
			Node<T> element = new Node<T>(); // creates a new node
			element.setInfo(newElement); // fills new node with info
			element.setNext(null); // set it to the back of the list
			if(index == 0){ // links pointer to new node
				head = element;
			}else{
				previous.setNext(element);
			}
			element.setNext(current); // pointer to new node
			size++; // size up by 1
		}
	}


	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if list is empty
	 * @return false is list has info
	 */
	@Override
	public boolean isEmpty(){
		if(size() == 0){ // compares size to 0
			return true;
		}
		return false;
	}


	/**
	 * returns the number of elements in the list
	 * 
	 * @return size number of elements in the list currently
	 */
	@Override
	public int size(){
		return size; // returns number stored in size variable
	}


	/**
	 * Removes all of the elements from this list
	 */
	@Override
	public void clear(){
		head = null; // makes head equal to null
		tail = null; // makes tail equal to null
		size = 0; // makes size equal to size -

	}


	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 * 
	 * @param search
	 *            what we are trying to find in the list
	 * @return first location it was found at
	 * @return -1 meaning not found
	 */
	@Override
	public int indexOf(Object search){
		Node<T> current = head; // first node of list
		int index = 0; // tracks index
		while(current != null){ // loops until end of list
			if(current.getInfo().equals(search)){ // compares current link to
													// search
				return index; // returns current link
			}
			index++; // increases until end of list
			current = current.getNext(); // moves to next link
		}
		return -1; // returns -1
	}


	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @return true if search item is in list
	 */
	@Override
	public boolean contains(Object search){
		return indexOf(search) != -1; // returns true if search is in list
	}


	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if not out of range
	 * @param index
	 *            - index of element to get from list
	 */
	@Override
	public T get(int index){
		Node<T> current = head; // first node of list
		T info = null;
		if(index < 0 || index >= size()){ // checks index given to list size
			throw new IndexOutOfBoundsException("index is out of range");// throws
																			// error
																			// if
																			// not
																			// in
																			// range
		}
		for(int i = 0; i <= index; i++){ // loops until same as index given
			if(index == i){ // compares given index and list index
				info = current.getInfo(); // return data when they are the same
			}
			current = current.getNext();// moves to next link
		}
		return info;
	}


	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element
	 *
	 * @param index
	 *            of what we are replacing
	 * @param value
	 *            we are replacing with
	 * @return previous info from link
	 * @throws IndexOutOfBoundsException
	 *             if not out of range
	 */
	@Override
	public T set(int index, T value){
		Node<T> current = head; // first node of list
		T oldInfo = null;
		if(index < 0 || index >= size()){ // checks index given to list size
			throw new IndexOutOfBoundsException("index is out of range");// throws
																			// error
																			// if
																			// not
																			// in
																			// range
		}
		for(int i = 0; i <= index; i++){
			if(index == i){
				oldInfo = current.getInfo(); // gets old info from link
				current.setInfo(value); // places new info into link

			}
			current = current.getNext();// moves to next link
		}
		return oldInfo; // returns old info from link
	}


	/**
	 * Removes the first occurrence of the specified element from this list
	 * 
	 * @param search
	 *            to be removed from list
	 * @return true if search is removed
	 */
	@Override
	public boolean remove(Object search){
		Node<T> current = head;
		Node<T> previous = null;
		if((size == 1) && (current.getInfo().equals(search))){ // checks to see
																// if list is
																// only one link
																// and if it
																// matches
																// search
			clear(); // clears the list if true
			return true; // returns true since list cleared
		}
		while(current != null){ // loops till finds end of list
			if(current.getInfo().equals(search)){ // checks to see if list info
													// matches search
				if(previous == null){
					head = current.getNext();
				}else if(tail == current){
					tail = previous; // changes tail to previous
					previous.setNext(null);// makes previous next
				}else{
					previous.setNext(current.getNext()); // sets previous with
															// current info
				}
				size--; // changes size
				return true; // removed link so returns true

			}
			previous = current; // gives current info to previous holder
			current = current.getNext();// moves to next link in list

		}
		return false; // return false
	}


	/**
	 * Removes the element at the specified position in this list
	 * 
	 * @param index
	 *            of element to remove
	 * @return element previously in that link
	 * @throws IndexOutOfBoundsException
	 *             if not out of range
	 */
	@Override
	public T remove(int index){
		Node<T> previous = null;
		Node<T> current = head;
		if(index < 0 || index >= size()){ // checks index given to list size
			throw new IndexOutOfBoundsException("index is out of range");// throws
																			// error
																			// if
																			// not
																			// in
																			// range
		}else{
			for(int i = 0; i <= index; i++){
				previous = current; // set previous to last link
				current = current.getNext();// changes current to continue loop
			}
			previous.setNext(current.getNext());
			size--;
			return current.getInfo();
		}
	}


	/**
	 * Returns a string representation of the object
	 * 
	 * @return result
	 */
	public String toString(){

		String result = "[";
		if(size == 0){
			result += "";
		}else if(size == 1){
			result += head.info;
		}else{
			Node<T> current = head;
			while(current.next != null){
				result += current.info + ", ";
				current = current.next;
			}
			result += current.info;
		}
		result += "]";
		return result;
	}


	// part #2 methods below...

	/**
	 * Adds collection to the end of the other collection
	 * 
	 * @param other
	 *            collection containing elements to be added to this list
	 * @return true if this list changed
	 */
	@Override
	public boolean addAll(Collection<? extends T> other){
		boolean added = false; //creates a boolean called added
		for(T newElement : other){ //enhanced loop iterates through other
			if(add(newElement)){ //if element added change
				added = true; // changed added to true
			}
		}
		return added;//return added variable
	}



	/**
	 * adds a second collection to the first collection at given index
	 * 
	 * @param other
	 *            collection containing elements to be added to this list
	 * @param index
	 *            at which to insert the first element from the specified
	 *            collection
	 * @return true if this list changed
	 * @throws IndexOutOfBoundsException
	 *             - if the index is out of range (index < 0 || index > size())
	 */
	@Override
	public boolean addAll(int index, Collection<? extends T> other){
		if ((index < 0) || (index > size())) {
			throw new IndexOutOfBoundsException("Not a valid index");
		}else if (other.isEmpty()) { 
			return false;
		}

		Node<T> current = head; //creates head pointer
		for (int i = 0; i < index; i++) { //loops to find right node by index given
			current = current.next; //loops through nodes
		}
		
		
		Node<T> temp = current.next; //creates variable of next node
		
		Iterator<? extends T> interimIterator = other.iterator();
		
		while (interimIterator.hasNext()) { //while there is still a next 
			T newElement = interimIterator.next(); //create new node 
			current.next = new Node<T>(); //put new node in next
			current = current.next; //makes current.next node the current node
			current.setInfo(newElement); //sets info
			current.setNext(null); //set address to null
		}
		
		current.next = temp; //changes variable temp to current.next
		return true; //return true
	}



	/**
	 * iterates over collection checking each element if is in collection returns 
	 * true if not false
	 * 
	 * @param other
	 *            collection to be checked for containment in this collection
	 * @return true if this collection contains all of the elements in the
	 *         specified collection
	 */
	@Override
	public boolean containsAll(Collection<?> other){
		for(Object list: other){ //enhanced for loop checks each element for other
			if(!contains(list)){ //if not found in list return false
				return false; //returns false
			}
		}
		return true; //it was found so return true
	}


	/**
	 * iterates over collection searching for element in collection if it is
	 * found it will remove element using remove function
	 * 
	 * @param other
	 *            collection containing elements to be removed from this
	 *            collection
	 */
	@Override
	public boolean removeAll(Collection<?> other){
			boolean changed = false;
			Iterator<?> interimIterator = iterator();
			while(interimIterator.hasNext()){
				if(other.contains(interimIterator.next())){
					interimIterator.remove();
					changed = true;
				}
			}
			return changed;
		}
	

	/**
	 * iterates over collection checking each element to see if its in collection if
	 * it isn't in the collection it is removed using the remove method.
	 * 
	 * @param other- collection containing elements to be retained in this collection
	 * @return true if this collection changed 
	 */
	@Override
	public boolean retainAll(Collection<?> other){
		boolean changed = false;
		Iterator<?> interimIterator = iterator();
		while(interimIterator.hasNext()){
			if(!other.contains(interimIterator.next())){
				interimIterator.remove();
				changed = true;
			}
		}
		return changed;
	}


	/**
	 * New List with elements of old list fromIndex toIndex
	 * 
	 * @param fromIndex start of the list to view
	 * @param toIndex end of the list to view
	 * @returns only elements in range
	 */
	@Override
	public List<T> subList(int fromIndex, int toIndex){
		int count = 0;
		LinkedListPartTwo<T> newLinkedList = new LinkedListPartTwo<T>();
		Iterator<T> interimIterator = iterator();
		while(interimIterator.hasNext()){
			if(fromIndex > count){
				interimIterator.next();
				count++;
			}else if(toIndex > count){
				newLinkedList.add(interimIterator.next());
				count++;
			}
		}
		return newLinkedList;
	}

	/**
	 * returns array with elements from first of list to last of list
	 * 
	 * returns an array with elements
	 */
	@Override
	public Object [] toArray(){
		Object [] listArray = new Object[size()];
		Iterator<T> interimIterator = iterator();
		for(int i = 0; i < listArray.length; i++){
			listArray[i] = interimIterator.next();
		}
		return listArray;
	}

	/**
	 * returns array with elements from first to last
	 * 
	 * @return an array with all elements
	 */
	@Override
	@SuppressWarnings("hiding")
	public <T> T [] toArray(T [] toFill){

		if(toFill.length != size){
			throw new IllegalArgumentException("Size has to be the same for array to work");
		}

		Node current = head;

		for(int i = 0; i < size; i++){
			toFill[i] = (T)current.info;
			current = current.next;
		}
		return toFill;
	}

	/**
	 * declares we have an iterator and will return an iterator  
	 * 
	 * @return iterator 
	 */
	@Override
	public Iterator<T> iterator(){
		
		return new ListIterator();
	}


	@Override
	public int lastIndexOf(Object o){
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public java.util.ListIterator<T> listIterator(){
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public java.util.ListIterator<T> listIterator(int index){
		// TODO Auto-generated method stub
		return null;
	}

}
