package onlinetest3;

/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2,b3,b4;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b3=new JButton("Previous");
		b4=new JButton("Finish Test");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		add(b1);add(b2);add(b3);add(b4);
		
		set();
		
		l.setBounds(22,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		
		b1.setBounds(50,240,100,30);
		b2.setBounds(290,240,100,30);
		b3.setBounds(170,240,100,30);
		b4.setBounds(410,240,100,30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//setLocation(250,100);
		setLocation(650,300);
		setVisible(true);
		//setSize(600,350);
		setSize(700,500);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b3)
		{
			current--;
			set();
		}
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();
			
			if(current==9)
			{
				b1.setEnabled(false);
				//b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(520,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			//if(current==9)
				//b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Finish Test"))
		//if(e.getSource()==b4)
		{
			b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);b4.setEnabled(false);
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"Correct answers="+count+"\n\nThanks for taking the test!");
			System.exit(0);
		}
	}
	void set()
	{
		b3.setEnabled(true);
		b1.setEnabled(true);
		
		jb[4].setSelected(true);
		
		if(current==0)
		{
			l.setText("Que1: Which one among these is not a datatype?");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");
			b3.setEnabled(false);
		}
		if(current==1)
		{
			l.setText("Que2: Which class is available to all the class automatically?");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our class without importing it?");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package?");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Which of these can be a variable?");
			jb[0].setText("val");jb[1].setText("String");jb[2].setText("int");jb[3].setText("All of these");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword?");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class? ");
			jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: Which one among these is not a function of Object class?");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: Which function is not present in Applet class?");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			b1.setEnabled(false);
			l.setText("Que10: Which function checks the equality of strings?");
			jb[0].setText("==");jb[1].setText("equal to()");jb[2].setText("equals()");jb[3].setText("Equal()");
			
		}
		l.setBounds(22,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
		{
			
			//jb[this].setSelected(true);
			return(jb[1].isSelected());
		}
			
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[3].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
