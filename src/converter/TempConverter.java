package converter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TempConverter extends JFrame {
    // Components
    JPanel p1;
    JPanel p2;
    JPanel p3;
    JLabel l1;
    JLabel l2;
    JTextField t;
    JButton b1; // Convert to F
    JButton b2; // Convert to C

    public TempConverter() {
        // Setting
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 200);
        // Calling the methods
        panel1();
        panel2();
        panel3();
        setVisible(true);
    }

    // METHOD FOR THE FIRST PANEL
    public void panel1() {
        // Create the components
        p1 = new JPanel();
        l1 = new JLabel("Enter a temperature, please: ");
        t = new JTextField(10);
        // Add the components to the panel
        p1.add(l1);
        p1.add(t);
        this.add(p1, BorderLayout.NORTH);
    }

    public void panel2() {
        p2 = new JPanel();
        l2 = new JLabel();
        // Add the components to the panel
        p2.add(l2);
        this.add(p2, BorderLayout.CENTER);
    }

    // METHOD FOR THE SECOND PANEL (buttons)
    public void panel3() {
        // Create the components
        p3 = new JPanel();
        b1 = new JButton("Convert to Fahrenheit");
        b2 = new JButton("Convert to Celsius");
        // Add the components to the panel
        p3.add(b1);
        p3.add(b2);
        this.add(p3, BorderLayout.SOUTH);
        // The action listener for the buttons
        b1.addActionListener(new ButtonListener());
        b2.addActionListener(new ButtonListener());
    }

    // ACTION LISTENER
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // What the button should do
            if (e.getSource() == b1) {
                String input = t.getText();
                double temperature = Double.parseDouble(input);
                double fahrenheit = (temperature * 9 / 5) + 32;
                l2.setText("The Fahrenheit temperature is " + fahrenheit + " degrees");
            }
            if (e.getSource() == b2) {
                String input = t.getText();
                double temperature = Double.parseDouble(input);
                double celsius = (temperature - 32) * 5 / 9;
                l2.setText("The Celsius temperature is " + celsius + " degrees");
            }
        }
    }

    public static void main(String[] args) {
        TempConverter converter = new TempConverter();
    }
}
