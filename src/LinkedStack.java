
public class LinkedStack<E> implements MyStack{
    private DSDummyHeadLinkedList<E> list;

    public LinkedStack(DSDummyHeadLinkedList<E> list) {
        this.list = list;
    }
    public LinkedStack() {
        list = new DSDummyHeadLinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(Object o) {
        list.addFirst((E)o);
    }


    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("LinkedStack:top ");
        res.append(list);
        return res.toString();
    }
}
