package MyClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client_MainFrame extends JFrame {

	private JPanel contentPane;
	private static String dst_ip; // ����Ŀ��IP
	private static int dst_port; // ����Ŀ��Port
	private File sendfile;
	private String sendfile_path; // Ҫ���͵��ļ�·��
	private static int sendbuffersize; // ���巢�ͻ������Ĵ�С
	private static int send_SoLinger; // ��������ʱ��(s)
	private static int send_Timeout; // ���峬ʱʱ��(s)
	private static boolean NagleState; // Nagle�㷨״̬(����/��ֹ)
	private String send_infoback = null; // ��������Ϣ

	private static Socket client = null; // ����socket

	private static TextField dst_ip_textfield;
	private static TextField dst_port_textfield;
	private static TextField sendbuffersize__textfield;
	private static TextField send_SoLinger_textfield;
	private static TextField send_Timeout__textfield;
	private static JRadioButton nagle_on_radiobtn;
	private static JRadioButton nagle_off_radiobtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_MainFrame frame = new Client_MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client_MainFrame() {
		setFont(new Font("΢���ź�", Font.PLAIN, 14));
		setResizable(false);
		setTitle("                    TCP\u6587\u672C\u4F20\u8F93\u8F6F\u4EF6---\u53D1\u9001\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblip = new JLabel("\u76EE\u7684IP\u5730\u5740:");
		lblip.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lblip.setBounds(24, 21, 74, 23);
		contentPane.add(lblip);

		dst_ip_textfield = new TextField();
		dst_ip_textfield.setText("127.0.0.1");
		dst_ip_textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		dst_ip_textfield.setBounds(121, 21, 162, 23);
		contentPane.add(dst_ip_textfield);

		JLabel label = new JLabel("\u76EE\u7684\u7AEF\u53E3:");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		label.setBounds(24, 66, 74, 23);
		contentPane.add(label);

		dst_port_textfield = new TextField();
		dst_port_textfield.setText("9999");
		dst_port_textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		dst_port_textfield.setBounds(121, 66, 162, 23);
		contentPane.add(dst_port_textfield);

		JLabel label_1 = new JLabel("\u53D1\u9001\u6587\u4EF6:");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		label_1.setBounds(24, 117, 74, 23);
		contentPane.add(label_1);

		TextField file_send_textfield = new TextField();
		file_send_textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		file_send_textfield.setBounds(121, 117, 162, 23);
		contentPane.add(file_send_textfield);

		Button openfile_btn = new Button("\u6D4F\u89C8");
		openfile_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "ѡ��Ҫ���͵��ļ���	");
				sendfile = jfc.getSelectedFile(); // ���ѡ��Ҫ���͵��ļ�
				file_send_textfield.setText(sendfile.getAbsolutePath());
			}
		});
		openfile_btn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		openfile_btn.setBounds(299, 117, 76, 23);
		contentPane.add(openfile_btn);

		JLabel lblbyte = new JLabel("\u53D1\u9001\u7F13\u5B58(byte):");
		lblbyte.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lblbyte.setBounds(24, 159, 90, 23);
		contentPane.add(lblbyte);

		sendbuffersize__textfield = new TextField();
		sendbuffersize__textfield.setText("6000");
		sendbuffersize__textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		sendbuffersize__textfield.setBounds(121, 159, 162, 23);
		contentPane.add(sendbuffersize__textfield);

		JLabel lblms_1 = new JLabel("\u6EDE\u7559\u65F6\u95F4(s):");
		lblms_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lblms_1.setBounds(24, 192, 90, 23);
		contentPane.add(lblms_1);

		JLabel lblms = new JLabel("\u8D85\u65F6\u65F6\u95F4(s):");
		lblms.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lblms.setBounds(24, 225, 90, 23);
		contentPane.add(lblms);

		send_SoLinger_textfield = new TextField();
		send_SoLinger_textfield.setText("1");
		send_SoLinger_textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		send_SoLinger_textfield.setBounds(121, 192, 162, 23);
		contentPane.add(send_SoLinger_textfield);

		send_Timeout__textfield = new TextField();
		send_Timeout__textfield.setText("0");
		send_Timeout__textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		send_Timeout__textfield.setBounds(121, 225, 162, 23);
		contentPane.add(send_Timeout__textfield);

		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		lblNagle.setBounds(24, 263, 90, 23);
		contentPane.add(lblNagle);

		nagle_on_radiobtn = new JRadioButton("\u542F\u7528");
		nagle_on_radiobtn.setBounds(121, 263, 74, 23);
		contentPane.add(nagle_on_radiobtn);

		nagle_off_radiobtn = new JRadioButton("\u7981\u7528");
		nagle_off_radiobtn.setSelected(true);
		nagle_off_radiobtn.setBounds(209, 263, 74, 23);
		contentPane.add(nagle_off_radiobtn);

		ButtonGroup bg = new ButtonGroup();
		bg.add(nagle_on_radiobtn);
		bg.add(nagle_off_radiobtn);

		JLabel label_2 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		label_2.setBounds(24, 296, 90, 23);
		contentPane.add(label_2);

		TextField send_infoback_textfield = new TextField();
		send_infoback_textfield.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		send_infoback_textfield.setBounds(121, 292, 162, 23);
		contentPane.add(send_infoback_textfield);

		Button sendfile_btn = new Button("\u53D1\u9001\u6587\u4EF6");
		sendfile_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getparams(); // Ϊclient��ֵ
				FileInputStream filereader = null; // ��ȡҪ���͵��ļ���
				DataOutputStream out = null; // ������server���͵�������
				DataInputStream in = null; // �����serve�˽��յ�������
				byte[] sendBytes = new byte[1024]; // һ�η���1024bytes

				try {
					filereader = new FileInputStream(sendfile);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out = new DataOutputStream(client.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					in = new DataInputStream((client.getInputStream()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int length = 0; // ���͵ĳ���
				try {
					while ((length = filereader.read(sendBytes, 0, sendBytes.length)) > 0) { // �ж��ļ��Ƿ����(ÿ�ζ�ȡ1024byte)
						try {
							out.write(sendBytes, 0, length);
							out.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							send_infoback_textfield.setText("�����ļ�ʧ��");
						}
					}
					client.shutdownOutput();             //�رշ��Ͷ������
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println("�ļ��������");
				
				
				try {
					byte[] backmsg =new byte[64];
					int conut = in.read(backmsg,0,backmsg.length);
					send_infoback = new String(backmsg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("�޷���ȡ���������˵ķ�����Ϣ");
				}		
				send_infoback_textfield.setText(send_infoback);
				
				
				try {                                                  // �ر�I/O��
					filereader.close();
					in.close();
					out.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		sendfile_btn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		sendfile_btn.setBounds(299, 292, 76, 23);
		contentPane.add(sendfile_btn);
	}

	public static void getparams() {
		// ��ȡclient�˸�������ֵ
		dst_ip = dst_ip_textfield.getText();
		dst_port = Integer.parseInt(dst_port_textfield.getText());
		sendbuffersize = Integer.parseInt(sendbuffersize__textfield.getText());
		send_SoLinger = Integer.parseInt(send_SoLinger_textfield.getText());
		send_Timeout = Integer.parseInt(send_Timeout__textfield.getText());
		if (nagle_on_radiobtn.isSelected() == true)
			NagleState = true;
		else
			NagleState = false;

		try {
			client = new Socket(dst_ip, dst_port); // ����Socket�����ӷ�����
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����Socketʧ��");
		}

		try {
			client.setSendBufferSize(sendbuffersize); // ������ֵ��ֵ��socket
			client.setSoLinger(true, send_SoLinger);
			client.setSoTimeout(send_Timeout * 1000);
			client.setTcpNoDelay(NagleState);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���������д���");
		}

	}
}
