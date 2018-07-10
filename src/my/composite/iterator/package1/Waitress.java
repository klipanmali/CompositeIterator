package my.composite.iterator.package1;

import java.util.Iterator;

public class Waitress {
	MenuComponent menu;

	public Waitress(MenuComponent menu) {
		this.menu = menu;
	}
	
	public void printMenu() {
		menu.print();
	}
	
	public void printVegeterian(){
		Iterator<MenuComponent> iterator = menu.createIterator();
		while(iterator.hasNext()){
			MenuComponent component = iterator.next();
			try {
				if(component.isVegetarian())
					component.print();
			} catch (UnsupportedOperationException e) {}
		}
	}

}
