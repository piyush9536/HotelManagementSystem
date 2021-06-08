
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1,b2;
	
	AddDriver()
	{
		JLabel title = new JLabel("ADD DRIVER");
		title.setBounds(150,20,300,50);
		title.setFont(new Font("Tahoma",Font.BOLD,24));
		add(title);
		
		JLabel name = new JLabel("Name");
		name.setBounds(60,80,100,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(190,80,150,30);
		add(t1);
		
		JLabel age = new JLabel("Age");
		age.setBounds(60,120,100,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(190,120,150,30);
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(60,160,100,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(gender);
		
		c1 = new JComboBox(new String[] {"Male","Female"});
		c1.setBounds(190,160,150,30);
		c1.setBackground(Color.white);
		add(c1);
		
		JLabel car = new JLabel("Car Company");
		car.setBounds(60,200,100,30);
		car.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(190,200,150,30);
		add(t3);
		
		JLabel model = new JLabel("Car Model");
		model.setBounds(60,240,100,30);
		model.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(model);
		
		t4 = new JTextField();
		t4.setBounds(190,240,150,30);
		add(t4);
		
		JLabel available = new JLabel("Available");
		available.setBounds(60,280,100,30);
		available.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(available);
		
		c2 = new JComboBox(new String[] {"Available","Busy"});
		c2.setBackground(Color.white);
		c2.setBounds(190,280,150,30);
		add(c2);
		
		
		JLabel location = new JLabel("Location");
		location.setBounds(60,320,100,30);
		location.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(190,320,150,30);
		add(t5);	
		
		b1 = new JButton("Add Driver");
		b1.setBounds(60,370,130,30);
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(210,370,130,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/6.jpg"));   
		Image img2 = img.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel j1 = new JLabel(img3);
		j1.setBounds(400,70,500,350);
		add(j1);		
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		setBounds(400,200,970,470);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			String name = t1.getText();
			String age = t2.getText();
			String gender =(String)c1.getSelectedItem();
			String company = t3.getText();
			String model = t4.getText();
			String available = (String)c2.getSelectedItem();
			String location = t5.getText();
			
			Conn c = new Conn();
			try {
				String str = "insert into driver values('"+name+"' ,'"+age+"' ,'"+gender+"' ,'"+company+"' ,'"+model+"' ,'"+available+"' ,'"+location+"')";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver Successfully Added");
				this.setVisible(false);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
	}
	
	public static void main(String []args)
	{
		new AddDriver().setVisible(true);
	}
}
/*
CREATE TABLE driver(
name VARCHAR(30),
age VARCHAR(10),
gender VARCHAR(30),
company VARCHAR(30),
model VARCHAR(30),
available VARCHAR(30),
location VARCHAR(30)
);
 */