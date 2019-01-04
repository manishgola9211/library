import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;


class Stuattendance1 implements ActionListener
{
JFrame stua;
JLabel name;
ImageIcon image;
Font f,f1;

JLabel firstnm,roll;
JLabel lastnm;
JLabel pr,total,pr1,total1;

JTextField fnm,rolltf;
JTextField lasttf;
Choice month;
JButton go,back,exit;
JLabel sub1,sub2,sub3,sub4,sub5,sub6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
JLabel sub7,sub8,sub9,sub10,sub11,sub12;
JTextField tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21,tf22,tf23,tf24;

Stuattendance1()
{
stua=new JFrame("Administrator-Student-Attendance");
stua.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
stua.add(name);

roll=new JLabel("Roll-No.");
f1=new Font("TimesRoman",Font.BOLD,20);
roll.setFont(f1);
roll.setFont(f1);
roll.setBounds(150,160,100,50);
stua.add(roll);

rolltf=new JTextField(20);
rolltf.setBounds(250,175,130,25);
stua.add(rolltf);

month=new Choice();
month.add("Select Month");
month.add("April");
month.add("May");
month.setBounds(420,175,130,35);
//month.addItemListener(this);
stua.add(month);

go=new JButton("Go");
go.setBounds(580,170,100,30);
stua.add(go);

pr=new JLabel("Present");
pr.setBounds(160,200,100,50);
stua.add(pr);

total=new JLabel("Total");
total.setBounds(260,200,100,50);
stua.add(total);

sub1=new JLabel("java");
f1=new Font("TimesRoman",Font.BOLD,20);
sub1.setFont(f1);
sub1.setBounds(20,240,100,50);
stua.add(sub1);

sub2=new JLabel("computer");
sub2.setFont(f1);
sub2.setBounds(20,290,100,50);
stua.add(sub2);

sub3=new JLabel("Testing");
sub3.setFont(f1);
sub3.setBounds(20,340,100,50);
stua.add(sub3);

sub4=new JLabel("Adv. java");
sub4.setFont(f1);
sub4.setBounds(20,390,100,50);
stua.add(sub4);

sub5=new JLabel("ad.java lab");
sub5.setFont(f1);
sub5.setBounds(20,440,100,50);
stua.add(sub5);

sub6=new JLabel("Subject6");
sub6.setFont(f1);
sub6.setBounds(20,490,100,50);
//stua.add(sub6);

tf1=new JTextField(20);
tf1.setBounds(150,255,80,30);
stua.add(tf1);

tf2=new JTextField(20);
tf2.setBounds(150,305,80,30);
stua.add(tf2);

tf3=new JTextField(20);
tf3.setBounds(150,355,80,30);
stua.add(tf3);

tf4=new JTextField(20);
tf4.setBounds(150,405,80,30);
stua.add(tf4);

tf5=new JTextField(20);
tf5.setBounds(150,455,80,30);
stua.add(tf5);

tf6=new JTextField(20);
tf6.setBounds(150,505,80,30);
//stua.add(tf6);

tf7=new JTextField(20);
tf7.setBounds(250,255,80,30);
stua.add(tf7);

tf8=new JTextField(20);
tf8.setBounds(250,305,80,30);
stua.add(tf8);

tf9=new JTextField(20);
tf9.setBounds(250,355,80,30);
stua.add(tf9);

tf10=new JTextField(20);
tf10.setBounds(250,405,80,30);
stua.add(tf10);

tf11=new JTextField(20);
tf11.setBounds(250,455,80,30);
stua.add(tf11);

tf12=new JTextField(20);
tf12.setBounds(250,505,80,30);
//stua.add(tf12);

sub7=new JLabel("Subject1");
sub7.setFont(f1);
sub7.setBounds(400,240,100,50);
//stua.add(sub7);

sub8=new JLabel("Subject2");
sub8.setFont(f1);
sub8.setBounds(400,290,100,50);
//stua.add(sub8);

sub9=new JLabel("Subject3");
sub9.setFont(f1);
sub9.setBounds(400,340,100,50);
//stua.add(sub9);

sub10=new JLabel("Subject4");
sub10.setFont(f1);
sub10.setBounds(400,390,100,50);
//stua.add(sub10);

sub11=new JLabel("Subject5");
sub11.setFont(f1);
sub11.setBounds(400,440,100,50);
//stua.add(sub11);

sub12=new JLabel("Subject6");
sub12.setFont(f1);
sub12.setBounds(400,490,100,50);
//stua.add(sub12);


tf13=new JTextField(20);
tf13.setBounds(530,255,80,30);
//stua.add(tf13);

tf14=new JTextField(20);
tf14.setBounds(530,305,80,30);
//stua.add(tf14);

tf15=new JTextField(20);
tf15.setBounds(530,355,80,30);
//stua.add(tf15);

tf16=new JTextField(20);
tf16.setBounds(530,405,80,30);
//stua.add(tf16);

tf17=new JTextField(20);
tf17.setBounds(530,455,80,30);
//stua.add(tf17);

tf18=new JTextField(20);
tf18.setBounds(530,505,80,30);
//stua.add(tf18);

tf19=new JTextField(20);
tf19.setBounds(630,255,80,30);
//stua.add(tf19);

tf20=new JTextField(20);
tf20.setBounds(630,305,80,30);
//stua.add(tf20);

tf21=new JTextField(20);
tf21.setBounds(630,355,80,30);
//stua.add(tf21);

tf22=new JTextField(20);
tf22.setBounds(630,405,80,30);
//stua.add(tf22);

tf23=new JTextField(20);
tf23.setBounds(630,455,80,30);
//stua.add(tf23);

tf24=new JTextField(20);
tf24.setBounds(630,505,80,30);
//stua.add(tf24);

pr1=new JLabel("Present");
pr1.setBounds(550,200,100,50);
//stua.add(pr1);

total1=new JLabel("Total");
total1.setBounds(640,200,100,50);
//stua.add(total1);


back=new JButton("Back");
back.setBounds(250,540,100,30);
back.addActionListener(this);
stua.add(back);

exit=new JButton("Exit");
exit.setBounds(400,540,100,30);
exit.addActionListener(this);
stua.add(exit);

stua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
stua.setSize(800,800);
stua.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Adminstudent();
stua.setVisible(false);
}

}
public static void main(String args[])
{
new Stuattendance();
}

}