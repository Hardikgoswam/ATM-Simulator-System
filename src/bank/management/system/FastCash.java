
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatment,pinchange,balance,exit; 
    String pinnumber;
    FastCash(String pinnumber){
      this.pinnumber = pinnumber; 
      setLayout(null);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);  
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      
      JLabel text = new JLabel(" SELECT WITHDRAWL AMOUNT "); 
      text.setBounds(220, 300, 700, 35);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
      deposit = new JButton("RS 100");
      deposit.setBounds(170,415,150,30);
      deposit.addActionListener(this);
      image.add(deposit);
      
      withdrawl = new JButton("RS 500");
      withdrawl.setBounds(335,415,150,30);
      withdrawl.addActionListener(this);
      image.add(withdrawl);
      
      fastcash = new JButton("RS 1000");
      fastcash.setBounds(170,450,150,30);
      fastcash.addActionListener(this);
      image.add(fastcash);
      
      ministatment = new JButton("RS 2000");
      ministatment.setBounds(335,450,150,30);
      ministatment.addActionListener(this);
      image.add(ministatment);
      
      pinchange = new JButton("RS 5000");
      pinchange.setBounds(170,485,150,30);
      pinchange.addActionListener(this);
      image.add(pinchange);
      
      balance = new JButton("RS 10000");
      balance.setBounds(335,485,150,30);
      balance.addActionListener(this);
      image.add(balance);
      
       exit = new JButton("BACK");
      exit.setBounds(250,520,150,30);
      exit.addActionListener(this);
      image.add(exit);
      
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
           setVisible(false);
              new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
               ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE PIN = '"+pinnumber+"'"); 
               int balance = 0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                     balance += Integer.parseInt(rs.getString("AMOUNT"));
                   }else{
                     balance -= Integer.parseInt(rs.getString("AMOUNT"));
                   }
               }
               if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return ;
               }
               Date date = new Date();
               String query ="INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
              
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
              System.out.println(e);
            }
        }    
    }
    public static void main(String args []){
       new FastCash("");
    }
}
