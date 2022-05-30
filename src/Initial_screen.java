import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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
		  
		//BorderLayout.CENTER
		JPanel p_background = new JPanel(new GridLayout()); //����ȭ�� ��׶����_���   
		p_background.setBackground(Color.white);
		c.add(p_background);
		  
		//BorderLayout.NORTH
		JPanel p_north = new JPanel(new FlowLayout());
		p_north.setBackground(new Color(255, 158, 60));//��Ȳ��
		c.add(p_north,BorderLayout.NORTH);
		  
		//BorderLayout.SOUTH
		JPanel p_south = new JPanel(new GridLayout());         
		p_south.setBackground(new Color(255, 158, 60)); //��Ȳ��
		c.add(p_south,BorderLayout.SOUTH);

				
		//image
		JLabel screen = new JLabel (new ImageIcon("./images/img/initial_pic.png")); //Ű����ũ ����ȭ��
		p_background.add(screen);
		  
		JLabel logo = new JLabel(new ImageIcon("./images/img/logo_transparent.png")); //����ŷ���� �ΰ�    
		p_north.add(logo);
		
		//����Ļ�, ���� ��ư
		JToggleButton eatin_btn = new JToggleButton("���� �Ļ�");
		eatin_btn.setBounds(0, 665, 300, 100); 
		eatin_btn.setBackground(new Color(255, 158, 60)); 
		eatin_btn.setForeground(Color.white); 
		eatin_btn.setBorder(BorderFactory.createLineBorder(Color.white)); 
		eatin_btn.setFont(new Font("Dialog", Font.BOLD, 40)); 
		p_south.add(eatin_btn, BorderLayout.WEST);
		  
		JButton eatout_btn = new JButton("���� �ϱ�");
		eatout_btn.setBounds(300, 665, 300, 100);
		eatout_btn.setBackground(new Color(255, 158, 60));
		eatout_btn.setForeground(Color.white); 
		eatout_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		eatout_btn.setFont(new Font("Dialog", Font.BOLD, 40)); 
		p_south.add(eatout_btn,BorderLayout.EAST);	   
		  
		  
		//event------------------------------------------		  
		eatin_btn.addActionListener(new ActionListener() {//���� �Ļ� ��ư ������ 
		      public void actionPerformed(ActionEvent e) {	 
		    	  Menu m = new Menu("����", new ArrayList<>(Arrays.asList("0","0","0","0","0","0")));
		    	  m.setVisible(true); //�޴�â(Menu) ����		    	  
		    	  setVisible(false); // �ʱ�ȭ��(Initial_screen) �ݰ�
		      }
		  });
		  
		eatout_btn.addActionListener(new ActionListener() {//�����ϱ� ��ư ������
		      public void actionPerformed(ActionEvent e) {
		    	  Menu m = new Menu("����", new ArrayList<>(Arrays.asList("0","0","0","0","0","0")));
		    	  m.setVisible(true); //�޴�â(Menu) ����		    	 
		    	  setVisible(false); // �ʱ�ȭ��(Initial_screen) �ݰ�
		      }
		   });      	      
			      
	    // ������ ũ�� ----------------------------------
		setSize(600, 800);
		this.setLocation(500, 20);
		setVisible(true);
	      
	}
	 
}
