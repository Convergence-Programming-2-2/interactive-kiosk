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
	
	public Initial_screen() { //������
		
		setTitle("�ʱ� ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ������ ���α׷� ����
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//JPanner �˾�â
		  
		//BorderLayout.CENTER
		JPanel p_background = new JPanel(new GridLayout(0,3));      
		JScrollPane p_center = new JScrollPane(p_background,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		p_background.setBackground(Color.white);
		c.add(p_center,BorderLayout.CENTER);
		  
		  
		//BorderLayout.NORTH
		JPanel p_north = new JPanel(new FlowLayout());
		p_north.setBackground(new Color(255, 158, 60));
		c.add(p_north,BorderLayout.NORTH);
		  
		//BorderLayout.SOUTH
		JPanel p_south = new JPanel(new FlowLayout());         
		p_south.setBackground(new Color(255, 158, 60));      
		c.add(p_south,BorderLayout.SOUTH);
		  
		//p_background
		JLabel screen = new JLabel (new ImageIcon("https://user-images.githubusercontent.com/101086248/169693778-2020e5f3-7a63-41a4-808a-844043bab2ba.png"));
		p_background.add(screen);
		  
		//p_north title
		JLabel logo = new JLabel(new ImageIcon("./images/img/logo_transparent.png"));     
		p_north.add(logo);
		
		  
		  
		//����Ļ�, ���� ��ư
		JToggleButton eatin_btn = new JToggleButton("���� �Ļ�");
		eatin_btn.setBounds(0, 665, 300, 100); //��ġ
		eatin_btn.setBackground(new Color(255, 158, 60)); //���� ��
		eatin_btn.setForeground(Color.white); // ��� ��
		eatin_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		eatin_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // ���� ��Ʈ �� ũ��
		p_south.add(eatin_btn, BorderLayout.WEST);
		  
		JButton eatout_btn = new JButton("���� �ϱ�");
		eatout_btn.setBounds(300, 665, 300, 100);//��ġ
		eatout_btn.setBackground(new Color(255, 158, 60));//���� ��
		eatout_btn.setForeground(Color.white); // ��� ��
		eatout_btn.setBorder(BorderFactory.createLineBorder(Color.white));//��ư �׵θ� ��
		eatout_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // ���� ��Ʈ �� ũ��
		p_south.add(eatout_btn,BorderLayout.EAST);	   
		  
		  
		//�̺�Ʈ: ��ư ������ �޴� ������ ȭ������
//		Menu m = new Menu();
//		  
//		eatin_btn.addActionListener(new ActionListener() {
//		      public void actionPerformed(ActionEvent e) {	      
//		    	  m.setVisible(true); //�޴�â ����
//		    	  setVisible(false); // �ʱ�ȭ�� �ݰ�
//		      }
//		  });
//		  
//		eatout_btn.addActionListener(new ActionListener() {
//		      public void actionPerformed(ActionEvent e) {
//		    	  m.setVisible(true); //�޴�â ����
//		    	  setVisible(false); // �ʱ�ȭ�� �ݰ�
//		      }
//		   });      	      
			      
	    // ������ ũ�� 
		setSize(600, 800);
	      
	}
	 
}