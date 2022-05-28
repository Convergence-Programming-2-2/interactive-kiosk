import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;


public class order_Dialog extends JDialog{
	public order_Dialog(ArrayList<String> arr) {
		setTitle("결제 팝업창");
	
		//컨테이너 ----------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner---------------------------------------------------
		JPanel p_background = new JPanel(); //background 패널
		p_background.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_background.setBackground(Color.white); //색깔
		p_background.setBounds(0, 0, 500, 400);  //크기
		c.add(p_background); //컨테이너에 background 패널 부착
		
		
		JPanel p_north = new JPanel(); //상단 패널
		p_north.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_north.setBackground(new Color(255, 158, 60)); //색깔
		p_north.setBounds(0, 0, 500, 60); //크기
		p_background.add(p_north); //background에 상단 패널 부착
		

		JPanel p_foreground = new JPanel(); //foreground 패널
		p_foreground.setLayout(null); //직접 위치 설정을 위해 레이아웃 null
		p_foreground.setBackground((new Color(255, 248, 243))); //색깔
		p_foreground.setBounds(25, 60, 430, 300); //크기
		p_background.add(p_foreground); //background에 foreground 부착 
		
		
		//JButton--------------------------------------------------
		JButton ok_btn = new JButton("Ok"); //버튼 생성
		ok_btn.setBounds(0, 315, 250, 50); //버튼 위치
		ok_btn.setBackground(new Color(255, 158, 60)); //글자 색
		ok_btn.setForeground(Color.white); // 배경 색
		ok_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		ok_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // 글자 폰트 및 크기
		c.add(ok_btn); //컨테이너에 버튼 부착
		
		JButton cancel_btn = new JButton("Cancel");//버튼 생성
		cancel_btn.setBounds(250, 315, 250, 50); //버튼 위치
		cancel_btn.setBackground(new Color(255, 158, 60)); //글자 색
		cancel_btn.setForeground(Color.white); // 배경 색
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // 글자 폰트 및 크기
		c.add(cancel_btn); //컨테이너에 버튼 부착
		
		
		//JLabel----------------------------------------------------		
		JLabel main_title = new JLabel("주문 확인"); 
		main_title.setBounds(10, 5, 200, 50); //위치
		main_title.setForeground(Color.white); //글자 색
		main_title.setFont(new Font("Dailog", Font.BOLD, 30)); //글자 폰트, 크기
		p_north.add(main_title); //패널에 라벨 부착
			
		JLabel order_title = new JLabel("주문 내역"); 
		order_title.setBounds(40, 5, 200, 50); //위치
		order_title.setForeground(Color.DARK_GRAY); //글자 색
		order_title.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_foreground.add(order_title); //패널에 라벨 부착

		int y_index = -121;
		String order_list = "<html>"; // 줄바꿈을 넣기 위해 html 형식 사용
		for (int i = 0; i < 6; i++)
		{
			if (Integer.parseInt(arr.get(i)) != 0) // 주문한 상품이 0개가 아니라면
			{
				order_list += Constants.name[i] + ": " + arr.get(i) +"개<br>"; // 상품명과 주문 개수를 order_list에 추가하고
				y_index += 11; // 세로축 조정
			}			
		}
		order_list += arr.get(6) + "</html>"; // 매장/포장 여부 추가 후 html 닫기
		JLabel order_list_title = new JLabel(order_list); // order_list 출력
		order_list_title.setBounds(200, y_index, 200, 300); // 주문한 상품 종류 수에 따라 세로축 조정
		order_list_title.setForeground(Color.DARK_GRAY); //글자 색
		order_list_title.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_foreground.add(order_list_title); //패널에 라벨 부착

		int sum = 0;
		for (int i = 0; i < 6; i++) // 총 결제 금액 계싼
			sum += Constants.price[i] * Integer.parseInt(arr.get(i));
		JLabel total_price = new JLabel("총 결제 금액 : " + sum + "원");
		total_price.setBounds(200, 200, 200, 50); //위치
		total_price.setForeground(Color.DARK_GRAY); //글자 색
		total_price.setFont(new Font("Dailog", Font.BOLD, 15)); //글자 폰트, 크기
		p_foreground.add(total_price); //패널에 라벨 부착
		
		
		//img-------------------------------------------------------
		ImageIcon burger_icon = new ImageIcon("./images/img/0.png"); //이미지 아이콘 생성
		JLabel burger_label = new JLabel(burger_icon); // 라벨에 이미지 아이콘 부탁
		burger_label.setBounds(20, 135, 100, 117); //라벨 크기
		p_foreground.add(burger_label); //패널에 라벨 부착
		
		//이벤트------------------------------------------------------
		
		Payment p = new Payment();
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(true);// payment 창 열고
				setVisible(false); // order_dialog 창 종료
			}
		});
		

		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  // order_dialog 종료
			}
		});
		
		setSize(500, 400);		
		
	}
}