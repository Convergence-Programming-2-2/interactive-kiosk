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
		JPanel p_background = new JPanel(); //background �г�
		p_background.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_background.setBackground(Color.white); //����
		p_background.setBounds(0, 0, 600, 800); //ũ��
		c.add(p_background); //�����̳ʿ� background �г� ����

		
		JPanel p_north = new JPanel(); //��� �г�
		p_north.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_north.setBackground(new Color(255, 158, 60)); //����
		p_north.setBounds(0, 0, 600, 80); //ũ��
		p_background.add(p_north); //background�� ��� �г� ����
			

		//JLabel-------------------------------------------------
		
		JLabel title_label = new JLabel("���� ���� ����");
		title_label.setBounds(10, 15, 300, 50); //��ġ
		title_label.setForeground(Color.white); //���� ��
		title_label.setFont(new Font("Dailog", Font.BOLD, 40)); //���� ��Ʈ, ũ��
		p_north.add(title_label);
		
		
		JLabel card_label = new JLabel("ī�� ����");
		card_label.setBounds(110, 410, 300, 50); //��ġ
		card_label.setFont(new Font("Dailog", Font.BOLD, 20)); //���� ��Ʈ, ũ��
		p_background.add(card_label);
		
		
		JLabel cash_label = new JLabel("���� ����");
		cash_label.setBounds(400, 410, 300, 50); //��ġ
		cash_label.setFont(new Font("Dailog", Font.BOLD, 20)); //���� ��Ʈ, ũ��
		p_background.add(cash_label);
		
		
		//Image---------------------------------------------------
		ImageIcon card_icon = new ImageIcon("./images/img/card2.png"); //card ������ 
		ImageIcon cash_icon = new ImageIcon("./images/img/cash.png");  //cash ������ 
		ImageIcon burger_icon = new ImageIcon("./images/img/burger_pic.png");
	
		JButton card_btn = new JButton(card_icon); //card ������ ��ư ����
		JButton cash_btn = new JButton(cash_icon); //cash ������ ��ư ����
		
		JLabel burger_label = new JLabel(burger_icon);
		burger_label.setBounds(52, 340, 500, 540);
		p_background.add(burger_label);
		
		card_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư border ��
		card_btn.setBounds(0, 210, 300, 200); //��ư ũ��
		card_btn.setBackground(Color.white); //��ư �� 
		p_background.add(card_btn);
		
		
		cash_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư border ��
		cash_btn.setBounds(300, 210, 300, 200); //��ư ũ��
		cash_btn.setBackground(Color.white); // ��ư ��
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
