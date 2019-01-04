import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;
import java.util.Date;
import java.util.*;


class Seeattendance implements ActionListener,ItemListener
{
JFrame see;
JLabel name;
ImageIcon image,exitimg,backimg;
Font f,f1;
Choice sem,br,sub,stu;
JButton go,se,back,exit;
PreparedStatement ps;
Connection con;
Statement stmt;
ResultSet rs;
String seme,bran,stud,subject;
JTable table,table1;
JScrollPane jsp1,jsp;
ArrayList rn,day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31;
ArrayList first,last,pre,tot;
String [][]data;
String []se1={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
String []colHeads={"Rollno","Firstname","Lastname","1","2","3","4","5","6","7","8","9","10","11","12","13"};
String [][]data1;
String []colHeads1={"14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","present","Total"};
String []colHeads2={"14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","present","Total"};
String mnt;
Choice month;
Date date;

Seeattendance()
{
see=new JFrame("Teacher-See-Attendance");
see.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,33);
name.setFont(f);
name.setBounds(35,12,700,120);
see.add(name);


rn=new ArrayList();
day1=new ArrayList();
day2=new ArrayList();
day3=new ArrayList();
day4=new ArrayList();
day5=new ArrayList();
day6=new ArrayList();
day7=new ArrayList();
day8=new ArrayList();
day9=new ArrayList();
day10=new ArrayList();
day11=new ArrayList();
day12=new ArrayList();
day13=new ArrayList();
day14=new ArrayList();
day15=new ArrayList();
day16=new ArrayList();
day17=new ArrayList();
day18=new ArrayList();
day19=new ArrayList();
day20=new ArrayList();
day21=new ArrayList();
day22=new ArrayList();
day23=new ArrayList();
day24=new ArrayList();
day25=new ArrayList();
day26=new ArrayList();
day27=new ArrayList();
day28=new ArrayList();
day29=new ArrayList();
day30=new ArrayList();
day31=new ArrayList();
first=new ArrayList();
last=new ArrayList();
pre=new ArrayList();
tot=new ArrayList();

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
sem.setBounds(20,140,120,50);
sem.addItemListener(this);
see.add(sem);

br=new Choice();
br.add("Select Branch");
br.add("CSE");
br.add("IT");
br.add("ECE");
br.setBounds(150,140,100,50);
br.addItemListener(this);
see.add(br);



stu=new Choice();
stu.add("Select Students");
stu.add("All");
stu.add("Group1");
stu.add("Group2");
stu.add("Group3");
stu.setBounds(260,140,110,50);
stu.addItemListener(this);
see.add(stu);

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
month.setBounds(590,140,100,35);
month.addItemListener(this);
see.add(month);

go=new JButton("Go");
go.setBounds(380,135,50,30);
go.addActionListener(this);
see.add(go);

sub=new Choice();
sub.add("Select Subject");
sub.setBounds(450,140,120,50);
sub.addItemListener(this);
see.add(sub);

se=new JButton("See");
se.setBounds(700,135,70,30);
se.addActionListener(this);
see.add(se);


back=new JButton("Back");
back.setBounds(150,530,100,30);
back.addActionListener(this);
see.add(back);

exit=new JButton("Exit");
exit.setBounds(400,530,100,30);
exit.addActionListener(this);
see.add(exit);



try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}



see.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
see.setSize(800,800);
see.setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Attendance();
see.setVisible(false);
}

if(str.equals("Go"))
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


