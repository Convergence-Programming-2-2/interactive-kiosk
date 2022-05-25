import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cash_payment extends JFrame{
	public Cash_payment() {
		setTitle("���� ����â");
		setSize(500, 400);
		
		//�����̳� ----------------------------------------------------
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
		
		JLabel title = new JLabel("���� ŷ����");
		title.setBounds(10, 7, 300, 50); //��ġ
		title.setForeground(Color.white); //���� ��
		title.setFont(new Font("Dailog", Font.BOLD, 35)); //���� ��Ʈ, ũ��
		p_north.add(title);
			
		JLabel quest = new JLabel("������ �������ּ���");
		quest.setBounds(40, 5, 200, 50); //��ġ
		quest.setForeground(Color.black); //���� ��
		quest.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_foreground.add(quest);
		
		
		JButton wait_btn = new JButton("���� �� �Դϴ�. ��ø� ��ٷ��ּ���:)");
		wait_btn.setBounds(100, 300, 300, 50);
		wait_btn.setForeground(Color.black); // ��� ��
		wait_btn.setBackground(new Color(255, 248, 243)); //���� ��
		wait_btn.setBorder(BorderFactory.createLineBorder(new Color(255, 248, 243))); //��ư �׵θ� ��
		wait_btn.setFont(new Font("Dialog", Font.BOLD, 15)); // ���� ��Ʈ �� ũ��
		c.add(wait_btn);
		
		/*����(�ȵǸ� �̰ŷ�!)
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

        ImageIcon cash_icon = new ImageIcon("./images/img/cash_img2.png");
		JLabel cash_label = new JLabel(cash_icon);
		cash_label.setBounds(90, 25, 280, 250);
		p_foreground.add(cash_label);
		
		//�̺�Ʈ
		wait_btn.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	 
		    	  finish f = new finish();
		    	  f.setVisible(true); //	���� �Ϸ�â ����	    	  
		    	  setVisible(false); // ī�����â �ݰ�
		      }
		  });
		
	}
}
