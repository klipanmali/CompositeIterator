package my.composite.iterator.package1;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {
	
	Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

	public CompositeIterator(Iterator iterator) {
	       stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(stack.isEmpty()){
			return false;
		}else{
			// check iterator on top of the stack. if it doesn't have element to iterate trough
			// remove it from the stack and call hasNet()
			Iterator<MenuComponent> iterator = stack.peek();
			if(iterator.hasNext()){
				return true;
			}else{
				stack.pop();
				return hasNext();
			}
		}
	}

	@Override
	public Object next() {
		if (hasNext()){
			// from the iterator on top of the stack, take next element ( this action can cause iterator to be empty, 
			// and during next call to hasNext() procedure this iterator will be removed from the stack)
			// if this element is of type Menu, add it's iterator on top of the stack.
			Iterator<MenuComponent> iterator = stack.peek();
			MenuComponent menuComponent = iterator.next();
			if (menuComponent instanceof Menu){
				stack.push(menuComponent.createIterator());
			}
			return menuComponent;
		}else{
			return null;
		}
		
	}

	@Override
	public void remove() {
		return;
	}

}
