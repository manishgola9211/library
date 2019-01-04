import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Adminstudent implements ActionListener
{
JFrame teach;
JLabel name;
ImageIcon image,stuimg,teaimg,settimg,exitimg,backimg;
Font f;
JButton account,atten,stu,stu1,back,exit;
Adminstudent()
{
teach=new JFrame("Administrator-Student");
teach.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
teach.add(name);




account=new JButton("Student's Record");
account.setBounds(300,150,150,40);
account.addActionListener(this);
teach.add(account);


atten=new JButton("Student Attendance");
atten.setBounds(300,230,150,40);
atten.addActionListener(this);
teach.add(atten);


stu=new JButton("Take Attendance");
stu.setBounds(300,310,150,40);
stu.addActionListener(this);
teach.add(stu);

stu1=new JButton("See Attendance");
stu1.setBounds(300,390,150,40);
stu1.addActionListener(this);
teach.add(stu1);

backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
teach.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
teach.add(exit);


teach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
teach.setSize(800,800);
teach.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();

if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Administrator();
teach.setVisible(false);
}

if(str.equals("Student's Record"))
{
new Studentrecord();
teach.setVisible(false);
}

if(str.equals("Student Attendance"))
{
new Stuattendance1();
teach.setVisible(false);
}

if(str.equals("Take Attendance"))
{
new Takeattendance1();
teach.setVisible(false);
}

if(str.equals("See Attendance"))
{
new Seeattendance1();
teach.setVisible(false);
}




}
public static void main(String args[])
{
new Adminstudent();
}
}