class Animal{
	String name;
	int age;
	void makeSound(){
	System.out.println("Animals make sound");
}	}
class Dog extends Animal{
	void makeSound(){
	System.out.println("Dogs Bark");
	}
	}
class Cat extends Animal{
	void makeSound(){
	System.out.println("Cat meoww");
	}
	}
class Bird extends Animal{
	void makeSound(){
	System.out.println("Birds chirp");
	}
	}
public class Animals{
	public static void main(String args[]){
	Animal animal = new Animal();
	animal.makeSound();
	Dog dog = new Dog();
	dog.makeSound();
	Cat cat = new Cat();
	cat.makeSound();
	Bird bird = new Bird();
	bird.makeSound();
	}
}
