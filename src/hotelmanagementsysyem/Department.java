
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Department extends JFrame implements ActionListener{

	JButton b1,b2;
	JTable t1;
	
	Department()
	{
		JLabel l1 = new JLabel("Department");
		l1.setBounds(160,10,250,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l3 = new JLabel("Department");
		l3.setBounds(70,60,100,20);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		l3.setForeground(Color.black);
		add(l3);
		
		JLabel l4 = new JLabel("Budget");
		l4.setBounds(330,60,100,20);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		l4.setForeground(Color.black);
		add(l4);
		
		t1 = new JTable();
		t1.setBounds(15,90,500,250);
		t1.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(t1);
		
		b1 = new JButton("Submit");
		b1.setBounds(80,350,150,30);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Tahoma",Font.PLAIN,16));
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250,350,150,30);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Tahoma",Font.PLAIN,16));
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(600,200,550,450);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Conn c = new Conn();
			String brand = "select * from department";
			try {
 				ResultSet rs = c.s.executeQuery(brand);
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
		new Department().setVisible(true);
	}
}

/*
CREATE TABLE department(
dept VARCHAR(40),
budget VARCHAR(40));

INSERT INTO department VALUES('Marketing','1100000'),
('Publicity','5000000'),
('Social Work','200000'),
('Repair and Maintainance','10000000');
*/