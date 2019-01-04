import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Attendance implements ActionListener
{
JFrame att;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f;
JButton take,see,back,exit;

Attendance()
{
att=new JFrame("Teacher-Attendance");
att.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
att.add(name);

take=new JButton("Take Attendance");
take.setBounds(300,180,150,40);
take.addActionListener(this);
att.add(take);


see=new JButton("See Attendance");
see.setBounds(300,280,150,40);
see.addActionListener(this);
att.add(see);


backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
att.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
att.add(exit);

att.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
att.setSize(800,800);
att.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Teacher();
att.setVisible(false);
}

if(str.equals("Take Attendance"))
{
new Takeattendance();
att.setVisible(false);
}

if(str.equals("See Attendance"))
{
new Seeattendance();
att.setVisible(false);
}

}

}