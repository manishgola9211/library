import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Administrator implements ActionListener
{
JFrame admin;
JLabel name;
ImageIcon image,stuimg,teaimg,settimg,exitimg,backimg;
Font f;
JButton stud,teach,sett,back,exit;

Administrator()
{
admin=new JFrame("ADMINISTRATOR");
admin.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
admin.add(name);

stuimg=new ImageIcon("student-icon.gif");
stud=new JButton("Student",stuimg);
stud.setBounds(300,180,150,50);
stud.addActionListener(this);
admin.add(stud);

teaimg=new ImageIcon("teacher icon.gif");
teach=new JButton("Teacher",teaimg);
teach.setBounds(300,280,150,50);
teach.addActionListener(this);
admin.add(teach);

settimg=new ImageIcon("settings-icon.gif");
sett=new JButton("Settings",settimg);
sett.setBounds(300,380,150,40);
sett.addActionListener(this);
admin.add(sett);

backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
admin.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
admin.add(exit);

admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
admin.setSize(800,800);
admin.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Login();
admin.setVisible(false);
}
if(str.equals("Student"))
{
new Adminstudent();
admin.setVisible(false);
}

if(str.equals("Settings"))
{
new Settings();
admin.setVisible(false);
}
if(str.equals("Teacher"))
{
new Adminteacher();
admin.setVisible(false);
}

}








}