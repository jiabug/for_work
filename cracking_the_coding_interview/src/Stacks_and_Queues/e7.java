package Stacks_and_Queues;

import java.util.LinkedList;

/*
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. 
 * People must adopt either the "oldest"(based on arrival time) of all animals at the shelter, or they 
 * can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like. Create the data structures to maintain this 
 * system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may use 
 * the built-in LinkedList data structure.
 */
public class e7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

	
abstract class Animal{
	String name;
	private int order;
	public Animal(String n){
		name = n;
	}
	public void setOrd(int i){
		order = i;
	}
	public int getOrd(){
		return order;
	}
	public boolean isOlderThan(Animal a){
		return this.getOrd() < a.getOrd();
	}
}
class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}
class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}
class AnimalQueue{
	LinkedList<Dog> dog = new LinkedList<Dog>();
	LinkedList<Cat> cat = new LinkedList<Cat>();
	int order = 0;
	public void enqueue(Animal a){
		a.setOrd(order);
		order++;
		if(a instanceof Dog){
			dog.addLast((Dog) a);
		} else if (a instanceof Cat){
			cat.addLast((Cat) a);
		}
	}
	public Animal dequeueAny(){
		if (dog.isEmpty()){
			return dequeueCat();
		} else if (cat.isEmpty()){
			return dequeueDog();
		}
		Dog d = dog.peek();
		Cat c = cat.peek();
		if(d.isOlderThan(c)){
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}
	public Animal dequeueDog(){
		return dog.poll();
	}
	public Animal dequeueCat(){
		return cat.poll();
	}
}






