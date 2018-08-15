import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Exam_mode extends JFrame{
	public Exam_mode() throws IOException{
		super("Java Test");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(8,1));
		JLabel portrait=new JLabel(new ImageIcon("images\\portrait.jpg"));
		JLabel name=new JLabel("������");
		JLabel permit=new JLabel("׼��֤��");
		JLabel sex=new JLabel("�Ա�");
		JLabel area=new JLabel("������");
		p.add(portrait);
		p.add(name);
		p.add(permit);
		p.add(sex);
		p.add(area);
		add(p,"East");
		JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout());
		JTextArea textarea=new JTextArea(4,110);
		textarea.setFont(new Font("����",Font.PLAIN,22));
		textarea.setLineWrap(true);
		textarea.setEditable(false);
		JScrollPane jsp=new JScrollPane(textarea);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		try {
			BufferedReader br=new BufferedReader(new FileReader("Java Test.txt"));
			String result=null;
			while((result=br.readLine())!=null){
				 textarea.append(result+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		p2.add(jsp);
		
		JButton submit=new JButton("�ύ�Ծ�");
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i=JOptionPane.showConfirmDialog(submit, "��ȷ��Ҫ�ύ�Ծ���",
						"ȷ��", JOptionPane.OK_CANCEL_OPTION );
			}
		});
		p2.add(submit,"South");
		add(p2,"West");
	
		pack();
		setResizable(false);
		setVisible(true);
		setBounds(100,100,1400,900); 
	}
	public static void main(String args[]) throws IOException{
		new Exam_mode();
	}
}
