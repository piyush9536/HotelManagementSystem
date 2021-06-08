
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

public class CustomerInfo extends JFrame implements ActionListener {

	JTable t1;
	JButton b1,b2;
	
	CustomerInfo()
	{
		t1 = new JTable();
		t1.setBounds(5,40,1000,500);
		add(t1);
		
		JLabel id = new JLabel("ID");
		id.setBounds(50,10,70,20);
		add(id);
		
		JLabel number = new JLabel("Number");
		number.setBounds(170,10,70,20);
		add(number);
		
		JLabel name = new JLabel("Name");
		name.setBounds(290,10,70,20);
		add(name);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(400,10,70,20);
		add(gender);
		
		JLabel country = new JLabel("Country");
		country.setBounds(540,10,70,20);
		add(country);
		
		JLabel allocated = new JLabel("Allocated_room");
		allocated.setBounds(640,10,100,20);
		add(allocated);
		

		JLabel status = new JLabel("Status");
		status.setBounds(800,10,70,20);
		add(status);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(900,10,70,20);
		add(deposit);
		
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
				String str = "Select * from customer";
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
		new CustomerInfo().setVisible(true);
	}
	
}


