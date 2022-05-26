import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JPanel p_background = new JPanel(new GridLayout());      
		p_background.setBackground(Color.white);
		c.add(p_background);
		  
		//BorderLayout.NORTH
		JPanel p_north = new JPanel(new FlowLayout());
		p_north.setBackground(new Color(255, 158, 60));
		c.add(p_north,BorderLayout.NORTH);
		  
		//BorderLayout.SOUTH
		JPanel p_south = new JPanel(new GridLayout());         
		p_south.setBackground(new Color(255, 158, 60));      
		c.add(p_south,BorderLayout.SOUTH);
		  
		//p_background
		JLabel screen = new JLabel (new ImageIcon("./images/img/initial_screen2.png"));
		p_background.add(screen);
		  
		//p_north title
		JLabel logo = new JLabel(new ImageIcon("./images/img/logo_transparent.png"));     
		p_north.add(logo);
		
		  
		  
		//매장식사, 포장 버튼
		JToggleButton eatin_btn = new JToggleButton("매장 식사");
		eatin_btn.setBounds(0, 665, 300, 100); //위치
		eatin_btn.setBackground(new Color(255, 158, 60)); //글자 색
		eatin_btn.setForeground(Color.white); // 배경 색
		eatin_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		eatin_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // 글자 폰트 및 크기
		p_south.add(eatin_btn, BorderLayout.WEST);
		  
		JButton eatout_btn = new JButton("포장 하기");
		eatout_btn.setBounds(300, 665, 300, 100);//위치
		eatout_btn.setBackground(new Color(255, 158, 60));//글자 색
		eatout_btn.setForeground(Color.white); // 배경 색
		eatout_btn.setBorder(BorderFactory.createLineBorder(Color.white));//버튼 테두리 색
		eatout_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // 글자 폰트 및 크기
		p_south.add(eatout_btn,BorderLayout.EAST);	   
		  
		  
		//이벤트: 버튼 누르면 메뉴 고르는 화면으로		
		  
		eatin_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  Menu m = new Menu("매장");
		    	  m.setVisible(true); //메뉴창 열고		    	  
		    	  setVisible(false); // 초기화면 닫고
		      }
		  });
		  
		eatout_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Menu m = new Menu("포장");
		    	  m.setVisible(true); //메뉴창 열고		    	 
		    	  setVisible(false); // 초기화면 닫고
		      }
		   });      	      
			      
	    // 프레임 크기 
		setSize(600, 800);
		this.setLocation(500, 20);
		setVisible(true);
	      
	}
	 
}
