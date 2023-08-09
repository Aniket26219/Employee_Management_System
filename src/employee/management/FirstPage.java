package employee.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {

    FirstPage(){

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050,500);
        add(image);

        JButton clickhere = new JButton("Click Here to continue");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setForeground(Color.WHITE);
        clickhere.setBackground(Color.BLACK);
        clickhere.addActionListener(this);
        image.add(clickhere);
        // we want to update the button on the image or above the image(see the output)

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setVisible(true);
        setSize(1170, 650);
        setLocation(100,50);
    }

    public void actionPerformed(ActionEvent ae){

        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {

        new FirstPage();
    }
}
