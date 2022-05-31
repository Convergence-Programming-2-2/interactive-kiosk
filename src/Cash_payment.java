import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cash_payment extends JFrame{
	public Cash_payment() {
		setTitle("���� ����â");
		setSize(500, 400);
		
		//�����̳� ----------------------------------------------------
		Container c = getContentPane();//�ϴ��� �гε��� �����̳ʿ� ������ ����
		c.setLayout(null);
		
		
		//JPanner--------------------------------------------
		//background �г�
		JPanel p_background = new JPanel(); 
		p_background.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_background.setBackground(Color.white); 
		p_background.setBounds(0, 0, 500, 400); 
		c.add(p_background);
		
		//��ܹ�
		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(255, 158, 60));//��Ȳ��
		p_north.setBounds(0, 0, 500, 60);
		p_background.add(p_north);
		
		//��� ȭ�� 
		JPanel p_foreground = new JPanel();
		p_foreground.setLayout(null);
		p_foreground.setBackground((new Color(255, 248, 243))); //���̺�����
		p_foreground.setBounds(25, 60, 430, 300);
		p_background.add(p_foreground);
		

		//JLabel---------------------------------------------
		JLabel title = new JLabel("���� ŷ����");//��� �� Ÿ��Ʋ
		title.setBounds(10, 7, 300, 50);
		title.setForeground(Color.white); 
		title.setFont(new Font("Dailog", Font.BOLD, 35)); 
		p_north.add(title);
			
		JLabel quest = new JLabel("������ �������ּ���"); //��û����
		quest.setBounds(40, 5, 200, 50); 
		quest.setForeground(Color.black); 
		quest.setFont(new Font("Dailog", Font.BOLD, 15));
		p_foreground.add(quest);
		
		//�����Ϸ��ư
		JButton wait_btn = new JButton("���� �� �Դϴ�. ��ø� ��ٷ��ּ���:)"); //�� ��ư�� ������ ���� �Ϸ�â���� �Ѿ �� �ְԲ�
		wait_btn.setBounds(100, 300, 300, 50); 
		wait_btn.setForeground(Color.black); //���ڻ�(����)
		wait_btn.setBackground(new Color(255, 248, 243));//��ư ����(���̺�����)
		wait_btn.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 243))); //��ư �׵θ� ��(���̺�����)
		wait_btn.setFont(new Font("Dialog", Font.BOLD, 15)); //���� ��Ÿ��
		c.add(wait_btn);
		

		//��û���� �׸�-----------------------------------------------------
        ImageIcon cash_icon = new ImageIcon("./images/img/cash_img2.png");//���� ���� ������ �߰�
		JLabel cash_label = new JLabel(cash_icon);
		cash_label.setBounds(90, 25, 280, 250);
		p_foreground.add(cash_label);
		
		//event-------------------------------------------------------
		wait_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  finish f = new finish();
		    	  f.setVisible(true); //���� �Ϸ�â(finish) ����  	  
		    	  setVisible(false); //���ݰ���â(Cash_payment0 �ݰ�
		      }
		  });
		
		this.setLocation(500, 20);
		
	}
}
