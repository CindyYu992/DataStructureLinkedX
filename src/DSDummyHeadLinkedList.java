public class DSDummyHeadLinkedList<E> {
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
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public DSDummyHeadLinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    //获取链表的元素个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的指定位置index位置添加新的元素
    public void addIndex(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;

    }

    //在链表头部添加新的元素e
    public void addFirst(E e) {
        addIndex(e, 0);
    }

    //在链表末端添加新的元素e
    public void addLast(E e) {
        addIndex(e, size);
    }

    //获得链表的第index（0-based）个位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;//dummyHead 是虚拟头结点，hummyHead.next中保存真实的第一个结点。
        //cur是真实的第一个结点
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) return true;
            cur = cur.next;
        }
        return false;
    }

    //toString
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            stringBuilder.append(cur + " -> ");
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    //从链表中删除元素e
    public void removeElement(E e) {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            if (cur.next.e.equals(e)) {
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null) {
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    //从链表中删除index位置的元素，返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node del = cur.next;
        cur.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    //从链表中删除第一个元素，返回被删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素，返回被删除的元素
    public E removeLast() {
        return remove(size - 1);
    }
}
