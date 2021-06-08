
package hotelmanagementsysyem;

import java.awt.Font;

/**
 * @author PIYUSH
 *
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener{

	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	CheckOut()
	{
		JLabel l1 = new JLabel("Check-Out");
		l1.setBounds(80,25,200,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.blue);
		add(l1);
		
		JLabel l3 = new JLabel("Customer-Id");
		l3.setBounds(30,100,120,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l3);
		
		c1 = new Choice();
		try {
			Conn c = new Conn();
			String str = "select * from customer";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next())
			{
				c1.add(rs.getString("number"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		c1.setBounds(150,100,150,30);
		c1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(c1);
		
		JLabel l4 = new JLabel("Room Number");
		l4.setBounds(30,160,120,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l4);
		
		t1 = new JTextField();
		t1.setBounds(150,160,150,30);
		t1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t1);
		
		b1 = new JButton("Check-out");
		b1.setBounds(35,210,110,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Tahoma",Font.PLAIN,16));
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(175,210,110,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(b2);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/11.png"));   
		Image img2 = img.getImage().getScaledInstance(40, 30, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		b3 = new JButton(img3);
		b3.setBounds(310,100,40,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img4 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/12.jpg"));
		JLabel l5 = new JLabel(img4);
		l5.setBounds(360,0,400,400);
		add(l5);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,200,790,400);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String room = null;
			String id = c1.getSelectedItem();
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where number='"+id+"'");
				
				while(rs.next())
				{
					room = rs.getString("allocated_room");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			String del_customer = "delete from customer where number='"+id+"'"; 
			String room_cond="update room set available='Available' , status='Dirty' where room_number='"+room+"'";          
			try {
				c.s.executeUpdate(del_customer);
				c.s.executeUpdate(room_cond);
				JOptionPane.showMessageDialog(null, "Check-out done");
				new Reception().setVisible(true);
				this.setVisible(false);
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
		else if(ae.getSource()==b3)
		{	
			String s1 = c1.getSelectedItem();
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where number='"+s1+"'");
				
				while(rs.next())
				{
					t1.setText(rs.getString("allocated_room"));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	public static void main(String []args)
	{
		new CheckOut().setVisible(true);
	}
}
