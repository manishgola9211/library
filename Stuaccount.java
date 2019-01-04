import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;


class Stuaccount implements ActionListener
{
JFrame sture;
JLabel name;
ImageIcon image;
Font f,f1;
JLabel firstnm,dob,fathernm,xper,sem,roll,phone,add;
JLabel lastnm,mothernm,gender,xiiper,branch,group,email,pass;

JTextField fnm,dobtf,fnmtf,xpertf,rolltf,phonetf,addtf;
JTextField lasttf,mothertf,xiitf,emailtf;
JTextField passtf;

JButton create,delete,modify,view,back,exit,clear;
Choice gentf,semtf,brantf,grtf;
String gend="",seme="",br="",gro="";
PreparedStatement ps;
Connection con;
Date date;
String first,last,dateof,father,x,rollno,phoneno,address,mother,xii,emailid,password;
String msg="";
String []se={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
ResultSet rs;
Statement stmt;
int rollnumber=0,rn=0;

Stuaccount()
{
sture=new JFrame("Teacher-Student");
sture.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
sture.add(name);

firstnm=new JLabel("Firstname");
f1=new Font("Dialog",Font.BOLD|Font.ITALIC,15);
firstnm.setFont(f1);
firstnm.setBounds(30,150,100,50);
sture.add(firstnm);

dob=new JLabel("Date-Of-Birth");
dob.setFont(f1);
dob.setBounds(30,200,100,50);
sture.add(dob);

fathernm=new JLabel("Father's name");
fathernm.setFont(f1);
fathernm.setBounds(30,250,100,50);
sture.add(fathernm);

xper=new JLabel("X%");
xper.setFont(f1);
xper.setBounds(30,300,100,50);
sture.add(xper);

sem=new JLabel("Semester");
sem.setFont(f1);
sem.setBounds(30,350,100,50);
sture.add(sem);

roll=new JLabel("Roll-No.");
roll.setFont(f1);
roll.setBounds(30,400,100,50);
sture.add(roll);

phone=new JLabel("Phone Number");
phone.setFont(f1);
phone.setBounds(30,450,120,50);
sture.add(phone);

add=new JLabel("Address");
add.setFont(f1);
add.setBounds(30,500,100,50);
sture.add(add);

fnm=new JTextField(20);
fnm.setBounds(160,165,130,25);
sture.add(fnm);

dobtf=new JTextField(20);
dobtf.setBounds(160,215,130,25);
sture.add(dobtf);

fnmtf=new JTextField(20);
fnmtf.setBounds(160,265,130,25);
sture.add(fnmtf);

xpertf=new JTextField(20);
xpertf.setBounds(160,315,130,25);
sture.add(xpertf);

semtf=new Choice();
semtf.add("Select Semester");
semtf.add("Semester1");
semtf.add("Semester2");
semtf.add("Semester3");
semtf.add("Semester4");
semtf.add("Semester5");
semtf.add("Semester6");
semtf.add("Semester7");
semtf.add("Semester8");
semtf.setBounds(160,365,130,30);
//semtf.addItemListener(this);
sture.add(semtf);

rolltf=new JTextField(20);
rolltf.setBounds(160,415,130,25);
sture.add(rolltf);

phonetf=new JTextField(20);
phonetf.setBounds(160,465,130,25);
sture.add(phonetf);

addtf=new JTextField(20);
addtf.setBounds(160,515,130,25);
sture.add(addtf);

lastnm=new JLabel("Lastname");
lastnm.setFont(f1);
lastnm.setBounds(330,150,100,50);
sture.add(lastnm);

gender=new JLabel("Gender");
gender.setFont(f1);
gender.setBounds(330,200,100,50);
sture.add(gender);

mothernm=new JLabel("Mother's name");
mothernm.setFont(f1);
mothernm.setBounds(330,250,130,50);
sture.add(mothernm);

xiiper=new JLabel("XII%");
xiiper.setFont(f1);
xiiper.setBounds(330,300,100,50);
sture.add(xiiper);

branch=new JLabel("Branch");
branch.setFont(f1);
branch.setBounds(330,350,100,50);
sture.add(branch);

group=new JLabel("Group");
group.setFont(f1);
group.setBounds(330,400,100,50);
sture.add(group);

email=new JLabel("Email-Id");
email.setFont(f1);
email.setBounds(330,450,120,50);
sture.add(email);

pass=new JLabel("Password");
pass.setFont(f1);
pass.setBounds(330,500,100,50);
sture.add(pass);


lasttf=new JTextField(20);
lasttf.setBounds(460,165,130,25);
sture.add(lasttf);

gentf=new Choice();
gentf.add("Select Gender");
gentf.add("Male");
gentf.add("Female");
gentf.setBounds(460,215,130,30);
//gentf.addItemListener(this);
sture.add(gentf);

mothertf=new JTextField(20);
mothertf.setBounds(460,265,130,25);
sture.add(mothertf);

xiitf=new JTextField(20);
xiitf.setBounds(460,315,130,25);
sture.add(xiitf);

brantf=new Choice();
brantf.add("Select Branch");
brantf.add("CSE");
brantf.add("IT");
brantf.add("ECE");
brantf.setBounds(460,365,130,25);
//brantf.addItemListener(this);
sture.add(brantf);

grtf=new Choice();
grtf.add("Select Group");
grtf.add("Group1");
grtf.add("Group2");
grtf.add("Group3");
grtf.setBounds(460,415,130,25);
//grtf.addItemListener(this);
sture.add(grtf);

emailtf=new JTextField(20);
emailtf.setBounds(460,465,130,25);
sture.add(emailtf);

passtf=new JTextField(20);
passtf.setBounds(460,515,130,25);
sture.add(passtf);

view=new JButton("View Acc. Details");
view.setBounds(630,200,150,30);
view.addActionListener(this);
sture.add(view);

clear=new JButton("Clear");
clear.setBounds(630,300,150,30);
clear.addActionListener(this);
sture.add(clear);

back=new JButton("Back");
back.setBounds(630,400,150,30);
back.addActionListener(this);
sture.add(back);

exit=new JButton("Exit");
exit.setBounds(630,500,150,30);
exit.addActionListener(this);
sture.add(exit);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}


sture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
sture.setSize(800,800);
sture.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Studetail();
sture.setVisible(false);
}
 
if(str.equals("Clear"))
{
fnm.setText("");
lasttf.setText("");
dobtf.setText("");
fnmtf.setText("");
xpertf.setText("");
rolltf.setText("");
phonetf.setText("");
addtf.setText("");
mothertf.setText("");
xiitf.setText("");
emailtf.setText("");
passtf.setText("");
gentf.select(0);
semtf.select(0);
brantf.select(0);
grtf.select(0);
}

if(str.equals("View Acc. Details"))
{

rn=0;
rollnumber=Integer.parseInt((String)rolltf.getText());
try
{
for(int i=0;i<8;i++)
{
rs=stmt.executeQuery("Select * from "+se[i]+" where Rollno="+rollnumber);
while(rs.next())
{
rn=1;

fnm.setText(rs.getString("Firstname"));
lasttf.setText(rs.getString("Lastname"));
dobtf.setText(rs.getString("Dateofbirth"));
gentf.select(rs.getString("Gender"));
//gend=rs.getString("Gender");

fnmtf.setText(rs.getString("Fathername"));
mothertf.setText(rs.getString("Mothername"));
xpertf.setText(rs.getInt("Xper")+"");
xiitf.setText(rs.getInt("XIIper")+"");
phonetf.setText(rs.getInt("Phoneno")+"");
emailtf.setText(rs.getString("Emailid"));
addtf.setText(rs.getString("Address"));
passtf.setText(rs.getString("Password"));

semtf.select(rs.getString("Semester"));
//seme=rs.getString("semester");
brantf.select(rs.getString("Branch"));
//br=rs.getString("Branch");
grtf.select(rs.getString("Group"));
//gro=rs.getString("Group");
gend=gentf.getSelectedItem();
seme=semtf.getSelectedItem();
br=brantf.getSelectedItem();
gro=grtf.getSelectedItem();


}
if(rn==1) break;
}
}
catch(Exception e){System.out.println(e);}
if(rn==0)
{
JOptionPane.showMessageDialog(null,"Record Not Found");
fnm.setText("");
lasttf.setText("");
dobtf.setText("");
fnmtf.setText("");
xpertf.setText("");
phonetf.setText("");
addtf.setText("");
mothertf.setText("");
xiitf.setText("");
emailtf.setText("");
passtf.setText("");
gentf.select(0);
semtf.select(0);
brantf.select(0);
grtf.select(0);
}
}







}

public static void main(String args[])
{
new Stuaccount();
}
}