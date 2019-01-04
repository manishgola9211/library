import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Login implements ActionListener,ItemListener
{
JFrame login;
JLabel name;
JLabel usernm;
JLabel passwd;
JLabel pic;
Font f,f1;
ImageIcon image,image1;
JComboBox user;
JPasswordField pass;
JButton logn,exit;
PreparedStatement ps;
String usernm1="";
int check=0;
String pawd="";

Login()
{
login=new JFrame("LOGIN");
login.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
login.add(name);

usernm=new JLabel("USERNAME");
f1=new Font("Dialog",Font.BOLD|Font.ITALIC,17);
usernm.setFont(f1);
usernm.setBounds(430,280,100,40);
login.add(usernm);

passwd=new JLabel("PASSWORD");
passwd.setFont(f1);
passwd.setBounds(430,330,100,40);
login.add(passwd);

image1=new ImageIcon("attendance_pgraphic.jpg");
pic=new JLabel("",image1,JLabel.CENTER);
pic.setBounds(10,190,450,340);
login.add(pic);

user=new JComboBox();
user.addItem("Select User");
user.addItem("Administrator");
user.addItem("Teacher");
user.addItem("Student");
user.setBounds(550,288,200,30);
user.addItemListener(this);
login.add(user);


pass=new JPasswordField(20);
pass.setBounds(550,337,200,30);
login.add(pass);

logn=new JButton("Login");
logn.setBounds(470,410,120,30);
logn.addActionListener(this);
login.add(logn);

exit=new JButton("Exit");
exit.setBounds(620,410,120,30);
exit.addActionListener(this);
login.add(exit);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:student","","");
ps=con.prepareStatement("Select * from login where Username=?");
}
catch(Exception e){}

login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
login.setSize(800,800);
login.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
check=0;
String str=ae.getActionCommand();
if(str.equals("Login"))
{
try
{
ps.setString(1,usernm1);
ResultSet rs=ps.executeQuery();
while(rs.next())
{
pawd=rs.getString("Password");
if(pawd.equals(pass.getText()))
check=1;
}
if(check==1)
{
if(usernm1.equals("Administrator"))
{
new Administrator();
login.setVisible(false);
}

if(usernm1.equals("Teacher"))
{
new Teacher();
login.setVisible(false);
}

if(usernm1.equals("Student"))
{
new Studetail1();
login.setVisible(false);
}
}
else
{
JOptionPane.showMessageDialog(null,"Wrong Username or Password");
pass.setText("");
}
}
catch(Exception e){}

}

if(str.equals("Exit"))
System.exit(0);
}
public void itemStateChanged(ItemEvent se)
{

usernm1=(String)se.getItem();
}



public static void main(String args[])
{
Login l=new Login();
}

}
