import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.Date;
import java.util.*;

class Takeattendance1 implements ActionListener,ItemListener
{
JFrame take;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f,f1;
Choice sem,br,sub,stu;
JButton chk,go,ta,back,exit;
PreparedStatement ps;
Connection con;
Statement stmt;
ResultSet rs;
String seme,bran,stud,subject;
Checkbox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20;
Checkbox cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28,cb29,cb30,cb31,cb32,cb33,cb34,cb35,cb36,cb37,cb38,cb39,cb40;
Checkbox cb41,cb42,cb43,cb44,cb45,cb46,cb47,cb48,cb49,cb50,cb51,cb52,cb53,cb54,cb55,cb56,cb57,cb58,cb59,cb60;
String []se={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
Date date;
ArrayList rn,first,last,status;
boolean c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
boolean c31,c32,c33,c34,c35,c36,c37,c38,c39,c40,c41,c42,c43,c44,c45,c46,c47,c48,c49,c50;
int present,total;
String month;

Takeattendance1()
{
take=new JFrame("Teacher-Take-Attendance");
take.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,33);
name.setFont(f);
name.setBounds(35,12,700,140);
take.add(name);

rn=new ArrayList();
first=new ArrayList();
last=new ArrayList();
status=new ArrayList();




sem=new Choice();
sem.add("Select Semester");
sem.add("Semester1");
sem.add("Semester2");
sem.add("Semester3");
sem.add("Semester4");
sem.add("Semester5");
sem.add("Semester6");
sem.add("Semester7");
sem.add("Semester8");
sem.setBounds(20,170,120,50);
sem.addItemListener(this);
take.add(sem);

br=new Choice();
br.add("Select Branch");
br.add("CSE");
br.add("IT");
br.add("ECE");
br.setBounds(170,170,120,50);
br.addItemListener(this);
take.add(br);

chk=new JButton("Check");
chk.setBounds(300,165,80,30);
chk.addActionListener(this);
take.add(chk);


sub=new Choice();
sub.add("Select Subject");
sub.setBounds(400,170,120,50);
sub.addItemListener(this);
take.add(sub);

stu=new Choice();
stu.add("Select Students");
stu.add("All");
stu.add("Group1");
stu.add("Group2");
stu.add("Group3");
stu.setBounds(550,170,120,50);
stu.addItemListener(this);
take.add(stu);

go=new JButton("Go");
go.setBounds(680,165,80,30);
go.addActionListener(this);
take.add(go);

ta=new JButton("Take");
ta.setBounds(150,550,80,30);
ta.addActionListener(this);
take.add(ta);

back=new JButton("Back");
back.setBounds(400,550,80,30);
back.addActionListener(this);
take.add(back);

exit=new JButton("Exit");
exit.setBounds(550,550,80,30);
exit.addActionListener(this);
take.add(exit);




cb1=new Checkbox("");
cb1.setBounds(10,180,130,50);
cb1.addItemListener(this);


cb2=new Checkbox("");
cb2.setBounds(10,215,130,50);
cb2.addItemListener(this);

cb3=new Checkbox("");
cb3.setBounds(10,250,130,50);
cb3.addItemListener(this);

cb4=new Checkbox("");
cb4.setBounds(10,285,130,50);
cb4.addItemListener(this);

cb5=new Checkbox("a");
cb5.setBounds(10,320,130,50);
cb5.addItemListener(this);

cb6=new Checkbox("");
cb6.setBounds(10,355,130,50);
cb6.addItemListener(this);

cb7=new Checkbox("");
cb7.setBounds(10,390,130,50);
cb7.addItemListener(this);

cb8=new Checkbox("");
cb8.setBounds(10,425,130,50);
cb8.addItemListener(this);

cb9=new Checkbox("a");
cb9.setBounds(10,460,130,50);
cb9.addItemListener(this);

cb10=new Checkbox("");
cb10.setBounds(10,495,130,50);
cb10.addItemListener(this);


cb11=new Checkbox("");
cb11.setBounds(150,180,130,50);
cb11.addItemListener(this);

cb12=new Checkbox("");
cb12.setBounds(150,215,150,50);
cb12.addItemListener(this);

cb13=new Checkbox("");
cb13.setBounds(150,250,150,50);
cb13.addItemListener(this);

cb14=new Checkbox("a");
cb14.setBounds(150,285,150,50);
cb14.addItemListener(this);

cb15=new Checkbox("");
cb15.setBounds(150,320,150,50);
cb15.addItemListener(this);

cb16=new Checkbox("");
cb16.setBounds(150,355,150,50);
cb16.addItemListener(this);

cb17=new Checkbox("");
cb17.setBounds(150,390,150,50);
cb17.addItemListener(this);

cb18=new Checkbox("");
cb18.setBounds(150,425,150,50);
cb18.addItemListener(this);

cb19=new Checkbox("");
cb19.setBounds(150,460,150,50);
cb19.addItemListener(this);

cb20=new Checkbox("");
cb20.setBounds(150,495,150,50);
cb20.addItemListener(this);

cb21=new Checkbox("");
cb21.setBounds(300,180,130,50);
cb21.addItemListener(this);

cb22=new Checkbox("");
cb22.setBounds(300,215,150,50);
cb22.addItemListener(this);

cb23=new Checkbox("");
cb23.setBounds(300,250,150,50);
cb23.addItemListener(this);

cb24=new Checkbox("a");
cb24.setBounds(300,285,150,50);
cb24.addItemListener(this);

cb25=new Checkbox("");
cb25.setBounds(300,320,150,50);
cb25.addItemListener(this);

cb26=new Checkbox("");
cb26.setBounds(300,355,150,50);
cb26.addItemListener(this);

cb27=new Checkbox("");
cb27.setBounds(300,390,150,50);
cb27.addItemListener(this);

cb28=new Checkbox("");
cb28.setBounds(300,425,150,50);
cb28.addItemListener(this);

cb29=new Checkbox("");
cb29.setBounds(300,460,150,50);
cb29.addItemListener(this);

cb30=new Checkbox("");
cb30.setBounds(300,495,150,50);
cb30.addItemListener(this);

cb31=new Checkbox("");
cb31.setBounds(450,180,130,50);
cb31.addItemListener(this);

cb32=new Checkbox("");
cb32.setBounds(450,215,150,50);
cb32.addItemListener(this);

cb33=new Checkbox("");
cb33.setBounds(450,250,150,50);
cb33.addItemListener(this);

cb34=new Checkbox("a");
cb34.setBounds(450,285,150,50);
cb34.addItemListener(this);

cb35=new Checkbox("");
cb35.setBounds(450,320,150,50);
cb35.addItemListener(this);

cb36=new Checkbox("");
cb36.setBounds(450,355,150,50);
cb36.addItemListener(this);

cb37=new Checkbox("");
cb37.setBounds(450,390,150,50);
cb37.addItemListener(this);

cb38=new Checkbox("");
cb38.setBounds(450,425,150,50);
cb38.addItemListener(this);

cb39=new Checkbox("");
cb39.setBounds(450,460,150,50);
cb39.addItemListener(this);

cb40=new Checkbox("");
cb40.setBounds(450,495,150,50);
cb40.addItemListener(this);

cb41=new Checkbox("");
cb41.setBounds(450,180,130,50);
cb41.addItemListener(this);

cb42=new Checkbox("");
cb42.setBounds(450,215,150,50);
cb42.addItemListener(this);

cb43=new Checkbox("");
cb43.setBounds(450,250,150,50);
cb43.addItemListener(this);

cb44=new Checkbox("a");
cb44.setBounds(450,285,150,50);
cb44.addItemListener(this);

cb45=new Checkbox("");
cb45.setBounds(450,320,150,50);
cb45.addItemListener(this);

cb46=new Checkbox("");
cb46.setBounds(450,355,150,50);
cb46.addItemListener(this);

cb47=new Checkbox("");
cb47.setBounds(450,390,150,50);
cb47.addItemListener(this);

cb48=new Checkbox("");
cb48.setBounds(450,425,150,50);
cb48.addItemListener(this);

cb49=new Checkbox("");
cb49.setBounds(450,460,150,50);
cb49.addItemListener(this);

cb50=new Checkbox("");
cb50.setBounds(450,495,150,50);
cb50.addItemListener(this);






try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}

take.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
take.setSize(800,800);
take.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Adminstudent();
take.setVisible(false);
}

