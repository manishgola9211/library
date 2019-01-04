import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Settings implements ActionListener
{
JFrame sett;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f;
JButton chpass,allsub,back,exit;

Settings()
{
sett=new JFrame("Administrator-Settings");
sett.setLayout(null);


image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
sett.add(name);


chpass=new JButton("Change Password");
chpass.setBounds(300,180,150,40);
chpass.addActionListener(this);
sett.add(chpass);


allsub=new JButton("Allocate Subject");
allsub.setBounds(300,280,150,40);
allsub.addActionListener(this);
sett.add(allsub);


backimg=new ImageIcon("back.gif");
back=new JButton("Back",backimg);
back.setBounds(200,470,150,40);
back.addActionListener(this);
sett.add(back);

exitimg=new ImageIcon("exit-icon.gif");
exit=new JButton("Exit",exitimg);
exit.setBounds(400,470,150,40);
exit.addActionListener(this);
sett.add(exit);



sett.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
sett.setSize(800,800);
sett.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Administrator();
sett.setVisible(false);
}
if(str.equals("Change Password"))
{
new  Changepassword();
sett.setVisible(false);
}
if(str.equals("Allocate Subject"))
{
new Allocatesubject();
sett.setVisible(false);
}
}








}