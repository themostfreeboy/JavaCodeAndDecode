//2014年6月18日第1版
//适用于任何文件
//加密原理:通过随机数产生一个128~255之间的随机整数int型，然后转化为4个Byte型，将此4个Byte由低位到高位添加在加密后的文件头(实际前4个Byte一定为x000)，然后再接着写入这个随机数这个多个Byte型数据，后面是(原始数据+这个随机数)并对256取余。
//解密原理:与加密原理相反，先提取文件头的由低位到高位的4个Byte翻译回int型的整数，然后接着忽略掉这个整数这么多的Byte，之后将(数+256-提取出来的随机数)，并对256取余，即为原始数据。
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class MainProgram_2 extends JFrame implements ActionListener
{
	    //登陆界面代码start
		JFrame jf1;//登陆界面
		JPanel jpl1;//jf1中的整体布局
		JPanel jpl2;//jf1中的上方布局
		JPanel jpl3;//jf1中的中方布局
		JPanel jpl3_temp;//jpl3中的临时布局，用于解决jtf1和jpf1中的text区域被无限放大的问题
		JPanel jpl4;//jf1中的下方布局
		JButton jbt1;//jf1中的确认
		JButton jbt2;//jf1中的重置
		JButton jbt3;//jf1中的退出
		JLabel jlb1;//用户名
		JLabel jlb2;//密码
		JLabel jlb3;//提示输入用户名和密码
		JTextField jtf1;//用户名
		JPasswordField jpf1;//密码
		String[] UserName=new String[100];
		String[] UserPassword=new String[100];
		int TotalOfUser=3;
		//登陆界面代码end
		
		//选择界面代码start
	    JFrame jf2;//加密文件与解密文件的选择界面
	    JPanel jpl5;//jf2中的整体布局
	    JPanel jpl6;//jf2中的上方布局
	    JPanel jpl7;//jf2中的中间布局
	    JPanel jpl8;//jf2中的下方布局
	    JComboBox jcb1;//加密文件与解密文件的选择
	    String[] com=new String[2];//选择列表项目数组
	    JButton jbt4;//jf2中的确认
	    JButton jbt5;//jf2中的退出
	    //选择界面代码end
	    
	    //加密界面代码start
	    JFrame jf3;//加密界面
	    JPanel jpl9;//jf3中的整体布局
	    JPanel jpl11;//jpl9中的上方布局
	    JPanel jpl12;//jpl9中的下方布局
	    JLabel jlb4;//加密文件
	    JButton jbt6;//返回键
	    JButton jbt7;//请选择待加密的文件
	    JButton jbt8;//退出键
	    //加密界面代码end
	    
	    //解密界面代码start
	    JFrame jf4;//解密界面
	    JPanel jpl10;//jf4中的整体布局
	    JPanel jpl13;//jpl10中的上方布局
	    JPanel jpl14;//jpl10中的下方布局
	    JLabel jlb5;//解密文件
	    JButton jbt9;//返回键
	    JButton jbt10;//请选择待解密的文件
	    JButton jbt11;//退出键
	    //解密图片界面代码end

	    public MainProgram_2()//构造函数
	    {
	    	//登陆界面代码start
	    	UserName[0]=new String("JXL");
			UserPassword[0]=new String("JXL");
			UserName[1]=new String("jxl");
			UserPassword[1]=new String("jxl");
			UserName[2]=new String("2012211706");
			UserPassword[2]=new String("2012211706");
			jf1=new JFrame();//登陆界面
			jf1.setLayout(new BorderLayout());
			jf2=new JFrame();//登陆成功界面
			jf2.setLayout(new BorderLayout());
			jpl1=new JPanel();//jf1中的整体布局
			jpl1.setLayout(new BorderLayout());
			jpl2=new JPanel();//jf1中的上方布局
			jpl2.setLayout(new FlowLayout());
			jpl3=new JPanel();//jf1中的中方布局
			jpl3.setLayout(new GridLayout(2,2,1,1));
			jpl3_temp=new JPanel();
			jpl3_temp.setLayout(new FlowLayout());
			jpl4=new JPanel();//jf1中的下方布局
			jpl4.setLayout(new FlowLayout());
			jpl5=new JPanel();//jf1中的下方布局
			jpl5.setLayout(new BorderLayout());
			//jf1的设置
			jbt1=new JButton("确认");
			jbt2=new JButton("重置");
			jbt3=new JButton("退出");
			jlb1=new JLabel("用户名：");
			jlb2=new JLabel("密码：");
			jlb3=new JLabel("请输入用户名和密码：");
			jtf1=new JTextField(10);
			jpf1=new JPasswordField(10);
			jpl2.add(jlb3);
			jpl3.add(jlb1);
			jpl3.add(jtf1);
			jpl3.add(jlb2);
			jpl3.add(jpf1);
			jpl3_temp.add(jpl3);
			jpl4.add(jbt1);
			jpl4.add(jbt2);
			jpl4.add(jbt3);
			jpl1.add(jpl2,BorderLayout.NORTH);
			jpl1.add(jpl3_temp,BorderLayout.CENTER);
			jpl1.add(jpl4,BorderLayout.SOUTH);
			jf1.add(jpl1,BorderLayout.CENTER);
			jbt1.addActionListener(this);//对确认按键的监听
			jbt2.addActionListener(this);//对重置按键的监听
			jbt3.addActionListener(this);//对退出按键的监听
			jtf1.addActionListener(this);//对用户名区域回车按键的监听
			jpf1.addActionListener(this);//对密码区域回车按键的监听
			jf1.setTitle("加密解密软件(JXL制)");
			jf1.setSize(350,170);
			jf1.setLocationRelativeTo(null);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf1.setVisible(true);
			//登陆界面代码end
			
			//选择界面代码start
			com[0]=new String("加密文件");
			com[1]=new String("解密文件");
			jcb1=new JComboBox(com);
			jpl5=new JPanel();
			jpl6=new JPanel();
			jpl7=new JPanel();
			jpl8=new JPanel();
			jpl6.add(new JLabel("请选择功能类型"));
			jpl7.add(jcb1);
			jbt4=new JButton("确认");
			jbt5=new JButton("退出");
			jpl8.add(jbt4);
			jpl8.add(jbt5);
			jpl5.setLayout(new BorderLayout());
			jpl5.add(jpl6,BorderLayout.NORTH);
			jpl5.add(jpl7,BorderLayout.CENTER);
			jpl5.add(jpl8,BorderLayout.SOUTH);
			jf2.add(jpl5);
			jbt4.addActionListener(this);//对确认键的监听
			jbt5.addActionListener(this);//对退出键的监听
			jf2.setTitle("加密解密软件(JXL制)");
			jf2.setSize(350,170);
			jf2.setLocationRelativeTo(null);
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf2.setVisible(false);
			//选择界面代码end
			
			//加密界面代码start
			jf3=new JFrame();
			jlb4=new JLabel("加密文件");
			jbt6=new JButton("返回");
			jbt7=new JButton("选择待加密的文件");
			jbt8=new JButton("退出");
			jpl9=new JPanel();
			jpl11=new JPanel();
			jpl12=new JPanel();
			jpl9.setLayout(new BorderLayout());
			jpl11.add(jlb4);
			jpl12.add(jbt6);
			jpl12.add(jbt7);
			jpl12.add(jbt8);
			jpl9.add(jpl11,BorderLayout.NORTH);
			jpl9.add(jpl12,BorderLayout.SOUTH);
			jf3.add(jpl9);
			jbt6.addActionListener(this);
			jbt7.addActionListener(this);
			jbt8.addActionListener(this);
			jf3.setTitle("加密解密软件(JXL制)");
			jf3.setSize(350,170);
			jf3.setLocationRelativeTo(null);
			jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf3.setVisible(false);
			//加密界面代码end
					
			//解密界面代码start
			jf4=new JFrame();
			jlb5=new JLabel("解密文件");
			jbt9=new JButton("返回");
			jbt10=new JButton("选择待解密的文件");
			jbt11=new JButton("退出");
			jpl10=new JPanel();
			jpl13=new JPanel();
			jpl14=new JPanel();
			jpl10.setLayout(new BorderLayout());
			jpl13.add(jlb5);
			jpl14.add(jbt9);
			jpl14.add(jbt10);
			jpl14.add(jbt11);
			jpl10.add(jpl13,BorderLayout.NORTH);
			jpl10.add(jpl14,BorderLayout.SOUTH);
			jf4.add(jpl10);
			jbt9.addActionListener(this);
			jbt10.addActionListener(this);
			jbt11.addActionListener(this);
			jf4.setTitle("加密解密软件(JXL制)");
			jf4.setSize(350,170);
			jf4.setLocationRelativeTo(null);
			jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf4.setVisible(false);
			//解密界面代码end
			
	    }

	    public void actionPerformed(ActionEvent e)
		{
	    	
	    	//登陆界面代码start
			if(e.getSource()==jbt1||e.getSource()==jtf1||e.getSource()==jpf1)//点击确认键或在用户名区域敲击回车键或在密码区域敲击回车键
			{
				String TempPassword=new String(jpf1.getPassword());
				for(int i=0;i<TotalOfUser;i++)
				{
					if(jtf1.getText().length()==0&&TempPassword.length()==0)//用户名和密码均为空
					{
						jlb3.setText("用户名和密码不能为空，请重新输入用户名和密码：");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(jtf1.getText().length()==0)//仅用户名为空
					{
						jlb3.setText("用户名不能为空，请重新输入用户名和密码：");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(TempPassword.length()==0)//仅密吗为空
					{
						jlb3.setText("密码不能为空，请重新输入用户名和密码：");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(UserName[i].equals(jtf1.getText())&&TempPassword.equals(UserPassword[i]))//用户名和密码输入正确
					{
						jf1.setVisible(false);
						jf2.setVisible(true);
						jf1.repaint();
						jf2.repaint();
						return;
					}
				}
				//用户名和密码输入错误
				jlb3.setText("你输入的用户名或密码有误，请重新输入用户名和密码：");
				jtf1.setText("");
				jpf1.setText("");
				jf1.repaint();
				return;
			}
			else if(e.getSource()==jbt2)//点击重置键
			{
				jtf1.setText("");
				jpf1.setText("");
				jf1.repaint();
			}
			else if(e.getSource()==jbt3)//点击退出键
			{
				System.exit(0);
			}
			//登陆界面代码end
			
			//选择界面代码start
			if(e.getSource()==jbt4)//点击确认键
			{
				String comchoose=(String)jcb1.getSelectedItem();
						
				//第一个图片界面代码start
				if(comchoose.equals(com[0]))//Server
				{
					jf2.setVisible(false);
					jf3.setVisible(true);
				}
				//第一个图片界面代码end
						
				//第二个图片界面代码start
				else if(comchoose.equals(com[1]))//Client
				{
					jf2.setVisible(false);
					jf4.setVisible(true);
				}
				//第二个图片界面代码end
						
			}
			else if(e.getSource()==jbt5)//点击退出键
			{
				System.exit(0);
			}
			//选择界面代码end
			
			//加密文件代码start
			if(e.getSource()==jbt6)//返回键
			{
				jf3.setVisible(false);
				jf2.setVisible(true);
			}
			if(e.getSource()==jbt7)//加密文件
			{
				JFileChooser jfc_code=new JFileChooser();
				jfc_code.setDialogTitle("请选择待加密文件");
				int flag_code;
	            flag_code=jfc_code.showOpenDialog(jf3);//这里显示打开文件的对话框 
	            if(flag_code==JFileChooser.APPROVE_OPTION)//如果按下确定按钮，则获得该文件
	            {
	                       File f_code=jfc_code.getSelectedFile();//获得该文件    
						   try 
						   {
								FileOutputStream fos=new FileOutputStream(f_code.getAbsolutePath()+"(已加密)");
								BufferedOutputStream bos=new BufferedOutputStream(fos);
			       				FileInputStream fis = new FileInputStream(f_code);
								BufferedInputStream bis=new BufferedInputStream(fis);
			       				byte[] buf_code= new byte[2048];
			       				int len_code = 0;
			       				int n_code=(int)(Math.random()*1000%128+128);//128~255
			       			    buf_code[0] = (byte) (0xff & n_code);
			       	            buf_code[1] = (byte) ((0xff00 & n_code)>>8);
			       	            buf_code[2] = (byte) ((0xff0000 & n_code)>>16);
			       	            buf_code[3] = (byte) ((0xff000000 & n_code)>>24);
			       	            bos.write(buf_code,0,4);
			       				for(int i=0;i<n_code;i++)
			       				{
			       					buf_code[i]=(byte) (0xff &(int)(Math.random()*1000%128+128));//128~255
			       				}
			       				bos.write(buf_code,0,n_code);
			       				int temp_code=0;
			                    while((len_code=bis.read())!=-1)
			       				{
			                    	   temp_code=len_code & 0xff;
			                    	   temp_code=(temp_code+n_code)%256;
			       				   	   bos.write((byte) (0xff & temp_code));
			       				}
			       				bis.close();
			       				bos.close();
							} 
						   catch (IOException e1)
						   {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						   }
	       				   JOptionPane.showMessageDialog(null,"加密文件完成");
	                       jf3.repaint();
	                       jf3.setVisible(true);
	             }
			}
			if(e.getSource()==jbt8)//退出键
			{
				System.exit(0);
			}
			//加密文件代码end
			
			//解密文件代码start
			if(e.getSource()==jbt9)//返回键
			{
				jf4.setVisible(false);
				jf2.setVisible(true);
			}
			if(e.getSource()==jbt10)//解密文件
			{
				JFileChooser jfc_decode=new JFileChooser();
				jfc_decode.setDialogTitle("请选择待加密文件");
				int flag_decode;
	            flag_decode=jfc_decode.showOpenDialog(jf3);//这里显示打开文件的对话框 
	            if(flag_decode==JFileChooser.APPROVE_OPTION)//如果按下确定按钮，则获得该文件
	            {
	                       File f_decode=jfc_decode.getSelectedFile();//获得该文件    
						   try 
						   {
								FileOutputStream fos=new FileOutputStream(f_decode.getAbsolutePath()+"(已解密)");
								BufferedOutputStream bos=new BufferedOutputStream(fos);
			       				FileInputStream fis = new FileInputStream(f_decode);
								BufferedInputStream bis=new BufferedInputStream(fis);
			       				byte[] buf_decode = new byte[2048];
			       				int len_decode = 0;
			       				int n_decode;
			       			    n_decode = bis.read() & 0xff;
			       			    n_decode |= ((bis.read() << 8)  & 0xff00);
			       			    n_decode |= ((bis.read() << 16) & 0xff0000);
			       			    n_decode |= ((bis.read() << 24) & 0xff000000);
			                    for(int i=0;i<n_decode;i++)
			                    {
			                    	bis.read();
			                    }
			                    int temp_decode=0;
			                    while((len_decode=bis.read())!=-1)
			       				{
			                    	   temp_decode=len_decode & 0xff;
			                    	   temp_decode=(temp_decode+256-n_decode)%256;
			       				   	   bos.write((byte) (0xff & temp_decode));
			       				}
			       				bis.close();
			       				bos.close();
							} 
						   catch (IOException e1)
						   {
								// TODO Auto-generated catch block
								e1.printStackTrace();
						   }
	       				   JOptionPane.showMessageDialog(null,"解密文件完成");
	                       jf4.repaint();
	                       jf4.setVisible(true);
	             }
			}
			if(e.getSource()==jbt11)//退出键
			{
				System.exit(0);
			}
			//解密文件代码end
		}
	    
	    public static void main(String[] args) 
	    {
		    // TODO Auto-generated method stub
		    new MainProgram_2();
	    }
}
