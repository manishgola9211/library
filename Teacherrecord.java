import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.Date;

class Teacherrecord implements ActionListener,ItemListener
{
JFrame teare;
JLabel name;
ImageIcon image;
Font f,f1;
JLabel firstnm,dob,fathernm,quali,id,phone,add;
JLabel lastnm,mothernm,gender,job,email,pass,special;

JTextField fnm,dobtf,fnmtf,qutf,idtf,phonetf,addtf;
JTextField lasttf,mothertf,sptf,emailtf,passtf;
Choice gentf,jobtf;

JButton create,delete,modify,view,back,exit,clear;

PreparedStatement ps;
Connection con;
Date date;
ResultSet rs;
Statement stmt;
String first,last,dateof,father,qu,idno,phoneno,address,mother,emailid,password,sp,jo,gend;
String msg="";
int idnumber=0;

Teacherrecord()
{
teare=new JFrame("Administrator-Teacher's Account");
teare.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
teare.add(name);




firstnm=new JLabel("Firstname");
f1=new Font("Dialog",Font.BOLD|Font.ITALIC,15);
firstnm.setFont(f1);
firstnm.setBounds(30,150,100,50);
teare.add(firstnm);

dob=new JLabel("Date-Of-Birth");
dob.setFont(f1);
dob.setBounds(30,200,100,50);
teare.add(dob);

fathernm=new JLabel("Father's name");
fathernm.setFont(f1);
fathernm.setBounds(30,250,100,50);
teare.add(fathernm);

quali=new JLabel("Qualification");
quali.setFont(f1);
quali.setBounds(30,300,100,50);
teare.add(quali);

id=new JLabel("Teacher-Id");
id.setFont(f1);
id.setBounds(30,350,100,50);
teare.add(id);



phone=new JLabel("Phone Number");
phone.setFont(f1);
phone.setBounds(30,400,120,50);
teare.add(phone);

add=new JLabel("Address");
add.setFont(f1);
add.setBounds(30,450,100,50);
teare.add(add);




fnm=new JTextField(20);
fnm.setBounds(160,165,130,25);
teare.add(fnm);

dobtf=new JTextField(20);
dobtf.setBounds(160,215,130,25);
teare.add(dobtf);

fnmtf=new JTextField(20);
fnmtf.setBounds(160,265,130,25);
teare.add(fnmtf);

qutf=new JTextField(20);
qutf.setBounds(160,315,130,25);
teare.add(qutf);



idtf=new JTextField(20);
idtf.setBounds(160,365,130,25);
teare.add(idtf);

phonetf=new JTextField(20);
phonetf.setBounds(160,415,130,25);
teare.add(phonetf);

addtf=new JTextField(20);
addtf.setBounds(160,465,130,25);
teare.add(addtf);


lastnm=new JLabel("Lastname");
lastnm.setFont(f1);
lastnm.setBounds(330,150,100,50);
teare.add(lastnm);

gender=new JLabel("Gender");
gender.setFont(f1);
gender.setBounds(330,200,100,50);
teare.add(gender);

mothernm=new JLabel("Mother's name");
mothernm.setFont(f1);
mothernm.setBounds(330,250,130,50);
teare.add(mothernm);

job=new JLabel("Job Post");
job.setFont(f1);
job.setBounds(330,300,100,50);
teare.add(job);

pass=new JLabel("Password");
pass.setFont(f1);
pass.setBounds(330,350,100,50);
teare.add(pass);



email=new JLabel("Email-Id");
email.setFont(f1);
email.setBounds(330,400,120,50);
teare.add(email);

special=new JLabel("Special Interest");
special.setFont(f1);
special.setBounds(330,450,120,50);
teare.add(special);

lasttf=new JTextField(20);
lasttf.setBounds(460,165,130,25);
teare.add(lasttf);

gentf=new Choice();
gentf.add("Select Gender");
gentf.add("Male");
gentf.add("Female");
gentf.setBounds(460,215,130,30);
gentf.addItemListener(this);
teare.add(gentf);

mothertf=new JTextField(20);
mothertf.setBounds(460,265,130,25);
teare.add(mothertf);


jobtf=new Choice();
jobtf.add("Select Job Post");
jobtf.add("HOD");
jobtf.add("Teacher");
jobtf.add("Other");
jobtf.setBounds(460,315,130,30);
jobtf.addItemListener(this);
teare.add(jobtf);

passtf=new JTextField(20);
passtf.setBounds(460,365,130,25);
teare.add(passtf);




emailtf=new JTextField(20);
emailtf.setBounds(460,415,130,25);
teare.add(emailtf);

sptf=new JTextField(20);
sptf.setBounds(460,465,130,25);
teare.add(sptf);

create=new JButton("Create New Account");
create.setBounds(630,170,150,25);
create.addActionListener(this);
teare.add(create);

delete=new JButton("Delete Account");
delete.setBounds(630,230,150,25);
delete.addActionListener(this);
teare.add(delete);

modify=new JButton("Update Account");
modify.setBounds(630,290,150,25);
modify.addActionListener(this);
teare.add(modify);

view=new JButton("View Acc. Details");
view.setBounds(630,350,150,25);
view.addActionListener(this);
teare.add(view);

clear=new JButton("Clear");
clear.setBounds(630,410,150,25);
clear.addActionListener(this);
teare.add(clear);

back=new JButton("Back");
back.setBounds(630,470,150,25);
back.addActionListener(this);
teare.add(back);

exit=new JButton("Exit");
exit.setBounds(630,520,150,25);
exit.addActionListener(this);
teare.add(exit);



try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}




teare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
teare.setSize(800,800);
teare.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Adminteacher();
teare.setVisible(false);
}


