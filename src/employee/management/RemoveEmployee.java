package employee.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{

    Choice cempId;
    JButton delete, back;

    RemoveEmployee(){

        JLabel lblempId = new JLabel("Employee Id");
        lblempId.setBounds(50,50,100,30);
        add(lblempId);

        cempId = new Choice();
        cempId.setBounds(200,50,150,30);
        add(cempId);

        try{
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                cempId.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,100,100,30);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,100,30);
        add(labelname);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50,150,100,30);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(200,150,100,30);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,200,100,30);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(200, 200,100,30);
        add(labelemail);

        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // the addItemListener class updates and shows the details of the employee id which is selected
        // by default it shows the details of the 1 st row and do not shows the details of the selected
        // employee id so this class shows the details everytime we select different employee id
        // that why above try catch and below try catch blocks are similar but we just using the
        // addItemListener class
        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try{
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '"+cempId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelphone.setText(rs.getString("phone"));
                        labelemail.setText(rs.getString("email"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0,600,400);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setLocation(300,30);
        setSize(1000,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane .showMessageDialog(null,"Employee data deleted successfully!");
                setVisible(false);
                new Home();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
