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
		
		TextField textField = new TextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField.setBounds(122, 23, 162, 23);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("\u63A5\u6536\u6587\u4EF6\u4F4D\u7F6E:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_1.setBounds(27, 62, 81, 23);
		contentPane.add(label_1);
		
		TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_1.setBounds(122, 62, 162, 23);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("\u63A5\u6536\u7F13\u5B58:");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_2.setBounds(27, 95, 81, 23);
		contentPane.add(label_2);
		
		TextField textField_2 = new TextField();
		textField_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_2.setBounds(122, 95, 162, 23);
		contentPane.add(textField_2);
		
		JLabel lbls = new JLabel("\u6EDE\u7559\u65F6\u95F4(s):");
		lbls.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lbls.setBounds(27, 132, 81, 23);
		contentPane.add(lbls);
		
		TextField textField_3 = new TextField();
		textField_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_3.setBounds(122, 132, 162, 23);
		contentPane.add(textField_3);
		
		JLabel lblNagle = new JLabel("Nagle\u7B97\u6CD5:");
		lblNagle.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		lblNagle.setBounds(27, 176, 81, 23);
		contentPane.add(lblNagle);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u542F\u7528");
		rdbtnNewRadioButton.setBounds(122, 176, 74, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("\u7981\u7528");
		radioButton.setSelected(true);
		radioButton.setBounds(210, 176, 74, 23);
		contentPane.add(radioButton);
		
		JLabel label_3 = new JLabel("\u4FE1\u606F\u53CD\u9988:");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		label_3.setBounds(27, 221, 81, 23);
		contentPane.add(label_3);
		
		TextField textField_4 = new TextField();
		textField_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		textField_4.setBounds(122, 221, 162, 23);
		contentPane.add(textField_4);
		
		Button button = new Button("\u63A5\u6536\u6587\u4EF6");
		button.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button.setBounds(27, 274, 76, 23);
		contentPane.add(button);
		
		Button button_1 = new Button("\u6E05\u7A7A\u914D\u7F6E");
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 13));
		button_1.setActionCommand("\u63A5\u6536\u6587\u4EF6");
		button_1.setBounds(208, 274, 76, 23);
		contentPane.add(button_1);
	}
}
