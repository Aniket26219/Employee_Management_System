package employee.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{

    JTextField tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfeducation;
    JLabel labelname, labelfname, labelaadhar, labeldob, employeeid;
    JButton update,back;
    String empId;

    UpdateEmployee(String empId){

        this.empId = empId;
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(230,50,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200,150, 150,30);
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,150,30);
        lblfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        add(labelfname);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(200,200,150,30);
        add(labeldob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(400,200,150,30);
        lblsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,150,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblhighesteducation = new JLabel("Highest Education");
        lblhighesteducation.setBounds(400,300,150,30);
        lblhighesteducation.setFont(new Font("serif",Font.PLAIN,20));
        add(lblhighesteducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        tfeducation.setBackground(Color.WHITE);
        add(tfeducation);


        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50,350,150,30);
        lbldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,150,30);
        lblaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(lblaadhar);

        labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        add(labelaadhar);

        JLabel lblemployeeid = new JLabel("Employee ID");
        lblemployeeid.setBounds(50,400,150,30);
        lblemployeeid.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblemployeeid);

        employeeid = new JLabel(empId);
        employeeid.setBounds(200,400,150,30);
        employeeid.setFont(new Font("serif",Font.PLAIN,20));
        add(employeeid);

        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                labelaadhar.setText(rs.getString("aadhar"));
                employeeid.setText(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30,144,254));
        back.addActionListener(this);
        add(back);

        update = new JButton("Update Details");
        update.setBounds(450,550,150,40);
        update.setForeground(Color.WHITE);
        update.setBackground(new Color(30,144,254));
        update.addActionListener(this);
        add(update);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setLocation(300,30);
        setSize(800,700);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == update){

            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();

            try{
                Conn conn = new Conn();
                String query = "update employee set salary = '"+salary+"' , address = '"+address+
                        "', phone = '"+phone+"', email = '"+email+"', education = '"+education+
                        "', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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

    public static void main(String args[]){

        new UpdateEmployee("");
    }
}
