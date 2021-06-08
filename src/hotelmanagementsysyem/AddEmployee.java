
package hotelmanagementsysyem;

import java.awt.*;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1;
	
	AddEmployee()
	{
		//First label
		JLabel name = new JLabel("NAME");
		name.setBounds(60,30,120,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(180,30,150,30);
		add(t1);
		
		// Second level
		JLabel age = new JLabel("AGE");
		age.setBounds(60,80,120,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(180,80,150,30);
		add(t2);
		
		// Third level
		JLabel gender = new JLabel("GENDER");
		gender.setBounds(60,130,120,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(gender);
		
		r1=new JRadioButton("Male");
		r1.setBounds(180,130,70,30);
		r1.setFont(new Font("Tahoma",Font.PLAIN,14));
		r1.setBackground(Color.white);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(260,130,70,30);
		r2.setBackground(Color.white);
		r2.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(r2);

		// Fourth level
		JLabel job = new JLabel("JOB");
		job.setBounds(60,180,120,30);
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(job);
		
		String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.white);
		c1.setBounds(180,180,150,30);
		add(c1);
		
		// Fifth level
		JLabel salary = new JLabel("SALARY");
		salary.setBounds(60,230,120,30);
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(180,230,150,30);
		add(t3);
		
		// Sixth level
		JLabel phone = new JLabel("PHONE");
		phone.setBounds(60,280,120,30);
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(phone);

		t4 = new JTextField();
		t4.setBounds(180,280,150,30);
		add(t4);
		
		// Seventh level
		JLabel adhar = new JLabel("ADHAR");
		adhar.setBounds(60,330,120,30);
		adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(adhar);

		t5 = new JTextField();
		t5.setBounds(180,330,150,30);
		add(t5);
		
		// Eight level
		JLabel email = new JLabel("EMAIL");
		email.setBounds(60,380,120,30);
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(email);

		t6 = new JTextField();
		t6.setBounds(180,380,150,30);
		add(t6);
		
		//Ninth  level
		b1 = new JButton("SUBMIT");
		b1.setBounds(180,430,150,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/4.jpg"));
		Image img2 = img.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel j1 = new JLabel(img3);
		j1.setBounds(380,80,450,450);
		add(j1);
		
		JLabel j2 = new JLabel("ADD EMPLOYEE DETAILS");
		j2.setBounds(420,30,400,50);
		j2.setFont(new Font("tahoma",Font.BOLD,26));
		add(j2);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(430,200,850,540);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String name = t1.getText();
		String age = t2.getText();
		String salary = t3.getText();
		String phone = t4.getText();
		String adhar = t5.getText();
		String email = t6.getText();
		
		String gender = null;
		if(r1.isSelected())
		{
			gender="Male";
		}
		else if(r2.isSelected())
		{
			gender="Female";
		}
		
		String job = (String)c1.getSelectedItem();
		
		Conn c = new Conn();
		
		String str = "insert into employee VALUES('"+name+"' ,'"+age+"' ,'"+gender+"' ,'"+job+"' ,'"+salary+"' ,'"+phone+"' ,'"+adhar+"' ,'"+email+"')";
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "New Employee Successfully added");
			this.setVisible(false);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private Object JOptionPane() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String []args)
	{
		new AddEmployee();
	}
}
