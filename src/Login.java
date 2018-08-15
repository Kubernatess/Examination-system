import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JDialog{
	public Login(JFrame f){
		super(f,"User Login",true); 
        //����ͼƬ��·���������·�����߾���·��������ͼƬ����"java��Ŀ��"���ļ��£�  
        String path="images\\login.jpg";  
        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
        JLabel image=new JLabel(new ImageIcon(path));  
        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
        image.setBounds(0, 0,getWidth(),getHeight()/2);  
        JLabel id=new JLabel("User ID");
        JLabel pwd=new JLabel("Password");
        JTextField text_id=new JTextField(30);
        JPasswordField text_pwd=new JPasswordField(30);
        JButton login=new JButton("Login");
        login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(text_id.getText().equals("1640706235")){
					if(String.valueOf(text_pwd.getPassword()).equals("sise")){
						dispose();
						try {
							new Exam_mode();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						new OptionDemo(1);
					}
					else {
						JOptionPane.showMessageDialog(login, "����������������", "��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						text_pwd.setText("");
					}
				}
				else {
					JOptionPane.showMessageDialog(login, "���˺���Ϣ�����ڣ�", "��Ϣ",JOptionPane.INFORMATION_MESSAGE);
					text_id.setText("");
					text_pwd.setText("");
				}
			}
		});
        JButton quit=new JButton("Quit");
        quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        p1.add(id);
        p1.add(text_id);
        p2.add(pwd);
        p2.add(text_pwd);
        p3.add(login);
        p3.add(quit);
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(3,1));
        p.add(p1);
        p.add(p2);
        p.add(p3);
        setLayout(new GridLayout(2,1));
        add(image);
        add(p);
        setLocation(250, 230);
        setSize(600,500);
        //setVisible(true); 
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	/*public static void main(String args[]){
		new Login();
	}*/
}
