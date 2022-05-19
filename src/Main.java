import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.*;


class Menu extends JFrame{
	
	private String name[]= {"ġ�����", "�������","�Ұ�����","�ݶ�","���̴�","ȯŸ"};
	private JLabel nameLabels[] = new JLabel[6];
	private JLabel imgLabels[] = new JLabel[6];
	private JButton btn_plus[] = new JButton[nameLabels.length];
	private JButton btn_minus[] = new JButton[nameLabels.length];
	private JLabel num[] = new JLabel[nameLabels.length];
	protected Vector<Integer> order_list = new Vector<>();
	
	private JPanel p_background;
	private JPanel p_north;
	private JPanel p_south;
	
	
	
	public Menu() {	//������		
		set_layout();
		menu_order_dp();
		setSize(600, 800);
		setVisible(true);
	}
	
	
	//order_Dialog
	private void btn_listener(JButton order_btn,JButton cancel_btn) {
		
		order_Dialog d = new order_Dialog();
		
		order_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true); //���� �˾�â ����
			}
		});
		
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	// menu ���� ����/����  ----------------------------------------------
	private void menu_listener(JButton btn_plus,JButton btn_minus,int index) {
		
		ActionListener listener = new ActionListener() {	

			public void actionPerformed(ActionEvent e) {	
				
				//plus btn
				if(e.getSource()== btn_plus) {	
					
					// ������Ű�� ���� string ->int
					String strNum = num[index].getText();
                    int count = Integer.parseInt(strNum);
                    count++;                    
                    
                    // int ->string
                    strNum = String.valueOf(count);
                    num[index].setText(strNum);
                    
                    //System.out.println(num[index].getText());
				}
				
				//minus btn
				else if(e.getSource()== btn_minus){			
					
					String strNum = num[index].getText();
					int count = Integer.parseInt(strNum);
					 
					if(count > 0) {
						count--;
						 strNum = String.valueOf(count);
						num[index].setText(strNum);
					}
					 
					else {
						num[index].setText("0");
					}
					//System.out.println(num[index].getText());	              
				}
			}
		};
		
		btn_plus.addActionListener(listener);
		btn_minus.addActionListener(listener);
	}
	
	
	// set layout
	public void set_layout() {
		
		setTitle("�޴�â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ������ ���α׷� ����
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		//JPanner------------------------------------------------
		
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
		p_south = new JPanel(new FlowLayout());			
		p_south.setBackground(new Color(255, 158, 60));		
		c.add(p_south,BorderLayout.SOUTH);
		
		
		//p_north title--------------------------------------------		
		JLabel title = new JLabel("���� ŷ ����");	
		ImageIcon logo_origin = new ImageIcon("./images/img/logo_transparent.png");
		JLabel title_logo = new JLabel(logo_origin);		
		p_north.add(title_logo);
		
		title.setBounds(10, 15, 300, 50); //��ġ
		title.setForeground(Color.white); //���� ��
		title.setFont(new Font("Dailog", Font.BOLD, 50)); //���� ��Ʈ, ũ��
		p_north.add(title);
		
		
		//�ֹ��ϱ�, ����ϱ� ��ư ----------------------------------------
		JButton order_btn = new JButton("�ֹ��ϱ�");
		order_btn.setBounds(0, 665, 300, 100); //��ġ
		order_btn.setBackground(new Color(255, 158, 60)); //���� ��
		order_btn.setForeground(Color.white); // ��� ��
		order_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		order_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // ���� ��Ʈ �� ũ��
		p_south.add(order_btn, BorderLayout.WEST);
		
		JButton cancel_btn = new JButton("����ϱ�");
		cancel_btn.setBounds(300, 665, 300, 100);//��ġ
		cancel_btn.setBackground(new Color(255, 158, 60));//���� ��
		cancel_btn.setForeground(Color.white); // ��� ��
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white));//��ư �׵θ� ��
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // ���� ��Ʈ �� ũ��
		p_south.add(cancel_btn,BorderLayout.EAST);
		
		btn_listener(order_btn,cancel_btn);
	}
	
	// menu display
	public void menu_order_dp() {

		JPanel menu_num1= new JPanel();
		JPanel menu_num2= new JPanel();
		JPanel menu_num3= new JPanel();
		JPanel menu_num4= new JPanel();
		JPanel menu_num5= new JPanel();
		JPanel menu_num6= new JPanel();
		
		JPanel menu1= new JPanel(new GridLayout(3,0));
		JPanel menu2= new JPanel(new GridLayout(3,0));
		JPanel menu3= new JPanel(new GridLayout(3,0));
		JPanel menu4= new JPanel(new GridLayout(3,0));
		JPanel menu5 =new JPanel(new GridLayout(3,0));
		JPanel menu6 =new JPanel(new GridLayout(3,0));


		for(int i=0; i<imgLabels.length; i++) { 
			ImageIcon icon = new ImageIcon("./images/img/"+i+".png"); 
			icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)); 
			imgLabels[i] = new JLabel(icon);
			
			nameLabels[i]= new JLabel(name[i]);
			nameLabels[i].setFont(new Font("Dialog", Font.BOLD, 25)); // ���� ��Ʈ �� ũ��
			nameLabels[i].setHorizontalAlignment(JLabel.CENTER);
			
			btn_plus[i] = new JButton("+");
			btn_minus[i] = new JButton("-");	
			
			num[i] = new JLabel ("0",JLabel.CENTER);
			num[i].setText("0");			
			
			menu_listener(btn_plus[i],btn_minus[i],i);
		}

		
		menu_num1.add(btn_minus[0]);
		menu_num1.add(num[0]);			
		menu_num1.add(btn_plus[0]);
		
		menu1.add(imgLabels[0]);
		menu1.add(nameLabels[0]);
		menu1.add(menu_num1);
		
		menu_num2.add(btn_minus[1]);
		menu_num2.add(num[1]);			
		menu_num2.add(btn_plus[1]);
		
		menu2.add(imgLabels[1]);
		menu2.add(nameLabels[1]);
		menu2.add(menu_num2);
		
		menu_num3.add(btn_minus[2]);
		menu_num3.add(num[2]);			
		menu_num3.add(btn_plus[2]);
		
		menu3.add(imgLabels[2]);
		menu3.add(nameLabels[2]);
		menu3.add(menu_num3);
		
		menu_num4.add(btn_minus[3]);
		menu_num4.add(num[3]);			
		menu_num4.add(btn_plus[3]);
		
		menu4.add(imgLabels[3]);
		menu4.add(nameLabels[3]);
		menu4.add(menu_num4);
		
		menu_num5.add(btn_minus[4]);
		menu_num5.add(num[4]);			
		menu_num5.add(btn_plus[4]);
		
		menu5.add(imgLabels[4]);
		menu5.add(nameLabels[4]);
		menu5.add(menu_num5);

		menu_num6.add(btn_minus[5]);
		menu_num6.add(num[5]);			
		menu_num6.add(btn_plus[5]);
		
		menu6.add(imgLabels[5]);
		menu6.add(nameLabels[5]);
		menu6.add(menu_num6);

		p_background.add(menu1);
		p_background.add(menu2);
		p_background.add(menu3);
		p_background.add(menu4);
		p_background.add(menu5);
		p_background.add(menu6);
	}

}//JFrame


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}
}
