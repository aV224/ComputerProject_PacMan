import javax.swing.*;
public class TestDriver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setSize(500, 500);
        frame.setLocation(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel2());
        frame.setVisible(true);
    }
}