if(str.equals("Check"))
{

int y=0;
try
{
ps=con.prepareStatement("Select * from allocatesubject where Semester=? and Branch=?");
ps.setString(1,seme);
ps.setString(2,bran);
rs=ps.executeQuery();

while(rs.next())
{
y=1;
sub.add(rs.getString("Subject1"));
sub.add(rs.getString("Subject2"));
sub.add(rs.getString("Subject3"));
sub.add(rs.getString("Subject4"));
sub.add(rs.getString("Subject5"));
sub.add(rs.getString("Subject6"));
sub.add(rs.getString("Lab1"));
sub.add(rs.getString("Lab2"));
sub.add(rs.getString("Lab3"));
sub.add(rs.getString("Lab4"));
sub.add(rs.getString("Additionalsubject1"));
sub.add(rs.getString("Additionalsubject2"));
}
}
catch(Exception e){System.out.println(e);}
if(y==0) JOptionPane.showMessageDialog(null,"Subjects not Found");
}

if(str.equals("Go"))
{
String gp;
date=new Date();
try
{
ps=con.prepareStatement("Select * from "+seme+" where Branch=?");
ps.setString(1,bran);
rs=ps.executeQuery();
while(rs.next())
{
gp=rs.getString("Group");

if(gp.equals(stud))
{
first.add(rs.getString("Firstname"));
last.add(rs.getString("Lastname"));
rn.add(rs.getInt("Rollno")+"");
}
if(stud.equals("All"))
{
first.add(rs.getString("Firstname"));
last.add(rs.getString("Lastname"));
rn.add(rs.getInt("Rollno")+"");
}
}
}

catch(Exception e){System.out.println(e);}
if(rn.size()>0)
{
cb1.setLabel((String)first.get(0)+" "+(String)last.get(0));
take.add(cb1);
}
if(rn.size()>1)
{
cb2.setLabel((String)first.get(1)+" "+(String)last.get(1));
take.add(cb2);
}
if(rn.size()>2)
{
cb3.setLabel((String)first.get(2)+" "+(String)last.get(2));
take.add(cb3);
}
if(rn.size()>3)
{
cb4.setLabel((String)first.get(3)+" "+(String)last.get(3));
take.add(cb4);
}
if(rn.size()>4)
{
cb5.setLabel((String)first.get(4)+" "+(String)last.get(4));
take.add(cb5);
}
if(rn.size()>5)
{
cb6.setLabel((String)first.get(5)+" "+(String)last.get(5));
take.add(cb6);
}
if(rn.size()>6)
{
cb7.setLabel((String)first.get(6)+" "+(String)last.get(6));
take.add(cb7);
}
if(rn.size()>7)
{
cb8.setLabel((String)first.get(7)+" "+(String)last.get(7));
take.add(cb8);
}
if(rn.size()>8)
{
cb9.setLabel((String)first.get(8)+" "+(String)last.get(8));
take.add(cb9);
}
if(rn.size()>9)
{
cb10.setLabel((String)first.get(9)+" "+(String)last.get(9));
take.add(cb10);
}
if(rn.size()>10)
{
cb11.setLabel((String)first.get(10)+" "+(String)last.get(10));
take.add(cb11);
}
if(rn.size()>11)
{
cb12.setLabel((String)first.get(11)+" "+(String)last.get(11));
take.add(cb12);
}
if(rn.size()>12)
{
cb13.setLabel((String)first.get(12)+" "+(String)last.get(12));
take.add(cb13);
}
if(rn.size()>13)
{
cb14.setLabel((String)first.get(13)+" "+(String)last.get(13));
take.add(cb14);
}
if(rn.size()>14)
{
cb15.setLabel((String)first.get(14)+" "+(String)last.get(14));
take.add(cb15);
}
if(rn.size()>15)
{
cb16.setLabel((String)first.get(15)+" "+(String)last.get(15));
take.add(cb16);
}
if(rn.size()>16)
{
cb17.setLabel((String)first.get(16)+" "+(String)last.get(16));
take.add(cb17);
}
if(rn.size()>17)
{
cb18.setLabel((String)first.get(17)+" "+(String)last.get(17));
take.add(cb18);
}
if(rn.size()>18)
{
cb19.setLabel((String)first.get(18)+" "+(String)last.get(18));
take.add(cb19);
}
if(rn.size()>19)
{
cb20.setLabel((String)first.get(19)+" "+(String)last.get(19));
take.add(cb20);
}


if(rn.size()>20)
{
cb21.setLabel((String)first.get(20)+" "+(String)last.get(20));
take.add(cb21);
}
if(rn.size()>21)
{
cb22.setLabel((String)first.get(21)+" "+(String)last.get(21));
take.add(cb22);
}
if(rn.size()>22)
{
cb23.setLabel((String)first.get(22)+" "+(String)last.get(22));
take.add(cb23);
}
if(rn.size()>23)
{
cb24.setLabel((String)first.get(23)+" "+(String)last.get(23));
take.add(cb24);
}
if(rn.size()>24)
{
cb25.setLabel((String)first.get(24)+" "+(String)last.get(24));
take.add(cb25);
}
if(rn.size()>25)
{
cb26.setLabel((String)first.get(25)+" "+(String)last.get(25));
take.add(cb26);
}
if(rn.size()>26)
{
cb27.setLabel((String)first.get(26)+" "+(String)last.get(26));
take.add(cb27);
}
if(rn.size()>27)
{
cb28.setLabel((String)first.get(27)+" "+(String)last.get(27));
take.add(cb28);
}
if(rn.size()>28)
{
cb29.setLabel((String)first.get(28)+" "+(String)last.get(28));
take.add(cb29);
}
if(rn.size()>29)
{
cb30.setLabel((String)first.get(29)+" "+(String)last.get(29));
take.add(cb30);
}
if(rn.size()>30)
{
cb31.setLabel((String)first.get(30)+" "+(String)last.get(30));
take.add(cb31);
}
if(rn.size()>31)
{
cb32.setLabel((String)first.get(31)+" "+(String)last.get(31));
take.add(cb32);
}
if(rn.size()>32)
{
cb33.setLabel((String)first.get(32)+" "+(String)last.get(32));
take.add(cb33);
}
if(rn.size()>33)
{
cb34.setLabel((String)first.get(33)+" "+(String)last.get(33));
take.add(cb34);
}
if(rn.size()>34)
{
cb35.setLabel((String)first.get(34)+" "+(String)last.get(34));
take.add(cb35);
}
if(rn.size()>35)
{
cb36.setLabel((String)first.get(35)+" "+(String)last.get(35));
take.add(cb36);
}
if(rn.size()>36)
{
cb37.setLabel((String)first.get(36)+" "+(String)last.get(36));
take.add(cb37);
}
if(rn.size()>37)
{
cb38.setLabel((String)first.get(37)+" "+(String)last.get(37));
take.add(cb38);
}
if(rn.size()>38)
{
cb39.setLabel((String)first.get(38)+" "+(String)last.get(38));
take.add(cb39);
}
if(rn.size()>39)
{
cb40.setLabel((String)first.get(39)+" "+(String)last.get(39));
take.add(cb40);
}




if(rn.size()>40)
{
cb41.setLabel((String)first.get(40)+" "+(String)last.get(40));
take.add(cb41);
}
if(rn.size()>41)
{
cb42.setLabel((String)first.get(41)+" "+(String)last.get(41));
take.add(cb42);
}
if(rn.size()>42)
{
cb43.setLabel((String)first.get(42)+" "+(String)last.get(42));
take.add(cb43);
}
if(rn.size()>43)
{
cb44.setLabel((String)first.get(43)+" "+(String)last.get(43));
take.add(cb44);
}
if(rn.size()>44)
{
cb45.setLabel((String)first.get(44)+" "+(String)last.get(44));
take.add(cb45);
}
if(rn.size()>45)
{
cb46.setLabel((String)first.get(45)+" "+(String)last.get(45));
take.add(cb46);
}
if(rn.size()>46)
{
cb47.setLabel((String)first.get(46)+" "+(String)last.get(46));
take.add(cb47);
}
if(rn.size()>47)
{
cb48.setLabel((String)first.get(47)+" "+(String)last.get(47));
take.add(cb48);
}
if(rn.size()>48)
{
cb49.setLabel((String)first.get(48)+" "+(String)last.get(48));
take.add(cb49);
}
if(rn.size()>49)
{
cb50.setLabel((String)first.get(49)+" "+(String)last.get(49));
take.add(cb50);
}








}
if(str.equals("Take"))
{

String dt;
date=new Date();
dt=date.getDate()+"";
int x=date.getMonth();
if(x==0)
month="January";
else if(x==1)
month="February";
else if(x==2)
month="March";
else if(x==3)
month="April";
else if(x==4)
month="May";
else if(x==5)
month="June";
else if(x==6)
month="July";
else if(x==7)
month="Augest";
else if(x==8)
month="September";
else if(x==9)
month="October";
else if(x==10)
month="November";
else 
month="December";

if(c1==true && rn.size()>0)
status.add("P");
else
status.add("A");

if(c2==true && rn.size()>1)
status.add("P");
else
status.add("A");

if(c3==true && rn.size()>2)
status.add("P");
else
status.add("A");

if(c4==true && rn.size()>3)
status.add("P");
else
status.add("A");

if(c5==true && rn.size()>4)
status.add("P");
else
status.add("A");

if(c6==true && rn.size()>5)
status.add("P");
else
status.add("A");

if(c7==true && rn.size()>6)
status.add("P");
else
status.add("A");

if(c8==true && rn.size()>7)
status.add("P");
else
status.add("A");

if(c9==true && rn.size()>8)
status.add("P");
else
status.add("A");

if(c10==true && rn.size()>9)
status.add("P");
else
status.add("A");

if(c11==true && rn.size()>10)
status.add("P");
else
status.add("A");

if(c12==true && rn.size()>11)
status.add("P");
else
status.add("A");

if(c13==true && rn.size()>12)
status.add("P");
else
status.add("A");

if(c14==true && rn.size()>13)
status.add("P");
else
status.add("A");

if(c15==true && rn.size()>14)
status.add("P");
else
status.add("A");

if(c16==true && rn.size()>15)
status.add("P");
else
status.add("A");

if(c17==true && rn.size()>16)
status.add("P");
else
status.add("A");

if(c18==true && rn.size()>17)
status.add("P");
else
status.add("A");

if(c19==true && rn.size()>18)
status.add("P");
else
status.add("A");

if(c20==true && rn.size()>19)
status.add("P");
else
status.add("A");

if(c21==true && rn.size()>20)
status.add("P");
else
status.add("A");

if(c22==true && rn.size()>21)
status.add("P");
else
status.add("A");

if(c23==true && rn.size()>22)
status.add("P");
else
status.add("A");

if(c24==true && rn.size()>23)
status.add("P");
else
status.add("A");

if(c25==true && rn.size()>24)
status.add("P");
else
status.add("A");

if(c26==true && rn.size()>25)
status.add("P");
else
status.add("A");

if(c27==true && rn.size()>26)
status.add("P");
else
status.add("A");

if(c28==true && rn.size()>27)
status.add("P");
else
status.add("A");

if(c29==true && rn.size()>28)
status.add("P");
else
status.add("A");

if(c30==true && rn.size()>29)
status.add("P");
else
status.add("A");




if(c31==true && rn.size()>30)
status.add("P");
else
status.add("A");

if(c32==true && rn.size()>31)
status.add("P");
else
status.add("A");

if(c33==true && rn.size()>32)
status.add("P");
else
status.add("A");

if(c34==true && rn.size()>33)
status.add("P");
else
status.add("A");

if(c35==true && rn.size()>34)
status.add("P");
else
status.add("A");

if(c36==true && rn.size()>35)
status.add("P");
else
status.add("A");

if(c37==true && rn.size()>36)
status.add("P");
else
status.add("A");

if(c38==true && rn.size()>37)
status.add("P");
else
status.add("A");

if(c39==true && rn.size()>38)
status.add("P");
else
status.add("A");

if(c40==true && rn.size()>39)
status.add("P");
else
status.add("A");


if(c41==true && rn.size()>40)
status.add("P");
else
status.add("A");

if(c42==true && rn.size()>41)
status.add("P");
else
status.add("A");

if(c43==true && rn.size()>42)
status.add("P");
else
status.add("A");

if(c44==true && rn.size()>43)
status.add("P");
else
status.add("A");

if(c45==true && rn.size()>44)
status.add("P");
else
status.add("A");

if(c46==true && rn.size()>45)
status.add("P");
else
status.add("A");

if(c47==true && rn.size()>46)
status.add("P");
else
status.add("A");

if(c48==true && rn.size()>47)
status.add("P");
else
status.add("A");

if(c49==true && rn.size()>48)
status.add("P");
else
status.add("A");

if(c50==true && rn.size()>49)
status.add("P");
else
status.add("A");








for(int i=0;i<rn.size();i++)
{
try
{
ps=con.prepareStatement("Update "+month+" set "+dt+"=? where Rollno=? and Subject=?");
ps.setString(1,(String)status.get(i));
ps.setInt(2,Integer.parseInt((String)rn.get(i)));
ps.setString(3,subject);
ps.executeUpdate();
}
catch(Exception e){System.out.println(e);}

}
JOptionPane.showMessageDialog(null,"Attendance is done for "+seme+" "+bran+" "+stud+" for "+subject);


for(int i=0;i<rn.size();i++)
{
try
{

ps=con.prepareStatement("Select * from "+month+" where Rollno=?");
ps.setInt(1,Integer.parseInt((String)rn.get(i)));
rs=ps.executeQuery();
while(rs.next())
{
present=rs.getInt("Present");
total=rs.getInt("Total");
}
total++;
String st=(String)status.get(i);
if(st.equals("P"))
present++;

ps=con.prepareStatement("Update "+month+" set Present=?,Total=? where Rollno=? and Subject=?");
ps.setInt(1,present);
ps.setInt(2,total);
ps.setInt(3,Integer.parseInt((String)rn.get(i)));
ps.setString(4,subject);
ps.executeUpdate();
}
catch(Exception e){System.out.println(e);}

}






}

}
public void itemStateChanged(ItemEvent ie)
{

seme=(String)sem.getSelectedItem();
bran=(String)br.getSelectedItem();
stud=(String)stu.getSelectedItem();
subject=(String)sub.getSelectedItem();
c1=cb1.getState();
c2=cb2.getState();
c3=cb3.getState();
c4=cb4.getState();
c5=cb5.getState();
c6=cb6.getState();
c7=cb7.getState();
c8=cb8.getState();
c9=cb9.getState();
c10=cb10.getState();
c11=cb11.getState();
c12=cb12.getState();
c13=cb13.getState();
c14=cb14.getState();
c15=cb15.getState();
c16=cb16.getState();
c17=cb17.getState();
c18=cb18.getState();
c19=cb19.getState();
c20=cb20.getState();

c21=cb21.getState();
c21=cb21.getState();
c22=cb22.getState();
c23=cb23.getState();
c24=cb24.getState();
c25=cb25.getState();
c26=cb26.getState();
c27=cb27.getState();
c28=cb28.getState();
c29=cb29.getState();
c30=cb30.getState();

c31=cb31.getState();
c31=cb31.getState();
c32=cb32.getState();
c33=cb33.getState();
c34=cb34.getState();
c35=cb35.getState();
c36=cb36.getState();
c37=cb37.getState();
c38=cb38.getState();
c39=cb39.getState();
c40=cb40.getState();

c41=cb41.getState();
c41=cb41.getState();
c42=cb42.getState();
c43=cb43.getState();
c44=cb44.getState();
c45=cb45.getState();
c46=cb46.getState();
c47=cb47.getState();
c48=cb48.getState();
c49=cb49.getState();
c50=cb50.getState();


}

public static void main(String args[])
{
new Takeattendance1();
}

}