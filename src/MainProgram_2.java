//2014��6��18�յ�1��
//�������κ��ļ�
//����ԭ��:ͨ�����������һ��128~255֮����������int�ͣ�Ȼ��ת��Ϊ4��Byte�ͣ�����4��Byte�ɵ�λ����λ����ڼ��ܺ���ļ�ͷ(ʵ��ǰ4��Byteһ��Ϊx000)��Ȼ���ٽ���д����������������Byte�����ݣ�������(ԭʼ����+��������)����256ȡ�ࡣ
//����ԭ��:�����ԭ���෴������ȡ�ļ�ͷ���ɵ�λ����λ��4��Byte�����int�͵�������Ȼ����ź��Ե����������ô���Byte��֮��(��+256-��ȡ�����������)������256ȡ�࣬��Ϊԭʼ���ݡ�
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
	    //��½�������start
		JFrame jf1;//��½����
		JPanel jpl1;//jf1�е����岼��
		JPanel jpl2;//jf1�е��Ϸ�����
		JPanel jpl3;//jf1�е��з�����
		JPanel jpl3_temp;//jpl3�е���ʱ���֣����ڽ��jtf1��jpf1�е�text�������޷Ŵ������
		JPanel jpl4;//jf1�е��·�����
		JButton jbt1;//jf1�е�ȷ��
		JButton jbt2;//jf1�е�����
		JButton jbt3;//jf1�е��˳�
		JLabel jlb1;//�û���
		JLabel jlb2;//����
		JLabel jlb3;//��ʾ�����û���������
		JTextField jtf1;//�û���
		JPasswordField jpf1;//����
		String[] UserName=new String[100];
		String[] UserPassword=new String[100];
		int TotalOfUser=3;
		//��½�������end
		
		//ѡ��������start
	    JFrame jf2;//�����ļ�������ļ���ѡ�����
	    JPanel jpl5;//jf2�е����岼��
	    JPanel jpl6;//jf2�е��Ϸ�����
	    JPanel jpl7;//jf2�е��м䲼��
	    JPanel jpl8;//jf2�е��·�����
	    JComboBox jcb1;//�����ļ�������ļ���ѡ��
	    String[] com=new String[2];//ѡ���б���Ŀ����
	    JButton jbt4;//jf2�е�ȷ��
	    JButton jbt5;//jf2�е��˳�
	    //ѡ��������end
	    
	    //���ܽ������start
	    JFrame jf3;//���ܽ���
	    JPanel jpl9;//jf3�е����岼��
	    JPanel jpl11;//jpl9�е��Ϸ�����
	    JPanel jpl12;//jpl9�е��·�����
	    JLabel jlb4;//�����ļ�
	    JButton jbt6;//���ؼ�
	    JButton jbt7;//��ѡ������ܵ��ļ�
	    JButton jbt8;//�˳���
	    //���ܽ������end
	    
	    //���ܽ������start
	    JFrame jf4;//���ܽ���
	    JPanel jpl10;//jf4�е����岼��
	    JPanel jpl13;//jpl10�е��Ϸ�����
	    JPanel jpl14;//jpl10�е��·�����
	    JLabel jlb5;//�����ļ�
	    JButton jbt9;//���ؼ�
	    JButton jbt10;//��ѡ������ܵ��ļ�
	    JButton jbt11;//�˳���
	    //����ͼƬ�������end

	    public MainProgram_2()//���캯��
	    {
	    	//��½�������start
	    	UserName[0]=new String("JXL");
			UserPassword[0]=new String("JXL");
			UserName[1]=new String("jxl");
			UserPassword[1]=new String("jxl");
			UserName[2]=new String("2012211706");
			UserPassword[2]=new String("2012211706");
			jf1=new JFrame();//��½����
			jf1.setLayout(new BorderLayout());
			jf2=new JFrame();//��½�ɹ�����
			jf2.setLayout(new BorderLayout());
			jpl1=new JPanel();//jf1�е����岼��
			jpl1.setLayout(new BorderLayout());
			jpl2=new JPanel();//jf1�е��Ϸ�����
			jpl2.setLayout(new FlowLayout());
			jpl3=new JPanel();//jf1�е��з�����
			jpl3.setLayout(new GridLayout(2,2,1,1));
			jpl3_temp=new JPanel();
			jpl3_temp.setLayout(new FlowLayout());
			jpl4=new JPanel();//jf1�е��·�����
			jpl4.setLayout(new FlowLayout());
			jpl5=new JPanel();//jf1�е��·�����
			jpl5.setLayout(new BorderLayout());
			//jf1������
			jbt1=new JButton("ȷ��");
			jbt2=new JButton("����");
			jbt3=new JButton("�˳�");
			jlb1=new JLabel("�û�����");
			jlb2=new JLabel("���룺");
			jlb3=new JLabel("�������û��������룺");
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
			jbt1.addActionListener(this);//��ȷ�ϰ����ļ���
			jbt2.addActionListener(this);//�����ð����ļ���
			jbt3.addActionListener(this);//���˳������ļ���
			jtf1.addActionListener(this);//���û�������س������ļ���
			jpf1.addActionListener(this);//����������س������ļ���
			jf1.setTitle("���ܽ������(JXL��)");
			jf1.setSize(350,170);
			jf1.setLocationRelativeTo(null);
			jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf1.setVisible(true);
			//��½�������end
			
			//ѡ��������start
			com[0]=new String("�����ļ�");
			com[1]=new String("�����ļ�");
			jcb1=new JComboBox(com);
			jpl5=new JPanel();
			jpl6=new JPanel();
			jpl7=new JPanel();
			jpl8=new JPanel();
			jpl6.add(new JLabel("��ѡ��������"));
			jpl7.add(jcb1);
			jbt4=new JButton("ȷ��");
			jbt5=new JButton("�˳�");
			jpl8.add(jbt4);
			jpl8.add(jbt5);
			jpl5.setLayout(new BorderLayout());
			jpl5.add(jpl6,BorderLayout.NORTH);
			jpl5.add(jpl7,BorderLayout.CENTER);
			jpl5.add(jpl8,BorderLayout.SOUTH);
			jf2.add(jpl5);
			jbt4.addActionListener(this);//��ȷ�ϼ��ļ���
			jbt5.addActionListener(this);//���˳����ļ���
			jf2.setTitle("���ܽ������(JXL��)");
			jf2.setSize(350,170);
			jf2.setLocationRelativeTo(null);
			jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf2.setVisible(false);
			//ѡ��������end
			
			//���ܽ������start
			jf3=new JFrame();
			jlb4=new JLabel("�����ļ�");
			jbt6=new JButton("����");
			jbt7=new JButton("ѡ������ܵ��ļ�");
			jbt8=new JButton("�˳�");
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
			jf3.setTitle("���ܽ������(JXL��)");
			jf3.setSize(350,170);
			jf3.setLocationRelativeTo(null);
			jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf3.setVisible(false);
			//���ܽ������end
					
			//���ܽ������start
			jf4=new JFrame();
			jlb5=new JLabel("�����ļ�");
			jbt9=new JButton("����");
			jbt10=new JButton("ѡ������ܵ��ļ�");
			jbt11=new JButton("�˳�");
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
			jf4.setTitle("���ܽ������(JXL��)");
			jf4.setSize(350,170);
			jf4.setLocationRelativeTo(null);
			jf4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf4.setVisible(false);
			//���ܽ������end
			
	    }

	    public void actionPerformed(ActionEvent e)
		{
	    	
	    	//��½�������start
			if(e.getSource()==jbt1||e.getSource()==jtf1||e.getSource()==jpf1)//���ȷ�ϼ������û��������û��س����������������û��س���
			{
				String TempPassword=new String(jpf1.getPassword());
				for(int i=0;i<TotalOfUser;i++)
				{
					if(jtf1.getText().length()==0&&TempPassword.length()==0)//�û����������Ϊ��
					{
						jlb3.setText("�û��������벻��Ϊ�գ������������û��������룺");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(jtf1.getText().length()==0)//���û���Ϊ��
					{
						jlb3.setText("�û�������Ϊ�գ������������û��������룺");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(TempPassword.length()==0)//������Ϊ��
					{
						jlb3.setText("���벻��Ϊ�գ������������û��������룺");
						jtf1.setText("");
						jpf1.setText("");
						jf1.repaint();
						return;
					}
					else if(UserName[i].equals(jtf1.getText())&&TempPassword.equals(UserPassword[i]))//�û���������������ȷ
					{
						jf1.setVisible(false);
						jf2.setVisible(true);
						jf1.repaint();
						jf2.repaint();
						return;
					}
				}
				//�û����������������
				jlb3.setText("��������û������������������������û��������룺");
				jtf1.setText("");
				jpf1.setText("");
				jf1.repaint();
				return;
			}
			else if(e.getSource()==jbt2)//������ü�
			{
				jtf1.setText("");
				jpf1.setText("");
				jf1.repaint();
			}
			else if(e.getSource()==jbt3)//����˳���
			{
				System.exit(0);
			}
			//��½�������end
			
			//ѡ��������start
			if(e.getSource()==jbt4)//���ȷ�ϼ�
			{
				String comchoose=(String)jcb1.getSelectedItem();
						
				//��һ��ͼƬ�������start
				if(comchoose.equals(com[0]))//Server
				{
					jf2.setVisible(false);
					jf3.setVisible(true);
				}
				//��һ��ͼƬ�������end
						
				//�ڶ���ͼƬ�������start
				else if(comchoose.equals(com[1]))//Client
				{
					jf2.setVisible(false);
					jf4.setVisible(true);
				}
				//�ڶ���ͼƬ�������end
						
			}
			else if(e.getSource()==jbt5)//����˳���
			{
				System.exit(0);
			}
			//ѡ��������end
			
			//�����ļ�����start
			if(e.getSource()==jbt6)//���ؼ�
			{
				jf3.setVisible(false);
				jf2.setVisible(true);
			}
			if(e.getSource()==jbt7)//�����ļ�
			{
				JFileChooser jfc_code=new JFileChooser();
				jfc_code.setDialogTitle("��ѡ��������ļ�");
				int flag_code;
	            flag_code=jfc_code.showOpenDialog(jf3);//������ʾ���ļ��ĶԻ��� 
	            if(flag_code==JFileChooser.APPROVE_OPTION)//�������ȷ����ť�����ø��ļ�
	            {
	                       File f_code=jfc_code.getSelectedFile();//��ø��ļ�    
						   try 
						   {
								FileOutputStream fos=new FileOutputStream(f_code.getAbsolutePath()+"(�Ѽ���)");
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
	       				   JOptionPane.showMessageDialog(null,"�����ļ����");
	                       jf3.repaint();
	                       jf3.setVisible(true);
	             }
			}
			if(e.getSource()==jbt8)//�˳���
			{
				System.exit(0);
			}
			//�����ļ�����end
			
			//�����ļ�����start
			if(e.getSource()==jbt9)//���ؼ�
			{
				jf4.setVisible(false);
				jf2.setVisible(true);
			}
			if(e.getSource()==jbt10)//�����ļ�
			{
				JFileChooser jfc_decode=new JFileChooser();
				jfc_decode.setDialogTitle("��ѡ��������ļ�");
				int flag_decode;
	            flag_decode=jfc_decode.showOpenDialog(jf3);//������ʾ���ļ��ĶԻ��� 
	            if(flag_decode==JFileChooser.APPROVE_OPTION)//�������ȷ����ť�����ø��ļ�
	            {
	                       File f_decode=jfc_decode.getSelectedFile();//��ø��ļ�    
						   try 
						   {
								FileOutputStream fos=new FileOutputStream(f_decode.getAbsolutePath()+"(�ѽ���)");
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
	       				   JOptionPane.showMessageDialog(null,"�����ļ����");
	                       jf4.repaint();
	                       jf4.setVisible(true);
	             }
			}
			if(e.getSource()==jbt11)//�˳���
			{
				System.exit(0);
			}
			//�����ļ�����end
		}
	    
	    public static void main(String[] args) 
	    {
		    // TODO Auto-generated method stub
		    new MainProgram_2();
	    }
}
