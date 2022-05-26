import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class Payment extends JFrame {
	public Payment() {
		setTitle("���� ���� ����");
		//�����̳� ------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner------------------------------------------------
		JPanel p_background = new JPanel();
		p_background.setLayout(null);
		p_background.setBackground(Color.white);
		p_background.setBounds(0, 0, 600, 800);
		c.add(p_background);
		
		//��� ��-------------------------------------------------
		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(255, 158, 60));
		p_north.setBounds(0, 0, 600, 80);
		p_background.add(p_north);
			

		//JLabel-------------------------------------------------
		
		JLabel title_label = new JLabel("���� ���� ����");
		title_label.setBounds(10, 15, 300, 50); //��ġ
		title_label.setForeground(Color.white); //���� ��
		title_label.setFont(new Font("Dailog", Font.BOLD, 40)); //���� ��Ʈ, ũ��
		p_north.add(title_label);
		
		
		JLabel card_label = new JLabel("ī�� ����");
		card_label.setBounds(110, 450, 300, 50); //��ġ
		card_label.setFont(new Font("Dailog", Font.BOLD, 20)); //���� ��Ʈ, ũ��
		p_background.add(card_label);
		
		
		JLabel cash_label = new JLabel("���� ����");
		cash_label.setBounds(400, 450, 300, 50); //��ġ
		cash_label.setFont(new Font("Dailog", Font.BOLD, 20)); //���� ��Ʈ, ũ��
		p_background.add(cash_label);
		
		
		//Image---------------------------------------------------
		ImageIcon card_icon = new ImageIcon("./images/img/card2.png");
		ImageIcon cash_icon = new ImageIcon("./images/img/cash.png");
		
	
		JButton card_btn = new JButton(card_icon);
		JButton cash_btn = new JButton(cash_icon);
		
		card_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		card_btn.setBounds(0, 250, 300, 200);
		card_btn.setBackground(Color.white);
		p_background.add(card_btn);
		
		
		cash_btn.setBorder(BorderFactory.createLineBorder(Color.white));
		cash_btn.setBounds(300, 250, 300, 200);
		cash_btn.setBackground(Color.white);
		p_background.add(cash_btn);
		
		// ������ ũ�� ----------------------------------------------
		setSize(600, 800);
		//setVisible(true);
		
		//�̺�Ʈ(�߰�)
		card_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  Card_payment card = new Card_payment();
		    	  card.setVisible(true); //	ī�� ����â ����	   
		    	  card.setLocation(550, 180);
		    	  setVisible(false); // ���� ���� ����â �ݰ�
		      }
		  });
		  
		cash_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  Cash_payment cash = new Cash_payment();
		    	  cash.setVisible(true); //���� ����â ����		
		    	  cash.setLocation(550, 180);
		    	  setVisible(false); // ���� ���� ����â �ݰ�
		      }
		   });      
		
		this.setLocation(500,20);
	}
}
