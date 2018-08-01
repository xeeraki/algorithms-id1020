import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private int N;
    private Item item;
    Bag(){

    }

    void add(Item item){
        this.item = item;
        N++;
    }

    boolean isEmpty(){
        return N == 0;
    }

    int size(){

        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
