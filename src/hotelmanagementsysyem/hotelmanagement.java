/**
 * 
 */
package hotelmanagementsysyem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hotelmanagement extends JFrame implements ActionListener {

	hotelmanagement(){
	 
	 	setSize(1366,565);
		setLocation(100,200);
		System.out.println("testing");
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsysyem/icons/1.jpg"));
		
		JLabel l1=new JLabel(i1);
		l1.setBounds(0,0,1366,565);
		add(l1);
		JLabel l2 = new JLabel("Hotel Management System");
		l2.setBounds(20,420,1000,90);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l1.add(l2);
		
		JButton b1 = new JButton("Next");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1150,440,150,50);
		b1.addActionListener(this);
		l1.add(b1);
		setLayout(null);
		setVisible(true);
 	}
 
	public void actionPerformed(ActionEvent ae)
	{
		new login().setVisible(true);
		this.setVisible(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new hotelmanagement();
	}
 
 
 
}
