import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Test extends JFrame{
	public Test() throws IOException{
		super("Java考试模拟系统");
		JPanel p1=new JPanel();
		JButton btn1=new JButton("练习模式");
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
		JButton btn2=new JButton("考试模式");
		JDialog login=new Login(this);		
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				login.setVisible(true);
			}
		});
		JButton btn3=new JButton("考试须知");
		JDialog inform=new Information(this);		
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				inform.setVisible(true);
			}
		});
		JButton btn4=new JButton("介绍");
		JDialog describe=new DescribeDemo(this);
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				describe.setVisible(true);
			}
		});
		JButton btn5=new JButton("退出系统");
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		p1.setLayout(new GridLayout(5,1));
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.add(btn4);
		p1.add(btn5);
		add(p1,"East");
		String path="images\\image2.jpg";
		JLabel image=new JLabel(new ImageIcon(path));
		add(image,"West");
		setLocation(200,200);
		setSize(760, 800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String args[]) throws IOException{
		new Test();
	}
	
}
