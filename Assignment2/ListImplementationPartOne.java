/*
 * Kimberly M. Praxel
 * 4/24/16
 * ListImplementationPartOne.java
 * My attempt at a custom LinkedList 
 */


package edu.greenriver.tech.it.lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListImplementationPartOne<T> implements List<T>{

	private Node head; // first node in list
	private Node tail; // last node in list
	private int size; // holds size of list


	/**
	 * LinkedList Node
	 * 
	 * @author Kimberly M. Praxel
	 * @version 1.0
	 */
	private class Node{
		public T info; // info stored in node
		public Node next; // goes to next node
		public boolean removed; // true if working node false if deleted


		public T getInfo(){
			return info;// gets info
		}


		public void setInfo(T info){
			this.info = info;// set info
		}


		public Node getNext(){
			return next;// gets next
		}


		public void setNext(Node next){
			this.next = next;// set next
		}


		public void setRemoved(boolean removed){
			this.removed = removed; // sets removed
		}
	}


	// part #1 methods below...

	/**
	 * adds new node to linkedlist
	 * 
	 * @param newElement
	 *            holds info for inside link
	 * @return true;
	 */
	@Override
	public boolean add(T newElement){
		Node element = new Node(); // creates a new node
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
		Node previous = null;
		Node current = head;
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
			Node element = new Node(); // creates a new node
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
		Node current = head; // first node of list
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
		Node current = head; // first node of list
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
		Node current = head; // first node of list
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
		Node current = head;
		Node previous = null;
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
		Node previous = null;
		Node current = head;
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
			Node current = head;
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


	@Override
	public boolean addAll(Collection<? extends T> other){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public boolean addAll(int index, Collection<? extends T> other){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public boolean containsAll(Collection<?> other){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public boolean removeAll(Collection<?> other){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public boolean retainAll(Collection<?> other){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public List<T> subList(int fromIndex, int toIndex){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public Object [] toArray(){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	@SuppressWarnings("hiding")
	public <T> T [] toArray(T [] toFill){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public Iterator<T> iterator(){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	// extra credit below...

	@Override
	public ListIterator<T> listIterator(int index){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public int lastIndexOf(Object search){
		throw new UnsupportedOperationException("This method is not supported.");
	}


	@Override
	public ListIterator<T> listIterator(){
		throw new UnsupportedOperationException("This method is not supported.");
	}
}
