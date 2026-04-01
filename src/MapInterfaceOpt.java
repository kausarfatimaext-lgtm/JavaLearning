void main() {
    Map<Integer, String> map = new HashMap<>();

    map.put(1, "Ali");
    map.put(2, "Sara");
    map.put(1, "Ahmad");

    System.out.println(map);

    map.put(100, "Ali");
    System.out.println(map.get(2));
    map.remove(1);
    map.put(1, "Aisha");

    map.containsKey(2);
    System.out.println(map.containsValue("Ali"));

    System.out.println(map.size());
    System.out.println(map.isEmpty());

    Map<String, Integer> m = new HashMap<>();
    List<String> args = new ArrayList<>();
    args.add("Here");
    args.add("are");
    args.add("coders");
    args.add("in");
    args.add("Programming");

    for(String word : args){
        m.compute(word, (k, freq) -> (freq == null) ? 1 : freq + 1);
    }
    System.out.println(m);

    // Bulk Operations
    Map<String, Integer> map2 = new HashMap<>();
    map2.putAll(m);
    map.clear();
    Map<String, Integer> copy = new HashMap<>(m);

    Map<String, String> managers = new HashMap<>();

    managers.put("Ali", "Sara");
    managers.put("Ahmad", "Sara");

    // Employees without managers
    Set<String> employees = new HashSet<>(managers.keySet());
    System.out.println(employees);

    Map<String, Integer> hashmap = new HashMap<>();
    hashmap.put("chairs", 2);
    hashmap.put("bed", 3);
    hashmap.put("cups", 6);
    hashmap.put("Plates", 8);

    Set<String> set1 = new HashSet<>();
    set1.add("bad");
    set1.add("cups");
    set1.add("tables");

    Set<String> set2 = new HashSet<>();
    set2.add("Plates");
    set2.add("glasses");
    set2.add("chairs");

    System.out.println(validate(hashmap, set1, set2));

    // Multimap
//    CreateFile();
    String[] strings = {"words.txt", "1"};
    Anagrams(strings);

    // HashMaps
    HashMap<Integer, String> Map1 = new HashMap<>();
    HashMap<Integer, String> Map2 = new HashMap<>(10);
    HashMap<Integer, String> Map3 = new HashMap<>(10, 0.8f);

    Map1.put(1, "Ali");
    Map1.put(2, "Sara");
    HashMap<Integer, String> mapCopy = new HashMap<>(Map1);
    System.out.println("Initial mapCopy: " + mapCopy);

    Map1.put(3, "Ahmad");
    Map1.put(2, "Ayesha");
    System.out.println("After put operations: " + Map1);

    System.out.println("Value at key 1: " + Map1.get(1));
    System.out.println("Value at key 4 (non-existent): " + Map1.get(4));

    System.out.println("Key 4 default: " + Map1.getOrDefault(4, "Not Found"));
    System.out.println("Contains key 2? " + Map1.containsKey(2));
    System.out.println("Contains value 'Ali'?" + Map1.containsValue("Ali"));

    Map1.remove(3);
    Map1.remove(2, "Ayesha");
    System.out.println("After removals: " + Map1);
    System.out.println("Size of Map1: " + Map1.size());
    System.out.println("Is Map1 empty: " + Map1.isEmpty());

    Set<Integer> keys = Map1.keySet();
    System.out.println("Keys: " + keys);

    Collection<String> values = Map1.values();
    System.out.println("Values: " + values);

    Set<Map.Entry<Integer, String>> entries = Map1.entrySet();
    System.out.println("Entries: " + entries);

    Map1.computeIfAbsent(4, k -> "Khan");
    System.out.println("After computeIfAbsent: " + Map1);

    Map1.computeIfPresent(4, (k, v) -> v + "Khan");
    System.out.println("After computeIfPresent: " + Map1);

    Map1.compute(5, (k, v) -> (v == null) ? "Guest" : v + " Guest");
    System.out.println("After compute: " + Map1);

    Map1.merge(1, " Jr.", String::concat);
    System.out.println("After merge: " + Map1);

    HashMap<Integer, String> cloneMap = (HashMap<Integer, String>) Map1.clone();
    System.out.println("Cloned map: " + cloneMap);

    // LinkedHashMap
    LinkedHashMap<Integer, String> Lmap1 = new LinkedHashMap<>();
    LinkedHashMap<Integer, String> Lmap2 = new LinkedHashMap<>(10);
    LinkedHashMap<Integer, String> Lmap3 = new LinkedHashMap<>(10, 0.75f);
    LinkedHashMap<Integer, String> Lmap4 = new LinkedHashMap<>(10, 0.75f, true);

    Map<Integer, String> initialMap = new HashMap<>();
    initialMap.put(1, "One");
    initialMap.put(2, "Two");
    LinkedHashMap<Integer, String> Lmap5 = new LinkedHashMap<>(initialMap);

    Lmap1.put(1, "Ali");
    Lmap1.put(2, "Ahmad");
    Lmap1.put(3, "Asif");
    Lmap1.put(4, null);
    System.out.println("Lmap1 after put: " + Lmap1);

    // Iterating entrySet
    System.out.println("\nIterating using entrySet: ");
    for(Map.Entry<Integer, String> entry : Lmap1.entrySet()){
        System.out.println(entry.getKey() + " => " + entry.getValue());
    }
    Lmap1.replaceAll((k, v) -> (v == null ? "Unknown" : v.toUpperCase()));
    System.out.println("\nMap after replaceAll: " + Lmap1);

    LinkedHashMap<Integer, String> lruCache = new LinkedHashMap<Integer, String>(4, 0.75f, true){
        private static final int MAX_ENTRIES = 3;
        protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
            return size() > MAX_ENTRIES;
        }
    };
    lruCache.put(1, "One");
    lruCache.put(2, "Two");
    lruCache.put(3, "Three");
    System.out.println("\nLRU Cache before adding 4th element: " + lruCache);
    lruCache.put(4, "Four");
    System.out.println("\nLRU Cache after adding 4th element: " + lruCache);

    // TreeMap
    TreeMap<Integer, String> Tmap = new TreeMap<>();
    Tmap.put(3, "Three");
    Tmap.put(1, "One");
    Tmap.put(2, "Two");

    System.out.println(Tmap);

    System.out.println(Tmap.firstKey());
    System.out.println(Tmap.lastKey());
    System.out.println(Tmap.ceilingKey(2));
    System.out.println(Tmap.floorKey(2));

    System.out.println(Tmap.lastEntry());
    System.out.println(Tmap.floorEntry(2));
    System.out.println(Tmap.lowerEntry(2));
    System.out.println(Tmap.lowerKey(1));

    map.remove(2);
    System.out.println(map);
}
static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K> permittedAttrs){
    boolean valid = true;
    Set<K> attrs = attrMap.keySet();

    if(!attrs.containsAll(requiredAttrs)){
        Set<K> missing = new HashSet<K>(requiredAttrs);
        missing.removeAll(attrs);
        System.out.println("Missing attributes: " + missing);
        valid = false;
    }
    if(!permittedAttrs.containsAll(attrs)){
        Set<K> illegal = new HashSet<>(attrs);
        illegal.removeAll(permittedAttrs);
        System.out.println("Illegal attributes: " + illegal);
        valid = false;
    }
    return valid;
}
public void CreateFile(){
    try{
        FileWriter writer = new FileWriter("words.txt");

        writer.write("listen silent enlist\n");
        writer.write("rat tar art\n");
        writer.write("evil vile live veil\n");
        writer.write("cat dog act\n");

        writer.close();
        System.out.println("File created successfully");
    } catch (IOException e){
        e.printStackTrace();
    }
}
private static String alphabetize(String s){
    char[] a = s.toCharArray();
    Arrays.sort(a);
    return new String(a);
}
public void Anagrams(String[] strings){
    int minGroupSize = Integer.parseInt(strings[1]);

    // Read words from file and put into a simulated multimap
    Map<String, List<String>> m = new HashMap<String, List<String>>();

    try {
        Scanner s = new Scanner(new File(strings[0]));
        while (s.hasNext()) {
            String word = s.next();
            String alpha = alphabetize(word);
            List<String> l = m.get(alpha);
            if(l == null)
                m.put(alpha, l = new ArrayList<String>());
            l.add(word);
        }

        //Print all permutation groups above size threshold
        for(List<String> l : m.values())
            if(l.size() >= minGroupSize)
                System.out.println(l.size() + ": " + l);
    } catch (IOException e){
        System.err.println(e);
        System.exit(1);
    }
}