if(str.equals("See"))
{
String gp;
int y=0;
date=new Date();
int x=date.getMonth();

try
{
ps=con.prepareStatement("Select * from "+seme+" where Semester=? and Branch=?");
ps.setString(1,seme);
ps.setString(2,bran);
rs=ps.executeQuery();
while(rs.next())
{

gp=rs.getString("Group");
if(gp.equals(stud))
{
String st=rs.getInt("Rollno")+"";
rn.add(st);
y=1;
}

if(stud.equals("All"))
{
String st=rs.getInt("Rollno")+"";
rn.add(st);
y=1;
}

}
}
catch(Exception e){System.out.println(e);}
if(y==0) JOptionPane.showMessageDialog(null,"NO Record Found");





if(y==1)
{
try
{
for(int j=0;j<rn.size();j++)
{
ps=con.prepareStatement("Select * from "+seme+" where Rollno=?");
int rollnumber=Integer.parseInt((String)rn.get(j));
ps.setInt(1,rollnumber);
rs=ps.executeQuery();
while(rs.next())
{
first.add(rs.getString("Firstname"));
last.add(rs.getString("Lastname"));

}
}
}
catch(Exception e){System.out.println(e);}

}






if(y==1)
{
for(int i=0;i<rn.size();i++)
{
try
{
ps=con.prepareStatement("Select * from "+mnt+" where Rollno=? and Subject=?");
ps.setInt(1,Integer.parseInt((String)rn.get(i)));
ps.setString(2,subject);
rs=ps.executeQuery();
while(rs.next())
{
day1.add(rs.getString("1"));
day2.add(rs.getString("2"));
day3.add(rs.getString("3"));
day4.add(rs.getString("4"));
day5.add(rs.getString("5"));
day6.add(rs.getString("6"));
day7.add(rs.getString("7"));
day8.add(rs.getString("8"));
day9.add(rs.getString("9"));
day10.add(rs.getString("10"));
day11.add(rs.getString("11"));
day12.add(rs.getString("12"));
day13.add(rs.getString("13"));
day14.add(rs.getString("14"));
day15.add(rs.getString("15"));
day16.add(rs.getString("16"));
day17.add(rs.getString("17"));
day18.add(rs.getString("18"));
day19.add(rs.getString("19"));
day20.add(rs.getString("20"));
day21.add(rs.getString("21"));
day22.add(rs.getString("22"));
day23.add(rs.getString("23"));
day24.add(rs.getString("24"));
day25.add(rs.getString("25"));
day26.add(rs.getString("26"));
day27.add(rs.getString("27"));
day28.add(rs.getString("28"));
day29.add(rs.getString("29"));
day30.add(rs.getString("30"));

if(mnt.equals("May")||mnt.equals("JUly")) day31.add(rs.getString("31"));

pre.add(rs.getInt("Present")+"");
tot.add(rs.getInt("Total")+"");
}
}
catch(Exception e){System.out.println(e);}
}
}


data=new String[rn.size()][30];

for(int i=0;i<rn.size();i++)
{
data[i][0]=(String)rn.get(i);
data[i][1]=(String)first.get(i);
data[i][2]=(String)last.get(i);
data[i][3]=(String)day1.get(i);
data[i][4]=(String)day2.get(i);
data[i][5]=(String)day3.get(i);
data[i][6]=(String)day4.get(i);
data[i][7]=(String)day5.get(i);
data[i][8]=(String)day6.get(i);
data[i][9]=(String)day7.get(i);
data[i][10]=(String)day8.get(i);
data[i][11]=(String)day9.get(i);
data[i][12]=(String)day10.get(i);
data[i][13]=(String)day11.get(i);
data[i][14]=(String)day12.get(i);
data[i][15]=(String)day13.get(i);
}
table=new JTable(data,colHeads);
int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

jsp=new JScrollPane(table,v,h);
jsp.setBounds(10,180,780,150);
if(y==1) see.add(jsp);




data1=new String[rn.size()][30];
if(mnt.equals("May")||mnt.equals("July"))
{
for(int i=0;i<rn.size();i++)
{
data1[i][0]=(String)day14.get(i);
data1[i][1]=(String)day15.get(i);
data1[i][2]=(String)day16.get(i);
data1[i][3]=(String)day17.get(i);
data1[i][4]=(String)day18.get(i);
data1[i][5]=(String)day19.get(i);
data1[i][6]=(String)day20.get(i);
data1[i][7]=(String)day21.get(i);
data1[i][8]=(String)day22.get(i);
data1[i][9]=(String)day23.get(i);
data1[i][10]=(String)day24.get(i);
data1[i][11]=(String)day25.get(i);
data1[i][12]=(String)day26.get(i);
data1[i][13]=(String)day27.get(i);
data1[i][14]=(String)day28.get(i);
data1[i][15]=(String)day29.get(i);
data1[i][16]=(String)day30.get(i);
data1[i][17]=(String)day31.get(i);
data1[i][18]=(String)pre.get(i);
data1[i][19]=(String)tot.get(i);
}
}
else
{
for(int i=0;i<rn.size();i++)
{
data1[i][0]=(String)day14.get(i);
data1[i][1]=(String)day15.get(i);
data1[i][2]=(String)day16.get(i);
data1[i][3]=(String)day17.get(i);
data1[i][4]=(String)day18.get(i);
data1[i][5]=(String)day19.get(i);
data1[i][6]=(String)day20.get(i);
data1[i][7]=(String)day21.get(i);
data1[i][8]=(String)day22.get(i);
data1[i][9]=(String)day23.get(i);
data1[i][10]=(String)day24.get(i);
data1[i][11]=(String)day25.get(i);
data1[i][12]=(String)day26.get(i);
data1[i][13]=(String)day27.get(i);
data1[i][14]=(String)day28.get(i);
data1[i][15]=(String)day29.get(i);
data1[i][16]=(String)day30.get(i);
data1[i][17]=(String)pre.get(i);
data1[i][18]=(String)tot.get(i);
}
}





if(mnt.equals("May"))
table1=new JTable(data1,colHeads2);
else
table1=new JTable(data1,colHeads1);

int v1=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h1=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

jsp1=new JScrollPane(table1,v1,h1);
jsp1.setBounds(10,360,780,150);
if(y==1) see.add(jsp1);



}



}
public void itemStateChanged(ItemEvent ie)
{
seme=(String)sem.getSelectedItem();
bran=(String)br.getSelectedItem();
stud=(String)stu.getSelectedItem();
subject=(String)sub.getSelectedItem();
mnt=(String)month.getSelectedItem();
}

public static void main(String args[])
{
new Seeattendance();
}

}