public class MethodReferencesExample{
    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger){
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b){
        return a + b;
    }

    public String appendStrings2(String a, String b){
        return a + b;
    }
}

//Constructor Referencing
public static class Person {
    LocalDate birthday;
    public LocalDate getBirthday() {
        return birthday;
    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}
public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory){
    DEST result = collectionFactory.get();
    result.addAll(sourceCollection);
    return result;
}

void main() {
    MethodReferencesExample myApp = new MethodReferencesExample();
    // Calling the method mergeThings with a lambda expression
    System.out.println(MethodReferencesExample.mergeThings("Hello ", "World", (a, b) -> a + b));

    // Reference to a static method
    System.out.println(MethodReferencesExample.mergeThings("Hello ", "World", MethodReferencesExample::appendStrings));

    // Reference to an instance method of a particular object
    System.out.println(MethodReferencesExample.mergeThings("Hello ", "World", myApp::appendStrings2));

    // Reference to an instance method of an arbitrary object of a particular type
    System.out.println(MethodReferencesExample.mergeThings("Hello ", "World", String::concat));

    // Reference to a Constructor
    List<Person> roster = List.of(
            new Person(),
            new Person(),
            new Person()
    );
    Set<Person> rosterSet = transferElements(roster, HashSet<Person>::new);
}