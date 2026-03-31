void main() {
    List<String> l1 = new ArrayList<>();

    // positional access and search operations
    // (get, set, add, remove. indexOf, lastIndexOf)
    l1.add("we");
    l1.add("are");
    l1.add("family");
    l1.add("of");
    l1.add("coding");

//    shuffle(l1, new Random());
    Collections.shuffle(l1, new Random());
    System.out.println(l1);

    indexOf(l1, "family");
    replace(l1, "coding", "programing");

    if(l1.toArray().length < 2){
        System.out.println("Usage: Deal hands cards");
        return;
    }

    int numHands = 4;
    int cardsPerHand = 5;

    // Make a normal 52-card deck.
    String[] suit = new String[] {
            "spades", "hearts",
            "diamonds", "clubs"
    };
    String[] rank = new String[] {
            "ace", "2", "3", "4",
            "5", "6", "7", "8", "9", "10",
            "jack", "queen", "king"
    };

    List<String> deck = new ArrayList<String>();
    for(int i = 0; i < suit.length; i++)
        for (int j = 0; j < rank.length; j++)
            deck.add(rank[j] + " of " + suit[i]);

    // Shuffle the deck
    Collections.shuffle(deck);

    if(numHands * cardsPerHand > deck.size()){
        System.out.println("Not enough cards");
        return;
    }

    for(int i = 0; i < numHands; i++){
        System.out.println(dealHand(deck, cardsPerHand));
    }

    // ArrayList
    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Orange");
    fruits.add("Mango");

    fruits.add(1, "Grapes");
    System.out.println("Element as index 2: " + fruits.get(2));
    fruits.set(0, "Pineapple");
    fruits.remove("Banana");
    fruits.remove(1);

    System.out.println("Fruits (iterator):");
    Iterator<String> iterator = fruits.iterator();
    while(iterator.hasNext()){
        System.out.println(iterator.next());
    }
    Collections.sort(fruits);
    System.out.println("Sorted fruits" + fruits);
    System.out.println("Total fruits: " + fruits.size());

    // LinkedList
    LinkedList<String> animals = new LinkedList<>();
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Elephant");
    animals.add("Tiger");

    animals.addFirst("Loin");
    animals.addLast("Monkey");

    System.out.println("First Animal: " + animals.getFirst());
    System.out.println("Last animal: " + animals.getLast());
    System.out.println("Element at index 2: " + animals.get(2));

    animals.removeFirst();
    animals.removeLast();
    animals.remove("Elephant");

    System.out.println("Animals (for-each): ");
    for(String animal: animals){
        System.out.println(animal);
    }

    System.out.println("Animals (for-each): ");
    for(String animal: animals){
        System.out.println(animal);
    }

    System.out.println("Animals (iterator)");
    Iterator<String> iterator1 = animals.iterator();
    while(iterator1.hasNext()){
        System.out.println(iterator1.next());
    }

    // stack operations
    animals.push("Horse");
    System.out.println("After push: " + animals);
    animals.pop();
    System.out.println("After pop: " + animals);

    // Queue operations
    animals.offer("Zebra");
    System.out.println("After offer: " + animals);
    System.out.println("Poll first: " + animals.poll());
    System.out.println("Animals now: " + animals);
}

public static <E> void swap(List<E> a, int i, int j){
    E tmp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, tmp);
}

public static void shuffle(List<?> list, Random rnd){
    for(int i = list.size(); i > 1; i--)
      swap(list, i - 1, rnd.nextInt(i));
}

// ListIterator
public <E> int indexOf(List<E> list,E e){
    for(ListIterator<E> it = list.listIterator(); it.hasNext();)
        if(e == null ? it.next() == null : e.equals((it.next())))
            return it.previousIndex();
    return -1;
}

public static <E> void replace(List<E> list, E val, E newVal){
    for(ListIterator<E> it = list.listIterator(); it.hasNext();)
        if(val == null ? it.next() == null : val.equals(it.next()))
            it.set(newVal);
}

// Range-View Operation
public static <E> List<E> dealHand(List<E> deck, int n){
    int deckSize = deck.size();
    List<E> handView = deck.subList(deckSize - n, deckSize);
    List<E> hand = new ArrayList<>(handView);
    handView.clear();
    return hand;
}
