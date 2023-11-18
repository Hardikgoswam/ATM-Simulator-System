
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        
        setTitle("mini statement");
        setLayout(null); 
         
        JLabel mini = new  JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel("");
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel("");
        balance.setBounds(20,400,320,20);
        add(balance);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true);
        setVisible(true);
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE PIN_NO = '"+pinnumber+"'");
            while(rs.next()){
              card.setText("Card Number:" +rs.getString("CARDNUMBER").substring(0, 4)+"XXXXXXXX"+rs.getString("CARDNUMBER").substring(12));
            }
        
        }catch(Exception e){
          System.out.println(e +"  FIRST");
          
        }
        
        try{
           Conn c = new Conn();
           int bal = 0;
           ResultSet rs = c.s.executeQuery("SElECT * FROM bank login WHERE PIN = '"+pinnumber+"'");
           while(rs.next()){
              mini.setText(mini.getText()+ "<html>" + rs.getString("DDATE")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("TYPE") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("AMOUNT")+"<br><br><br><html>");
              if(rs.getString("TYPE").equals("Deposit")){
                bal += Integer.parseInt(rs.getString("AMOUNT"));
              }else{
                bal -= Integer.parseInt(rs.getString("AMOUNT"));
              }
           }
            balance.setText("Your current account balance is Rs "+bal);  
        }catch(Exception e){
          System.out.println(e+"  SECOND");
        }
        
    }
    public static void main(String [] args){
      new MiniStatement("");
    }
}
