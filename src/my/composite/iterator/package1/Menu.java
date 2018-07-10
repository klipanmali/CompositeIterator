package my.composite.iterator.package1;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
	
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;

	public Menu(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent menuComponent){
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent){
		menuComponents.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription(){
		return description;
	}

	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
		
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			menuComponent.print();
		}
	}

	@Override
	public Iterator<MenuComponent> createIterator() {
		// TODO Auto-generated method stub
		return new CompositeIterator(menuComponents.iterator());
	}
	
	
	
}
