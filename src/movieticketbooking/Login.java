/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieticketbooking;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
        private JButton b1,b2,b3;


	public Login() {
            
	setBackground(new Color(255, 255, 204));	
        setBounds(550, 250, 700, 400);
		
        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setBounds(24, 80, 180, 26);
        l1.setFont(new Font("serif", Font.BOLD, 30));
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setBounds(24, 135, 180, 26);
        l2.setFont(new Font("serif", Font.BOLD, 30));
	panel.add(l2);

	textField = new JTextField();
	textField.setBounds(210, 83, 170, 30);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 125, 170, 30);
	panel.add(passwordField);

	JLabel l3 = new JLabel("");
	l3.setBounds(377, 79, 46, 34);
	panel.add(l3);

	JLabel l4 = new JLabel("");
	l4.setBounds(377, 124, 46, 34);
	panel.add(l3);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("Icon/third.jpeg"));
        Image i1 = c1.getImage().getScaledInstance(120, 190,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        
        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 70, 150, 150);
        add(l6);
        
        
	b1 = new JButton("Login");
	b1.addActionListener(this);
                
	b1.setForeground(Color.BLACK);
	b1.setBackground(Color.WHITE);
	b1.setBounds(50, 200, 130, 35);
	panel.add(b1);
		
        b2 = new JButton("SignUp");
	b2.addActionListener(this);
	
	b2.setForeground(Color.BLACK);
	b2.setBackground(Color.WHITE);
	b2.setBounds(289, 200, 130, 35);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(Color.WHITE);
	b3.setBackground(Color.blue);
	b3.setBounds(199, 285, 230, 35);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
	l5.setForeground(Color.BLACK);
	l5.setBounds(24, 285, 200, 40);
	panel.add(l5);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    Conn con = new Conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, passwordField.getText());

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Loading(textField.getText()).setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		ForgotPassword forgot = new ForgotPassword();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login().setVisible(true);
	}

}
