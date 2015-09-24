package ch3;

import java.util.LinkedList;

/*Maintain a system in which all animals should be adopted according to FIFO, or they can select a dog or a cat 
 * which also operated on FIFO
 */
public class Solution3_6 {
	public class Animal {// Animal class which has a order and name
		private int order;
		protected String name;

		public Animal(String n) {
			this.name = n;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		public boolean isOlder(Animal a) {
			return this.order < a.getOrder();
		}
	}

	// Dog class which extends animal class
	public class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}

	}

	// Cat class which extends animal class
	public class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}

	public class AnimalQueue {
		private LinkedList<Dog> dogs = new LinkedList<Dog>();
		private LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0;

		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;
			// check if a is a instance of dog or cat
			if (a instanceof Dog) {
				dogs.addLast((Dog) a);
			} else if (a instanceof Cat)
				cats.addLast((Cat) a);
		}

		public Animal dequeueAnimal() {
			if (dogs.size() == 0)
				return dequeueDogs();
			if (cats.size() == 0)
				return dequeueCats();

			Dog dog = dogs.peek();// retrive the first element of dogs list
			Cat cat = cats.peek();// retrive the first element of cats list

			if (dog.isOlder(cat))
				return dequeueDogs();
			else
				return dequeueCats();
		}

		private Animal dequeueDogs() {
			// retrive and remove the first element of dogs list
			return dogs.poll();
		}

		private Animal dequeueCats() {
			// retrive and remove the first element of cats list
			return cats.poll();
		}
	}
}
