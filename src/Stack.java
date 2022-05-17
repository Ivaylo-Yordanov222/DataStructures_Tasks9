import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {
    private final List<Integer> list = new ArrayList<>();
    private final List<Integer> maxNumbers = new ArrayList<>();
    private int maxNumber = 0;

    public void push(int el) {
        list.add(el);
        if (el >= maxNumber) {
            maxNumber = el;
            maxNumbers.add(maxNumber);
        }
    }

    public void max() {
        if (maxNumbers.size() > 0) {
            System.out.println(maxNumbers.get(maxNumbers.size() - 1));
        } else {
            System.out.println(0);
        }
    }

    public void pop() {
        System.out.println(list.get(list.size() - 1));
        if (Objects.equals(list.get(list.size() - 1), maxNumbers.get(maxNumbers.size() - 1))) {
            maxNumbers.remove(maxNumbers.size() - 1);
            list.remove(list.size() - 1);
        } else {
            list.remove(list.size() - 1);
        }
    }

    public List<Integer> getList() {
        return list;
    }
}
