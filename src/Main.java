public class Main {

    public static void main(String[] args) {
       DSDummyHeadLinkedList<Integer> dsdList = new DSDummyHeadLinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            dsdList.addFirst(i);
        }

        dsdList.addIndex(666, 2);
        System.out.println(dsdList);

        LinkedStack <Integer> linkedStack = new LinkedStack<>();
        for (int i=0;i<5;i++){
            linkedStack.push(i);
        }
        System.out.println(linkedStack);
        linkedStack.pop();
        System.out.println(linkedStack);
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i=0;i<10;i++){
            queue.enqueue(i);
            if (i%3 == 2){
                queue.dequeue();
            }
        }
        System.out.println(queue);
    }

}
