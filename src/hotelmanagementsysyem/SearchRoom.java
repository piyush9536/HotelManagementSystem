
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

public class SearchRoom extends JFrame implements ActionListener{

	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	
	SearchRoom()
	{
		JLabel l1 = new JLabel("Search for Room");
		l1.setBounds(400,10,250,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,24));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		JLabel l2 = new JLabel("Room Bed Type");
		l2.setBounds(50,80,150,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(l2);
		
		c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});	
		c1.setBounds(200,80,150,30);
		c1.setFont(new Font("Tahoma",Font.PLAIN,16));
		c1.setBackground(Color.white);
		add(c1);
		
		c2 = new JCheckBox("Only display Available");
		c2.setBounds(650,80,250,30);
		c2.setFont(new Font("Tahoma",Font.PLAIN,16));
		c2.setBackground(Color.white);
		add(c2);
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(50,160,100,20);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		l3.setForeground(Color.black);
		add(l3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(270,160,100,20);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		l4.setForeground(Color.black);
		add(l4);
		
		JLabel l5 = new JLabel("Cleaning Status");
		l5.setBounds(440,160,100,20);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		l5.setForeground(Color.black);
		add(l5);
		
		JLabel l6 = new JLabel("Price");
		l6.setBounds(680,160,100,20);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		l6.setForeground(Color.black);
		add(l6);
		
		JLabel l7 = new JLabel("Bed Type");
		l7.setBounds(850,160,100,20);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		l7.setForeground(Color.black);
		add(l7);
		
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
			String type = (String) c1.getSelectedItem();
			String room = "select * from room where bed_type='"+type+"'";
			String avai_room = "select * from room where bed_type='"+type+"' AND available='Available'";    
 			try {
 				if(c2.isSelected())
 				{
 					ResultSet rs2 = c.s.executeQuery(avai_room);
 					t1.setModel(DbUtils.resultSetToTableModel(rs2));
 				}
 				else 
 				{
 					ResultSet rs = c.s.executeQuery(room);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
 				}
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
		new SearchRoom().setVisible(true);
	}
}
