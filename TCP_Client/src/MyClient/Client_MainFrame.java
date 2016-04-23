package MyClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JRadioButton;

public class Client_MainFrame extends JFrame {

	private JPanel contentPane;
	private String dst_ip;                             //¶¨ÒåÄ¿µÄIP
	private int dst_port;                             //¶¨ÒåÄ¿µÄPort
	private String sendfile_path;                //Òª·¢ËÍµÄÎÄ¼þÂ·¾¶
	private int sendbuffersize;                  //¶¨Òå·¢ËÍ»º³åÇøµÄ´óÐ¡
	private int send_SoLinger;                   //¶¨ÒåÖÍÁôÊ±¼ä(ms)
	private int send_Timeout;                   //¶¨Òå³¬Ê±Ê±¼ä(ms)
	private boolean NagleState;              //NagleËã·¨×´Ì¬(ÆôÓÃ/½ûÖ¹)
	private String send_infoback;             //·´À¡µÄÐÅÏ¢

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
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		setResizable(false);
		setTitle("                    TCP\u6587\u672C\u4F20\u8F93\u8F6F\u4EF6---\u53D1\u9001\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblip = new JLabel("\u76EE\u7684IP\u5730\u5740:");
		lblip.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblip.setBounds(24, 21, 74, 23);
		contentPane.add(lblip);
		
		TextField dst_ip_textfield = new TextField();
		dst_ip_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		dst_ip_textfield.setBounds(121, 21, 162, 23);
		contentPane.add(dst_ip_textfield);
		
		JLabel label = new JLabel("\u76EE\u7684\u7AEF\u53E3:");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label.setBounds(24, 66, 74, 23);
		contentPane.add(label);
		
		TextField dst_port_textfield = new TextField();
		dst_port_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		dst_port_textfield.setBounds(121, 66, 162, 23);
		contentPane.add(dst_port_textfield);
		
		JLabel label_1 = new JLabel("\u53D1\u9001\u6587\u4EF6:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(24, 117, 74, 23);
		contentPane.add(label_1);
		
		TextField file_send_textfield = new TextField();
		file_send_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		file_send_textfield.setBounds(121, 117, 162, 23);
		contentPane.add(file_send_textfield);
		
		Button openfile_btn = new Button("\u6D4F\u89C8");
		openfile_btn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		openfile_btn.setBounds(299, 117, 76, 23);
		contentPane.add(openfile_btn);
		
		JLabel lblbyte = new JLabel("\u53D1\u9001\u7F13\u5B58(byte):");
		lblbyte.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblbyte.setBounds(24, 159, 90, 23);
		contentPane.add(lblbyte);
		
		TextField sendbuffersize__textfield = new TextField();
		sendbuffersize__textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		sendbuffersize__textfield.setBounds(121, 159, 162, 23);
		contentPane.add(sendbuffersize__textfield);
		
		JLabel lblms_1 = new JLabel("\u6EDE\u7559\u65F6\u95F4(ms):");
		lblms_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblms_1.setBounds(24, 192, 90, 23);
		contentPane.add(lblms_1);
		
		JLabel lblms = new JLabel("\u8D85\u65F6\u65F6\u95F4(ms):");
		lblms.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblms.setBounds(24, 225, 90, 23);
		contentPane.add(lblms);
		
		TextField send_SoLinger_textfield = new TextField();
		send_SoLinger_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		send_SoLinger_textfield.setBounds(121, 192, 162, 23);
		contentPane.add(send_SoLinger_textfield);
		
		TextField send_Timeout__textfield = new TextField();
		send_Timeout__textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		send_Timeout__textfield.setBounds(121, 225, 162, 23);
		contentPane.add(send_Timeout__textfield);
		
		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblNagle.setBounds(24, 263, 90, 23);
		contentPane.add(lblNagle);
		
		JRadioButton nagle_on_radiobtn = new JRadioButton("\u542F\u7528");
		nagle_on_radiobtn.setBounds(121, 263, 74, 23);
		contentPane.add(nagle_on_radiobtn);
		
		JRadioButton nagle_off_radiobtn = new JRadioButton("\u7981\u7528");
		nagle_off_radiobtn.setBounds(209, 263, 74, 23);
		contentPane.add(nagle_off_radiobtn);
		
		JLabel label_2 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setBounds(24, 296, 90, 23);
		contentPane.add(label_2);
		
		TextField send_infoback_textfield = new TextField();
		send_infoback_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		send_infoback_textfield.setBounds(121, 292, 162, 23);
		contentPane.add(send_infoback_textfield);
		
		Button sendfile_btn = new Button("\u53D1\u9001\u6587\u4EF6");
		sendfile_btn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		sendfile_btn.setBounds(299, 292, 76, 23);
		contentPane.add(sendfile_btn);
	}
}
