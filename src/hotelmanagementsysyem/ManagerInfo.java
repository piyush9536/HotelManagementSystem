
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.*;

public class ManagerInfo extends JFrame implements ActionListener {

	JTable t1;
	JButton b1,b2;
	
	ManagerInfo()
	{
		t1 = new JTable();
		t1.setBounds(5,40,1000,500);
		add(t1);
		
		JLabel name = new JLabel("Name");
		name.setBounds(40,10,70,20);
		add(name);
		
		JLabel age = new JLabel("Age");
		age.setBounds(170,10,70,20);
		add(age);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(290,10,70,20);
		add(gender);
		
		JLabel department = new JLabel("Department");
		department.setBounds(400,10,70,20);
		add(department);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(540,10,70,20);
		add(salary);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(660,10,70,20);
		add(phone);
		
		JLabel adhar = new JLabel("Adhar");
		adhar.setBounds(780,10,70,20);
		add(adhar);
		
		JLabel email = new JLabel("Email");
		email.setBounds(900,10,70,20);
		add(email);
		
		
		b1 = new JButton("Load Data");
		b1.setBounds(350,550,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Tahoma",Font.PLAIN,14));
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(480,550,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Tahoma",Font.PLAIN,14));
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,150,1010,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try {
				Conn c = new Conn();
				String str = "Select * from employee where job='Manager'";
				ResultSet rs = c.s.executeQuery(str);
				
				// Using DbUtils method to show tables. external jar file is added for this class. 
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String []args)
	{
		new ManagerInfo().setVisible(true);
	}
	
}

