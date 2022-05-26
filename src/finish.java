import javax.swing.*;
import java.awt.*;
import java.awt.Container;

public class finish extends JFrame{
	public finish() {
		setTitle("결제 완료창");
		setSize(500, 300);
		
		//컨테이너 
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner--------------------------------------------
		//background
		JPanel p_background = new JPanel();
		p_background.setLayout(null);//직접 위치 설정을 위해 레이아웃 null
		p_background.setBackground(Color.white); 
		p_background.setBounds(0, 0, 500, 400);
		c.add(p_background); 
		
		//상단 바
		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(255, 158, 60)); //주황색
		p_north.setBounds(0, 0, 500, 60);
		p_background.add(p_north);
		
		//가운데 부착한 패널
		JPanel p_foreground = new JPanel();
		p_foreground.setLayout(null);
		p_foreground.setBackground((new Color(255, 248, 243))); //아이보리색
		p_foreground.setBounds(25, 60, 430, 300);
		p_background.add(p_foreground);
		

		//JLabel---------------------------------------------
		
		JLabel title = new JLabel("동국 킹버거");
		title.setBounds(10, 5, 300, 50); 
		title.setForeground(Color.white); 
		title.setFont(new Font("Dailog", Font.BOLD, 35)); //글자 폰트, 크기
		p_north.add(title);
		
		
		JLabel quest = new JLabel();
		quest.setText("<html>" + "결제 완료되었습니다." +"<br>" +"메뉴가 준비되면 불러드리겠습니다:)"+ "</html>");//텍스트
		quest.setBounds(100, 70, 430, 50); //위치
		quest.setForeground(Color.black); //글자 색
		quest.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_foreground.add(quest);
		
		this.setLocation(550, 220);
	}
}
