import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;


public class order_Dialog extends JDialog{
	public order_Dialog(ArrayList<String> arr) {
		setTitle("���� �˾�â");
	
		//�����̳� ----------------------------------------------------
		Container c = getContentPane();
		c.setLayout(null);
		
		//JPanner---------------------------------------------------
		JPanel p_background = new JPanel(); //background �г�
		p_background.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_background.setBackground(Color.white); //����
		p_background.setBounds(0, 0, 500, 400);  //ũ��
		c.add(p_background); //�����̳ʿ� background �г� ����
		
		
		JPanel p_north = new JPanel(); //��� �г�
		p_north.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_north.setBackground(new Color(255, 158, 60)); //����
		p_north.setBounds(0, 0, 500, 60); //ũ��
		p_background.add(p_north); //background�� ��� �г� ����
		

		JPanel p_foreground = new JPanel(); //foreground �г�
		p_foreground.setLayout(null); //���� ��ġ ������ ���� ���̾ƿ� null
		p_foreground.setBackground((new Color(255, 248, 243))); //����
		p_foreground.setBounds(25, 60, 430, 300); //ũ��
		p_background.add(p_foreground); //background�� foreground ���� 
		
		
		//JButton--------------------------------------------------
		JButton ok_btn = new JButton("Ok"); //��ư ����
		ok_btn.setBounds(0, 315, 250, 50); //��ư ��ġ
		ok_btn.setBackground(new Color(255, 158, 60)); //���� ��
		ok_btn.setForeground(Color.white); // ��� ��
		ok_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		ok_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // ���� ��Ʈ �� ũ��
		c.add(ok_btn); //�����̳ʿ� ��ư ����
		
		JButton cancel_btn = new JButton("Cancel");//��ư ����
		cancel_btn.setBounds(250, 315, 250, 50); //��ư ��ġ
		cancel_btn.setBackground(new Color(255, 158, 60)); //���� ��
		cancel_btn.setForeground(Color.white); // ��� ��
		cancel_btn.setBorder(BorderFactory.createLineBorder(Color.white)); //��ư �׵θ� ��
		cancel_btn.setFont(new Font("Dialog", Font.BOLD, 20)); // ���� ��Ʈ �� ũ��
		c.add(cancel_btn); //�����̳ʿ� ��ư ����
		
		
		//JLabel----------------------------------------------------		
		JLabel main_title = new JLabel("�ֹ� Ȯ��"); 
		main_title.setBounds(10, 5, 200, 50); //��ġ
		main_title.setForeground(Color.white); //���� ��
		main_title.setFont(new Font("Dailog", Font.BOLD, 30)); //���� ��Ʈ, ũ��
		p_north.add(main_title); //�гο� �� ����
			
		JLabel order_title = new JLabel("�ֹ� ����"); 
		order_title.setBounds(40, 5, 200, 50); //��ġ
		order_title.setForeground(Color.DARK_GRAY); //���� ��
		order_title.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_foreground.add(order_title); //�гο� �� ����

		int y_index = -121;
		String order_list = "<html>"; // �ٹٲ��� �ֱ� ���� html ���� ���
		for (int i = 0; i < 6; i++)
		{
			if (Integer.parseInt(arr.get(i)) != 0) // �ֹ��� ��ǰ�� 0���� �ƴ϶��
			{
				order_list += Constants.name[i] + ": " + arr.get(i) +"��<br>"; // ��ǰ��� �ֹ� ������ order_list�� �߰��ϰ�
				y_index += 11; // ������ ����
			}			
		}
		order_list += arr.get(6) + "</html>"; // ����/���� ���� �߰� �� html �ݱ�
		JLabel order_list_title = new JLabel(order_list); // order_list ���
		order_list_title.setBounds(200, y_index, 200, 300); // �ֹ��� ��ǰ ���� ���� ���� ������ ����
		order_list_title.setForeground(Color.DARK_GRAY); //���� ��
		order_list_title.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_foreground.add(order_list_title); //�гο� �� ����

		int sum = 0;
		for (int i = 0; i < 6; i++) // �� ���� �ݾ� ���
			sum += Constants.price[i] * Integer.parseInt(arr.get(i));
		JLabel total_price = new JLabel("�� ���� �ݾ� : " + sum + "��");
		total_price.setBounds(200, 200, 200, 50); //��ġ
		total_price.setForeground(Color.DARK_GRAY); //���� ��
		total_price.setFont(new Font("Dailog", Font.BOLD, 15)); //���� ��Ʈ, ũ��
		p_foreground.add(total_price); //�гο� �� ����
		
		
		//img-------------------------------------------------------
		ImageIcon burger_icon = new ImageIcon("./images/img/0.png"); //�̹��� ������ ����
		JLabel burger_label = new JLabel(burger_icon); // �󺧿� �̹��� ������ ��Ź
		burger_label.setBounds(20, 135, 100, 117); //�� ũ��
		p_foreground.add(burger_label); //�гο� �� ����
		
		//�̺�Ʈ------------------------------------------------------
		
		Payment p = new Payment();
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setVisible(true);// payment â ����
				setVisible(false); // order_dialog â ����
			}
		});
		

		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  // order_dialog ����
			}
		});
		
		setSize(500, 400);		
		
	}
}