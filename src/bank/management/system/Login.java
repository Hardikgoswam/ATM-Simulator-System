/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*; // JFrame
import java.awt.*;//awt import for image and font  
import java.awt.event.*;// ActionListener
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login , signup , clear;// Instance variable for button
    JTextField cardTextField;  //Instance variable for Card no
    JPasswordField pinTextField; //Instance variable for pin Hidden purpose
    Login(){
    
       setTitle("AUTOMATED TELLER MACHINE");   //heading
       setLayout(null);//for layout null purpose because apply customize icon layout
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));//load the image
       Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT); //adj. size of image
       ImageIcon i3 = new ImageIcon(i2);//typecast into ImageIcon class;
       JLabel label = new JLabel(i3); //than apply image 
       label.setBounds(130,10,80,90);//set layout image
       add(label); // finally add inside layout
       
       //extra code start
       ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
       Image ii2 = i11.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
       ImageIcon i13 = new ImageIcon(ii2);
       JLabel labell = new JLabel(i13);
       labell.setBounds(590,10,80,90);
       add(labell);
       //extra code end
       
       JLabel text = new JLabel("_Welcome To ATM_");//add text
       text.setFont(new Font("Osward",Font.BOLD,38));//adj font size
       text.setBounds(220, 40, 400,30);//adj. text layout
       add(text);//finally add them
       
       JLabel cardno = new JLabel("Card No : ");//add text
       cardno.setFont(new Font("Raleway",Font.BOLD,28));//adj font size
       cardno.setBounds(120, 150, 150,30);//adj. text layout
       add(cardno);//finally add them
       
       cardTextField = new JTextField(); //add field for input purpose
       cardTextField.setBounds(300,150,230,30);//adj. textfield layout
       cardTextField.setFont(new Font("Arial",Font.BOLD,14));//adj input font size
       add(cardTextField);//finally add them
     
       JLabel pin = new JLabel("Pin : ");//add text
       pin.setFont(new Font("Raleway",Font.BOLD,28));//adj font size
       pin.setBounds(120, 220, 250,30);//adj. text layout
       add(pin);//finally add them
       
       pinTextField = new JPasswordField();//add field for input purpose
       pinTextField.setBounds(300,220,230,30);//adj. textfield layout
       pinTextField.setFont(new Font("Arial",Font.BOLD,14));//adj input font size
       add(pinTextField);//finally add them
       
       login = new JButton("SIGN IN"); //button name
       login.setBounds(300,300,100,30); // button size
       login.setBackground(Color.BLACK);//button bg color
       login.setForeground(Color.WHITE);//button fg color
       login.addActionListener(this);//add action in button
       add(login);//finally add them
       
       clear = new JButton("CLEAR");//button name
       clear.setBounds(430,300,100,30); // button size
       clear.setBackground(Color.BLACK);//button bg color
       clear.setForeground(Color.WHITE);//button fg color
       clear.addActionListener(this);//add action in button
       add(clear);//finally add them
       
       signup = new JButton("SIGN UP");//button name
       signup.setBounds(300,350,230,30);// button size
       signup.setBackground(Color.BLACK);//button bg color
       signup.setForeground(Color.WHITE);//button fg color
       signup.addActionListener(this);//add action in button
       add(signup);//finally add them
       
       getContentPane().setBackground(Color.white);//set layout backgound color white
  
       setSize(800,480);//set layout width and height
       setVisible(true);//visible value false to true 
       setLocation(350, 200);//viewport location adj.
    }
    
    @Override  //override ActionListener interface method
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){ //catch click action and perform extra Activity
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource() == login){ //catch click action and perform extra Activity
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE CARDNUMBER = '"+cardnumber+"' AND PIN_NO = '"+pinnumber+"'"; 
            try{
               ResultSet rs  = conn.s.executeQuery(query);
               if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
               }else{
                 JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
                
            }
            catch(Exception e){
               System.out.println(e);
            }
        }else if(ae.getSource() == signup){ //catch click action and perform extra Activity
             setVisible(false);
             new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){//main kaam 
        
        new Login();//login class object 
    }
}
