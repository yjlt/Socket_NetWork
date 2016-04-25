package MyServer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JRadioButton;
import java.awt.Button;

public class Server_MainFrame extends JFrame {

	private JPanel contentPane;
	
	private TextField listenport_textField;
	private TextField savepath_textField;
	private TextField ReceiveBufferSize_textField;
	private TextField SoLinger_textField;
	private JRadioButton Nagle_on_radion;
	private JRadioButton Nagle_off_radion;
	private TextField send_infoback_textfield;
	private Button recefile_btn;
	private Button clearsetting_btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server_MainFrame frame = new Server_MainFrame();
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
	public Server_MainFrame() {
		setTitle("                          TCP\u6587\u672C\u4F20\u8F93\u8F6F\u4EF6---\u63A5\u6536\u7AEF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u63A5\u6536\u7AEF\u53E3:");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label.setBounds(27, 23, 74, 23);
		contentPane.add(label);
		
		listenport_textField = new TextField();
		listenport_textField.setEnabled(false);
		listenport_textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		listenport_textField.setBounds(122, 23, 162, 23);
		contentPane.add(listenport_textField);
		
		JLabel label_1 = new JLabel("\u63A5\u6536\u6587\u4EF6\u4F4D\u7F6E:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(27, 62, 81, 23);
		contentPane.add(label_1);
		
		savepath_textField = new TextField();
		savepath_textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		savepath_textField.setBounds(122, 62, 162, 23);
		contentPane.add(savepath_textField);
		
		JLabel label_2 = new JLabel("\u63A5\u6536\u7F13\u5B58:");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setBounds(27, 95, 81, 23);
		contentPane.add(label_2);
		
		ReceiveBufferSize_textField = new TextField();
		ReceiveBufferSize_textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		ReceiveBufferSize_textField.setBounds(122, 95, 162, 23);
		contentPane.add(ReceiveBufferSize_textField);
		
		JLabel lbls = new JLabel("\u6EDE\u7559\u65F6\u95F4(s):");
		lbls.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lbls.setBounds(27, 132, 81, 23);
		contentPane.add(lbls);
		
		SoLinger_textField = new TextField();
		SoLinger_textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		SoLinger_textField.setBounds(122, 132, 162, 23);
		contentPane.add(SoLinger_textField);
		
		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblNagle.setBounds(27, 176, 81, 23);
		contentPane.add(lblNagle);
		
		Nagle_on_radion = new JRadioButton("\u542F\u7528");
		Nagle_on_radion.setBounds(122, 176, 74, 23);
		contentPane.add(Nagle_on_radion);
		
		Nagle_off_radion = new JRadioButton("\u7981\u7528");
		Nagle_off_radion.setSelected(true);
		Nagle_off_radion.setBounds(210, 176, 74, 23);
		contentPane.add(Nagle_off_radion);
		
		JLabel label_3 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_3.setBounds(27, 221, 81, 23);
		contentPane.add(label_3);
		
		send_infoback_textfield = new TextField();
		send_infoback_textfield.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		send_infoback_textfield.setBounds(122, 221, 162, 23);
		contentPane.add(send_infoback_textfield);
		
		recefile_btn = new Button("\u63A5\u6536\u6587\u4EF6");
		recefile_btn.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		recefile_btn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		recefile_btn.setBounds(27, 274, 76, 23);
		contentPane.add(recefile_btn);
		
		clearsetting_btn = new Button("\u6E05\u7A7A\u914D\u7F6E");
		clearsetting_btn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		clearsetting_btn.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		clearsetting_btn.setBounds(208, 274, 76, 23);
		contentPane.add(clearsetting_btn);
	}
}
