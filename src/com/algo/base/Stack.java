package com.algo.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.algo.util.StdOut;

/**
 * 栈的链表实现
 * 
 * @author peige
 */
public class Stack<T> implements Iterable<T> {

	private int 	N;			// 栈的大小
	private Node 	first;		// 栈顶
	
	private class Node {
		private T 		item;
		private Node 	next;
	}
	
	public Stack() {
		N = 0;
		first = null;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}

	public void push(T value) {
		Node node = new Node();
		node.item = value;
		node.next = first;
		first = node;
		++N;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		T val = first.item;
		first = first.next;
		--N;
		return val;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		return first.item;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}				
			T val = current.item;
			current = current.next;
			return val;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T t : this) {
			sb.append(t + " ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = "pei ge dao ci yi you".split(" ");
		Stack<String> stack = new Stack<>();
		for(String s : strs)
			stack.push(s);
		while(!stack.isEmpty()) {
			StdOut.print(stack.peek() + " ");
			stack.pop();
		}
		StdOut.println();
		
		for(String s : strs)
			stack.push(s);
		StdOut.println(stack);
	}
}

















