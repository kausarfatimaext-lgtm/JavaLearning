import javax.swing.*;

// Generics Multiple Types
public interface Pair<K,V>{
    public K getKey();
    public V getValue();
}

public static class OrderedPair<K, V> implements Pair<K, V>{
    private K key;
    private V value;

    public OrderedPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}

// Multiple Bounded Types
interface Printable {
    void print();
}

static class Demo<T extends Number & Printable> {
    private java.util.List<T> items = new ArrayList<>();

    public void addItem(T obj){
        items.add(obj);
    }

    public void showAll(){
        for(T obj: items){
            obj.print();
            System.out.println("Double value: " + obj.doubleValue());
        }
    }

    public double calculateSum(){
        double sum = 0;
        for(T obj: items){
            sum += obj.doubleValue();
        }
        return sum;
    }

    public <U extends String> void compare(U obj1, U obj2){
        if(Objects.equals(obj1, obj2)){
            System.out.println("Both Strings are equal");
        } else {
            System.out.println("Both Strings are not equal");
        }
    }
}

static class MyNumber extends Number implements Printable {
    private int value;

    public MyNumber(int value) {
        this.value = value;
    }

    public void print() {
        System.out.println("Value: " + value);
    }

    public int intValue() {
        return value;
    }

    public long longValue() {
        return value;
    }

    public float floatValue() {
        return value;
    }

    public double doubleValue() {
        return value;
    }
}

// Type Inference
public static class Box<U>{
    private U u;
    void set(U u){
        this.u = u;
    }
    U get(){
        return u;
    }
}
public static <U> void addBox(U u, java.util.List<Box<U>> boxes){
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
}
public static <U> void outputBoxes(java.util.List<Box<U>> boxes){
    for(Box<U> box: boxes){
        U boxContent = box.get();
        System.out.println("Here is box content: " + boxContent);
    }
}

// Generics, Inheritance and Subtypes
interface PayloadList<E, P> extends List<E>{
    void setPayload(int index, P val);
    P getPayload(int index);
}
class PayloadArrayList<E, P> extends ArrayList<E> implements PayloadList<E, P>{
    private ArrayList<P> payloads = new ArrayList<>();

    public void add(E element, P payload){
        super.add(element);
        payloads.add(payload);
    }
    public void setPayload(int index, P val){
        payloads.set(index, val);
    }
    public P getPayload(int index){
        return payloads.get(index);
    }
}

// WildCards
static class Student {
    String name;

    Student(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}

static class GraduateStudent extends Student{
    double thesisScore;

    GraduateStudent(String name, double thesisScore){
        super(name);
        this.thesisScore = thesisScore;
    }
    double getThesisScore(){
        return thesisScore;
    }
}

//  --------------- Unbounded Wildcard -------------------
class Utils {
    public static void printList(List<?> list){
        for(Object obj: list){
            System.out.println(obj);
        }
        // list.add(new Student("Ali"));    // Not allowed
    }
}
//  --------------- Upper bounded Wildcard -------------------
class ScoreUtils {
    public static double calculateAverage(List<? extends GraduateStudent> list){
        double sum = 0;

        for(GraduateStudent gs: list){
            sum += gs.getThesisScore();
        }
        return sum / list.size();
    }
}
//  --------------- Lower bounded Wildcard -------------------
class Enrollment {
    public static void addStudents(List<? super Student> list){
        list.add(new Student("ALi"));
        list.add(new GraduateStudent("Sara", 88));
    }
}

void main() {
    // Generics Multiple Types
    Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
    Pair<String, String> p2 = new OrderedPair<>("hello", "world");
    System.out.println("Here is p1 key value pair: " + p1.getKey() + ", " + p1.getValue());
    System.out.println("Here is p2 key value pair: " + p2.getKey() + ", " + p2.getValue());

    // Multiple Bounded Types
    Demo<MyNumber> demo = new Demo<>();

    MyNumber n1 = new MyNumber(10);
    MyNumber n2 = new MyNumber(25);

    demo.addItem(n1);
    demo.addItem(n2);

    demo.showAll();
    System.out.println("Sum of values: " + demo.calculateSum());

    String s1 = "Kausar Fatima";
    String s2 = "Fatima Kausar";
    demo.compare(s1, s2);

    // Type Inference
    java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new java.util.ArrayList<Box<Integer>>();
    addBox(10, listOfIntegerBoxes);
    addBox(24, listOfIntegerBoxes);
    addBox(Integer.valueOf(35), listOfIntegerBoxes);    // no need type casting would be done automatically
    outputBoxes(listOfIntegerBoxes);

    // Generics, Inheritance and Subtypes
    PayloadList<String, String> list1 = new PayloadArrayList<>();
    PayloadList<String, Integer> list2 = new PayloadArrayList<>();
    ArrayList<String> l = new PayloadArrayList<>();

    //Wildcards

    //Unbounded
    List<Student> students = List.of(new Student("Ahmad"), new Student("Bilal"));
    List<Integer> numbers = List.of(1, 2, 3);

    Utils.printList(students);
    Utils.printList(numbers);

    //Upperbounded
    List<GraduateStudent> grads = List.of(new GraduateStudent("Ali", 80), new GraduateStudent("Sara", 90));
    double avg = ScoreUtils.calculateAverage(grads);
    System.out.println("Average: " + avg);

    //Lowerbounded
    List<Student> studentList = new ArrayList<>();
    List<Object> objectList = new ArrayList<>();

    Enrollment.addStudents(studentList);
    Enrollment.addStudents(objectList);
}