void main() {
    Collection<String> c1 = new HashSet<>();
    c1.add("ali");
    c1.add("ahmad");
    c1.add("Maryam");
    c1.add("Maya");
    c1.add("Maya");

    Collection<String> c2 = new HashSet<>();
    c2.add("ali");
    c2.add("Aisha");
    c2.add("Maryam");
    c2.add("Maham");
    c2.add("Maya");

    FindDups(c2);
    System.out.println(c1.containsAll(c2));  // c2 subset of c1
    System.out.println(c1.addAll(c2));   // union of c1 and c2
    System.out.println(c1.retainAll(c2));   // intersection of c1 and c2
    System.out.println(c1.removeAll(c2));   // difference of c1 and c2

    // HashSet with synchronization
    Set<Integer> set1 = Collections.synchronizedSet(new HashSet<>());
    set1.add(10);
    set1.add(20);
    set1.add(30);
    set1.add(10);

    System.out.println("Contains 10? " + set1.contains(10));
    set1.remove(30);
    System.out.println("Size: " + set1.size());

    synchronized (set1){
        for (Integer s: set1){
            System.out.println("With Collections synchronization" + s);
        }
    }

    // mannual synchronization
    HashSet<Integer> set2 = new HashSet<>();
    synchronized (set2){
        set2.add(10);
        set2.add(24);
    }

    for(Integer s: set2){
        System.out.println("With mannual synchronization" + s);
    }

    // LinkedHashSet
    LinkedHashSet<String> set3 = new LinkedHashSet<>();
    set3.add("Ali");
    set3.add("Ahmad");
    set3.add("Sara");

    System.out.println("LinkedHashSet: " + set3);
    set3.remove("Ahmad");
    System.out.println("Contains Sara: " + set3.contains("Sara"));

    for(String name: set3)
        System.out.println(name);

    //TreeSet
    TreeSet<Integer> set4 = new TreeSet<>();
    set4.add(30);
    set4.add(29);
    set4.add(26);
    set4.add(10);

    System.out.println("TreeSet: " + set4);
    System.out.println("First: " + set4.first());
    System.out.println("Last: " + set4.last());
    System.out.println("Higher than 20: " + set4.higher(20));
    System.out.println("Lower than 40: " + set4.lower(40));
    set4.remove(10);
    for(int num: set4){
        System.out.println(num);
    }

    // Descending order
    TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
    set.add(10);
    set.add(50);
    set.add(30);
    System.out.println(set);

    // Stream API
    HashSet<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    s.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
}
public void FindDups(Collection<String> args){
    // using aggregate function
//    Set<String> distinctWords = args.stream()
//            .collect(Collectors.toSet());
//    System.out.println(distinctWords.size() + " distinct words: " + distinctWords);

    // using for-each
    Set<String> Words = new HashSet<String>();
    Set<String> uniques = new HashSet<String>();

    for(String a : args){
        Words.add(a);
        System.out.println(Words.size() + " Union words: " + Words);
    }

    // Destructive set-difference
    uniques.removeAll(Words);

    System.out.println("Union Words: " + Words);
    System.out.println("Unique Words: " + uniques);
}
