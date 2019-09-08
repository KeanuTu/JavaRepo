package paint;

import javax.swing.JFrame;

/**
  @ClassName: 人机交互界面 

* @Description: 

* @author A18ccms a18ccms_gmail_com 

*
 */
public class UserInterface extends JFrame 
{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		//主窗体
		JFrame frame = new JFrame("Paint");
		
 
        // 主窗体设置位置
        frame.setLocation(200, 200);
 
       
		
		//关闭主窗口时，退出程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawingPanel paintPanel = new DrawingPanel();
		
		//设置按钮类
		ButtonPanel mainPanel = new ButtonPanel(paintPanel);
		frame.getContentPane().add(mainPanel);
		
		//
		frame.setVisible(true);
		frame.pack();
	}	
}
