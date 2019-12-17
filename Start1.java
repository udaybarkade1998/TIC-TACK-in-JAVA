import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class TicTack extends JFrame implements ActionListener
{
	JButton j[]=new JButton[9];
	
	Color c1,c2;
	JPanel jp=new JPanel();
	JButton jbs;
	String nm1,nm2;
	
	int flg=1;
	
	JLabel jpl1,jnm1,jnm2,jpl2;
	
	JLabel ll=new JLabel();
	JPanel jmain;
	
	TicTack(Color c1,Color c2,String nm1,String nm2)
	{
		super("TickTack");
		
		setLayout(null);	
		setResizable(false);
		setUndecorated(true);
		//setOpacity(0.9f);
		setBackground(new Color(0,0,0,230));
		
		jmain=new JPanel();
		jmain.setBounds(0,0,600,300);
		//add(jmain);
		jmain.setBackground(Color.black);

	
		jp.setLayout(new GridLayout(3,3));
		jp.setBounds(300,20,290,270);
		add(jp);
	
		this.c1=c1;
		this.c2=c2;
		
		if(nm1=="")
			nm1="Player1";
		else
			this.nm1=nm1;
		
		if(nm2=="")
			nm2="Player2";
		else
			this.nm2=nm2;
	
			
		jbs=new JButton("Start and reset");
		jbs.setBounds(10,20,280,30);
		jbs.setBackground(Color.white);
		add(jbs);
	
		jpl1=new JLabel("Player 1 :  ");
		jpl1.setFont(new Font("Times New Roman",Font.BOLD,15));
		jpl1.setForeground(Color.white);
		jpl1.setBounds(10,70,150,20);
		add(jpl1);
		
		jnm1=new JLabel(nm1);
		jnm1.setFont(new Font("Courier",Font.BOLD,20));
		jnm1.setForeground(c1);
		jnm1.setBounds(50,90,150,30);
		add(jnm1);
		
		jpl2=new JLabel("Player 2 :  ");
		jpl2.setFont(new Font("Times New Roman",Font.BOLD,15));
		jpl2.setForeground(Color.white);
		jpl2.setBounds(10,120,150,20);
		add(jpl2);
		
		jnm2=new JLabel(nm2);
		jnm2.setFont(new Font("Courier",Font.BOLD,20));
		jnm2.setForeground(c2);
		jnm2.setBounds(50,140,150,30);
		add(jnm2);
		
		ll.setFont(new Font("Courier",Font.BOLD,20));
		ll.setBounds(50,200,250,30);
		add(ll);
	
		for(int i=0;i<9;i++)
		{
			j[i]=new JButton();
			jp.add(j[i]);
			j[i].setEnabled(false);
			j[i].addActionListener(this);
		}

		jbs.addActionListener(this);
		setLocation(500,200);
		setSize(600,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton jj=(JButton)e.getSource();
		
		if(jj==jbs)
		{
			for(int i=0;i<9;i++)
			{
				j[i].setEnabled(true);
				j[i].setBackground(Color.white);
				j[i].setActionCommand("no");
				flg=1;
				ll.setForeground(Color.white);
			}
			ll.setText(nm1+"'s turn");
			ll.setForeground(c1);
			repaint();
		}
		
		for(int i=0;i<9;i++)
		{
			if(jj==j[i]&&j[i].getActionCommand().equals("no"))
			{
				if(flg==1)
				{
					ll.setText(nm2+"'s turn");
					ll.setForeground(c2);
					j[i].setBackground(c1);
					repaint();
					flg=2;
					j[i].setActionCommand("ok");
				}
				else
				{
					ll.setText(nm1+"'s turn");
					ll.setForeground(c1);
					j[i].setBackground(c2);
					repaint();
					flg=1;
					j[i].setActionCommand("okk");
				}	
			}
		}
		
		
		String s[]=new String[9];		
		
		for(int i=0;i<9;i++)
		{
			s[i]="";
		}
		
		for(int i=0;i<9;i++)
		{
			s[i]=j[i].getActionCommand();
		}
		
		
		Border bb=BorderFactory.createLineBorder(Color.white,2);
		
		
		if((s[1].equals("ok")&&s[4].equals("ok")&&s[7].equals("ok"))||(s[2].equals("ok")&&s[4].equals("ok")&&s[6].equals("ok"))||(s[3].equals("ok")&&s[4].equals("ok")&&s[5].equals("ok"))||(s[6].equals("ok")&&s[7].equals("ok")&&s[8].equals("ok"))||(s[0].equals("ok")&&s[4].equals("ok")&&s[8].equals("ok"))||(s[0].equals("ok")&&s[3].equals("ok")&&s[6].equals("ok"))||(s[0].equals("ok")&&s[1].equals("ok")&&s[2].equals("ok"))||(s[2].equals("ok")&&s[5].equals("ok")&&s[8].equals("ok")))
		{
			for(int i=0;i<9;i++)
			{
				j[i].setBackground(c1);
				ll.setForeground(c1);
				ll.setText(nm1+" Wins");
				//ll.setBorder(bb);
				repaint();
			}
		}
		
		if((s[1].equals("okk")&&s[4].equals("okk")&&s[7].equals("okk"))||(s[2].equals("okk")&&s[4].equals("okk")&&s[6].equals("okk"))||(s[3].equals("okk")&&s[4].equals("okk")&&s[5].equals("okk"))||(s[6].equals("okk")&&s[7].equals("okk")&&s[8].equals("okk"))||(s[0].equals("okk")&&s[4].equals("okk")&&s[8].equals("okk"))||(s[0].equals("okk")&&s[3].equals("okk")&&s[6].equals("okk"))||(s[0].equals("okk")&&s[1].equals("okk")&&s[2].equals("okk"))||(s[2].equals("okk")&&s[5].equals("okk")&&s[8].equals("okk")))
		{
			for(int i=0;i<9;i++)
			{
				j[i].setBackground(c2);
				ll.setForeground(c2);
				ll.setText(nm2+" Wins");
				repaint();
				//ll.setBorder(bb);
			}
		}
		
	}
}

class Start1 extends JFrame 
{
	Label l=new Label("Tic Tack Toe");
	
	Start1()
	{
		setLayout(null);
		setLocation(500,200);
		setSize(400,300);
		setUndecorated(true);
		

		
		setResizable(false);
		setBackground(Color.black);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
				
		l.setFont(new Font("Times New Roman",Font.BOLD,20));
		l.setForeground(Color.blue);
		
		l.setBounds(130,100,150,100);
		l.setForeground(Color.white);
		add(l);
		
		setVisible(true);
		try{Thread.sleep(1000);}catch(Exception e){}

		new ChooseColor();
	}

	public static void main(String []args)
	{
		new Start1();
	}
}

class ChooseColor extends JFrame implements ActionListener,FocusListener,MouseListener
{
	Color c,ct;
	JLabel lnm1,lnm2,war,err;
	JTextArea tnm1,tnm2;
	JButton jc1,jc2,jsub;
	int flg1=0,flg2=0;
	int ch=0;
	Border b1;
	JPanel obar;JButton jclose,jminimize;
	
	ChooseColor()
	{
		setLayout(null);
		setLocation(500,200);
		setUndecorated(true);
		setSize(400,350);
		setResizable(false);
		setBackground(new Color(0,0,0,240));
		
		
		obar=new JPanel();
		obar.setLayout(null);
		obar.setBounds(2,2,396,20);
		Graphics g=obar.getGraphics();
		obar.setBackground(Color.white);
		add(obar);
		
		jclose=new JButton("x");
		jclose.setFont(new Font("Roman",Font.BOLD,15));
		jclose.setBounds(351,0,45,20);
		jclose.setFocusPainted(false);
		jclose.setBackground(Color.white);
		jclose.setForeground(Color.black);
		jclose.addActionListener(this);
		jclose.addMouseListener(this);
		obar.add(jclose);
		
		jminimize=new JButton("-");
		jminimize.setFont(new Font("Roman",Font.BOLD,15));
		jminimize.setBounds(306,0,45,20);
		jminimize.setFocusPainted(false);
		jminimize.setBackground(Color.white);
		jminimize.setForeground(Color.black);
		jminimize.addMouseListener(this);
		jminimize.addActionListener(this);
		obar.add(jminimize);
		
		
		lnm1=new JLabel("Enter Player 1 name");
		lnm1.setBounds(30,20,200,50);
		lnm1.setFont(new Font("ALGERIAN",Font.BOLD,15));
		lnm1.setBackground(Color.black);
		lnm1.setForeground(Color.white);
		add(lnm1);
		
		
		
		tnm1=new JTextArea(200,50);
		tnm1.setBounds(50,70,200,30);
		tnm1.setFont(new Font("Times New Roman",Font.BOLD,25));
		add(tnm1);
		tnm1.setBackground(Color.white);
		
		lnm2=new JLabel("Enter Player 2 name");
		lnm2.setBounds(30,130,200,50);
		lnm2.setFont(new Font("ALGERIAN",Font.BOLD,15));
		add(lnm2);
		
		lnm2.setForeground(Color.white);

		tnm2=new JTextArea(200,50);
		tnm2.setBounds(50,190,200,30);
		lnm2.setFont(new Font("ALGERIAN",Font.BOLD,15));
		add(tnm2);
		tnm2.setBackground(Color.white);
		
		jsub=new JButton("Start");
		jsub.setBounds(50,260,320,40);
		add(jsub);
		jsub.setEnabled(false);
		jsub.addActionListener(this);
		jsub.setBackground(new Color(0,0,0,200));
		jsub.setForeground(Color.white);
		b1=BorderFactory.createLineBorder(new Color(255,255,255,150),2);
		jsub.addFocusListener(this);
		
		war=new JLabel("*Please select both colors to start match");
		war.setFont(new Font("Courier",Font.BOLD,10));
		war.setBounds(50,300,300,40);
		war.setForeground(Color.red);
		add(war);
		
		Border b=BorderFactory.createLineBorder(new Color(0,0,0,150),1);
		tnm1.setBorder(b);
		tnm2.setBorder(b);
		
		
		err=new JLabel("Already Assigned..!  Please choose another");
		err.setBackground(Color.white);
		err.setForeground(Color.red);
		add(err);
		
		jc1=new JButton("Color p1");
		jc1.setBounds(270,70,100,30);
		jc1.setBackground(new Color(0,0,0,100));
		jc1.setForeground(Color.white);
	
		repaint();
		add(jc1);
		
		jc2=new JButton("Color p2");
		jc2.setBounds(270,190,100,30);
		jc2.setBackground(new Color(0,0,0,100));
		jc2.setForeground(Color.white);
		
		add(jc2);
		
		jc2.addActionListener(this);
		jc1.addActionListener(this);
		
		
		setVisible(true);
	}
	
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e){}
	
	public void mouseEntered(MouseEvent e) 
	{
		JButton jj=(JButton)e.getSource();
		
		if(jj==jclose)
		{
			jclose.setBackground(new Color(255,0,0));
			jclose.setForeground(Color.white);
		}
		if(jj==jminimize)
		{
			jminimize.setBackground(new Color(72,149,242));
			jminimize.setForeground(Color.white);
		}
	}

	public void mouseExited(MouseEvent e) 
	{
		JButton jj=(JButton)e.getSource();	
		if(jj==jclose)
		{
			jclose.setBackground(Color.white);
			jclose.setForeground(Color.black);
		}
		
		if(jj==jminimize)
		{	
			jminimize.setBackground(Color.white);
			jminimize.setForeground(Color.black);
		}
	}

	public void mouseClicked(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		JButton jj=(JButton)e.getSource();
		
		if(jj==jc1)
		{
			c=JColorChooser.showDialog(null,"Choose Color",Color.red);
			
			if(c!=ct)
			{
				if(ch==1)
				{
					for(int i=699;i>=400;i--)
					{
						repaint();
						setSize(i,350);
						try{Thread.sleep(1);}catch(Exception e1){}
						repaint();
					}
					ch=0;
				}
				
				if(ch==0)
				{	
					jc1.setBackground(c);
					flg1=1;
				}
				
				err.setVisible(false);	
				
			}
			else
			{
				if(ch==0)
				{
					for(int i=401;i<700;i++)
					{
						repaint();
						setSize(i,350);
						try{Thread.sleep(1);}catch(Exception e11){}
						repaint();
					}
					ch=1;
				}
				err.setBounds(400,70,300,50);
				err.setVisible(true);
			}
		}
		
		if(jj==jc2)
		{
			ct=JColorChooser.showDialog(null,"Choose Color",Color.red);
			
			if(ct!=c)
			{
				if(ch==1)
				{
					for(int i=699;i>=400;i--)
					{
						repaint();
						setSize(i,350);
						try{Thread.sleep(1);}catch(Exception e1){}
						repaint();
					}
					ch=0;
				}
				
				if(ch==0)
				{
					jc2.setBackground(ct);
					flg2=1;
					err.setVisible(false);
				}
			}
			else
			{
				if(ch==0)
				{
					for(int i=401;i<700;i++)
					{
						repaint();
						setSize(i,350);
						try{Thread.sleep(1);}catch(Exception e1){}
						repaint();
					}
					ch=1;
				}
				err.setVisible(true);
				err.setBounds(400,190,300,50);
			}
		}
		
		if(flg1==1&&flg2==1)
		{
			war.setVisible(false);
			jsub.setEnabled(true);
			jsub.setBorder(b1);
		}
		if(jj==jsub)
		{
			setVisible(false);
			new TicTack(c,ct,tnm1.getText(),tnm2.getText());
		}
		
		if(jj==jclose)
		{
			System.exit(0);
		}
		
		if(jj==jminimize)
			setState(JFrame.ICONIFIED);	
	}
}