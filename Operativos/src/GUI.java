import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;


public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int numMaquinas;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 479);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("T");
		label.setFont(new Font("Calibri", Font.BOLD, 26));
		label.setBounds(82, 351, 54, 50);
		contentPane.add(label);
		
		
		textField = new JTextField();
		textField.setBounds(42, 36, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLaber = new JLabel("Numero de maquinas ");
		lblLaber.setBounds(42, 13, 200, 22);
		contentPane.add(lblLaber);
		
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tipo 3"}));
		comboBox_2.setBounds(41, 180, 117, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numMaquinas=numMaquinas-Integer.parseInt((String)comboBox_1.getSelectedItem());
				String[] a= new String[numMaquinas];
				for(int i=0; i<numMaquinas;i++){
					a[i]=i+1+"";
				}
				comboBox_2.setModel(new DefaultComboBoxModel(a));
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tipo 2"}));
		comboBox_1.setBounds(41, 145, 117, 22);
		contentPane.add(comboBox_1);
		
		JComboBox com = new JComboBox();
		com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numMaquinas=numMaquinas-Integer.parseInt((String)com.getSelectedItem());
				String[] a= new String[numMaquinas];
				for(int i=0; i<numMaquinas;i++){
					a[i]=i+1+"";
				}
				comboBox_1.setModel(new DefaultComboBoxModel(a));
			}
		});
		com.setModel(new DefaultComboBoxModel(new String[] {"Tipo 1"}));
		com.setBounds(41, 110, 117, 22);
		contentPane.add(com);
		
		
		JLabel lblNumeroDeBlogs = new JLabel("Numero de blogs ");
		lblNumeroDeBlogs.setBounds(42, 206, 200, 22);
		contentPane.add(lblNumeroDeBlogs);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(42, 229, 116, 22);
		contentPane.add(textField_1);
		
		JLabel lblRuntime = new JLabel("Runtime");
		lblRuntime.setBounds(42, 255, 200, 22);
		contentPane.add(lblRuntime);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(42, 278, 116, 22);
		contentPane.add(textField_2);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numMaquinas=Integer.parseInt(textField.getText());
				String[] a= new String[numMaquinas];
				for(int i=0; i<numMaquinas;i++){
					a[i]=i+1+"";
				}
				com.setModel(new DefaultComboBoxModel(a));
				
				
			}
		});
		btnAceptar.setBounds(52, 71, 97, 25);
		contentPane.add(btnAceptar);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(new Color(102, 204, 0));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Thread(new Runnable() {
					int time=Integer.parseInt(textField_2.getText());
					boolean a=true;
					@Override
					public void run() {
						label.setText(time+"s");
						while(a){
							if (time==0)
								setVisible(false);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						time--;
						label.setText(time+"s");
						}
					}
				}).start();
				
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
				
				List<Usuario> usuarios= new ArrayList<Usuario>();
				
				for(int i=0;i<Integer.parseInt((String)com.getSelectedItem());i++){
					usuarios.add(Usuario.T1);
				}
				for(int i=0;i<Integer.parseInt((String)comboBox_1.getSelectedItem());i++){
					usuarios.add(Usuario.T2);
				}
				for(int i=0;i<Integer.parseInt((String)comboBox_2.getSelectedItem());i++){
					usuarios.add(Usuario.T3);
				}
				
				Main main= new Main(usuarios,0,Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
				try {
					main.iniciar();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					}
				}).start();
				
				
				
				
				
			}
		});
		btnIniciar.setBounds(52, 313, 97, 25);
		contentPane.add(btnIniciar);
		
		
		
	}
}
