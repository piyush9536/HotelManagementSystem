
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

public class UpdateCheck extends JFrame implements ActionListener{

	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	
	UpdateCheck()
	{
		JLabel l1 = new JLabel("Check-in Details");
		l1.setBounds(70,20,200,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Customer ID");
		l2.setBounds(30,80,100,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l2);
		
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
		c1.setFont(new Font("Tahoma",Font.PLAIN,16));
		c1.setBounds(190,80,150,30);
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,120,120,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(190,120,150,30);
		t1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t1);
		
		JLabel l4 = new JLabel("Name");
		l4.setBounds(30,160,100,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(190,160,150,30);
		t2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t2);
		
		JLabel l5 = new JLabel("Check-In");
		l5.setBounds(30,200,100,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l5);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma",Font.PLAIN,16));
		t3.setBounds(190,200,150,30);
		add(t3);
		
		JLabel l6 = new JLabel("Amount Paid");
		l6.setBounds(30,240,100,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(190,240,150,30);
		t4.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t4);
		
		JLabel l7 = new JLabel("Pending Amount");
		l7.setBounds(30,280,120,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(190,280,150,30);
		t5.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t5);
		
		b1 = new JButton("Check");
		b1.setBounds(120,340,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(30,390,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Tahoma",Font.PLAIN,16));
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(190,390,120,30);
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setFont(new Font("Tahoma",Font.PLAIN,16));
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/10.jpg"));   
		JLabel l8 = new JLabel(img);
		l8.setBounds(380,10,450,400);
		add(l8);
		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,200,850,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try {
				String number = c1.getSelectedItem();
				String room=null;
				String deposit = null;
				String str = "select * from customer where number='"+number+"'";
				Conn c = new Conn();
				String s1 = c1.getSelectedItem();
				ResultSet rs = c.s.executeQuery(str);
				while(rs.next())
				{
					t1.setText(rs.getString("allocated_room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
					t4.setText(rs.getString("deposit"));
					room = rs.getString("allocated_room");
					deposit=rs.getString("deposit");
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+room+"'");
				String price = null;
				while(rs2.next())
				{
					price = rs2.getString("price");
				}
				int pending_amt = Integer.parseInt(price)-Integer.parseInt(deposit);
				String s3 = String.valueOf(pending_amt);
				t5.setText(s3);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			String id_num = c1.getSelectedItem();
			String room_num = t1.getText(); 
			String name = t2.getText();
			String check = t3.getText();
			String deposit = t4.getText();
			String pending = t5.getText();
		
			try {
				Conn c = new Conn();
				String str = "update customer set allocated_room='"+room_num+"', name='"+name+"', status='"+check+"', deposit='"+deposit+"' where number='"+id_num+"'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Update Sucessful");
				new Reception().setVisible(true);
				this.setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else if(ae.getSource()==b3)
		{
			new Reception().setVisible(true);
			this.setVisible(false);
		}
	}
	public static void main(String []args)
	{
		new UpdateCheck().setVisible(true);
	}
}
