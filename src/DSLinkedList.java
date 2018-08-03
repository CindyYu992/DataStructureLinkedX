public class DSLinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public  String toString(){
            return  e.toString();
        }
    }

    private  Node head;
    private int size;

    public DSLinkedList(){
        head = null;
        size = 0;
    }

    //获取链表的元素个数
    public int getSize(){
        return  size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //在链表头添加新的元素
    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    //在链表的指定位置index位置添加新的元素
    public void addIndex(E e,int index){
        if (index <0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        if (index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for (int i=0;i<index-1;i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    //在链表末端添加新的元素e
    public void addLast(E e){
        addIndex(e,size);
    }
}
