/**
 * 
 */
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

public class PickUp extends JFrame implements ActionListener{

	Choice c1;
	JButton b1,b2;
	JTable t1;
	
	PickUp()
	{
		JLabel l1 = new JLabel("Pick Up Service");
		l1.setBounds(400,10,250,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Type of Car");
		l2.setBounds(50,80,150,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l2);
		
		c1 = new Choice();
		try {
			String str = "select * from driver";
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(str);
			
			while(rs.next())
			{
				c1.add(rs.getString("model"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(200,80,150,30);
		c1.setFont(new Font("Tahoma",Font.PLAIN,16));
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(50,160,100,20);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		l3.setForeground(Color.black);
		add(l3);
		
		JLabel l4 = new JLabel("Age");
		l4.setBounds(0,160,100,20);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		l4.setForeground(Color.black);
		add(l4);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(330,160,100,20);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		l5.setForeground(Color.black);
		add(l5);
		
		JLabel l6 = new JLabel("Company");
		l6.setBounds(470,160,100,20);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		l6.setForeground(Color.black);
		add(l6);
		
		JLabel l7 = new JLabel("Model");
		l7.setBounds(620,160,100,20);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		l7.setForeground(Color.black);
		add(l7);
		
		JLabel l8 = new JLabel("Availability");
		l8.setBounds(750,160,100,20);
		l8.setFont(new Font("Tahoma",Font.PLAIN,14));
		l8.setForeground(Color.black);
		add(l8);
		
		JLabel l9 = new JLabel("Location");
		l9.setBounds(890,160,100,20);
		l9.setFont(new Font("Tahoma",Font.PLAIN,14));
		l9.setForeground(Color.black);
		add(l9);
		
		
		t1 = new JTable();
		t1.setBounds(0,180,1000,300);
		t1.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(t1);
		
		b1 = new JButton("Submit");
		b1.setBounds(300,500,150,30);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Tahoma",Font.PLAIN,16));
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(490,500,150,30);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Tahoma",Font.PLAIN,16));
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,200,1000,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Conn c = new Conn();
			String type = c1.getSelectedItem();
			String brand = "select * from driver where model='"+type+"'";
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
		new PickUp().setVisible(true);
	}
}

