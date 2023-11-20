import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import entity.Person;
import entity.gender;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		//imperative apprach 
		
		List<Person> people = List.of(
				new Person("Yugesh","yugesh@gmail.com",gender.MALE),
				new Person("Jothika","jothika@gmail.com",gender.FEMALE),
				new Person("Amutha","amutha@gmail.com",gender.FEMALE),
				new Person("Srinivasan","Srinivasn@gmail.com",gender.MALE),
				new Person("Ragul","Ragul@gmail.com",gender.MALE)
				);
		
		System.out.println(people.toString());
		
		for(Person female : people) {
			if(female.getGender().equals(gender.FEMALE)) {
				System.out.println(female);
			}
		}
	
		//declarative approach
		//inside filter filter is called as predicate that return beeolean 
		List<Person> females=people.stream().filter(person -> gender.FEMALE.equals(person.getGender()))
		.collect(Collectors.toList());
		
		females.stream().map(fe -> "name : "+ fe.getName()).forEach(System.out :: println);
		
		
		
		// calling that functional interface
		int value = func1.apply("1");
		System.out.println(value);
		
		//function Chaining concept
		Function<String , Integer> chainMethod = func1.andThen(funcmulti);
		System.out.println("the output of chainmethod:"+chainMethod.apply("20"));
		
		// calling that consumer
		greetingPerson.accept(new Person("strak","stark@gmail.com",gender.MALE));
		
		// calling the biconsumer
		
		displayPerson.accept(people.get(1), true);
	
		
		//email checker consumer takes person and interally 
		//calls perdicate and based on that checks email
		emailChecker.accept(people.get(1));
		
		
		// getting the result from the supplier
		System.out.println(getDummyString.get());
		
		
		//the above functions programming concepts all comes into picture
		//when we use array.stream()
		System.out.println(people.stream().anyMatch(person -> person.getName().equalsIgnoreCase("yugesh")));
		
		//list of all email
		List<String> allTheEmail = people.stream().map(person -> person.getEmail()).collect(Collectors.toList());
		// Set gender
		Set<gender> allgender = people.stream().map(person -> person.getGender()).collect(Collectors.toSet());
		
		//
		List<Person> allMaleOnly = people.stream().filter(person -> person.getGender().equals(gender.MALE)).collect(Collectors.toList());
	
		allMaleOnly.stream().forEach(person-> System.out.println("the men are "+person.getName()));
	
		
		// token concept
		String name = extraSomething(people.get(1), Person::getName);
		String email = extraSomething(people.get(0), getEmail);
		System.out.println(name + " " + email);
		
		
	}
	
	
	
	//function interface a funciton that accepts one type and return another type
//	this is a function that accept a string and returns an integer
	static Function<String, Integer> func1 = number -> Integer.parseInt(number);
	
	static Function<Integer,Integer> funcmulti = number -> number*10;
	
	
	//consumer accept one input and doesnt return anything 
	static Consumer<Person> greetingPerson = person -> 
	                    System.out.println("Hello " +  person.getName() + " have a nice Day");

	 // biconsumer have two input based on that 
	static BiConsumer<Person, Boolean> displayPerson = (person, showEmail )-> 
	{       
	System.out.println("the name is : "+ person.getName() );
	if(showEmail) {
		System.out.println("the email is : "+ person.getEmail());
	}
	else {
		System.out.println("the email is : "+"***********@gamil.com");
	}
	};
	
	
	
	//prediate is like boolean true or false
	static Predicate<Person> checkEmail = person -> person.getEmail().contains("@gmail.com");
	
	// accepting above predicate consumer
	
	static Consumer<Person> emailChecker = person ->{
		if(checkEmail.test(person)) {
			System.out.println("valid email...");
		}
		else {
			System.out.println("not valid email...");
		}
	};
	
	
	static Supplier<String> getDummyString = ()->{
		System.out.println("inside supplier");
		return "Hello World";
	};
	
	static Function<Person,String> getEmail = Person::getEmail;
	
	
	// mimic method type in jwttoken code
	
	static <T> T extraSomething(Person person, Function<Person, T> resolver) {
		return resolver.apply(person);
	}
	
//	function accept one time and returns one type
//	bifunction accept two type and return one type
//	consumer acccepts one type and return nothing
//	biconsumer accept two type and return nothing
	//supplier accepts nothing but return something like the mentioned type
	
	
}
