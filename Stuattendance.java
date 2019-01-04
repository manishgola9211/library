import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.*;


class Stuattendance implements ItemListener,ActionListener
{
JFrame stua;
JLabel name;
ImageIcon image;
Font f,f1;

JLabel firstnm,roll;
JLabel lastnm;
JLabel pr,total,per,per1,pr1,total1;

JTextField fnm,rolltf;
JTextField lasttf;
Choice month;
JButton go,back,exit;
JLabel sub1,sub2,sub3,sub4,sub5,sub6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
JLabel sub7,sub8,sub9,sub10,sub11,sub12;
JTextField tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21,tf22,tf23,tf24;
JTextField tf25,tf26,tf27,tf28,tf29,tf30,tf31,tf32,tf33,tf34,tf35,tf36;
String mnt;
PreparedStatement ps;
Connection con;
Statement stmt;
ResultSet rs;
ArrayList subnm,present,tot,present1,tot1,present2,tot2;
String []allmn={"April","May"};

Stuattendance()
{
stua=new JFrame("Teacher-Student");
stua.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
stua.add(name);

subnm=new ArrayList();
present=new ArrayList();
tot=new ArrayList();
present1=new ArrayList();
tot1=new ArrayList();
present2=new ArrayList();
tot2=new ArrayList();

roll=new JLabel("Roll-No.");
f1=new Font("TimesRoman",Font.BOLD,20);
roll.setFont(f1);
roll.setFont(f1);
roll.setBounds(150,150,100,50);
stua.add(roll);

rolltf=new JTextField(20);
rolltf.setBounds(250,165,130,25);
stua.add(rolltf);

month=new Choice();
month.add("Select Month");
month.add("January");
month.add("February");
month.add("March");
month.add("April");
month.add("May");
month.add("June");
month.add("July");
month.add("August");
month.add("September");
month.add("October");
month.add("November");
month.add("December");
month.add("All");
month.setBounds(420,165,130,35);
month.addItemListener(this);
stua.add(month);

go=new JButton("Go");
go.setBounds(580,160,100,30);
go.addActionListener(this);
stua.add(go);

pr=new JLabel("Present");
pr.setBounds(150,200,90,50);


total=new JLabel("Total");
total.setBounds(230,200,90,50);

per=new JLabel("Percentage");
per.setBounds(300,200,100,50);

stua.add(pr);
stua.add(total);
stua.add(per);
pr.setVisible(false);
total.setVisible(false);
per.setVisible(false);

sub1=new JLabel("");
f1=new Font("TimesRoman",Font.BOLD,20);
sub1.setFont(f1);
sub1.setBounds(20,240,90,50);


sub2=new JLabel("");
sub2.setFont(f1);
sub2.setBounds(20,290,90,50);


sub3=new JLabel("");
sub3.setFont(f1);
sub3.setBounds(20,340,90,50);


sub4=new JLabel("");
sub4.setFont(f1);
sub4.setBounds(20,390,90,50);


sub5=new JLabel("");
sub5.setFont(f1);
sub5.setBounds(20,440,90,50);


sub6=new JLabel("");
sub6.setFont(f1);
sub6.setBounds(20,490,90,50);


tf1=new JTextField(20);
tf1.setBounds(140,255,60,30);


tf2=new JTextField(20);
tf2.setBounds(140,305,60,30);


tf3=new JTextField(20);
tf3.setBounds(140,355,60,30);


tf4=new JTextField(20);
tf4.setBounds(140,405,60,30);


tf5=new JTextField(20);
tf5.setBounds(140,455,60,30);


tf6=new JTextField(20);
tf6.setBounds(140,505,60,30);


tf7=new JTextField(20);
tf7.setBounds(220,255,60,30);


tf8=new JTextField(20);
tf8.setBounds(220,305,60,30);


tf9=new JTextField(20);
tf9.setBounds(220,355,60,30);


tf10=new JTextField(20);
tf10.setBounds(220,405,60,30);


tf11=new JTextField(20);
tf11.setBounds(220,455,60,30);


tf12=new JTextField(20);
tf12.setBounds(220,505,60,30);



tf25=new JTextField(20);
tf25.setBounds(300,255,60,30);


tf26=new JTextField(20);
tf26.setBounds(300,305,60,30);


tf27=new JTextField(20);
tf27.setBounds(300,355,60,30);


tf28=new JTextField(20);
tf28.setBounds(300,405,60,30);


tf29=new JTextField(20);
tf29.setBounds(300,455,60,30);

tf30=new JTextField(20);
tf30.setBounds(300,505,60,30);


sub7=new JLabel("Subject1");
sub7.setFont(f1);
sub7.setBounds(450,240,100,50);


sub8=new JLabel("Subject2");
sub8.setFont(f1);
sub8.setBounds(450,290,90,50);


sub9=new JLabel("Subject3");
sub9.setFont(f1);
sub9.setBounds(450,340,90,50);


sub10=new JLabel("Subject4");
sub10.setFont(f1);
sub10.setBounds(450,390,90,50);


sub11=new JLabel("Subject5");
sub11.setFont(f1);
sub11.setBounds(450,440,90,50);


sub12=new JLabel("Subject6");
sub12.setFont(f1);
sub12.setBounds(450,490,90,50);



tf13=new JTextField(20);
tf13.setBounds(580,255,60,30);


tf14=new JTextField(20);
tf14.setBounds(580,305,80,30);


tf15=new JTextField(20);
tf15.setBounds(580,355,60,30);


tf16=new JTextField(20);
tf16.setBounds(580,405,60,30);


tf17=new JTextField(20);
tf17.setBounds(580,455,60,30);


tf18=new JTextField(20);
tf18.setBounds(580,505,60,30);


tf19=new JTextField(20);
tf19.setBounds(670,255,60,30);


tf20=new JTextField(20);
tf20.setBounds(670,305,60,30);


tf21=new JTextField(20);
tf21.setBounds(670,355,60,30);


tf22=new JTextField(20);
tf22.setBounds(670,405,60,30);


tf23=new JTextField(20);
tf23.setBounds(670,455,60,30);


tf24=new JTextField(20);
tf24.setBounds(670,505,60,30);



tf31=new JTextField(20);
tf31.setBounds(730,505,60,30);


tf32=new JTextField(20);
tf32.setBounds(730,255,60,30);


tf33=new JTextField(20);
tf33.setBounds(730,305,60,30);


tf34=new JTextField(20);
tf34.setBounds(730,355,60,30);


tf35=new JTextField(20);
tf35.setBounds(730,405,60,30);


tf36=new JTextField(20);
tf36.setBounds(730,455,80,30);




pr1=new JLabel("Present");
pr1.setBounds(550,200,90,50);


total1=new JLabel("Total");
total1.setBounds(640,200,90,50);

per1=new JLabel("Percentage");
per1.setBounds(710,200,100,50);

stua.add(pr1);
stua.add(total1);
stua.add(per1);
pr1.setVisible(false);
total1.setVisible(false);
per1.setVisible(false);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}


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
new Studetail();
stua.setVisible(false);
}
if(str.equals("Go"))
{

if(!mnt.equals("All"))
{
try
{
ps=con.prepareStatement("Select * from "+mnt+" where Rollno=?");
ps.setInt(1,Integer.parseInt(rolltf.getText()));
rs=ps.executeQuery();
while(rs.next())
{
subnm.add(rs.getString("Subject"));
present.add(rs.getInt("Present")+"");
tot.add(rs.getInt("Total")+"");
}
}
catch(Exception e){System.out.println(e);}
}
else
{
for(int i=0;i<2;i++)
{
try
{
ps=con.prepareStatement("Select * from "+allmn[i]+" where Rollno=?");
ps.setInt(1,Integer.parseInt(rolltf.getText()));
rs=ps.executeQuery();
while(rs.next())
{
if(i==0)
{
subnm.add(rs.getString("Subject"));
present.add(rs.getInt("Present")+"");
tot.add(rs.getInt("Total")+"");
}
else
{
present1.add(rs.getInt("Present")+"");
tot1.add(rs.getInt("Total")+"");
}

}
}
catch(Exception e){System.out.println(e);}
}
for(int i=0;i<present.size();i++)
{
present2.add(Integer.parseInt((String)present.get(i))+Integer.parseInt((String)present1.get(i))+"");
tot2.add(Integer.parseInt((String)tot.get(i))+Integer.parseInt((String)tot1.get(i))+"");
}
present.clear();
tot.clear();
present.addAll(present2);
tot.addAll(tot2);


}


if(subnm.size()>0)
{
stua.add(sub1);
pr.setVisible(true);
total.setVisible(true);
per.setVisible(true);
}


if(subnm.size()>0)
{
sub1.setText((String)subnm.get(0));
tf1.setText((String)present.get(0));
tf7.setText((String)tot.get(0));
int x=Integer.parseInt(tf1.getText())*100/Integer.parseInt(tf7.getText());
tf25.setText(x+"");
stua.add(tf1);
stua.add(tf7);
stua.add(tf25);
stua.add(sub1);
}

if(subnm.size()>1)
stua.add(sub2);

if(subnm.size()>1)
{
sub2.setText((String)subnm.get(1));
tf2.setText((String)present.get(1));
tf8.setText((String)tot.get(1));
int x=Integer.parseInt(tf2.getText())*100/Integer.parseInt(tf8.getText());
tf26.setText(x+"");
stua.add(tf2);
stua.add(tf8);
stua.add(tf26);
stua.add(sub2);
}

if(subnm.size()>2)
stua.add(sub3);

if(subnm.size()>2)
{
sub3.setText((String)subnm.get(2));
tf3.setText((String)present.get(2));
tf9.setText((String)tot.get(2));
int x=Integer.parseInt(tf3.getText())*100/Integer.parseInt(tf9.getText());
tf27.setText(x+"");
stua.add(tf3);
stua.add(tf9);
stua.add(tf27);
stua.add(sub3);
}

if(subnm.size()>3)
stua.add(sub4);

if(subnm.size()>3)
{
sub4.setText((String)subnm.get(3));
tf4.setText((String)present.get(3));
tf10.setText((String)tot.get(3));
int x=Integer.parseInt(tf4.getText())*100/Integer.parseInt(tf10.getText());
tf28.setText(x+"");
stua.add(tf4);
stua.add(tf10);
stua.add(tf28);
stua.add(sub4);
}

if(subnm.size()>4)
stua.add(sub5);

if(subnm.size()>4)
{
sub5.setText((String)subnm.get(4));
tf5.setText((String)present.get(4));
tf11.setText((String)tot.get(4));
int x=Integer.parseInt(tf5.getText())*100/Integer.parseInt(tf11.getText());
tf29.setText(x+"");
stua.add(tf5);
stua.add(tf11);
stua.add(tf29);
stua.add(sub5);
}

if(subnm.size()>5)
stua.add(sub6);

if(subnm.size()>5)
{
sub6.setText((String)subnm.get(5));
tf6.setText((String)present.get(5));
tf12.setText((String)tot.get(5));
int x=Integer.parseInt(tf6.getText())*100/Integer.parseInt(tf12.getText());
tf30.setText(x+"");
stua.add(tf6);
stua.add(tf12);
stua.add(tf30);
stua.add(sub6);
}

if(subnm.size()>6)
{
stua.add(sub7);
pr1.setVisible(true);
total1.setVisible(true);
per1.setVisible(true);
}


if(subnm.size()>6)
{
sub7.setText((String)subnm.get(6));
tf13.setText((String)present.get(6));
tf19.setText((String)tot.get(6));
int x=Integer.parseInt(tf13.getText())*100/Integer.parseInt(tf19.getText());
tf31.setText(x+"");
stua.add(tf13);
stua.add(tf19);
stua.add(tf31);
stua.add(sub7);
}

if(subnm.size()>7)
stua.add(sub8);

if(subnm.size()>7)
{
sub8.setText((String)subnm.get(7));
tf14.setText((String)present.get(7));
tf20.setText((String)tot.get(7));
int x=Integer.parseInt(tf14.getText())*100/Integer.parseInt(tf20.getText());
tf32.setText(x+"");
stua.add(tf14);
stua.add(tf20);
stua.add(tf32);
stua.add(sub8);
}

if(subnm.size()>8)
stua.add(sub9);

if(subnm.size()>8)
{
sub9.setText((String)subnm.get(8));
tf15.setText((String)present.get(8));
tf21.setText((String)tot.get(8));
int x=Integer.parseInt(tf15.getText())*100/Integer.parseInt(tf21.getText());
tf33.setText(x+"");
stua.add(tf15);
stua.add(tf21);
stua.add(tf33);
stua.add(sub9);
}


if(subnm.size()>9)
stua.add(sub10);

if(subnm.size()>9)
{
sub10.setText((String)subnm.get(9));
tf16.setText((String)present.get(9));
tf22.setText((String)tot.get(9));
int x=Integer.parseInt(tf16.getText())*100/Integer.parseInt(tf22.getText());
tf34.setText(x+"");
stua.add(tf16);
stua.add(tf22);
stua.add(tf34);
stua.add(sub10);
}

if(subnm.size()>10)
stua.add(sub11);

if(subnm.size()>10)
{
sub11.setText((String)subnm.get(10));
tf17.setText((String)present.get(10));
tf23.setText((String)tot.get(10));
int x=Integer.parseInt(tf17.getText())*100/Integer.parseInt(tf23.getText());
tf35.setText(x+"");
stua.add(tf17);
stua.add(tf23);
stua.add(tf35);
stua.add(sub11);
}

if(subnm.size()>11)
stua.add(sub12);

if(subnm.size()>11)
{
sub12.setText((String)subnm.get(11));
tf18.setText((String)present.get(11));
tf24.setText((String)tot.get(11));
int x=Integer.parseInt(tf18.getText())*100/Integer.parseInt(tf24.getText());
tf36.setText(x+"");
stua.add(tf18);
stua.add(tf24);
stua.add(tf36);
stua.add(sub12);
}







}
}

public void itemStateChanged(ItemEvent ie)
{

mnt=(String)month.getSelectedItem();
}
public static void main(String args[])
{
new Stuattendance();
}

}