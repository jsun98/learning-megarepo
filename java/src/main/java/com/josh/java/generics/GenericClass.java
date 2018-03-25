package com.josh.java.generics;

public class GenericClass {
	public static void main (String[] args) {
		// instantiating generic class
		Box<Integer> integerBox;

		// pre SE 7
		Box<Integer> integerBox2 = new Box<Integer>();

		// post SE 7 "the diamond" aka inferred type
		Box<Integer> integerBox3 = new Box<>();


		// instantiating classes with multiple generic types
		Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
		Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");

		// parameterized types
		OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>());

		// raw types - name of generic class without types
		Box<String> stringBox = new Box<>();
		Box rawBox = stringBox;               // OK - assign parameterized type to raw type

		// not okays
		Box rawBox2 = new Box();           // rawBox is a raw type of Box<T>
		Box<Integer> intBox = rawBox2;     // warning: unchecked conversion
	}
}

/**
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * V - Value
 * N - Number
 * T - Type
 * S,U,V etc. - 2nd, 3rd, 4th types
 */
class Box<T> {
	// T stands for "Type"
	private T t;

	public void set(T t) { this.t = t; }
	public T get() { return t; }
}


/**
 * multiple types
 */
interface Pair<K, V> {
	public K getKey();
	public V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {

	private K key;
	private V value;

	public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey()	{ return key; }
	public V getValue() { return value; }
}

