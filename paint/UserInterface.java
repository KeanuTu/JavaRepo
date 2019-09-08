package paint;

import javax.swing.JFrame;

/**
  @ClassName: �˻��������� 

* @Description: 

* @author A18ccms a18ccms_gmail_com 

*
 */
public class UserInterface extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		//������
		JFrame frame = new JFrame("Paint");
		
 
        // ����������λ��
        frame.setLocation(200, 200);
 
       
		
		//�ر�������ʱ���˳�����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel paintPanel = new DrawingPanel();
		
		//���ð�ť��
		ButtonPanel mainPanel = new ButtonPanel(paintPanel);
		frame.getContentPane().add(mainPanel);
		
		//
		frame.setVisible(true);
		frame.pack();
	}	
}
