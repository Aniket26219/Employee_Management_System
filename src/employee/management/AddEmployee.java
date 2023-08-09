package employee.management;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfemail, tfdesignation, tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel employeeid;
    JButton add,back;

    AddEmployee(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel heading = new JLabel("Enter Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        image.add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150, 150,30);
        image.add(tfname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,150,30);
        lblfname.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        image.add(tffname);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        image.add(dcdob);

        JLabel lblsalary = new JLabel("Salary");
        lblsalary.setBounds(400,200,150,30);
        lblsalary.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        image.add(tfsalary);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 150, 30);
        lbladdress.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250,150,30);
        image.add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,150,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        image.add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,300,150,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        image.add(tfemail);

        JLabel lblhighesteducation = new JLabel("Highest Education");
        lblhighesteducation.setBounds(400,300,150,30);
        lblhighesteducation.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblhighesteducation);

        String courses[] = {"BBA","BCA","BA","BSC","B.COM","B.Tech/BE","MBA","MCA","MA","M.Tech","MSC","PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600,300,150,30);
        cbeducation.setBackground(Color.WHITE);
        image.add(cbeducation);


        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50,350,150,30);
        lbldesignation.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lbldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        image.add(tfdesignation);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,150,30);
        lblaadhar.setFont(new Font("serif",Font.PLAIN,20));
        image.add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        image.add(tfaadhar);

        JLabel lblemployeeid = new JLabel("Employee ID");
        lblemployeeid.setBounds(50,400,150,30);
        lblemployeeid.setFont(new Font("serif",Font.PLAIN, 20));
        image.add(lblemployeeid);

        employeeid = new JLabel(""+number);
        employeeid.setBounds(200,400,150,30);
        employeeid.setFont(new Font("serif",Font.PLAIN,20));
        image.add(employeeid);

        back = new JButton("Back");
        back.setBounds(250,550,150,40);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30,144,254));
        back.addActionListener(this);
        image.add(back);

        add = new JButton("Add Details");
        add.setBounds(450,550,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(30,144,254));
        add.addActionListener(this);
        image.add(add);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setVisible(true);
        setSize(900,700);
        setLocation(250,17);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == add){

            // following variable names should be exactly same as the names present
            // in the database's table's column names meaning if the name of column
            // is dob then here the variable name should also has to be dob which is
            // exactly similar to the name present in the table
            // above the names given to text field/label/etc doesn't need to be similar
            // the the names present in the table's column name but following
            // names has to be and that is very important.....!!!
            // because we are passing them through the query and the query is passed to
            // our database's table so indirectly we are referring our table's column here
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = employeeid.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+
                        "', '"+phone+ "', ' "+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
                new Home();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]){

        new AddEmployee();
    }
}
