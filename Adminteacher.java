import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Adminteacher implements ActionListener
{
JFrame adt;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f;
JButton teare,allsub,back,exit;

Adminteacher()
{
adt=new JFrame("Administrator-Teacher");
adt.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
adt.add(name);


teare=new JButton("Teacher's Account");
teare.setBounds(300,180,150,40);
teare.addActionListener(this);
adt.add(teare);


allsub=new JButton("Allocate classes");
allsub.setBounds(300,280,150,40);
allsub.addActionListener(this);
adt.add(allsub);


backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
adt.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
adt.add(exit);



adt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
adt.setSize(800,800);
adt.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Administrator();
adt.setVisible(false);
}
if(str.equals("Teacher's Account"))
{
new  Teacherrecord();
adt.setVisible(false);
}
if(str.equals("Allocate classes"))
{
new Allocateclass();
adt.setVisible(false);
}
}








}