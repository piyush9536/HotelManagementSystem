
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{

	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	JPasswordField t2;
	
	login()
	{
		l1 = new JLabel("UserName:");
		l1.setBounds(40,20,100,30);
		l1.setFont(new Font("serif",Font.BOLD,16));
		l1.setBackground(Color.WHITE);
		add(l1);
		
		l2 = new JLabel("Password:");
		l2.setBounds(40,70,100,30);
		l2.setFont(new Font("serif",Font.BOLD,16));
		l2.setBackground(Color.white);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(140,20,140,30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(140,70,140,30);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(30,150,100,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(170,150,100,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/2.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel j3 = new JLabel(i3);
		j3.setBounds(350,20,200,200);
		add(j3);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(500,200,600,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String username=t1.getText();
			String password=t2.getText();
			
			Conn c1 = new Conn();
			String str = "SELECT * FROM login WHERE username='"+username+"' and password='"+password+"'";
			try {
				ResultSet rs = c1.s.executeQuery(str);
				
				if(rs.next())
				{
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
//					this.setVisible(false);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==b2)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new login();
	}

}
