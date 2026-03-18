// Inner Class and Nested Static Class
public class TopLevelClass{
    void accessMembers(OuterClass outer){
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}
public class OuterClass{
    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass{
        void accessMembers(){
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }

    static class StaticNestedClass{
        void accessMembers(OuterClass outer){
           // System.out.println(outerField);    // can not access non-static field
           System.out.println(outer.outerField);
           System.out.println(staticOuterField);
        }
    }
}

// Inner Class using interface
public class DataStructure {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure(){
        for(int i = 0; i< SIZE; i++){
            arrayOfInts[i] = i;
        }
    }

    interface DataStructureIterator extends java.util.Iterator<Integer>{}

    private class EvenIterator implements DataStructureIterator{
        private int nextIndex = 0;

        public boolean hasNext(){
            return (nextIndex <= SIZE - 1);
        }
        public Integer next(){
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);

            nextIndex += 2;
            return retValue;
        }
    }
    public void printEven(){
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
    }
}

// shadowing
public class ShadowTest{
    public int x = 0;

    class FirstLevel {
        public int x = 1;
        void methodInFirstLevel(int x){
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }
}

// Local Classes
// 1. Inside block where local classes are created can not create interface.
// 2. Cannot declare static initializers or member interfaces in a local class.
// 3. A local class can have static members provided that they are constant variables. e.g;  public static final String farewell = "Bye bye";
public class LocalClassExample{
    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2){
        final int numberLength = 10;
        class PhoneNumber{
            String formattedPhoneNumber = null;
            PhoneNumber(String phoneNumber){
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if(currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }
            public String getNumber(){
                return formattedPhoneNumber;
            }
            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                    " and " + phoneNumber2);
            }
        }
        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        myNumber1.printOriginalNumbers();

        if(myNumber1.getNumber() == null){
            System.out.println("First number is invalid");
        } else {
            System.out.println("First number is " + myNumber1.getNumber());
        }
        if(myNumber2.getNumber() == null){
            System.out.println("Second number is invalid");
        } else {
            System.out.println("Second number is " + myNumber2.getNumber());
        }
    }
}

// Anonymous Classes (Same points as for local classes)
// they don't have constructors
public static class HelloWorldAnonymousClasses{
    interface HelloWorld{
        public void greet();
        public void greetSomeone(String someone);
    }
    public void sayHello(){
        class EnglishGreeting implements HelloWorld{
            String name = "world";
            public void greet(){
                greetSomeone("world");
            }
            public void greetSomeone(String someone){
                name = someone;
                System.out.println("Hello" + name);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "Hello";
            @Override
            public void greet() {
                greetSomeone("Coding");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello" + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "Hello";
            @Override
            public void greet() {
                greetSomeone("Programming");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello" + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }
}

void main() {
    // Inner Class and Nested Static Class
    System.out.println("Inner class:");
    System.out.println("-----------------");
    OuterClass outerObject = new OuterClass();
    OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    innerObject.accessMembers();

    System.out.println("\nStatic nested class:");
    System.out.println("-----------------");
    OuterClass.StaticNestedClass staticNestedObject = new OuterClass.StaticNestedClass();
    staticNestedObject.accessMembers(outerObject);

    System.out.println("\nTop-level class:");
    System.out.println("-----------------");
    TopLevelClass topLevelObject = new TopLevelClass();
    topLevelObject.accessMembers(outerObject);

    // Shadowing
    ShadowTest st = new ShadowTest();
    ShadowTest.FirstLevel fl = st.new FirstLevel();
    fl.methodInFirstLevel(23);

    // Inner Class using interface
    DataStructure ds = new DataStructure();
    ds.printEven();

    // Local Classes
    LocalClassExample.validatePhoneNumber("123-456-7890", "456-7890");

    // Anonymous Classes
    HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
    myApp.sayHello();
}