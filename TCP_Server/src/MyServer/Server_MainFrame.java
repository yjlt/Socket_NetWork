package MyServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server_MainFrame extends JFrame {

	private JPanel contentPane;

	private static TextField listenport_textField;
	private static TextField savepath_textField;
	private static TextField ReceiveBufferSize_textField;
	private static TextField SoLinger_textField;
	private static JRadioButton Nagle_on_radion;
	private static JRadioButton Nagle_off_radion;
	private static TextField send_infoback_textfield;
	private static Button recefile_btn;
	private static Button clearsetting_btn;

	private static File savefile; // 保存的文件

	private static int listenport = 9999; // 监听端口
	private static String savepath; // 接收文件保存路径
	private static int ReceiveBufferSize; // 接收缓存
	private static int ReceiveSoLinger; // 滞留时间
	private static boolean NagleState; // Nagle算法状态(启用/禁止)
	private static String send_infoback = null; // 反馈的信息

	private static Socket client; // 定义client
	private static ServerSocket server; // 定义Server

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_MainFrame frame = new Server_MainFrame();
					frame.setVisible(true);
					listenport_textField.setText(Integer.toString(listenport));
					server = new ServerSocket(listenport); // 设定接收端口
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server_MainFrame() {
		setTitle("                          TCP\u6587\u672C\u4F20\u8F93\u8F6F\u4EF6---\u63A5\u6536\u7AEF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u63A5\u6536\u7AEF\u53E3:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label.setBounds(27, 23, 74, 23);
		contentPane.add(label);

		listenport_textField = new TextField();
		listenport_textField.setEnabled(false);
		listenport_textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		listenport_textField.setBounds(132, 23, 162, 23);
		contentPane.add(listenport_textField);

		JLabel label_1 = new JLabel("\u63A5\u6536\u6587\u4EF6\u4F4D\u7F6E:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_1.setBounds(27, 62, 81, 23);
		contentPane.add(label_1);

		savepath_textField = new TextField();
		savepath_textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		savepath_textField.setBounds(132, 62, 162, 23);
		contentPane.add(savepath_textField);

		JLabel lblbyte = new JLabel("\u63A5\u6536\u7F13\u5B58(byte):");
		lblbyte.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblbyte.setBounds(27, 95, 100, 23);
		contentPane.add(lblbyte);

		ReceiveBufferSize_textField = new TextField();
		ReceiveBufferSize_textField.setText("6000");
		ReceiveBufferSize_textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		ReceiveBufferSize_textField.setBounds(132, 95, 162, 23);
		contentPane.add(ReceiveBufferSize_textField);

		JLabel lbls = new JLabel("\u6EDE\u7559\u65F6\u95F4(s):");
		lbls.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lbls.setBounds(27, 132, 81, 23);
		contentPane.add(lbls);

		SoLinger_textField = new TextField();
		SoLinger_textField.setText("1");
		SoLinger_textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		SoLinger_textField.setBounds(132, 132, 162, 23);
		contentPane.add(SoLinger_textField);

		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNagle.setBounds(27, 176, 81, 23);
		contentPane.add(lblNagle);

		Nagle_on_radion = new JRadioButton("\u542F\u7528");
		Nagle_on_radion.setBounds(134, 176, 74, 23);
		contentPane.add(Nagle_on_radion);

		Nagle_off_radion = new JRadioButton("\u7981\u7528");
		Nagle_off_radion.setSelected(true);
		Nagle_off_radion.setBounds(220, 176, 74, 23);
		contentPane.add(Nagle_off_radion);
		ButtonGroup bg = new ButtonGroup();
		bg.add(Nagle_on_radion);
		bg.add(Nagle_off_radion);

		JLabel label_3 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_3.setBounds(27, 221, 81, 23);
		contentPane.add(label_3);

		send_infoback_textfield = new TextField();
		send_infoback_textfield.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		send_infoback_textfield.setBounds(132, 221, 162, 23);
		contentPane.add(send_infoback_textfield);

		recefile_btn = new Button("\u63A5\u6536\u6587\u4EF6");
		recefile_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				send_infoback_textfield.setText("正在等待客户端连接………");
				
				try {
					invoke();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("无法开启传输任务");
				}
			}
		});
		recefile_btn.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		recefile_btn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		recefile_btn.setBounds(32, 274, 76, 23);
		contentPane.add(recefile_btn);

		clearsetting_btn = new Button("\u6E05\u7A7A\u8BBE\u7F6E");
		clearsetting_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listenport_textField.setText(" ");
				savepath_textField.setText(" ");
				ReceiveBufferSize_textField.setText(" ");
				SoLinger_textField.setText(" ");
				send_infoback_textfield.setText(" ");
				Nagle_on_radion.setSelected(false);
				Nagle_off_radion.setSelected(true);
			}
		});
		clearsetting_btn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		clearsetting_btn.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		clearsetting_btn.setBounds(218, 274, 76, 23);
		contentPane.add(clearsetting_btn);

		Button savefile_btn = new Button("\u6D4F\u89C8");
		savefile_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择要发送的文件·	");
				savefile = jfc.getSelectedFile(); // 获得选中要发送的文件
				savepath_textField.setText(savefile.getAbsolutePath());
			}
		});
		savefile_btn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		savefile_btn.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		savefile_btn.setBounds(308, 62, 76, 23);
		contentPane.add(savefile_btn);
	}

	public static void getparams() {
		// 获取Server端各参数的值
		savepath = savepath_textField.getText();
		ReceiveBufferSize = Integer.parseInt(ReceiveBufferSize_textField.getText());
		ReceiveSoLinger = Integer.parseInt(ReceiveBufferSize_textField.getText());
		if (Nagle_on_radion.isSelected() == true)
			NagleState = true;
		else
			NagleState = false;

		try {
			client.setReceiveBufferSize(ReceiveBufferSize);// 将设置值赋值给socket
			client.setSoLinger(true, ReceiveSoLinger);
			client.setTcpNoDelay(NagleState);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("参数设置有错误！");
		}

	}

	private static void invoke() throws IOException {
		new Thread(new Runnable() {
			public void run() {	
				try {
					client = server.accept();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("监听端口失败");
				}
				getparams(); // 获取设置的socket的各个参数
				
				DataInputStream in = null; // 定义从client端接收的数据流
				DataOutputStream out = null; // 定义向client端发送的数据流
				FileOutputStream filewriter = null; // 将接收的数据流写入文件的流
				byte[] inputByte = new byte[1024]; // 一次接收1024bytes
				String backmsg ="";                            //反馈给client端的信息

				try {
					in = new DataInputStream(client.getInputStream());
					out = new DataOutputStream(client.getOutputStream());
					filewriter = new FileOutputStream(savefile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int length = 0;
				try {
					while ((length = in.read(inputByte, 0, inputByte.length))>0) { // 判断socket流是否读完(每次读取1024byte)						
						filewriter.write(inputByte, 0, length);
						filewriter.flush();
					}
					client.shutdownInput();                         //关闭接收端输入流
					send_infoback = "接收的文件保存成功！";
					backmsg ="服务器端已成功接收文件！";
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					send_infoback = "接收的文件保存失败！";
					backmsg = "服务器端接收文件失败！";
				}

				send_infoback_textfield.setText(send_infoback);
				
	
				try {	
					out.write(backmsg.getBytes());
					out.flush();
					System.out.println(backmsg);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("无法给client发送反馈信息！");
				}
				
				try {
					in.close();
					out.close();
					filewriter.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
