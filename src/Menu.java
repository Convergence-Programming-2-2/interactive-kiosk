import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.*;


class Menu extends JFrame{
	
	private String name[]= {"치즈버거", "새우버거","불고기버거","콜라","사이다","환타"}; //menu name
	private JLabel nameLabels[] = new JLabel[name.length]; 					//menu name JLabel
	
	private int price[]= {5000,5300,4800,2000,2000,1800}; 	//menu price
	private JLabel Jprice[] = new JLabel[name.length];		//menu price JLabel
	private JLabel imgLabels[] = new JLabel[name.length];	 //menu image JLabel
	
	private JButton btn_plus[] = new JButton[name.length];	//menuCount button_plus JLabel
	private JButton btn_minus[] = new JButton[name.length];	//menuCount button_minus JLabel	
	private JLabel num[] = new JLabel[name.length];			//menuCount num
	
	protected ArrayList<String> order_list = new ArrayList<>(name.length); // order list
	
	private JPanel p_background; 
	private JPanel p_north;
	private JPanel p_south;
	
	
	public Menu(String eatinOreatout) {	//생성자			 
		/* data set init. Initial_screen 으로 부터 받아온 변수를 데이터셋에 추가(매장 OR 포장)*/
		set_data(eatinOreatout);
		set_layout(); // Menu layout set
		menu_dp();    // Menu display
		setSize(600, 800); 
		setVisible(false);
	}
	
	protected void set_data(String eatinOreatout) {				
		//Menu data : 6개 + 매장/포장 :  1개
		order_list = new ArrayList<>(Arrays.asList("0","0","0","0","0","0"));
		order_list.add(eatinOreatout);
		System.out.println(order_list);
	}
	
