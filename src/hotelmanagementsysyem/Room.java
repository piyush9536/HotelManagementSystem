
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.sql.*;

public class Room extends JFrame implements ActionListener{

	JTable t1;
	JButton b1,b2;
	
	Room()
	{
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/5.jpg"));
		JLabel l1 = new JLabel(img);
		l1.setBounds(500,0,500,500);
		add(l1);
	
		JLabel l2 = new JLabel("ROOM INFORMATION");
		l2.setBounds(150,5,300,20);
		l2.setFont(new Font("Tahoma",Font.BOLD,18));
		add(l2);
		
		JLabel number = new JLabel("Room Number");
		number.setBounds(10,30,120,20);
		add(number);
		
		JLabel available = new JLabel("Availability");
		available.setBounds(120,30,120,20);
		add(available);
		
		JLabel status = new JLabel("Status");
		status.setBounds(220,30,120,20);
		add(status);
		
		JLabel price = new JLabel("Price");
		price.setBounds(330,30,120,20);
		add(price);
		
		JLabel btype = new JLabel("Bed Type");
		btype.setBounds(410,30,120,20);
		add(btype);
		
		t1 = new JTable();
		t1.setBounds(5,50,490,400);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setBounds(100,480,100,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(250,480,100,30);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(350,200,1010,550);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Conn c = new Conn();
			String str = "select * from room";
			try
			{
				ResultSet rs = c.s.executeQuery(str);
				
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
		new Room().setVisible(true);
	}
}
