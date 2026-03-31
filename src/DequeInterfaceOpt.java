void main() throws InterruptedException {
    int time = 11;
    Deque<Integer> deque = new LinkedList<>();

    for(int i = time; i >= 0; i--){
        deque.add(i);
    }

    while(!deque.isEmpty()){
        System.out.println(deque.remove());
        Thread.sleep(1000);
    }

    deque.addFirst(2);
    System.out.println(deque.offerFirst(2));

    deque.addLast(23);
    System.out.println(deque.offerLast(23));

    System.out.println(deque.getFirst());
    System.out.println(deque.peekFirst());

    System.out.println(deque.getLast());
    System.out.println(deque.peekLast());

    System.out.println(deque.getFirst());
    System.out.println(deque.peekFirst());

    System.out.println(deque.getLast());
    System.out.println(deque.peekLast());
}