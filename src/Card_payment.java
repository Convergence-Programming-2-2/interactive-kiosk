import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card_payment extends JFrame{
		
	public Card_payment() {//������
		setTitle("ī�� ����â");
		setSize(500, 400);
		
		//�����̳� ----------------------------------------------------
		Container c = getContentPane(); //�ϴ��� �гε��� �����̳ʿ� ������ ����
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
		
		//��� ������ �г�
		JPanel p_foreground = new JPanel();
		p_foreground.setLayout(null);
		p_foreground.setBackground((new Color(255, 248, 243)));//���̺�����
		p_foreground.setBounds(25, 60, 430, 300);
		p_background.add(p_foreground);
		

		//JLabel---------------------------------------------
		JLabel title = new JLabel("���� ŷ����");//��� �� Ÿ��Ʋ
		title.setBounds(10, 7, 300, 50); 
		title.setForeground(Color.white);
		title.setFont(new Font("Dailog", Font.BOLD, 35)); 
		p_north.add(title);
			
		JLabel quest = new JLabel("ī�带 �������ּ���");//��û����
		quest.setBounds(40, 5, 200, 50); 
		quest.setForeground(Color.black);
		quest.setFont(new Font("Dailog", Font.BOLD, 15)); 
		p_foreground.add(quest);
		
		//�����Ϸ��ư
		JButton wait_btn = new JButton("���� �� �Դϴ�. ��ø� ��ٷ��ּ���:)"); //�� ��ư�� ������ ���� �Ϸ�â���� �Ѿ �� �ְԲ�
		wait_btn.setBounds(100, 300, 300, 50);
		wait_btn.setForeground(Color.black); //���ڻ�(����)
		wait_btn.setBackground(new Color(255, 248, 243)); //��ư ����(���̺�����)
		wait_btn.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 243))); //��ư �׵θ� ��(���̺�����)
		wait_btn.setFont(new Font("Dialog", Font.BOLD, 15));
		c.add(wait_btn);
		
		/*����->�ȵǸ� �̰ŷ�!
		JLabel wait = new JLabel("���� �� �Դϴ�. ��ø� ��ٷ��ּ���:)");
		wait.setBounds(150, 200, 400, 50); //��ġ
		wait.setForeground(Color.black); //���� ��
		wait.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_foreground.add(wait);
		*/
		
		/*�ð���
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JLabel wait1 = new JLabel(new ImageIcon("./images/img/cash.png"));
		wait1.setToolTipText("���� �� �Դϴ�. ��ø� ��ٷ��ּ���:)");
		contentPane.add(wait1);
		
	
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(10000);
		*/

		//��û���� �׸�-----------------------------------------------------
        ImageIcon card_icon = new ImageIcon("./images/img/card_img2.png"); //ī������ ������ �߰�
		JLabel card_label = new JLabel(card_icon);
		card_label.setBounds(90, 45, 270, 200);
		p_foreground.add(card_label);
		
		//event-------------------------------------------------------
		wait_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  finish f = new finish();
		    	  f.setVisible(true); //���� �Ϸ�â(finish) ����	    	  
		    	  setVisible(false); //ī�� ����â(Card_payment) �ݰ�
		      }
		  });
		this.setLocation(500, 20);
	}
}
