void main() throws InterruptedException {
    int time = 11;
    Queue<Integer> queue = new LinkedList<>();

    for(int i = time; i >= 0; i--){
        queue.add(i);
    }

    while(!queue.isEmpty()){
        System.out.println(queue.remove());
        Thread.sleep(1000);
    }

    System.out.println(queue.add(23));
    System.out.println(queue.element());
    System.out.println(queue.remove());
    System.out.println(queue.offer(34));
    System.out.println(queue.peek());
    System.out.println(queue.poll());
}