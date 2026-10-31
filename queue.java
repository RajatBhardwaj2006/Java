import java.util.LinkedList;
import java.util.Queue;

public class queue {

    public static void main(String[] args) {

        Queue<String> reminders = new LinkedList<>();

        reminders.add("8:00 AM - Paracetamol");
        reminders.add("2:00 PM - Vitamin C");
        reminders.add("8:00 PM - Crocin");

        System.out.println(reminders);

        System.out.println("Next reminder: " + reminders.peek());

        reminders.poll();

        System.out.println("Remaining reminders: " + reminders);
    }
}
