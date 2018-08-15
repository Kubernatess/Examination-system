import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionDemo extends JFrame{
	public OptionDemo(int i){
		super("OptionDemo");
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(1,1));
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","sise");
			//System.out.println("连接成功！");
			conn.setAutoCommit(true);
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery("select * from OPTIONDEMO where no="+i);
			//System.out.println("查询成功！");
			JRadioButton A=new JRadioButton("A");
			JRadioButton B=new JRadioButton("B");
			JRadioButton C=new JRadioButton("C");
			JRadioButton D=new JRadioButton("D");
			ButtonGroup bg=new ButtonGroup();
			while(rs.next()){
				if(rs.getString("answer").equals("A"))A.setSelected(true);
			    if(rs.getString("answer").equals("B"))B.setSelected(true);
			    if(rs.getString("answer").equals("C"))C.setSelected(true);
			    if(rs.getString("answer").equals("D"))D.setSelected(true);
			}
			bg.add(A);bg.add(B);bg.add(C);bg.add(D);
			p.add(A);p.add(B);p.add(C);p.add(D);
			
			if(A.isSelected())stmt.executeUpdate("update optiondemo set answer='A' where no="+i);
			if(B.isSelected())stmt.executeUpdate("update optiondemo set answer='B' where no="+i);
			if(C.isSelected())stmt.executeUpdate("update optiondemo set answer='C' where no="+i);
			if(D.isSelected())stmt.executeUpdate("update optiondemo set answer='D' where no="+i);
			conn.setAutoCommit(true);
	        conn.commit();
			JLabel label=new JLabel(""+i+".");
			JPanel p2=new JPanel();
			JButton last=new JButton("上一题");
			if(i==1)last.setEnabled(false);
			last.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new OptionDemo(i-1);
					dispose();
				}
			});
			JButton next=new JButton("下一题");
			if(i==40)next.setEnabled(false);
			next.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new OptionDemo(i+1);
					dispose();
				}
			});
			p2.setLayout(new GridLayout(1,1));
			p2.add(last);
			p2.add(next);
			add(label,"North");
			add(p);
			add(p2,"South");
			setLocation(1000, 120);
	        setSize(200,100);
	        setVisible(true); 
	        setResizable(false);
	        setAlwaysOnTop(true);
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String args[]){
		new OptionDemo(1);
	}
}
