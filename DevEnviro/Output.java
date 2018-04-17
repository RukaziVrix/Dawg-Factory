/** Automatically generated code **/


import javax.swing.*;
import java.util.ArrayList;
public class Output {
public static void main(String[] args) {
final JFrame window = new JFrame();
window.setSize(800, 800);
JPanel mainPanel = new JPanel();
ArrayList<JComponent> elements = new ArrayList<>();
mainPanel.setLayout(null);
window.add(mainPanel);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLocationRelativeTo(null);
window.setTitle("GUI Output Demo");
window.setVisible(true);
JLabel jlabel1 = new JLabel();
jlabel1.setSize(100, 25);
jlabel1.setLocation(40, 232);
jlabel1.setBackground(null);
jlabel1.setText("Text");
jlabel1.setBounds(jlabel1.getX(), jlabel1.getY(), jlabel1.getWidth(), jlabel1.getHeight());
mainPanel.add(jlabel1);
elements.add(jlabel1);


}
}
