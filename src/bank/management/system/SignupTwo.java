
package bank.management.system;

import javax.swing.*;//jFrame ke liye
import java.awt.*;//color ke liye
import java.awt.event.*;//for actionListener

public class SignupTwo extends JFrame implements ActionListener {
    
   
    JTextField panTextField,aadharTextField;
    JRadioButton eno,sno,eyes,syes;
    JButton next;
    JComboBox reli,cat,in,Qualification,occu;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        System.out.println(formno);
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel AdditionalDetails = new JLabel("Page 2 : Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valreli[] = {"Select","Hindu","Muslim","Sikh","Christian","Other"};  
        reli= new JComboBox(valreli);
        reli.setBackground(Color.WHITE);
        reli.setBounds(300,140,400,30);
        add(reli);

        JLabel category= new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valcat[] = {"Select","General","OBC","ST","SC","Other"};  
        cat= new JComboBox(valcat);
        cat.setBackground(Color.WHITE);
        cat.setBounds(300,190,400,30);
        add(cat);

        JLabel income= new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valincome[] = {"Select","Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};  
        in= new JComboBox(valincome);
        in.setBackground(Color.WHITE);
        in.setBounds(300,240,400,30);
        add(in);

         
        JLabel Edu= new JLabel("Educational");
        Edu.setFont(new Font("Raleway",Font.BOLD,20));
        Edu.setBounds(100,290,200,30);
        add(Edu);
        
        JLabel quali= new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds( 100,315,200,30);
        add(quali);
        
        String valEdu[] = {"Select","Non-Graduation","Graduate","Post-Graduation","Doctrate","Other"};  
        Qualification= new JComboBox(valEdu);
        Qualification.setBackground(Color.WHITE);
        Qualification.setBounds(300,315,400,30);
        add(Qualification);
    
              
        JLabel occupation= new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        
        String occupationval[] = {"Select","Govt. Employee","Self-employed","Student","Retired","Other"};  
        occu= new JComboBox(occupationval);
        occu.setBackground(Color.WHITE);
        occu.setBounds(300,390,400,30);
        add(occu);  

        
        JLabel pno= new JLabel("PAN Number:");
        pno.setFont(new Font("Raleway",Font.BOLD,20));
        pno.setBounds(100,440,200,30);
        add(pno);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

       
        JLabel adcard= new JLabel("Aadhar Number:");
        adcard.setFont(new Font("Raleway",Font.BOLD,20));
        adcard.setBounds(100,490,200,30);
        add(adcard);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel scitizen= new JLabel("Senior Citizen:");
        scitizen.setFont(new Font("Raleway",Font.BOLD,20));
        scitizen.setBounds(100,540,200,30);
        add(scitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup gendergroup =new ButtonGroup();
        gendergroup.add(syes);
        gendergroup.add(sno);
        
        JLabel Eacc= new JLabel("Exisiting Account :");
        Eacc.setFont(new Font("Raleway",Font.BOLD,20));
        Eacc.setBounds(100,590,200,30);
        add(Eacc);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup Eacc1 =new ButtonGroup();
        Eacc1.add(eyes);
        Eacc1.add(eno);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(450,630,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setUndecorated(true);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       
        String religion =  (String)reli.getSelectedItem();
        String category =  (String)cat.getSelectedItem();
        String income =  (String)in.getSelectedItem();
        String edu =  (String)Qualification.getSelectedItem();
        String occupation =  (String)occu.getSelectedItem();
        
        String seniorcitizen =  "";
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String exisitingaccount =  "";
        if(eyes.isSelected()){
          exisitingaccount = "Yes";
        }
        else if(eno.isSelected()){
          exisitingaccount = "No";
        }
        
        String pan = panTextField.getText(); 
        String aadhar = aadharTextField.getText();
    
        try{  //validations apply start
            if(religion.equals("Select")){
                  JOptionPane.showMessageDialog(null,"Religion is Required");
            }
            else  if(category.equals("Select")){
                  JOptionPane.showMessageDialog(null,"Category is Required");
            }
            else  if(income.equals("Select")){
                  JOptionPane.showMessageDialog(null,"Income is Required");
            }
            else  if(edu.equals("Select")){
                  JOptionPane.showMessageDialog(null,"Qualification is Required");
            }
            else  if(occupation.equals("Select")){
                  JOptionPane.showMessageDialog(null,"Occupation is Required");
            }
            else  if(pan.equals("")){
                  JOptionPane.showMessageDialog(null,"Pan No. is Required");
            }
            else  if(aadhar.equals("")){
                  JOptionPane.showMessageDialog(null,"Aadhar No. is Required");                    
            }
            else  if("".equals(seniorcitizen)){
                  JOptionPane.showMessageDialog(null,"Please select Senior Citizen or not ");
            }
            else  if("".equals(exisitingaccount)){
                  JOptionPane.showMessageDialog(null,"Exisiting Account field is Required");
            }//validations apply end
            else{
               Conn c = new Conn();
//               System.out.println(formno);
               String query = "INSERT INTO signuptwo VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+edu+"','"+occupation+"','"+seniorcitizen+"','"+exisitingaccount+"','"+pan+"','"+aadhar+"')";
               c.s.executeUpdate(query);
               //signup3 object
               setVisible(false);
               new SignupThree(formno).setVisible(true);
            }   
        }catch(Exception e){
           System.out.println(e);
        }
    }
    
    public static void main(String args[]){
       new SignupTwo("");
    }
}
