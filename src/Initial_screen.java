import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;


class Initial_screen extends JFrame {
	
	public Initial_screen() { //생성자
		
		setTitle("초기 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		  
		//BorderLayout.CENTER
		JPanel p_background = new JPanel(new GridLayout()); //메인화면 백그라운드색_흰색   
		p_background.setBackground(Color.white);
		c.add(p_background);
		  
		//BorderLayout.NORTH
		JPanel p_north = new JPanel(new FlowLayout());
		p_north.setBackground(new Color(255, 158, 60));//주황색
		c.add(p_north,BorderLayout.NORTH);
		  
		//BorderLayout.SOUTH
		JPanel p_south = new JPanel(new GridLayout());         
		p_south.setBackground(new Color(255, 158, 60)); //주황색
		c.add(p_south,BorderLayout.SOUTH);

				
		//image
		JLabel screen = new JLabel (new ImageIcon("./images/img/initial_pic.png")); //키오스크 메인화면
		p_background.add(screen);
		  
		JLabel logo = new JLabel(new ImageIcon("./images/img/logo_transparent.png")); //동국킹버거 로고    
		p_north.add(logo);
		
		//매장식사, 포장 버튼
		JToggleButton eatin_btn = new JToggleButton("매장 식사");
		eatin_btn.setBounds(0, 665, 300, 100); 
		eatin_btn.setBackground(new Color(255, 158, 60)); 
		eatin_btn.setForeground(Color.white); 
		eatin_btn.setBorder(BorderFactory.createLineBorder(Color.white)); 
		eatin_btn.setFont(new Font("Dialog", Font.BOLD, 40)); 
		p_south.add(eatin_btn, BorderLayout.WEST);
		  
		JButton eatout_btn = new JButton("포장 하기");
		eatout_btn.setBounds(300, 665, 300, 100);
		eatout_btn.setBackground(new Color(255, 158, 60));
		eatout_btn.setForeground(Color.white); 
		eatout_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		eatout_btn.setFont(new Font("Dialog", Font.BOLD, 40)); 
		p_south.add(eatout_btn,BorderLayout.EAST);	   
		  
		  
		//event------------------------------------------		  
		eatin_btn.addActionListener(new ActionListener() {//매장 식사 버튼 누르면 
		      public void actionPerformed(ActionEvent e) {	 
		    	  Menu m = new Menu("매장", new ArrayList<>(Arrays.asList("0","0","0","0","0","0")));
		    	  m.setVisible(true); //메뉴창(Menu) 열고		    	  
		    	  setVisible(false); // 초기화면(Initial_screen) 닫고
		      }
		  });
		  
		eatout_btn.addActionListener(new ActionListener() {//포장하기 버튼 누르면
		      public void actionPerformed(ActionEvent e) {
		    	  Menu m = new Menu("포장", new ArrayList<>(Arrays.asList("0","0","0","0","0","0")));
		    	  m.setVisible(true); //메뉴창(Menu) 열고		    	 
		    	  setVisible(false); // 초기화면(Initial_screen) 닫고
		      }
		   });      	      
			      
	    // 프레임 크기 ----------------------------------
		setSize(600, 800);
		this.setLocation(500, 20);
		setVisible(true);
	      
	}
	 
}
