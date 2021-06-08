
package hotelmanagementsysyem;

/**
 * @author PIYUSH
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	Dashboard()
	{
		mb = new JMenuBar();
		add(mb);

		m1=new JMenu("Hotel Management");
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2=new JMenu("Admin");
		m2.setForeground(Color.BLUE);
		mb.add(m2);
		
		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("Add Employee");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3 = new JMenuItem("Add Rooms");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("Add Drivers");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0,0,1950,30);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/3.jpg"));
		Image img2 = img.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
		ImageIcon img3 = new ImageIcon(img2);
		JLabel l1 = new JLabel(img3);
		l1.setBounds(0,0,1950,1000);
		add(l1);
		
		JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
		l2.setBounds(500,50,800,60);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("tahoma",Font.PLAIN,40));
		l1.add(l2);
		
		setLayout(null);
		setBounds(0,0,1950,1000);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Reception"))
		{
			new Reception().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Employee"))
		{
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Rooms"))
		{
			new AddRooms().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Drivers"))
		{
			new AddDriver().setVisible(true);
		}
	}
	
	public static void main(String []args)
	{
		new Dashboard().setVisible(true);
	}
	
}
