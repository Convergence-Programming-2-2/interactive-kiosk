import javax.swing.*;
import java.awt.*;

public class finish extends JFrame{
	public finish() {
		setTitle("결제 완료창");
		setSize(500, 300);
		
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
		ImageIcon logo_origin = new ImageIcon("./images/img/logo_transparent.png");
		JLabel title_logo = new JLabel(logo_origin);		
		p_north.add(title_logo);
		title.setBounds(10, 15, 300, 50); //위치
		title.setForeground(Color.white); //글자 색
		title.setFont(new Font("Dailog", Font.BOLD, 50)); //글자 폰트, 크기
		p_north.add(title);
		
		
			
		JLabel quest = new JLabel("결제 완료되었습니다. 메뉴가 준비되면 불러드리겠습니다:)");
		quest.setBounds(0, 5, 430, 50); //위치
		quest.setForeground(Color.black); //글자 색
		quest.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_foreground.add(quest);
		
		this.setLocation(550, 220);
	}
}
