// for interfaces that only contain one abstrct method (functional interfaces)
// we can use a lambda expression instead of an anounmous class

public class LambdaExpressions {
	// this is a functional interface
	interface Predicate<T> {
		boolean test(T t);
	}
	
	public static boolean doSomeTesting(int n, Predicate<Integer> p) {
		return p.test(n);
	} 

	public static void main(String[] argv) {
		// in a lambda expression, you can omit the type of the parameters
		// you can also omit the parameter parenthesis if there is only 1 param
		// the body doesn't need curly braces, the compiler will return the value if there is only 1 line
		// if curly braces are included, return must be used
		System.out.println("1 is greater than 0: " + doSomeTesting(1, (Integer n) -> n > 0));
	}
}
