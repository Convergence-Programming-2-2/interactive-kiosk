import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class Payment extends JFrame {
	public Payment() {
		setTitle("결제 수단 선택");
		//컨테이너 ------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner------------------------------------------------
		JPanel p_background = new JPanel(); //background 패널
		p_background.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_background.setBackground(Color.white); //색깔
		p_background.setBounds(0, 0, 600, 800); //크기
		c.add(p_background); //컨테이너에 background 패널 부착

		
		JPanel p_north = new JPanel(); //상단 패널
		p_north.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_north.setBackground(new Color(255, 158, 60)); //색깔
		p_north.setBounds(0, 0, 600, 80); //크기
		p_background.add(p_north); //background에 상단 패널 부착
			

		//JLabel-------------------------------------------------
		
		JLabel title_label = new JLabel("결제 수단 선택");
		title_label.setBounds(10, 15, 300, 50); //위치
		title_label.setForeground(Color.white); //글자 색
		title_label.setFont(new Font("Dailog", Font.BOLD, 40)); //글자 폰트, 크기
		p_north.add(title_label);
		
		
		JLabel card_label = new JLabel("카드 결제");
		card_label.setBounds(110, 410, 300, 50); //위치
		card_label.setFont(new Font("Dailog", Font.BOLD, 20)); //글자 폰트, 크기
		p_background.add(card_label);
		
		
		JLabel cash_label = new JLabel("현금 결제");
		cash_label.setBounds(400, 410, 300, 50); //위치
		cash_label.setFont(new Font("Dailog", Font.BOLD, 20)); //글자 폰트, 크기
		p_background.add(cash_label);
		
		
		//Image---------------------------------------------------
		ImageIcon card_icon = new ImageIcon("./images/img/card2.png"); //card 아이콘 
		ImageIcon cash_icon = new ImageIcon("./images/img/cash.png");  //cash 아이콘 
		ImageIcon burger_icon = new ImageIcon("./images/img/burger_pic.png");
	
		JButton card_btn = new JButton(card_icon); //card 아이콘 버튼 부착
		JButton cash_btn = new JButton(cash_icon); //cash 아이콘 버튼 부착
		
		JLabel burger_label = new JLabel(burger_icon);
		burger_label.setBounds(52, 340, 500, 540);
		p_background.add(burger_label);
		
		card_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 border 색
		card_btn.setBounds(0, 210, 300, 200); //버튼 크기
		card_btn.setBackground(Color.white); //버튼 색 
		p_background.add(card_btn);
		
		
		cash_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 border 색
		cash_btn.setBounds(300, 210, 300, 200); //버튼 크기
		cash_btn.setBackground(Color.white); // 버튼 색
		p_background.add(cash_btn);
		
		// 프레임 크기 ----------------------------------------------
		setSize(600, 800);
		//setVisible(true);
		
		//이벤트(추가)
		card_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  Card_payment card = new Card_payment();
		    	  card.setVisible(true); //	카드 결제창 열고	   
		    	  card.setLocation(550, 180);
		    	  setVisible(false); // 결제 수단 선택창 닫고
		      }
		  });
		  
		cash_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Cash_payment cash = new Cash_payment();
		    	  cash.setVisible(true); //현금 결제창 열고		
		    	  cash.setLocation(550, 180);
		    	  setVisible(false); // 결제 수단 선택창 닫고
		      }
		   });      
		
		this.setLocation(500,20);
	}
}
