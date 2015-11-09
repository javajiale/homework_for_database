package cn.edu.zucc.booklib.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import cn.edu.zucc.booklib.control.SystemUserManager;

public class FrmMain extends JFrame implements ActionListener {
	private JMenuBar menubar=new JMenuBar(); ;
    private JMenu menu_UserManager=new JMenu("用户信息管理");
    private JMenu menu_search=new JMenu("查询");
    private JMenuItem  menuItem_AddUserMessage = new JMenuItem("用户信息增加");
    private JMenuItem  menuItem_UpdateMessage = new JMenuItem("用户信息更新");
    private JMenuItem  menuItem_DeleteMessage = new JMenuItem("用户信息删除");
    private JMenuItem  menuItem_student = new JMenuItem("查询student变化");
    
	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	public FrmMain(){
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("学生管理系统");
		dlgLogin=new FrmLogin(this,"登陆",true);
		dlgLogin.setVisible(true);
	    //菜单
	    menu_UserManager.add(this.menuItem_AddUserMessage);
	    menuItem_AddUserMessage.addActionListener(this);
	    menu_UserManager.add(this.menuItem_UpdateMessage);
	    menuItem_UpdateMessage.addActionListener(this);
	    menu_UserManager.add(this.menuItem_DeleteMessage);
	    menuItem_DeleteMessage.addActionListener(this);
	    menubar.add(menu_UserManager);
	    menu_search.add(this.menuItem_student);
	    menuItem_student.addActionListener(this);
	    menubar.add(this.menu_search);
	    this.setJMenuBar(menubar);
	    
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		System.exit(0);
             }
        });
	    this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.menuItem_AddUserMessage){
			
		}
		else if(e.getSource()==this.menuItem_UpdateMessage){
			
		}
		else if(e.getSource()==this.menuItem_DeleteMessage){
			
		}
		else if(e.getSource()==this.menuItem_student){
			
		}
		
	}
}
