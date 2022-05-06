import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Menu extends JFrame{
	public Menu() {
		setTitle("�޴�â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â ������ ���α׷� ����
		
		//�����̳� ------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner------------------------------------------------
		JPanel p_background = new JPanel();
		p_background.setLayout(null);
		p_background.setBackground(Color.white);
		p_background.setBounds(0, 0, 600, 800);
		c.add(p_background);
		
		JPanel p_north = new JPanel();
		p_north.setLayout(null);
		p_north.setBackground(new Color(255, 158, 60));
		p_north.setBounds(0, 0, 600, 80);
		p_background.add(p_north);
		

		//JLabel-------------------------------------------------
		
		JLabel title = new JLabel("���� ŷ ����");
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
		p_background.add(order_btn);
		
		JButton cancel_btn = new JButton("����ϱ�");
		cancel_btn.setBounds(300, 665, 300, 100);//��ġ
		cancel_btn.setBackground(new Color(255, 158, 60));//���� ��
		cancel_btn.setForeground(Color.white); // ��� ��
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white));//��ư �׵θ� ��
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 40)); // ���� ��Ʈ �� ũ��
		p_background.add(cancel_btn);
		
		
		//�̺�Ʈ, ���� �˾�â ���̾�α� ����-------------------------------------------
		
		order_Dialog d = new order_Dialog();
		
		order_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(true); //���� �˾�â ����
				setVisible(false); // �޴� â�� ��
			}
		});
		
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	
		// ������ ũ�� ----------------------------------------------
		setSize(600, 800);
		setVisible(true);
					
	}//Payment
}//JFrame




public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}

}