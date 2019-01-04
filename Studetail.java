import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;


class Studetail  implements ActionListener
{
JFrame stud;
JLabel name;
ImageIcon image,stuimg,teaimg,settimg,exitimg,backimg;
Font f;
JButton account,atten,stu,back,exit;

Studetail()
{
stud=new JFrame("Teacher-Student");
stud.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
stud.add(name);



account=new JButton("Student's Details");
account.setBounds(300,180,150,50);
account.addActionListener(this);
stud.add(account);


atten=new JButton("Attendance");
atten.setBounds(300,280,150,50);
atten.addActionListener(this);
stud.add(atten);

backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
stud.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
stud.add(exit);


stud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
stud.setSize(800,800);
stud.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Teacher();
stud.setVisible(false);
}
if(str.equals("Student's Details"))
{
new Stuaccount();
stud.setVisible(false);
}
if(str.equals("Attendance"))
{
new Stuattendance();
stud.setVisible(false);
}
}

}

