
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,rpin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
      this.pinnumber = pinnumber;
      setLayout(null); 
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
      Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);  
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      add(image);
      
      JLabel text = new JLabel("CHANGE YOUR PIN");
      text.setForeground(Color.WHITE);
      text.setFont(new Font("System",Font.BOLD,16));
      text.setBounds(250,280,500,35);
      image.add(text);
      
      JLabel pintext = new JLabel("NEW PIN");
      pintext.setForeground(Color.WHITE);
      pintext.setFont(new Font("System",Font.BOLD,16));
      pintext.setBounds(165,320,180,25);
      image.add(pintext);
      
      pin = new JPasswordField();
      pin.setFont(new Font("Relway",Font.BOLD,25));
      pin.setBounds(330,320,180,25);
      image.add(pin);  
      
      JLabel rpintext = new JLabel("RE-ENTER NEW PIN");
      rpintext.setForeground(Color.WHITE);
      rpintext.setFont(new Font("System",Font.BOLD,16));
      rpintext.setBounds(165,360,180,25);
      image.add(rpintext);
      
      rpin = new JPasswordField();
      rpin.setFont(new Font("Relway",Font.BOLD,25));
      rpin.setBounds(330,360,180,25);
      image.add(rpin);
      
      change = new JButton("CHANGE");
      change.setBounds(355,485,150,30);
      change.addActionListener(this);
      image.add(change);
       
      back = new JButton("BACK");
      back.setBounds(355,520,150,30);
      back.addActionListener(this);
      image.add(back); 
      
      setSize(900,900);
      setLocation(300,0);
      setUndecorated(true);
      setVisible(true);
        
    
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String repin = rpin.getText();

                if(!npin.equals(repin)){
                  JOptionPane.showMessageDialog(null,"Enter PIN does not match");
                  return;
                }
                if(npin.equals("")){
                  JOptionPane.showMessageDialog(null,"Please enter new PIN");
                  return;
                }
                if(repin.equals("")){
                  JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                  return;
                }
                Conn conn =new Conn();
                String q1 = "UPDATE bank set PIN = '"+repin+"' WHERE  PIN = '"+pinnumber+"'";
                String q2 = "UPDATE login set PIN_NO = '"+repin+"' WHERE  PIN_NO = '"+pinnumber+"'";
                String q3 = "UPDATE signupthree set PINNUMBER = '"+repin+"' WHERE PINNUMBER = '"+pinnumber+"'";
                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
              System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }    
    }
    public static void main(String args []){
       new PinChange("");
    }
}
