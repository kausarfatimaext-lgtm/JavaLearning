void main() {
    int[] array;
    array = new int[10];

    Scanner input = new Scanner(System.in);
    for(int i = 0; i < array.length; i++){
        System.out.println("Enter the number ");
        int num = input.nextInt();
        array[i] = num;
    }
    for(int i = 0; i < array.length; i++){
        System.out.println("Here are array values: " + array[i]);
    }

    // copy arrays
    char[] copyFrom = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
//    char[] copyTo = new char[5];
//    System.arraycopy(copyFrom, 2, copyTo, 0, 5);
//    for(char character: copyTo){
//        System.out.println(character + " ");
//    }
    char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 6);
    for(char character: copyTo){
        System.out.println(character + " ");
    }

    int[] firstArray = getRandomArray(10);
    System.out.println(Arrays.toString(firstArray));
    Arrays.sort(firstArray);
    System.out.println(Arrays.toString(firstArray));
    System.out.println(Arrays.binarySearch(firstArray,35));

    int[] secondArray = new int[10];
    System.out.println(Arrays.toString(secondArray));
    Arrays.fill(secondArray, 5);
    System.out.println(Arrays.toString(secondArray));

    Arrays.stream(firstArray).filter(n -> n % 2 == 0).forEach(System.out::println);

    // ArrayList
    ArrayList arrayList = new ArrayList();
    for(int num : firstArray){
        arrayList.add(num);
    }

    System.out.println("ArrayList: " + arrayList);
    arrayList.add("here is string");
    System.out.println("ArrayList after adding element: " + arrayList);
    System.out.println("ArrayList element at index 2: " + arrayList.get(2));

    // linkedList
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.add(10);
    linkedList.add(20);
    linkedList.add(30);
    linkedList.add(40);
    linkedList.add(50);

    System.out.println("Forward Traversing: ");
    for(Integer num : linkedList){
        System.out.println(num + " ");
    }

    System.out.println("\nBackward Traversing: ");
    Iterator<Integer> iterator = linkedList.descendingIterator();

    while(iterator.hasNext()){
        System.out.println(iterator.next() + " ");
    }

    // Vector
    Vector<Integer> vector = new Vector<>();
    for(int num : firstArray){
        vector.add(num);
    }

    System.out.println("Vector after adding elements: " + vector);
    System.out.println("Vector element at index 3: " + vector.get(3));
}

private static int[] getRandomArray(int len){
    Random random = new Random();
    int[] newInt = new int[len];

    for(int i = 0; i < len; i++){
        newInt[i] = random.nextInt(100);
    }

    return newInt;
}