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
		
		TextField textField = new TextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField.setBounds(121, 21, 162, 23);
		contentPane.add(textField);
		
		JLabel label = new JLabel("\u76EE\u7684\u7AEF\u53E3:");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label.setBounds(24, 66, 74, 23);
		contentPane.add(label);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_1.setBounds(121, 66, 162, 23);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("\u53D1\u9001\u6587\u4EF6:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(24, 117, 74, 23);
		contentPane.add(label_1);
		
		TextField textField_2 = new TextField();
		textField_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_2.setBounds(121, 117, 162, 23);
		contentPane.add(textField_2);
		
		Button button = new Button("\u6D4F\u89C8");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button.setBounds(299, 117, 76, 23);
		contentPane.add(button);
		
		JLabel lblbyte = new JLabel("\u53D1\u9001\u7F13\u5B58(byte):");
		lblbyte.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblbyte.setBounds(24, 159, 90, 23);
		contentPane.add(lblbyte);
		
		TextField textField_3 = new TextField();
		textField_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_3.setBounds(121, 159, 162, 23);
		contentPane.add(textField_3);
		
		JLabel lblms_1 = new JLabel("\u6EDE\u7559\u65F6\u95F4(ms):");
		lblms_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblms_1.setBounds(24, 192, 90, 23);
		contentPane.add(lblms_1);
		
		JLabel lblms = new JLabel("\u8D85\u65F6\u65F6\u95F4(ms):");
		lblms.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblms.setBounds(24, 225, 90, 23);
		contentPane.add(lblms);
		
		TextField textField_4 = new TextField();
		textField_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_4.setBounds(121, 192, 162, 23);
		contentPane.add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_5.setBounds(121, 225, 162, 23);
		contentPane.add(textField_5);
		
		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblNagle.setBounds(24, 263, 90, 23);
		contentPane.add(lblNagle);
		
		JRadioButton radioButton = new JRadioButton("\u542F\u7528");
		radioButton.setBounds(121, 263, 74, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u7981\u7528");
		radioButton_1.setBounds(209, 263, 74, 23);
		contentPane.add(radioButton_1);
		
		JLabel label_2 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setBounds(24, 296, 90, 23);
		contentPane.add(label_2);
		
		TextField textField_6 = new TextField();
		textField_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_6.setBounds(121, 292, 162, 23);
		contentPane.add(textField_6);
		
		Button button_1 = new Button("\u53D1\u9001\u6587\u4EF6");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button_1.setBounds(299, 292, 76, 23);
		contentPane.add(button_1);
	}
}
