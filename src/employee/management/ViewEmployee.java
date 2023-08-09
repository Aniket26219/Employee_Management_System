package employee.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice cemployeeId;
    JTable table;
    JButton search, update, print, back;

    ViewEmployee(){

        JLabel lblsearch = new JLabel("Search by Employee ID");
        lblsearch.setBounds(20,20,150,20);
        add(lblsearch);

        cemployeeId = new Choice();
        cemployeeId.setBounds(180,20,150,20);
        add(cemployeeId);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,1200,600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(120,70,80,20);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        print = new JButton("Print");
        print.setBounds(320, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(420, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setSize(1200,700);
        setLocation(100,30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == search){
            String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        else if(ae.getSource() == update){

            setVisible(false);
            new UpdateEmployee(cemployeeId.getSelectedItem());
        }

        else{

            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]){

        new ViewEmployee();
    }
}
