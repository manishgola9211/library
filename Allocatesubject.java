import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Allocatesubject implements ActionListener,ItemListener
{
JFrame allsub;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f,f1;
JComboBox sem,bran;
JLabel sub1,sub2,sub3,sub4,sub5,sub6,lab1,lab2,lab3,lab4,add1,add2;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
JButton allo,upd,view,back,exit;
String sb1,sb2,sb3,sb4,sb5,sb6,sb7,sb8,sb9,sb10,sb11,sb12;
PreparedStatement ps;
Connection con;
String seme="null",br="null",msg=""; 
Statement stmt;
ResultSet rs;

Allocatesubject()
{
allsub=new JFrame("Administrator-Settings-AllocateSubject");
allsub.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
allsub.add(name);

sem=new JComboBox();
sem.addItem("Select Semester");
sem.addItem("Semester1");
sem.addItem("Semester2");
sem.addItem("Semester3");
sem.addItem("Semester4");
sem.addItem("Semester5");
sem.addItem("Semester6");
sem.addItem("Semester7");
sem.addItem("Semester8");
sem.setBounds(200,150,150,30);
sem.addItemListener(this);
allsub.add(sem);

bran=new JComboBox();
bran.addItem("Select Branch");
bran.addItem("CSE");
bran.addItem("IT");
bran.addItem("ECE");
bran.setBounds(400,150,150,30);
bran.addItemListener(this);
allsub.add(bran);

sub1=new JLabel("Subject1");
f1=new Font("TimesRoman",Font.BOLD,20);
sub1.setFont(f1);
sub1.setBounds(50,200,100,50);
allsub.add(sub1);

sub2=new JLabel("Subject2");
sub2.setFont(f1);
sub2.setBounds(50,250,100,50);
allsub.add(sub2);

sub3=new JLabel("Subject3");
sub3.setFont(f1);
sub3.setBounds(50,300,100,50);
allsub.add(sub3);

sub4=new JLabel("Subject4");
sub4.setFont(f1);
sub4.setBounds(50,350,100,50);
allsub.add(sub4);

sub5=new JLabel("Subject5");
sub5.setFont(f1);
sub5.setBounds(50,400,100,50);
allsub.add(sub5);

sub6=new JLabel("Subject6");
sub6.setFont(f1);
sub6.setBounds(50,450,100,50);
allsub.add(sub6);

tf1=new JTextField(20);
tf1.setBounds(180,215,150,30);
allsub.add(tf1);

tf2=new JTextField(20);
tf2.setBounds(180,265,150,30);
allsub.add(tf2);

tf3=new JTextField(20);
tf3.setBounds(180,315,150,30);
allsub.add(tf3);

tf4=new JTextField(20);
tf4.setBounds(180,365,150,30);
allsub.add(tf4);

tf5=new JTextField(20);
tf5.setBounds(180,415,150,30);
allsub.add(tf5);

tf6=new JTextField(20);
tf6.setBounds(180,465,150,30);
allsub.add(tf6);

lab1=new JLabel("Lab1");
lab1.setFont(f1);
lab1.setBounds(400,200,100,50);
allsub.add(lab1);

lab2=new JLabel("Lab2");
lab2.setFont(f1);
lab2.setBounds(400,250,100,50);
allsub.add(lab2);

lab3=new JLabel("Lab3");
lab3.setFont(f1);
lab3.setBounds(400,300,100,50);
allsub.add(lab3);

lab4=new JLabel("Lab4");
lab4.setFont(f1);
lab4.setBounds(400,350,100,50);
allsub.add(lab4);

add1=new JLabel("Add. Subj1");
add1.setFont(f1);
add1.setBounds(400,400,150,50);
allsub.add(add1);

add2=new JLabel("Add. Subj2");
add2.setFont(f1);
add2.setBounds(400,450,150,50);
allsub.add(add2);

tf7=new JTextField(20);
tf7.setBounds(530,215,150,30);
allsub.add(tf7);

tf8=new JTextField(20);
tf8.setBounds(530,265,150,30);
allsub.add(tf8);

tf9=new JTextField(20);
tf9.setBounds(530,315,150,30);
allsub.add(tf9);

tf10=new JTextField(20);
tf10.setBounds(530,365,150,30);
allsub.add(tf10);

tf11=new JTextField(20);
tf11.setBounds(530,415,150,30);
allsub.add(tf11);

tf12=new JTextField(20);
tf12.setBounds(530,465,150,30);
allsub.add(tf12);

allo=new JButton("Allocate");
allo.setBounds(50,520,100,30);
allo.addActionListener(this);
allsub.add(allo);

view=new JButton("View");
view.setBounds(200,520,100,30);
view.addActionListener(this);
allsub.add(view);

upd=new JButton("Update");
upd.setBounds(350,520,120,30);
upd.addActionListener(this);
allsub.add(upd);

back=new JButton("Back");
back.setBounds(500,520,120,30);
back.addActionListener(this);
allsub.add(back);

exit=new JButton("Exit");
exit.setBounds(650,520,120,30);
exit.addActionListener(this);
allsub.add(exit);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}

allsub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
allsub.setSize(800,800);
allsub.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Settings();
allsub.setVisible(false);
}

