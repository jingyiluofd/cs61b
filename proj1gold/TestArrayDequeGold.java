import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.ArrayList;

public class TestArrayDequeGold {
    @Test
    public void testArraydeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sad2 = new ArrayDequeSolution<>();
        Integer x;
        ArrayList<String> logs = new ArrayList<String>();


        for (int i = 0; i < 10000; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                sad2.addLast(i);
                logs.add("addLast[" + i + "]");
            }
            else if (sad1.size() > 0 && numberBetweenZeroAndOne < 0.6) {
                logs.add("removeLast()");
                assertEquals(joinLogs(logs), sad2.removeLast(), sad1.removeLast());
            } else if (sad2.size() > 0 && numberBetweenZeroAndOne < 0.75) {
                logs.add("removeFirst()");
                assertEquals(joinLogs(logs), sad2.removeFirst(), sad1.removeFirst());
            }
            else {
                logs.add("addFist[" + i + "]");
                sad1.addFirst(i);
                sad2.addFirst(i);
            }
        }
    }

    private String joinLogs(ArrayList<String> logs) {
        return String.join("\n", logs);
    }
}
