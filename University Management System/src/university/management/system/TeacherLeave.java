package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cempId, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;

    TeacherLeave() {

        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setBounds(40, 50, 300, 30);
        add(heading);

        JLabel lblrollno = new JLabel("Search by Employee Id");
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblrollno.setBounds(60, 100, 200, 20);
        add(lblrollno);

        cempId = new Choice();
        cempId.setBounds(60, 130, 200, 20);
        add(cempId);

        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select * from teacher");
            while (rs.next()) {
                cempId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbldate.setBounds(60, 180, 200, 20);
        add(lbldate);
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltime.setBounds(60, 260, 200, 20);
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Submit");
        cancel.setBounds(60, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = cempId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String query = "insert into teacherleave values ('"+rollno+"','"+date+"','"+duration+"')";
            try {
                Conn con = new Conn();
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception o) {
                o.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] ar) {
        new TeacherLeave();
    }
}
