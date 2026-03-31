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
}