if(str.equals("Allocate"))
{


if(seme.equals("null")||seme.equals("Select Semester"))
msg="Please Select Semester";
else if(br.equals("null")||br.equals("Select Branch"))
msg="Please Select Branch";
else
msg="";

sb1=tf1.getText();
sb2=tf2.getText();
sb3=tf3.getText();
sb4=tf4.getText();
sb5=tf5.getText();
sb6=tf6.getText();
sb7=tf7.getText();
sb8=tf8.getText();
sb9=tf9.getText();
sb10=tf10.getText();
sb11=tf11.getText();
sb12=tf12.getText();

if(sb1.equals(""))
sb1="null";
if(sb2.equals(""))
sb2="null";
if(sb3.equals(""))
sb3="null";
if(sb4.equals(""))
sb4="null";
if(sb5.equals(""))
sb5="null";
if(sb6.equals(""))
sb6="null";
if(sb7.equals(""))
sb7="null";
if(sb8.equals(""))
sb8="null";
if(sb9.equals(""))
sb9="null";
if(sb10.equals(""))
sb10="null";
if(sb11.equals(""))
sb11="null";
if(sb12.equals(""))
sb12="null";

try
{
ps=con.prepareStatement("Select * from allocatesubject where Semester=? and Branch=?");
ps.setString(1,seme);
ps.setString(2,br);
rs=ps.executeQuery();
while(rs.next())
{
msg="Subject already allocated to "+seme+"-"+br;
JOptionPane.showMessageDialog(null,msg);
}
}
catch(Exception e){System.out.println(e);}


if(msg.equals(""))
{
try
{
ps=con.prepareStatement("Insert into allocatesubject values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,seme);
ps.setString(2,br);
ps.setString(3,sb1);
ps.setString(4,sb2);
ps.setString(5,sb3);
ps.setString(6,sb4);
ps.setString(7,sb5);
ps.setString(8,sb6);
ps.setString(9,sb7);
ps.setString(10,sb8);
ps.setString(11,sb9);
ps.setString(12,sb10);
ps.setString(13,sb11);
ps.setString(14,sb12);
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"Subjects allocated to"+seme+"-"+br);

}
catch(Exception e){System.out.println(e);}

}
else
JOptionPane.showMessageDialog(null,msg);

msg="";
}
if(str.equals("View"))
{
try
{
ps=con.prepareStatement("Select * from allocatesubject where Semester=? and Branch=?");
ps.setString(1,seme);
ps.setString(2,br);
rs=ps.executeQuery();
while(rs.next())
{
msg="allocated";
tf1.setText(rs.getString("Subject1"));
tf2.setText(rs.getString("Subject2"));
tf3.setText(rs.getString("Subject3"));
tf4.setText(rs.getString("Subject4"));
tf5.setText(rs.getString("Subject5"));
tf6.setText(rs.getString("Subject6"));
tf7.setText(rs.getString("Lab1"));
tf8.setText(rs.getString("Lab2"));
tf9.setText(rs.getString("Lab3"));
tf10.setText(rs.getString("Lab4"));
tf11.setText(rs.getString("Additionalsubject1"));
tf12.setText(rs.getString("Additionalsubject2"));
}
}
catch(Exception e){System.out.println(e);}
if(msg.equals(""))
JOptionPane.showMessageDialog(null,"Subjects is not allocated to "+seme+" "+br);
msg="";
}

if(str.equals("Update"))
{
try
{
ps=con.prepareStatement("Update allocatesubject set Subject1=?,Subject2=?,Subject3=?,Subject4=?,Subject5=?,Subject6=?,Lab1=?,Lab2=?,Lab3=?,Lab4=?,Additionalsubject1=?,Additionalsubject2=? where Semester=? and Branch=?");
ps.setString(1,tf1.getText());
ps.setString(2,tf2.getText());
ps.setString(3,tf3.getText());
ps.setString(4,tf4.getText());
ps.setString(5,tf5.getText());
ps.setString(6,tf6.getText());
ps.setString(7,tf7.getText());
ps.setString(8,tf8.getText());
ps.setString(9,tf9.getText());
ps.setString(10,tf10.getText());
ps.setString(11,tf11.getText());
ps.setString(12,tf12.getText());
ps.setString(13,seme);
ps.setString(14,br);
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"Subjects Updated to "+seme+" "+br);
}
catch(Exception e){System.out.println(e);}
}



}
public void itemStateChanged(ItemEvent ie)
{

seme=(String)sem.getSelectedItem();
br=(String)bran.getSelectedItem();

}



}