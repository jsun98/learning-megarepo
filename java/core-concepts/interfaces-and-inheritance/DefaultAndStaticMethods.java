// when we need to add new functionality to a interface
// we can use a default method so that classes already 
// implementing the interface don't have to be changed
public class DefaultAndStaticMethods {
	public interface ExampleInterface {
		public void print();
		default public int onePlusOne() {
			return 2;
		}
		public static double oneTimeOne() {
			return 1.0;
		}
	}

	class SomeClass implements ExampleInterface {
		public void print() {
			System.out.println("hello world");
		}
	}
}
/*
When you extend an interface that contains a default method, you can do the following:

Not mention the default method at all, which lets your extended interface inherit the default method.
Redeclare the default method, which makes it abstract.
Redefine the default method, which overrides it.
*/
