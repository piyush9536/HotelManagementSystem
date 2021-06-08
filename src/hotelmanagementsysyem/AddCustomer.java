
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4,t5;
	JComboBox c1;
	JButton b1,b2;
	Choice c2; 
	JRadioButton r1,r2;
	
	AddCustomer()
	{
		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100,20,300,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel id = new JLabel("ID");
		id.setBounds(40,80,100,20);
		id.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(id);
		
		c1 = new JComboBox(new String[] {"Aadhar Card","Pan Card","Passport","Voter-id Card","Driving Licence"});   
		c1.setBounds(200,80,150,25);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel number = new JLabel("Number");
		number.setBounds(40,120,100,20);
		number.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(number);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		add(t1);

		JLabel name = new JLabel("Name");
		name.setBounds(40,160,100,20);
		name.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(name);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(40,200,100,20);
		gender.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,200,65,25);
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(270,200,75,25);
		r2.setBackground(Color.white);
		add(r2);		
		
		JLabel country = new JLabel("Country");
		country.setBounds(40,240,100,20);
		country.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(country);
		
		t3 = new JTextField();
		t3.setBounds(200,240,150,25);
		add(t3);
		
		JLabel allocate = new JLabel("Allocated Room");
		allocate.setBounds(40,280,150,20);
		allocate.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(allocate);
		
		c2 = new Choice();
		try {
			Conn c = new Conn();
			String str = "select * from room";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next())
			{
				c2.add(rs.getString("room_number"));	
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		c2.setBounds(200,280,150,25);
		add(c2);
		
		JLabel checkin = new JLabel("Checked In");
		checkin.setBounds(40,320,100,20);
		checkin.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(checkin);
		
		t4 = new JTextField();
		t4.setBounds(200,320,150,25);
		add(t4);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(40,360,100,20);
		deposit.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(deposit);
		
		t5 = new JTextField();
		t5.setBounds(200,360,150,25);
		add(t5);
		
		b1 = new JButton("Add Customer");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Tahoma",Font.PLAIN,14));
		b1.setBounds(40,400,150,25);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Tahoma",Font.PLAIN,14));
		b2.setBounds(200,400,150,25);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/8.png"));  
		Image img2 = img.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel l3 = new JLabel(img3);
		l3.setBounds(370,20,500,400);
		add(l3);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(500,200,900,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String id = (String)c1.getSelectedItem();
			String number = t1.getText();
			String name = t2.getText();
			String gender = null;
			if(r1.isSelected())
			{
				gender = "Male";
			}
			else if(r2.isSelected()) 
			{
				gender = "Female";
			}
			String country = t3.getText();
			String allocated_room = c2.getSelectedItem();
			String checkin = t4.getText();
			String deposit = t5.getText();
			
			try {
				String str ="insert into customer values('"+id+"' ,'"+number+"' ,'"+name+"' ,'"+gender+"' ,'"+country+"' ,'"+allocated_room+"' ,'"+checkin+"' ,'"+deposit+"')";
				String str2 = "update room set available='Occupied' WHERE room_number='"+allocated_room+"'";
				Conn c = new Conn();
				
				c.s.executeUpdate(str);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null,"Customer Successfully Added");
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
	}
	public static void main(String []args)
	{
		new AddCustomer().setVisible(true);
	}
}

/*
CREATE TABLE customer(
id VARCHAR(50),
number VARCHAR(50),
name VARCHAR(50),
gender VARCHAR(15),
country VARCHAR(20),
allocated_room VARCHAR(10),
status VARCHAR(20),
deposit VARCHAR(20)
);
 */