if(str.equals("Clear"))
{
fnm.setText("");
dobtf.setText("");
fnmtf.setText("");
qutf.setText("");
idtf.setText("");
phonetf.setText("");
addtf.setText("");
lasttf.setText("");
mothertf.setText("");
sptf.setText("");
emailtf.setText("");
passtf.setText("");
gentf.select(0);
jobtf.select(0);
}


if(str.equals("Create New Account"))
{
date=new Date();


first=fnm.getText();
last=lasttf.getText();
dateof=dobtf.getText();
father=fnmtf.getText();
qu=qutf.getText();
idno=idtf.getText();
phoneno=phonetf.getText();
address=addtf.getText();
mother=mothertf.getText();
sp=sptf.getText();
emailid=emailtf.getText();
password=passtf.getText();


if(first.equals(""))
msg="Please enter first name";
else if(last.equals(""))
msg="Please enter last name";
else if(dateof.equals(""))
msg="Please enter date-of-birth";
else if(gend.equals(""))
msg="Please select gender";
else if(father.equals(""))
msg="Select enter father name";
else if(qu.equals(""))
msg="Please enter your qualification";
else if(jo.equals(""))
msg="Please select your job post";
else if(idno.equals(""))
msg="please enter teacher-id";
else if(phoneno.equals(""))
msg="Please enter phone number";
else if(address.equals(""))
msg="Please enter address";
else if(mother.equals(""))
msg="Select enter mother name";
else if(emailid.equals(""))
msg="Please enter E-mail id";
else if(password.equals(""))
msg="Please enter password";
else if(sp.equals(""))
msg="please enter special interest";
else msg="";



if(msg.equals(""))
{
try
{
Integer.parseInt((String)idno);
}
catch(Exception e){msg="Please enter Teacher-Id  in number format";}
}

if(msg.equals(""))
{
try
{
Integer.parseInt((String)phoneno);
}
catch(Exception e){msg="Please enter Phone number in number format";}
}



if(msg.equals(""))
{
try{
idnumber=Integer.parseInt((String)idtf.getText());
}
catch(Exception e){System.out.println(e);}
try
{
ps=con.prepareStatement("Select * from teacher where Teacherid=?");
ps.setInt(1,idnumber);
rs=ps.executeQuery();
while(rs.next())
{
msg="this "+idnumber+" Teacherid number aleardy has an account";
}
}

catch(Exception e){System.out.println(e);}
}


if(msg.equals(""))
{

try
{
ps=con.prepareStatement("Insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setString(1,fnm.getText());
ps.setString(2,lasttf.getText());
ps.setString(3,dobtf.getText());
ps.setString(4,gend);
ps.setString(5,fnmtf.getText());
ps.setString(6,mothertf.getText());
ps.setString(7,qutf.getText());
ps.setString(8,jo);
ps.setInt(9,Integer.parseInt(idtf.getText()));
ps.setString(10,passtf.getText());
ps.setInt(11,Integer.parseInt(phonetf.getText()));
ps.setString(12,emailtf.getText());
ps.setString(13,addtf.getText());
ps.setString(14,sptf.getText());
ps.setString(15,date.toString());
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"New Account Created");
}
catch(Exception e){System.out.println(e);}
}
else
JOptionPane.showMessageDialog(null,msg);
}


