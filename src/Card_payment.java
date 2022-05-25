import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card_payment extends JFrame{
	
	private JPanel p_background;
	private JPanel p_north;
	private JPanel p_south;
	
	public Card_payment() {//생성자
		setTitle("카드 결제창");
		setSize(500, 400);
		
		//컨테이너 ----------------------------------------------------
				Container c = getContentPane();
				c.setLayout(null);
				
				//JPanner--------------------------------------------
				JPanel p_background = new JPanel();
				p_background.setLayout(null);
				p_background.setBackground(Color.white);
				p_background.setBounds(0, 0, 500, 400);
				c.add(p_background);
				
				
				JPanel p_north = new JPanel();
				p_north.setLayout(null);
				p_north.setBackground(new Color(255, 158, 60));
				p_north.setBounds(0, 0, 500, 60);
				p_background.add(p_north);
				
				

				JPanel p_foreground = new JPanel();
				p_foreground.setLayout(null);
				p_foreground.setBackground((new Color(255, 248, 243)));
				p_foreground.setBounds(25, 60, 430, 300);
				p_background.add(p_foreground);
				

				//JLabel---------------------------------------------
				
				JLabel title = new JLabel("동국 킹버거");
				title.setBounds(10, 15, 300, 50); //위치
				title.setForeground(Color.white); //글자 색
				title.setFont(new Font("Dailog", Font.BOLD, 50)); //글자 폰트, 크기
				p_north.add(title);
					
				JLabel quest = new JLabel("카드를 삽입해주세요");
				quest.setBounds(40, 5, 200, 50); //위치
				quest.setForeground(Color.black); //글자 색
				quest.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
				p_foreground.add(quest);
				
				JButton wait_btn = new JButton("결제 중 입니다. 잠시만 기다려주세요:)");
				wait_btn.setBounds(100, 300, 300, 50);
				wait_btn.setForeground(Color.black); // 배경 색
				wait_btn.setBackground(new Color(255, 248, 243)); //글자 색
				wait_btn.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 243))); //버튼 테두리 색
				wait_btn.setFont(new Font("Dialog", Font.BOLD, 15)); // 글자 폰트 및 크기
				c.add(wait_btn);
				
				/*원본->안되면 이거로!
				JLabel wait = new JLabel("결제 중 입니다. 잠시만 기다려주세요:)");
				wait.setBounds(150, 200, 400, 50); //위치
				wait.setForeground(Color.black); //글자 색
				wait.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
				p_foreground.add(wait);
				*/
				
				/*시간차
				Container contentPane;
				contentPane = getContentPane();
				contentPane.setLayout(new FlowLayout());
				JLabel wait1 = new JLabel(new ImageIcon("./images/img/cash.png"));
				wait1.setToolTipText("결제 중 입니다. 잠시만 기다려주세요:)");
				contentPane.add(wait1);
				
			
				ToolTipManager m = ToolTipManager.sharedInstance();
				m.setInitialDelay(0);
				m.setDismissDelay(10000);
				*/

		        ImageIcon card_icon = new ImageIcon("./images/img/card_quest.png");
				JLabel card_label = new JLabel(card_icon);
				card_label.setBounds(100, 45, 150, 150);
				p_foreground.add(card_label);
				
				
				//이벤트
				wait_btn.addActionListener(new ActionListener() {
				      public void actionPerformed(ActionEvent e) {	 
				    	  finish f = new finish();
				    	  f.setVisible(true); //	결제 완료창 열고	    	  
				    	  setVisible(false); // 카드결제창 닫고
				      }
				  });
				
	}
	
	

}
