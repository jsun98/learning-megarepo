package com.josh.java.collections.aggregate.reduction;
import com.josh.java.constructs.Person;
import com.josh.java.constructs.Averager;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReductionNotes {
	public static void main (String[] argv) {
		List<Person> roster = Person.createRoster();
		/**
		 * reduction operations tend to computer a single value (double, int etc.) or
		 * a collection of values
		 * there are terminal operators (ex. getAsDouble) that returns a value and
		 * there are intermediate operations (ex. filter) that reuturns a stream
		 *
		 **/

		double average = roster
				.stream()
				.filter(r -> r.getGender() == Person.Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();

		System.out.println(average);

		/**
		 * the reduce() method is a general purpose reduction operation
		 *
		 * identity is the initial value of the reduction operation, or the default
		 * value if there is no members in roster
		 *
		 * the accumulator takes two parametrs, the partial result and the current memeber
		 *
		 * note: the reduce() method always makes a new value/instance
		 */
		Integer totalAgeReduce = roster
				.stream()
				.map(Person::getAge)
				.reduce(
						0,
						(a, b) -> a + b);

		System.out.println(totalAgeReduce);


		/**
		 * The collect() method is similar to the reduce() method
		 * instead of creating new instances, it modifies existing instances/values
		 *
		 * params:
		 *
		 * supplier : It creates a new result container which will be populated
		 * by accumulator and combiner and finally it will be returned by collect() method.
		 * In parallel processing the Supplier function will be called multiple times
		 * that will return fresh value each time.
		 *
		 * accumulator : It incorporates additional element into the result.
		 *
		 * combiner : It combines two values that must be compatible with accumulator. Combiner works in parallel processing.
		 */
		Averager averageCollect = roster.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);

		System.out.println("Average age of MALE members: " +
				averageCollect.average());

		/**
		 * The Collectors class contains many useful reduction operations,
		 * such as accumulating elements into collections and summarizing
		 * elements according to various criteria. These reduction operations
		 * return instances of the class Collector,
		 * so you can use them as a parameter for the collect operation.
		 */
		List<String> namesOfMALEMembersCollect = roster
				.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(p -> p.getName())
				.collect(Collectors.toList());

		/**
		 * The groupingBy operation returns a
		 * map whose keys are the values that result
		 * from applying the lambda expression specified as its parameter
		 *
		 * The values of the map are lists of the Person instances
		 * that corropsonds to the keys
		 */
		Map<Person.Sex, List<Person>> byGender =
				roster
						.stream()
						.collect(Collectors.groupingBy(Person::getGender));
	}
}
