
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{

	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	UpdateRoom()
	{
		JLabel l1 = new JLabel("Update Room Status");
		l1.setBounds(50,20,300,30);
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		add(l1);
		
		JLabel l2 = new JLabel("Guest ID");
		l2.setForeground(Color.black);
		l2.setBounds(30,80,120,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l2);
		
		c1 = new Choice();
		try {
			String str = "select * from customer";
			Conn c = new Conn();
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
		c1.setBounds(200,80,150,30);
		c1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(c1);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,130,120,30);
		l3.setForeground(Color.black);
		l3.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,130,150,30);
		t1.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t1);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(30,180,120,30);
		l4.setForeground(Color.black);
		l4.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,180,150,30);
		t2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t2);
		
		JLabel l5 = new JLabel("Cleaning Status");
		l5.setBounds(30,230,120,30);
		l5.setForeground(Color.black);
		l5.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l5);

		t3 = new JTextField();
		t3.setBounds(200,230,150,30);
		t3.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(t3);
		
		b1 = new JButton("Check");
		b1.setBounds(130,310,120,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(40,360,120,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(210,360,120,30);
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/9.jpg"));
		Image img2 = img.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel j1 = new JLabel(img3);
		j1.setBounds(0,0,800,550);
		add(j1);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(450,200,800,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String room = null;
			String s1 = c1.getSelectedItem();
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where number='"+s1+"'");
				while(rs.next())
				{
					room  = rs.getString("allocated_room");
					t1.setText(rs.getString("allocated_room"));
				}
				ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+room+"'");
				while(rs2.next())
				{
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			try {
				String room = t1.getText();
				String new_avai = t2.getText();
				String new_status = t3.getText();
				
				Conn c = new Conn();
//				String s1 = "select * from room where room_number='"+room+"'";
//				ResultSet rs = c.s.executeQuery(s1);
//				
//				while(rs.next())
//				{
					String s2 = "update room set available='"+new_avai+"', status='"+new_status+"' where room_number='"+room+"'";  
					c.s.executeUpdate(s2);
					JOptionPane.showMessageDialog(null,"Room Updated Successfully");
					new Reception().setVisible(true);
					this.setVisible(false);
			//	}
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
		new UpdateRoom().setVisible(true);
	}
}
