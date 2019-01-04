import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.Date;

class Teacherdetail implements ActionListener
{
JFrame tead;
JLabel name;
ImageIcon image;
Font f,f1;

JLabel firstnm,dob,fathernm,quali,id,phone,add;
JLabel lastnm,mothernm,gender,job,email,pass,special;

JTextField fnm,dobtf,fnmtf,qutf,idtf,phonetf,addtf;
JTextField lasttf,mothertf,sptf,emailtf,passtf;
Choice gentf,jobtf;
JButton view,back,exit;
PreparedStatement ps;
Connection con;
Date date;
ResultSet rs;
Statement stmt;

Teacherdetail()
{
tead=new JFrame("Teacher-Account's Details");
tead.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
tead.add(name);

firstnm=new JLabel("Firstname");
f1=new Font("Dialog",Font.BOLD|Font.ITALIC,15);
firstnm.setFont(f1);
firstnm.setBounds(30,200,100,50);
tead.add(firstnm);


id=new JLabel("Teacher-Id");
id.setFont(f1);
id.setBounds(30,150,100,50);
tead.add(id);


dob=new JLabel("Date-Of-Birth");
dob.setFont(f1);
dob.setBounds(30,250,100,50);
tead.add(dob);

fathernm=new JLabel("Father's name");
fathernm.setFont(f1);
fathernm.setBounds(30,300,100,50);
tead.add(fathernm);

quali=new JLabel("Qualification");
quali.setFont(f1);
quali.setBounds(30,350,100,50);
tead.add(quali);




phone=new JLabel("Phone Number");
phone.setFont(f1);
phone.setBounds(30,400,120,50);
tead.add(phone);

add=new JLabel("Address");
add.setFont(f1);
add.setBounds(30,450,100,50);
tead.add(add);


idtf=new JTextField(20);
idtf.setBounds(160,165,130,25);
tead.add(idtf);

fnm=new JTextField(20);
fnm.setBounds(160,215,130,25);
tead.add(fnm);

dobtf=new JTextField(20);
dobtf.setBounds(160,265,130,25);
tead.add(dobtf);

fnmtf=new JTextField(20);
fnmtf.setBounds(160,315,130,25);
tead.add(fnmtf);

qutf=new JTextField(20);
qutf.setBounds(160,365,130,25);
tead.add(qutf);





phonetf=new JTextField(20);
phonetf.setBounds(160,415,130,25);
tead.add(phonetf);

addtf=new JTextField(20);
addtf.setBounds(160,465,130,25);
tead.add(addtf);


pass=new JLabel("Password");
pass.setFont(f1);
pass.setBounds(330,150,100,50);
tead.add(pass);

lastnm=new JLabel("Lastname");
lastnm.setFont(f1);
lastnm.setBounds(330,200,100,50);
tead.add(lastnm);

gender=new JLabel("Gender");
gender.setFont(f1);
gender.setBounds(330,250,100,50);
tead.add(gender);

mothernm=new JLabel("Mother's name");
mothernm.setFont(f1);
mothernm.setBounds(330,300,130,50);
tead.add(mothernm);

job=new JLabel("Job Post");
job.setFont(f1);
job.setBounds(330,350,100,50);
tead.add(job);





email=new JLabel("Email-Id");
email.setFont(f1);
email.setBounds(330,400,120,50);
tead.add(email);

special=new JLabel("Special Interest");
special.setFont(f1);
special.setBounds(330,450,120,50);
tead.add(special);


passtf=new JTextField(20);
passtf.setBounds(460,165,130,25);
tead.add(passtf);

lasttf=new JTextField(20);
lasttf.setBounds(460,215,130,25);
tead.add(lasttf);

gentf=new Choice();
gentf.add("Select Gender");
gentf.add("Male");
gentf.add("Female");
gentf.setBounds(460,265,130,30);
tead.add(gentf);

mothertf=new JTextField(20);
mothertf.setBounds(460,315,130,25);
tead.add(mothertf);


jobtf=new Choice();
jobtf.add("Select Job Post");
jobtf.add("HOD");
jobtf.add("Teacher");
jobtf.add("Other");
jobtf.setBounds(460,365,130,30);
tead.add(jobtf);






emailtf=new JTextField(20);
emailtf.setBounds(460,415,130,25);
tead.add(emailtf);

sptf=new JTextField(20);
sptf.setBounds(460,465,130,25);
tead.add(sptf);

view=new JButton("View Acc. Details");
view.setBounds(630,200,150,30);
view.addActionListener(this);
tead.add(view);


back=new JButton("Back");
back.setBounds(630,300,150,30);
back.addActionListener(this);
tead.add(back);

exit=new JButton("Exit");
exit.setBounds(630,400,150,30);
exit.addActionListener(this);
tead.add(exit);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}


tead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
tead.setSize(800,800);
tead.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Teacher();
tead.setVisible(false);
}

if(str.equals("View Acc. Details"))
{
int y=0;
int idnumber=Integer.parseInt((String)idtf.getText());
try
{
ps=con.prepareStatement("select * from teacher where Teacherid=? and Password=?");
ps.setInt(1,idnumber);
ps.setString(2,passtf.getText());
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
phonetf.setText(rs.getInt("Phonenumber")+"");
emailtf.setText(rs.getString("Emailid"));
addtf.setText(rs.getString("Address"));
sptf.setText(rs.getString("Specialinterest"));
y=1;

}
}
catch(Exception e){System.out.println(e);}
if(y==0) JOptionPane.showMessageDialog(null,"Invalid Teacherid or Password");
}
}


}