/*
Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private. 
Static nested classes do not have access to other members of the enclosing class. As a member of the OuterClass, 
a nested class can be declared private, public, protected, or package private.
*/
public class NestedClass {
	class InnerClass {
		public void print() {
			System.out.println("hello, I'm an inner member class");
		}
	}
	static class StaticNestedClass {
		public void print() {
			System.out.println("hello, I'm a nested static inner class");
		}
	}
	public static void main(String[] argv) {
		// inner class has access to all fields and methods of the outer class,
		// but because it belongs to an instance of the outer class, 
		// it cannot declare static field/methods
		NestedClass nestedClass = new NestedClass();
		NestedClass.InnerClass innerClass = nestedClass.new InnerClass();
		innerClass.print();	
		
		// creating a nested static class
		// note: nested static class does not have access to the outer classes' fields and methods
		// in essense, it behaves the same as a top-level class
		NestedClass.StaticNestedClass staticNestedClass = new NestedClass.StaticNestedClass();
		staticNestedClass.print();		
		
	}

}
		
