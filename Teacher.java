import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Teacher  implements ActionListener
{
JFrame teach;
JLabel name;
ImageIcon image,stuimg,teaimg,settimg,exitimg,backimg;
Font f;
JButton account,atten,stu,back,exit;

Teacher()
{
teach=new JFrame("Teacher");
teach.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
teach.add(name);




account=new JButton("Teacher's Details");
account.setBounds(300,180,150,50);
account.addActionListener(this);
teach.add(account);


atten=new JButton("Attendance");
atten.setBounds(300,280,150,50);
atten.addActionListener(this);
teach.add(atten);


stu=new JButton("Student's Details");
stu.setBounds(300,380,150,40);
stu.addActionListener(this);
teach.add(stu);

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
new Login();
teach.setVisible(false);
}

if(str.equals("Teacher's Details"))
{
new Teacherdetail();
teach.setVisible(false);
}

if(str.equals("Attendance"))
{
new Attendance();
teach.setVisible(false);
}

if(str.equals("Student's Details"))
{
new Studetail();
teach.setVisible(false);
}

}
public static void main(String args[])
{
new Teacher();
}

}