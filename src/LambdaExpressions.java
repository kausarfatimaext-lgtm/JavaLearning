import java.time.LocalDate;
import java.util.function.Predicate;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String email;

    public Person(String name, LocalDate birthday, Sex gender, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public void printPerson() {
        System.out.println(name + " | Age: " + getAge() + " | " + gender + " | " + email);
    }
}

public class PersonProcessor {
    public static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> action) {
        for (X element : source) {
            if (tester.test(element)) {
                Y data = mapper.apply(element);
                action.accept(data);
            }
        }
    }
}

void main() {
    List<Person> roster = List.of(
            new Person("Ali", LocalDate.of(2000, 1, 1), Person.Sex.MALE, "ali@gmail.com"),
            new Person("Sara", LocalDate.of(1995, 5, 10), Person.Sex.FEMALE, "sara@gmail.com"),
            new Person("Ahmad", LocalDate.of(2003, 3, 15), Person.Sex.MALE, "ahmad@gmail.com")
    );

    // Using Predicate
    System.out.println("----- Males between 18-30 -----");
    Predicate<Person> maleBetween18and30 =
            // 1st way
//            p -> p.getGender() == Person.Sex.MALE &&
//                    p.getAge() >= 18 &&
//                    p.getAge() <= 30;
            // 2nd way
            (person) -> {
               return person.getGender() == Person.Sex.MALE && person.getAge() >= 18 && person.getAge() <= 30;
            };

    roster.stream()
            .filter(maleBetween18and30)
            .forEach(Person::printPerson);

    // Using Consumer
    System.out.println("----- Print Emails -----");
    Consumer<Person> printEmail =
            // 1st way
//            (Person person) -> {
//               System.out.println("Person Email: " + person.getEmail());
//            };
            // 2nd way
            person -> System.out.println("Person Email: " + person.getEmail());

    roster.forEach(printEmail);

    // Using Function (Mapping)
    System.out.println("----- Extract Names -----");
    Function<Person, String> getName =
            // 1st way
            Person::getName;
            // 2nd way
//            (Person person) -> {
//               return person.getName();
//            };
    roster.stream().map(getName).forEach(System.out::println);

    PersonProcessor.processElements(
            roster,
            person -> person.getAge() > 23,
            Person::getEmail,
            System.out::println
    );

    // Stream Pipeline
    System.out.println("----- Complex Pipeline -----");
    roster.stream()
            .filter(p -> p.getGender() == Person.Sex.FEMALE)
            .filter(p -> p.getAge() > 20)
            .map(p -> p.getName() + " (" + p.getEmail() + ") ")
            .sorted().forEach(System.out::println);

    // Variable Capture(final variable)
    int minAge = 20;

    System.out.println("----- Variable Capture -----");

    roster.stream()
            .filter(p -> p.getAge() > minAge)
            .forEach(p -> System.out.println(p.getName()));

    System.out.println("----- Target Typing -----");
    Predicate<Person> tester = p -> p.getAge() > 18;
    printWithTester(roster, tester);

    // Method Reference Advanced
    System.out.println("----- Method Reference -----");
    roster.stream().map(Person::getEmail).forEach(System.out::println);

    // Combined Scenario
    System.out.println("----- Ultimate Combined Example -----");
    processAdvamced(
            roster,
            person -> person.getGender() == Person.Sex.MALE,
            Person::getName,
            name -> System.out.println("Selected: " + name)
    );
}
public static void printWithTester(List<Person> list, Predicate<Person> tester){
    list.stream().filter(tester).forEach(Person::printPerson);
}

public static <T, R> void processAdvamced(
        List<T> list,
        Predicate<T> condition,
        Function<T, R> mapper,
        Consumer<R> action) {
    list.stream().filter(condition).map(mapper).forEach(action);
}
