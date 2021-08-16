import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IssueBook extends JFrame{
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
	private JTextField txt1,txt2,txt3,txt4,txt5;
	private JButton btn,btnBack;
	
	IssueBook(){
		setBounds(400,200,400,480);
		setTitle("Enter Details");
		setLayout(null);     
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intiComponents();
	}
	
	public void intiComponents() {
		
		lbl1 = new JLabel("UserID");
		lbl1.setBounds(30,15,100,40);
		add(lbl1);
		
		lbl2 = new JLabel("BookID");
		lbl2.setBounds(30,75,100,40);
		add(lbl2);
		
		lbl3 = new JLabel("Issue Id");
		lbl3.setBounds(30,135,100,40);
		add(lbl3);
		
		lbl4 = new JLabel("Period");
		lbl4.setBounds(30,195,100,40);
		add(lbl4);
		
		lbl5 = new JLabel("Issue Date");
		lbl5.setBounds(30,255,100,40);
		add(lbl5);
		
		txt1 = new JTextField("");
		txt1.setBounds(130,15,200,40);
		add(txt1);
		txt1.setToolTipText("Enter UserID");
		
		txt2 = new JTextField("");
		txt2.setBounds(130,75,200,40);
		add(txt2);
		txt2.setToolTipText("Enter BookID");
		
		txt3 = new JTextField("");
		txt3.setBounds(130,135,200,40);
		add(txt3);
		txt3.setToolTipText("Enter Days No.");
		
		txt4 = new JTextField("");
		txt4.setBounds(130,195,200,40);
		add(txt4);
		txt4.setToolTipText("DD/MM/YY");
		
		txt5 = new JTextField("");
		txt5.setBounds(130,255,200,40);
		add(txt5);
		//txt4.setToolTipText("DD/MM/YY");
		
		btn = new JButton("Confirm");
		btn.setBounds(50,315,120,40);
		add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btn){
					setVisible(false);
					ViewBooks bo = new ViewBooks();
					bo.setVisible(true);
				}	
			}
		});
		
		btnBack = new JButton("Back");
		btnBack.setBounds(180,315,120,40);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnBack){
					setVisible(false);
					HomePage h = new HomePage();
					h.setVisible(true);
				}
			}
		});
		add(btnBack);
	}	
	}
	
