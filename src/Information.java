import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Information extends JDialog {
	public Information(JFrame f) throws IOException{
		super(f, "Inform", true);
		JPanel p=new JPanel();
		p.setLayout(new BorderLayout());
		JTextArea textarea=new JTextArea();
		textarea.setFont(new Font("黑体",Font.PLAIN,36));
		textarea.setLineWrap(true);
		textarea.setEditable(false);
		JScrollPane jsp=new JScrollPane(textarea);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		try {
			BufferedReader br=new BufferedReader(new FileReader("inform.txt"));
			String result=null;
			while((result=br.readLine())!=null){
				 textarea.append(result+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		p.add(jsp);
		add(p);
		pack();
		setResizable(false);
		setLocation(250,250);
		setSize(650, 600);
	}
	/*public static void main(String[] args) {
		new DecribeDemo();
	}*/
}
