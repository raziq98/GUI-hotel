
import java.awt.*;
import javax.swing.*;
import java.awt.event.* ;
import javax.swing.border.* ;
import java.text.DecimalFormat;
import java.awt.Color;
import java.lang.Math;
import java.util.Random;
import java.util.*;
import java.awt.Font;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   


public class nejukoo extends JFrame
{
    private JPanel pnlDetails,pnlData, pnlPrice, pnlBawah  ;
    
    private JCheckBox suite,family,single,sauna,food ;
    
    private JRadioButton yes,no,y,n,visa,master,cash ;
    
    private JButton calc, clear ,reciept;
    
    private JLabel set,name,ic,type,service,date,payment,member,extra,room,total;
    
    public static ImageIcon logo = new ImageIcon("lol.jpg");
    public static JTextField Name,IC,Date,Room,Total ,memBer,Set ;
    
    private CalculateButtonHandler cbHandler;
    private ClearHandler clearHandler;
    private RecieptHandler recieptHandler;
    
    public static final Color grey = new Color(230,230,250);
    public static final Color red = new Color(227,66,52);
    public static final Color purple = new Color(179,128,235);
    
    private String naMe,Ic,membeR,dAte;
    private String pRice="";
    private String prIce="";
    private String paYment="";
    private String z="";
    
    
     public nejukoo()
     {
        Font f=new Font ("Otsutome" , Font.BOLD,12);
        setTitle("     NEZUKO RESORT    ") ;
        this.setIconImage(logo.getImage());
        Container cont=this.getContentPane() ;
        cont.setLayout(new BorderLayout()) ;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();
        //create panel Details
        pnlDetails = new JPanel(new GridLayout(11,1)) ;
        pnlDetails.setBorder(new TitledBorder(new EtchedBorder(), "Details")) ;
        
        
        //create label pizza, quantity, price, payMethod
        name=new JLabel("NAME") ;
        ic=new JLabel("IC") ;
        type=new JLabel("Room Type") ;
        payment=new JLabel("Payment Method") ;
        service=new JLabel("Room sevice") ;
        date=new JLabel("Check out date ") ;
        
        member=new JLabel("Membership") ;
        
        extra=new JLabel("Extra service") ;
        room=new JLabel("Room number ") ;
        total=new JLabel("Total ") ;
        set=new JLabel("Check-in");
        String strDate=dtf.format(now);
        //create JCheckBox for large, regular
        suite=new JCheckBox("Suite (RM 500/day)") ;
        family=new JCheckBox("Family (RM 200/day)") ;
        single=new JCheckBox("Single (RM 100/day)");
        sauna=new JCheckBox("Sauna +RM 5");
        food=new JCheckBox("Food delivery +RM 5");
        
        //create JTextField for Quantity
        Name=new JTextField("", 10) ;
        IC=new JTextField("", 10) ;
        Room=new JTextField("",10);
        Date=new JTextField("yyyy/MM/dd",10);
        Total=new JTextField("",10);
        memBer=new JTextField("",10);
        Set=new JTextField(strDate,10);
        //create JRadioButton for Visa, Master
        
        visa=new JRadioButton("VISA") ;
        master=new JRadioButton("MASTER") ;
        cash=new JRadioButton("CASH");
        yes=new JRadioButton("YES");
        no=new JRadioButton("NO");
        y=new JRadioButton("YES");
        n=new JRadioButton("NO");
        //create ButtonGroup()
        ButtonGroup group=new ButtonGroup() ;
        group.add(visa) ;
        group.add(master) ;
        group.add(cash);
        ButtonGroup group1=new ButtonGroup() ;
        group1.add(yes) ;
        group1.add(no) ;
        ButtonGroup group2=new ButtonGroup() ;
        group2.add(y) ;
        group2.add(n) ;
        pnlData=new JPanel (new GridLayout(12,1));
        pnlData.setBorder(new TitledBorder(new EtchedBorder(), "Details")) ;
        
        //add to pnlDetails
        pnlDetails.add(name) ;
        pnlData.add(Name) ;
        pnlDetails.add(ic) ;
        pnlData.add(IC) ;
        pnlDetails.add(type) ;
        pnlDetails.add(set) ;
        pnlDetails.add(Set);
        
        pnlData.add(suite);
        pnlData.add(family);
        pnlData.add(single);
        pnlDetails.add(date) ;
         
         pnlDetails.add(Date);
        pnlDetails.add(member);
        pnlDetails.add(y);
        pnlDetails.add(n);
        pnlDetails.add(memBer);
        pnlData.add(payment);
        pnlData.add(cash);
        pnlData.add(visa) ;
        pnlData.add(master) ;
        
        
       
        
        
        
        //create panel Price
        pnlPrice=new JPanel(new GridLayout(10,2)) ;
        pnlPrice.setBorder(new TitledBorder(new EtchedBorder(), "Extra services")) ;
        
        //add to pnlPrice
        pnlPrice.add(service);
        pnlPrice.add(yes);
        pnlPrice.add(no);
        pnlPrice.add(extra);
        pnlPrice.add(sauna);
        pnlPrice.add(food);
        pnlPrice.add(room);
        pnlPrice.add(Room);
        pnlPrice.add(total) ;
        pnlPrice.add(Total) ;
        
        //create panel Bawah
        pnlBawah=new JPanel(new GridLayout(1,3)) ;
        
        //create JButton for calculate and clear And   //register action/item listener
        calc=new JButton("CALCULATE") ;
        cbHandler = new CalculateButtonHandler();
        calc.addActionListener(cbHandler);

        clear=new JButton("CLEAR") ;
        clearHandler = new ClearHandler();
        clear.addActionListener(clearHandler);
        
        reciept=new JButton("RECIEPT");
        recieptHandler=new RecieptHandler();
        reciept.addActionListener(recieptHandler);
       

        //add to pnlBawah
        pnlBawah.add(calc) ;
        pnlBawah.add(clear) ;
        pnlBawah.add(reciept);
        
        //create ButtonGroup for pnlBawah
        ButtonGroup groupB=new ButtonGroup() ;
        groupB.add(calc) ;
        groupB.add(clear) ;
        
        
        
        //arrange the panel
        cont.add(pnlDetails, BorderLayout.WEST) ;
        cont.add(pnlData, BorderLayout.CENTER) ;
        cont.add(pnlPrice, BorderLayout.EAST) ;
        cont.add(pnlBawah, BorderLayout.SOUTH) ;
        
        pnlDetails.setBackground(purple);
        pnlPrice.setBackground(purple);
        pnlData.setBackground(purple);
        pnlBawah.setBackground(purple);
        visa.setBackground(purple);
        master.setBackground(purple);
        cash.setBackground(purple);
        y.setBackground(purple);
        n.setBackground(purple);
        yes.setBackground(purple);
        no.setBackground(purple);
        sauna.setBackground(purple);
        food.setBackground(purple);
        suite.setBackground(purple);
        family.setBackground(purple);
        single.setBackground(purple);
        clear.setBackground(red);        
        this.setSize(600,300) ;
        this.show() ;
     }
     
     
     
   
   
