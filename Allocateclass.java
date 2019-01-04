import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.event.*;

class Allocateclass implements ActionListener,ItemListener
{
JFrame allc;
JLabel name;
ImageIcon image;
Font f,f1,f2;
JLabel teaid,nm,job,sem,br,sub;
JTextField id,nmtf,jobtf;
JLabel sub1,sub2,sub3,sub4,sub5,sub6;
Choice sem1,sem2,sem3,sem4,sem5,sem6,br1,br2,br3,br4,br5,br6;
JTextField tf1,tf2,tf3,tf4,tf5,tf6;
JButton chk,allo,up,view,back,exit;
PreparedStatement ps;
Connection con;
Statement stmt;
ResultSet rs;
String s1,s2,s3,s4,s5,s6,b1,b2,b3,b4,b5,b6; 

Allocateclass()
{
allc=new JFrame("Administrator-Teacher-Allocateclasses");
allc.setLayout(null);

image=new ImageIcon("attendance1.gif");
name=new JLabel("STUDENT ATTENDANCE SYSTEM",image,JLabel.CENTER);

name.setForeground(Color.blue);
f=new Font("TimesRoman",Font.BOLD|Font.ITALIC,35);
name.setFont(f);
name.setBounds(35,12,700,140);
allc.add(name);

teaid=new JLabel("Teacher-Id");
f1=new Font("TimesRoman",Font.BOLD,20);
teaid.setFont(f1);
teaid.setBounds(230,130,150,50);
allc.add(teaid);

id=new JTextField(20);
id.setBounds(350,140,150,30);
allc.add(id);

nm=new JLabel("Name");
f2=new Font("TimesRoman",Font.BOLD,18);
nm.setFont(f2);
nm.setBounds(100,180,100,50);
allc.add(nm);

nmtf=new JTextField(20);
nmtf.setBounds(170,190,150,30);
nmtf.setEditable(false);
allc.add(nmtf);

job=new JLabel("Job Post");
job.setFont(f2);
job.setBounds(360,180,100,50);
allc.add(job);

jobtf=new JTextField(20);
jobtf.setBounds(450,190,150,30);
jobtf.setEditable(false);
allc.add(jobtf);

sem=new JLabel("Semester");
sem.setFont(f2);
sem.setBounds(150,230,100,50);
allc.add(sem);

br=new JLabel("Branch");
br.setFont(f2);
br.setBounds(300,230,100,50);
allc.add(br);

sub=new JLabel("Subject");
sub.setFont(f2);
sub.setBounds(450,230,100,50);
allc.add(sub);

sub1=new JLabel("Subject1");
sub1.setFont(f2);
sub1.setBounds(30,280,80,50);
allc.add(sub1);

sub2=new JLabel("Subject2");
sub2.setFont(f2);
sub2.setBounds(30,330,80,50);
allc.add(sub2);

sub3=new JLabel("Subject3");
sub3.setFont(f2);
sub3.setBounds(30,380,80,50);
allc.add(sub3);

sub4=new JLabel("Subject4");
sub4.setFont(f2);
sub4.setBounds(30,430,80,50);
allc.add(sub4);

sub5=new JLabel("Subject5");
sub5.setFont(f2);
sub5.setBounds(30,480,80,50);
allc.add(sub5);

sub6=new JLabel("Subject6");
sub6.setFont(f2);
sub6.setBounds(30,530,80,50);
allc.add(sub6);


sem1=new Choice();
sem1.add("Select Semester");
sem1.add("Semester1");
sem1.add("Semester2");
sem1.add("Semester3");
sem1.add("Semester4");
sem1.add("Semester5");
sem1.add("Semester6");
sem1.add("Semester7");
sem1.add("Semester8");
sem1.setBounds(120,295,120,30);
sem1.addItemListener(this);
allc.add(sem1);

sem2=new Choice();
sem2.add("Select Semester");
sem2.add("Semester1");
sem2.add("Semester2");
sem2.add("Semester3");
sem2.add("Semester4");
sem2.add("Semester5");
sem2.add("Semester6");
sem2.add("Semester7");
sem2.add("Semester8");
sem2.setBounds(120,345,120,30);
sem2.addItemListener(this);
allc.add(sem2);

sem3=new Choice();
sem3.add("Select Semester");
sem3.add("Semester1");
sem3.add("Semester2");
sem3.add("Semester3");
sem3.add("Semester4");
sem3.add("Semester5");
sem3.add("Semester6");
sem3.add("Semester7");
sem3.add("Semester8");
sem3.setBounds(120,395,120,30);
sem3.addItemListener(this);
allc.add(sem3);

sem4=new Choice();
sem4.add("Select Semester");
sem4.add("Semester1");
sem4.add("Semester2");
sem4.add("Semester3");
sem4.add("Semester4");
sem4.add("Semester5");
sem4.add("Semester6");
sem4.add("Semester7");
sem4.add("Semester8");
sem4.setBounds(120,445,120,30);
sem4.addItemListener(this);
allc.add(sem4);

sem5=new Choice();
sem5.add("Select Semester");
sem5.add("Semester1");
sem5.add("Semester2");
sem5.add("Semester3");
sem5.add("Semester4");
sem5.add("Semester5");
sem5.add("Semester6");
sem5.add("Semester7");
sem5.add("Semester8");
sem5.setBounds(120,495,120,30);
sem5.addItemListener(this);
allc.add(sem5);

sem6=new Choice();
sem6.add("Select Semester");
sem6.add("Semester1");
sem6.add("Semester2");
sem6.add("Semester3");
sem6.add("Semester4");
sem6.add("Semester5");
sem6.add("Semester6");
sem6.add("Semester7");
sem6.add("Semester8");
sem6.setBounds(120,545,120,30);
sem6.addItemListener(this);
allc.add(sem6);



br1=new Choice();
br1.add("Select Branch");
br1.add("CSE");
br1.add("IT");
br1.add("ECE");
br1.setBounds(270,295,120,30);
br1.addItemListener(this);
allc.add(br1);

br2=new Choice();
br2.add("Select Branch");
br2.add("CSE");
br2.add("IT");
br2.add("ECE");
br2.setBounds(270,345,120,30);
br2.addItemListener(this);
allc.add(br2);

br3=new Choice();
br3.add("Select Branch");
br3.add("CSE");
br3.add("IT");
br3.add("ECE");
br3.setBounds(270,395,120,30);
br3.addItemListener(this);
allc.add(br3);

br4=new Choice();
br4.add("Select Branch");
br4.add("CSE");
br4.add("IT");
br4.add("ECE");
br4.setBounds(270,445,120,30);
br4.addItemListener(this);
allc.add(br4);

br5=new Choice();
br5.add("Select Branch");
br5.add("CSE");
br5.add("IT");
br5.add("ECE");
br5.setBounds(270,495,120,30);
br5.addItemListener(this);
allc.add(br5);

br6=new Choice();
br6.add("Select Branch");
br6.add("CSE");
br6.add("IT");
br6.add("ECE");
br6.setBounds(270,545,120,30);
br6.addItemListener(this);
allc.add(br6);



tf1=new JTextField(20);
tf1.setBounds(420,295,150,30);
allc.add(tf1);

tf2=new JTextField(20);
tf2.setBounds(420,345,150,30);
allc.add(tf2);

tf3=new JTextField(20);
tf3.setBounds(420,395,150,30);
allc.add(tf3);

tf4=new JTextField(20);
tf4.setBounds(420,445,150,30);
allc.add(tf4);

tf5=new JTextField(20);
tf5.setBounds(420,495,150,30);
allc.add(tf5);

tf6=new JTextField(20);
tf6.setBounds(420,545,150,30);
allc.add(tf6);


chk=new JButton("Check");
chk.setBounds(650,190,100,30);
chk.addActionListener(this);
allc.add(chk);

allo=new JButton("Allocate");
allo.setBounds(650,280,100,30);
allo.addActionListener(this);
allc.add(allo);

up=new JButton("Update");
up.setBounds(650,340,100,30);
up.addActionListener(this);
allc.add(up);

view=new JButton("View");
view.setBounds(650,400,100,30);
view.addActionListener(this);
allc.add(view);

back=new JButton("Back");
back.setBounds(650,460,100,30);
back.addActionListener(this);
allc.add(back);

exit=new JButton("Exit");
exit.setBounds(650,520,100,30);
exit.addActionListener(this);
allc.add(exit);

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:student","","");
stmt=con.createStatement();
}
catch(Exception e){}

allc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
allc.setSize(800,800);
allc.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Exit"))
System.exit(0);

if(str.equals("Back"))
{
new Adminteacher();
allc.setVisible(false);
}

if(str.equals("Check"))
{
int y=0;
try
{
ps=con.prepareStatement("Select * from teacher where Teacherid=?");
ps.setInt(1,Integer.parseInt(id.getText()));
rs=ps.executeQuery();
while(rs.next())
{
nmtf.setText(rs.getString("Firstname")+"  "+rs.getString("Lastname"));
jobtf.setText(rs.getString("Job Post"));
y=1;
}
}
catch(Exception e){System.out.println(e);}
if(y==0) JOptionPane.showMessageDialog(null,"Record not Found");
}


if(str.equals("Allocate"))
{
try
{
ps=con.prepareStatement("Insert into allocateclass values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
ps.setInt(1,Integer.parseInt(id.getText()));
ps.setString(2,s1);
ps.setString(3,b1);
ps.setString(4,tf1.getText());
ps.setString(5,s2);
ps.setString(6,b2);
ps.setString(7,tf2.getText());
ps.setString(8,s3);
ps.setString(9,b3);
ps.setString(10,tf3.getText());
ps.setString(11,s4);
ps.setString(12,b4);
ps.setString(13,tf4.getText());
ps.setString(14,s5);
ps.setString(15,b5);
ps.setString(16,tf5.getText());
ps.setString(17,s6);
ps.setString(18,b6);
ps.setString(19,tf6.getText());
ps.executeUpdate();
JOptionPane.showMessageDialog(null,"Classes allocated to"+id.getText()+" Teacher-Id");
}
catch(Exception e){System.out.println(e);}
}



if(str.equals("View"))
{
try
{
ps=con.prepareStatement("Select * from allocateclass where Teacherid=?");
ps.setInt(1,Integer.parseInt(id.getText()));
rs=ps.executeQuery();
while(rs.next())
{

sem1.select(rs.getString("Semester1"));
br1.select(rs.getString("Branch1"));
tf1.setText(rs.getString("Subject1"));

sem2.select(rs.getString("Semester2"));
br2.select(rs.getString("Branch2"));
tf2.setText(rs.getString("Subject2"));

sem3.select(rs.getString("Semester3"));
br3.select(rs.getString("Branch3"));
tf3.setText(rs.getString("Subject3"));

sem4.select(rs.getString("Semester4"));
br4.select(rs.getString("Branch4"));
tf4.setText(rs.getString("Subject4"));

sem5.select(rs.getString("Semester5"));
br5.select(rs.getString("Branch5"));
tf5.setText(rs.getString("Subject5"));

sem6.select(rs.getString("Semester6"));
br6.select(rs.getString("Branch6"));
tf6.setText(rs.getString("Subject6"));
s1=sem1.getSelectedItem();
s2=sem2.getSelectedItem();
s3=sem3.getSelectedItem();
s4=sem4.getSelectedItem();
s5=sem5.getSelectedItem();
s6=sem6.getSelectedItem();
b1=br1.getSelectedItem();
b2=br2.getSelectedItem();
b3=br3.getSelectedItem();
b4=br4.getSelectedItem();
b5=br5.getSelectedItem();
b6=br6.getSelectedItem();
}
}
catch(Exception e){System.out.println(e);}
}

if(str.equals("Update"))
{
try
{
ps=con.prepareStatement("Update allocateclass set Semester1=?,Branch1=?,Subject1=?,Semester2=?,Branch2=?,Subject2=?,Semester3=?,Branch3=?,Subject3=?,Semester4=?,Branch4=?,Subject4=?,Semester5=?,Branch5=?,Subject5=?,Semester6=?,Branch6=?,Subject6=? where Teacherid=?");
ps.setString(1,s1);
ps.setString(2,b1);
ps.setString(3,tf1.getText());
ps.setString(4,s2);
ps.setString(5,b2);
ps.setString(6,tf2.getText());
ps.setString(7,s3);
ps.setString(8,b3);
ps.setString(9,tf3.getText());
ps.setString(10,s4);
ps.setString(11,b4);
ps.setString(12,tf4.getText());
ps.setString(13,s5);
ps.setString(14,b5);
ps.setString(15,tf5.getText());
ps.setString(16,s6);
ps.setString(17,b6);
ps.setString(18,tf6.getText());
ps.setInt(19,Integer.parseInt(id.getText()));
ps.executeUpdate();
}
catch(Exception e){System.out.println(e);}
JOptionPane.showMessageDialog(null,"Classes updated to"+id.getText()+" Teacher-Id");
}



}

public void itemStateChanged(ItemEvent ie)
{
s1=(String)sem1.getSelectedItem();
s2=(String)sem2.getSelectedItem();
s3=(String)sem3.getSelectedItem();
s4=(String)sem4.getSelectedItem();
s5=(String)sem5.getSelectedItem();
s6=(String)sem6.getSelectedItem();
b1=(String)br1.getSelectedItem();
b2=(String)br2.getSelectedItem();
b3=(String)br3.getSelectedItem();
b4=(String)br4.getSelectedItem();
b5=(String)br5.getSelectedItem();
b6=(String)br6.getSelectedItem();
System.out.println(s1);
}


public static void main(String args[])
{
new Allocateclass();
}

}