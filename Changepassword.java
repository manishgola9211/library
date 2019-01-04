import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Changepassword implements ActionListener
{
JFrame change;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f,f1;
JButton back,exit,chang;
JLabel admin,tea,stu;
JTextField admintf,teatf,stutf;
PreparedStatement ps;
ResultSet rs;
Connection con;
String msg;
int chk=0;

Changepassword()
{
change=new JFrame("Administrator-Settings-ChangePassword");
change.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
change.add(name);

admin=new JLabel("Administrator");
f1=new Font("TimesRoman",Font.BOLD,20);
admin.setFont(f1);
admin.setBounds(200,150,150,50);
change.add(admin);


tea=new JLabel("Teacher");
tea.setFont(f1);
tea.setBounds(200,200,150,50);
change.add(tea);

stu=new JLabel("Student");
stu.setFont(f1);
stu.setBounds(200,250,150,50);
change.add(stu);

backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
change.add(back);

admintf=new JTextField(20);
admintf.setBounds(380,165,150,30);
change.add(admintf);

teatf=new JTextField(20);
teatf.setBounds(380,215,150,30);
change.add(teatf);

stutf=new JTextField(20);
stutf.setBounds(380,265,150,30);
change.add(stutf);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
change.add(exit);


chang=new JButton("Change");
chang.setBounds(300,350,150,30);
chang.addActionListener(this);
change.add(chang);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
ps=con.prepareStatement("Select * from login where Username=?");
ps.setString(1,"Administrator");
rs=ps.executeQuery();
while(rs.next())
{
admintf.setText(rs.getString("Password"));
}
ps=con.prepareStatement("Select * from login where Username=?");
ps.setString(1,"Teacher");
rs=ps.executeQuery();
while(rs.next())
{
teatf.setText(rs.getString("Password"));
}
ps=con.prepareStatement("Select * from login where Username=?");
ps.setString(1,"Student");
rs=ps.executeQuery();
while(rs.next())
{
stutf.setText(rs.getString("Password"));
}


}
catch(Exception e){System.out.println(e);}


change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
change.setSize(800,800);
change.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();

if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Settings();
change.setVisible(false);
}

if(str.equals("Change"))
{
String msg1="",msg2="",msg3="";
msg1=admintf.getText();
msg2=teatf.getText();
msg3=stutf.getText();

if(msg1.equals(""))
msg="Please enter Administrator Password";
else if(msg2.equals(""))
msg="please enter Teacher Password";
else if(msg3.equals(""))
msg="Please enter Student Password";
else
msg="";

if(!msg.equals(""))
{
JOptionPane.showMessageDialog(null,msg);
}
else
{
JOptionPane.showMessageDialog(null,"Password changed");

try
{
ps=con.prepareStatement("Update login set Password=? where Username=?");
ps.setString(1,admintf.getText());
ps.setString(2,"Administrator");
ps.executeUpdate();

ps=con.prepareStatement("Update login set Password=? where Username=?");
ps.setString(1,teatf.getText());
ps.setString(2,"Teacher");
ps.executeUpdate();

ps=con.prepareStatement("Update login set Password=? where Username=?");
ps.setString(1,stutf.getText());
ps.setString(2,"Student");
ps.executeUpdate();
}
catch(Exception e){System.out.println(e);}

}
}
















}




}