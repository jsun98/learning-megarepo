package hashtable;

import java.util.ArrayList;

public class HashTable<K, V> {

	private class Node<K, V> {
		K key;
		V val;
		Node<K, V> next;


		Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

	private ArrayList<Node<K, V>> bucket;

	private int size;

	private int numBuckets;

	public HashTable(int s) {
		size = 0;
		bucket = new ArrayList<Node<K, V>>();
		numBuckets = s;
		for (int i = 0; i < 10; i++)
			bucket.add(null);
	}

	public int size() {
		return this.size;
	}

	private int hash(K key) {
		return key.hashCode() % numBuckets;
	}

	public void put(K key, V val) {
		int index = hash(key);
		Node<K, V> head = bucket.get(index);

		while (head != null) {
			if (head.key.equals(key)) {
				head.val = val;
				return;
			}
			head = head.next;
		}

		++size;
		Node<K,V> node = new Node<>(key, val);
		head = bucket.get(index);
		node.next = head;
		bucket.set(index, node);
	}

	public V get(K key) {
		int index = hash(key);
		Node<K, V> head = bucket.get(index);
		while (head != null) {
			if (head.key.equals(key))
				return head.val;
			head = head.next;
		}
		return null;
	}

	public void remove(K key) {
		int index = hash(key);
		Node<K, V> head = bucket.get(index);
		Node<K, V> prev = null;

		while (head != null) {
			if (head.key.equals(key))
				break;
			prev = head;
			head = head.next;
		}

		if (head == null) return;

		size--;

		if (prev != null) {
			prev.next = head.next;
		} else {
			bucket.set(index, head.next);
		}
	}




}
