
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
		super(f, "����", true);
		JTextArea textarea=new JTextArea("Java��һ�ֿ���׫д��ƽ̨Ӧ��������������ĳ���������ԣ�����Sun Microsystems��˾��1995��5���Ƴ���Java����������Ժ�Javaƽ̨����JavaSE, JavaEE, JavaME�����ܳơ�");
		textarea.setFont(new Font("΢���ź�",Font.BOLD,22));
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
