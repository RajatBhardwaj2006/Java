import java.util.PriorityQueue;

public class pq {

    public static void main(String[] args) {

        PriorityQueue<Integer> times = new PriorityQueue<>();

        times.add(800);
        times.add(1400);
        times.add(1000);

        System.out.println(times.peek());
    }
}