    public class CalculateButtonHandler implements ActionListener
    { 
        
        public void actionPerformed(ActionEvent e) 
        {
            double jumlah =0, priceS =0,priceR=0, total=0 ;
       

            if(suite.isSelected())
            {  
                priceR=500;
                
            }
            if(family.isSelected())
            {
                priceR=200;
            }
            if(single.isSelected())
            {
                priceR=100;
            }
           
            
            
            if(sauna.isSelected())
            {
                priceS=5;
            }
            if(food.isSelected())
            {
                priceS=5;
            }
                           
            total=priceS+priceR ;
           
            if(visa.isSelected())
            {
                jumlah=total+(0.05*total);                 
            }
         
            if(master.isSelected())
            {
                jumlah=total+(0.02*total);                  
            }
            
            if(cash.isSelected())
            {
                jumlah=total;
            }
            
            if(y.isSelected())
            {
              
                jumlah = jumlah-(jumlah*0.02);  
                DecimalFormat df=new DecimalFormat("0.00") ;
                
            
                Total.setText("RM " +df.format(jumlah)) ;
                
                
                pRice=Double.toString(priceS);
                prIce=Double.toString(priceR);
                
                paYment=Double.toString(jumlah);
           }//end method actionperformed
           DecimalFormat df1=new DecimalFormat("00") ;
           double x = (Math.random()*((100.0-1.0)+1.0)+1.0);
                
                z=df1.format(x);
                Room.setText(z);
        }     
    }//end class CBH
          public String getNAME(){return naMe=Name.getText();}
          public String getIC(){return Ic=IC.getText();}
          public String getDATE(){return dAte=Date.getText();}
          public String getPRICES(){return pRice;}
          public String getPRICER(){return prIce;}
          public String getPAYMENT(){return paYment;}
          public String getROOM(){return z;}
    
     private class RecieptHandler implements ActionListener
     {
        
         public void actionPerformed(ActionEvent e)
        
         {
            

             JOptionPane.showMessageDialog(null, "                                   RECIEPT          "+"\n          NEZUKO RESORT          ROOM no. "+z+"\nNAME :"+getNAME()+"\nDATE  :"+getDATE()+"\n\nROOM PRICE                                             "+prIce+
            "\nSERVICE CHARGE                                         "+getPRICES()+"\nTOTAL PRICE (AFTER DISCOUNT)          "+getPAYMENT()
            +"\n\n        DISCOUNT APPLIED FOR MEMBER.\n               MEMBER (5% DISCOUNT)\n\n   THANK YOU FOR STAYING AT NEZUKO RESORT", "Receipt",
            JOptionPane.PLAIN_MESSAGE);
           }
            
       }
      
        
        private class ClearHandler implements ActionListener
     {
           public void actionPerformed(ActionEvent e) 
           {
                
            
                Name.setText("") ;
                IC.setText("") ;
                Date.setText("yyyy/MM/dd") ;
                Room.setText("") ;
                Total.setText("") ;
                suite.setSelected(false) ;
                family.setSelected(false) ;
                single.setSelected(false) ;
                visa.setSelected(false) ;
                master.setSelected(false) ;
                cash.setSelected(false) ;
                yes.setSelected(false) ;
                no.setSelected(false) ;
                y.setSelected(false) ;
                n.setSelected(false) ;
                sauna.setSelected(false);
                food.setSelected(false);
        
       
            }
        }
    
      public static void main(String [] args) 
      { 
         nejukoo n=new nejukoo() ;
        }
   
 }


