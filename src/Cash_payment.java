import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class Cash_payment extends JFrame{
	public Cash_payment() {
		setTitle("현금 결제창");
		setSize(500, 400);
		
		//컨테이너 ----------------------------------------------------
		Container c = getContentPane();//하단의 패널들을 컨테이너에 부착할 예정
		c.setLayout(null);
		
		
		//JPanner--------------------------------------------
		//background 패널
		JPanel p_background = new JPanel(); 
		p_background.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_background.setBackground(Color.white); 
		p_background.setBounds(0, 0, 500, 400); 
		c.add(p_background);
		
		//상단바
		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(255, 158, 60));//주황색
		p_north.setBounds(0, 0, 500, 60);
		p_background.add(p_north);
		
		//가운데 화면 
		JPanel p_foreground = new JPanel();
		p_foreground.setLayout(null);
		p_foreground.setBackground((new Color(255, 248, 243))); //아이보리색
		p_foreground.setBounds(25, 60, 430, 300);
		p_background.add(p_foreground);
		

		//JLabel---------------------------------------------
		JLabel title = new JLabel("동국 킹버거");//상단 바 타이틀
		title.setBounds(10, 7, 300, 50);
		title.setForeground(Color.white); 
		title.setFont(new Font("Dailog", Font.BOLD, 35)); 
		p_north.add(title);
			
		JLabel quest = new JLabel("현금을 삽입해주세요"); //요청사항
		quest.setBounds(40, 5, 200, 50); 
		quest.setForeground(Color.black); 
		quest.setFont(new Font("Dailog", Font.BOLD, 15));
		p_foreground.add(quest);
		
		//결제완료버튼
		JButton wait_btn = new JButton("결제 중 입니다. 잠시만 기다려주세요:)"); //이 버튼을 누르면 결제 완료창으로 넘어갈 수 있게끔
		wait_btn.setBounds(100, 300, 300, 50); 
		wait_btn.setForeground(Color.black); //글자색(검정)
		wait_btn.setBackground(new Color(255, 248, 243));//버튼 배경색(아이보리색)
		wait_btn.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 243))); //버튼 테두리 색(아이보리색)
		wait_btn.setFont(new Font("Dialog", Font.BOLD, 15)); //글자 스타일
		c.add(wait_btn);

		// 몇 초 지나면 자동으로 결제 완료
		/*[설 명]
		 * 1. Timer, TimerTast를 사용해서 카운트다운 기능을 구현할 수 있습니다
		 * 2. timer.schedule - 타이머 스케줄러 작업 실행 및 반복 시간을 정의합니다
		 * 3. timer.cancle - 타이머 실행을 종료합니다
		 */
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){
		    @Override
		    public void run() { // 결제 완료 창으로 이동
		    	finish f = new finish();
		    	f.setVisible(true); //결제 완료창(finish) 열고	    	  
		    	setVisible(false); //카드 결제창(Card_payment) 닫고
				System.out.println("3초가 지나 결제 완료창으로 이동합니다.");
				timer.cancel(); //타이머 종료
		    }	
		};
		timer.schedule(task, 3000); // 3초 뒤 실헹
		

		//요청사항 그림-----------------------------------------------------
        ImageIcon cash_icon = new ImageIcon("./images/img/cash_img2.png");//현급 투입 아이콘 추가
		JLabel cash_label = new JLabel(cash_icon);
		cash_label.setBounds(90, 25, 280, 250);
		p_foreground.add(cash_label);
		

		//event-------------------------------------------------------
		wait_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  timer.cancel(); // 클릭으로 넘어가면 타이머 실행 안 됨
		    	  finish f = new finish();
		    	  f.setVisible(true); //결제 완료창(finish) 열고  	  
		    	  setVisible(false); //현금결제창(Cash_payment) 닫고
		      }
		  });
		
		this.setLocation(500, 20);
		
	}
}
