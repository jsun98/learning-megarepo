// if a Lambda Expression only calls 1 method,
// we can replace it with a method reference

public class MethodReference {
	interface FunctionalInterface {
		void print(String s);
	}
	static void functionParamFI(FunctionalInterface fi) {
		fi.print("swag3");
	}
	public static void main(String[] argv) {
		FunctionalInterface fI = s -> System.out.println(s);
		fI.print("swag1");

		// rewrite with method reference
		FunctionalInterface fI2 = System.out::println;
		fI2.print("swag2");

		// passing in method reference in function
		functionParamFI(System.out::println);
	}
}
