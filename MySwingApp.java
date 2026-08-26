import javax.swing.*;
public class MySwingApp {
   public static void main(String[] args) {
       JFrame frame = new JFrame("My First Swing App");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300, 200);
       JButton button = new JButton("Click Me");
       frame.add(button);
       frame.setVisible(true);
   }
}