if(str.equals("View Acc. Details"))
{
int y=0;
idnumber=Integer.parseInt((String)idtf.getText());
try
{
ps=con.prepareStatement("select * from teacher where Teacherid=?");
ps.setInt(1,idnumber);
rs=ps.executeQuery();
while(rs.next())
{
fnm.setText(rs.getString("Firstname"));
lasttf.setText(rs.getString("Lastname"));
dobtf.setText(rs.getString("Dateofbirth"));
gentf.select(rs.getString("Gender"));
fnmtf.setText(rs.getString("Fathername"));
mothertf.setText(rs.getString("Mothername"));
qutf.setText(rs.getString("Qualification"));
jobtf.select(rs.getString("Job Post"));
idtf.setText(rs.getInt("Teacherid")+"");
passtf.setText(rs.getString("password"));
phonetf.setText(rs.getInt("Phonenumber")+"");
emailtf.setText(rs.getString("Emailid"));
addtf.setText(rs.getString("Address"));
sptf.setText(rs.getString("Specialinterest"));
y=1;
gend=gentf.getSelectedItem();
jo=jobtf.getSelectedItem();

}
}
catch(Exception e){System.out.println(e);}

if(y==0)  
{
JOptionPane.showMessageDialog(null,"Record not Found");
fnm.setText("");
lasttf.setText("");
dobtf.setText("");
gentf.select(0);
fnmtf.setText("");
mothertf.setText("");
qutf.setText("");
jobtf.select(0);
passtf.setText("");
phonetf.setText("");
emailtf.setText("");
addtf.setText("");
sptf.setText("");
}
}


if(str.equals("Delete Account"))
{
int del=0;
try
{
ps=con.prepareStatement("Delete from teacher where Teacherid=?");
ps.setInt(1,Integer.parseInt(idtf.getText()));
del=ps.executeUpdate();
}
catch(Exception e){}
if(del==0)
JOptionPane.showMessageDialog(null,"Record Not Found");
else
JOptionPane.showMessageDialog(null,"Record Deleted");
}


if(str.equals("Update Account"))
{
int y=0;
try
{
idnumber=Integer.parseInt((String)idtf.getText());
ps=con.prepareStatement("Update teacher set Firstname=?,Lastname=?,Dateofbirth=?,Fathername=?,Mothername=?,Qualification=?,Password=?,Phonenumber=?,Emailid=?,Address=?,Specialinterest=? where Teacherid=?");
ps.setString(1,fnm.getText());
ps.setString(2,lasttf.getText());
ps.setString(3,dobtf.getText());
//ps.setString(4,gend);
ps.setString(4,fnmtf.getText());
ps.setString(5,mothertf.getText());
ps.setString(6,qutf.getText());
//ps.setString(8,jo);
ps.setString(7,passtf.getText());
ps.setInt(8,Integer.parseInt(phonetf.getText()));
ps.setString(9,emailtf.getText());
ps.setString(10,addtf.getText());
ps.setString(11,sptf.getText());
ps.setInt(12,Integer.parseInt(idtf.getText()));
y=ps.executeUpdate();
if(y==1) JOptionPane.showMessageDialog(null,"Record Updated");
}
catch(Exception e){System.out.println(e);}
}



}





public void itemStateChanged(ItemEvent ie)
{
gend=gentf.getSelectedItem();
jo=jobtf.getSelectedItem();
}




}