	//order_Dialog
	private void btn_listener(JButton order_btn,JButton cancel_btn) {		
		order_Dialog d = new order_Dialog();// new order_Dialog
		d.setLocation(550, 200);
		
		order_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true); //결제 팝업창 열고
			}
		});		
		
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// Menu창 닫기
			}
		});
	}
	
	// menu 수량 증가/감소  listener----------------------------------------------
	private void menu_listener(JButton btn_plus,JButton btn_minus,int index) {
		
		ActionListener listener = new ActionListener() {	
			public void actionPerformed(ActionEvent e) {					
				//plus btn
				if(e.getSource()== btn_plus) {	
					String strNum = num[index].getText();
					//string -> int
                    int count = Integer.parseInt(strNum);
                    count++;                    
                    
                    // int ->string
                    strNum = String.valueOf(count);
                    num[index].setText(strNum);
                    
                    // data update
                    order_list.set(index, strNum);
                    System.out.println(order_list+"\n");
				}
				
				//minus btn
				else if(e.getSource()== btn_minus){			
					
					String strNum = num[index].getText();
					//string ->int
					int count = Integer.parseInt(strNum);	
					
					if(count > 0) {
						count--;
						// int ->string
						strNum = String.valueOf(count);
						num[index].setText(strNum);
						order_list.set(index, strNum);// data update	
						System.out.println(order_list);
					}
					 
					else {// count <=0 이라면 -버튼 클릭시 0으로 set
						num[index].setText("0");
						order_list.set(index, strNum); // data update
						System.out.println(order_list);
					}           
				}
			}
		};		
		
		btn_plus.addActionListener(listener); //btn_plus에 linstenr 달기
		btn_minus.addActionListener(listener);//btn_minus에 linstenr 달기
	}
	
	
	// set layout
	public void set_layout() {
		
		setTitle("메뉴창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫으면 프로그램 종료
		Container c = getContentPane(); //컨테이너
		c.setLayout(new BorderLayout());
		
		//BorderLayout.CENTER
		p_background = new JPanel(new GridLayout(0,3));		
		JScrollPane p_center = new JScrollPane(p_background,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p_background.setBackground(Color.white);
		c.add(p_center,BorderLayout.CENTER);
		
		//BorderLayout.NORTH
		p_north = new JPanel(new FlowLayout());
		p_north.setBackground(new Color(255, 158, 60));
		c.add(p_north,BorderLayout.NORTH);
		
		//BorderLayout.SOUTH
		p_south = new JPanel(new GridLayout());	
		p_south.setBackground(new Color(255, 158, 60));		
		c.add(p_south,BorderLayout.SOUTH);
		
		
		//p_north title--------------------------------------------		
		JLabel title = new JLabel("동국 킹 버거");	
		ImageIcon logo_origin = new ImageIcon("./images/img/logo_transparent.png");
		JLabel title_logo = new JLabel(logo_origin);		
		p_north.add(title_logo);
		
		title.setBounds(10, 15, 300, 50); //위치
		title.setForeground(Color.white); //글자 색
		title.setFont(new Font("Dailog", Font.BOLD, 50)); //글자 폰트, 크기
		p_north.add(title);
		
		
		//주문하기, 취소하기 버튼 ----------------------------------------
		JButton order_btn = new JButton("주문하기");
		order_btn.setBounds(0, 665, 300, 100); //위치
		order_btn.setBackground(new Color(255, 158, 60)); //글자 색
		order_btn.setForeground(Color.white); // 배경 색
		order_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //버튼 테두리 색
		order_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // 글자 폰트 및 크기
		p_south.add(order_btn, BorderLayout.WEST);
		
		JButton cancel_btn = new JButton("취소하기");
		cancel_btn.setBounds(300, 665, 300, 100);//위치
		cancel_btn.setBackground(new Color(255, 158, 60));//글자 색
		cancel_btn.setForeground(Color.white); // 배경 색
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white));//버튼 테두리 색
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // 글자 폰트 및 크기
		p_south.add(cancel_btn,BorderLayout.EAST);
		
		btn_listener(order_btn,cancel_btn);
	}
	
	// menu backgroud setColor, setBorder
	public void set_background(JPanel menu_num,JPanel menu) {				
		menu_num.setBackground(Color.white);
		menu.setBackground(Color.white);
		menu.setBorder(BorderFactory.createLineBorder(new Color(255, 236, 213))); 
	}
	
	// menuPanel set
	public void set_menuPanel(JPanel menu_count_bar,JPanel menu, int index) {	
		//menu_count_bar
		menu_count_bar.add(btn_minus[index]);
		menu_count_bar.add(num[index]);			
		menu_count_bar.add(btn_plus[index]);
		
		// labels/panel add to menuPanel  
		menu.add(imgLabels[index]);
		menu.add(nameLabels[index]);
		menu.add(Jprice[index]);		
		menu.add(menu_count_bar);
	}
	
	// menu display
	public void menu_dp() {
		//menu count bar Panel ( +,-버튼 and 개수)
		JPanel menu_count_bar1= new JPanel();
		JPanel menu_count_bar2= new JPanel();
		JPanel menu_count_bar3= new JPanel();
		JPanel menu_count_bar4= new JPanel();
		JPanel menu_count_bar5= new JPanel();
		JPanel menu_count_bar6= new JPanel();
		
		// 4행 ( img, name, price, menucount bar )
		JPanel menu1= new JPanel(new GridLayout(4,0)); 
		JPanel menu2= new JPanel(new GridLayout(4,0));
		JPanel menu3= new JPanel(new GridLayout(4,0));
		JPanel menu4= new JPanel(new GridLayout(4,0));
		JPanel menu5 =new JPanel(new GridLayout(4,0));
		JPanel menu6 =new JPanel(new GridLayout(4,0));

		
		for(int i=0; i<name.length; i++) { //메뉴의 개수만큼 반복
			
			//가격
			Jprice[i]= new JLabel();
			Jprice[i].setText(String.valueOf(price[i])); 	 // int형 배열을 String으로 변환후 JPrice에 setText
			Jprice[i].setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
			Jprice[i].setFont(new Font("Dialog", Font.BOLD, 25)); //Font설정
			
			//이미지
			ImageIcon icon = new ImageIcon("./images/img/"+i+".png");  // ImageIcon 객체생성
			icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)); // Image사이즈 조정
			imgLabels[i] = new JLabel(icon);// imageicon을 JLabel imageLabels 객체로 생성
			
			//이름
			nameLabels[i]= new JLabel(name[i]);// name을 JLabel nameLabels 객체로 생성
			nameLabels[i].setHorizontalAlignment(JLabel.CENTER);
			nameLabels[i].setFont(new Font("Dialog", Font.BOLD, 25)); 
			
			//버튼
			btn_plus[i] = new JButton("+"); 
			btn_minus[i] = new JButton("-");	
			
			//개수 
			num[i] = new JLabel ("0",JLabel.CENTER);
			num[i].setText("0");			
			
			menu_listener(btn_plus[i],btn_minus[i],i);// JButton listener	
		}

		set_background(menu_count_bar1,menu1);// menu backgroud setColor, setBorder
		set_background(menu_count_bar2,menu2);
		set_background(menu_count_bar3,menu3);
		set_background(menu_count_bar4,menu4);
		set_background(menu_count_bar5,menu5);
		set_background(menu_count_bar6,menu6);
		
		set_menuPanel(menu_count_bar1, menu1 ,0);// menuPanel set
		set_menuPanel(menu_count_bar2, menu2 ,1);
		set_menuPanel(menu_count_bar3, menu3 ,2);
		set_menuPanel(menu_count_bar4, menu4 ,3);
		set_menuPanel(menu_count_bar5, menu5 ,4);
		set_menuPanel(menu_count_bar6, menu6 ,5);

		p_background.add(menu1);
		p_background.add(menu2);
		p_background.add(menu3);
		p_background.add(menu4);
		p_background.add(menu5);
		p_background.add(menu6);
		
		this.setLocation(500, 20);
	}
}
