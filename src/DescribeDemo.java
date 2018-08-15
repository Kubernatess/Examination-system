
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DescribeDemo extends JDialog {
	public DescribeDemo(JFrame f){
		super(f, "介绍", true);
		JTextArea textarea=new JTextArea("Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。");
		textarea.setFont(new Font("微软雅黑",Font.BOLD,22));
		textarea.setLineWrap(true);
		textarea.setEditable(false);	
		add(textarea);
		pack();
		setResizable(false);
		setLocation(250,250);
		setSize(310, 300);
	}
	/*public static void main(String[] args) {
		new DecribeDemo();
	}*/
}
