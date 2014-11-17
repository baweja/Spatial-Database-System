import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import oracle.sdoapi.geom.*;
import oracle.sdoapi.adapter.*;
import oracle.sdoapi.sref.*;

import java.awt.event.ActionListener;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.*;
import java.awt.Polygon;
import java.awt.image.*;
import java.io.*;

import javax.swing.JButton;

import oracle.sdoapi.OraSpatialManager;
import oracle.sdoapi.adapter.GeometryAdapter;
import oracle.sdoapi.geom.Geometry;
import oracle.sql.STRUCT;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;


public class hw2 extends JFrame
{
	Statement mainStatement = null;
  	ResultSet mainResultset = null;
  	Connection mainConnection = null;
  	private boolean AS=false;
  	private boolean BUILDING=false;
  	private boolean STUDENTS=false;
	private boolean submit=false;
  	private boolean wholeregion=false;
  	private boolean pointquery=false;
  	private boolean rangequery=false;
  	private boolean sr_stdnt=false;
  	private boolean emer_query=false;
  	private boolean flag;
  	
  	private JPanel panel;
  	private JTextArea textArea;
  	private JCheckBox chckbxNewCheckBox_1;
  	private JCheckBox chckbxNewCheckBox_2;
  	private JLabel lblMouse;
  	private MouseEvent q2evt;
  	private MouseEvent q3evt;
  	private JCheckBox chckbxNewCheckBox;
  	private JTextField textField;
  	//private String str1="";
  	private String str1="";
  	private int q2_x;
  	private int q2_y;
  	private int count=1;
  	private String str3="";
  	private String str4="";
    private String str="";
 	private int  ctr=-1;
 	private int  ct=-1;
    private int xco;
    private int x0;
    private int y0;
    private int yco;
    private int ann_x;
    
    private int ann_y;
    private int ann_r;
    private int stu_x;
    
    private ArrayList<Integer> q3x = new ArrayList<Integer>();
	private ArrayList<Integer> q3y = new ArrayList<Integer>();
	
	 private ArrayList<Integer> q2x = new ArrayList<Integer>();
		private ArrayList<Integer> q2y = new ArrayList<Integer>();
  
    private int stu_y;
    private String poly;
    private int fx,fy;
    private int lastx,lasty;
  	private double[] x_pt = new double[80];
  	private double[] y_pt = new double[80];
  	private double[] a_pt = new double[8];
  	private double[] b_pt = new double[8];
  	private double[] c_pt = new double[8];
  	private JRadioButton rdbtnNewRadioButton;
  	private JRadioButton rdbtnNewRadioButton_1;
  	private JRadioButton rdbtnNewRadioButton_2;
  	private JRadioButton rdbtnNewRadioButton_3;
  	private JRadioButton rdbtnNewRadioButton_4;
  	//private int q4a_x[]=new int[80];
	//private int q4a_y[]=new int[80];
    int i,j;
    private String q2poly="";
	private String q3poly="";
	private String q3polyas="";
	private String q3polyb="";
	private int q3s_x[]=new int[80];
	private int q3s_y[]=new int[80];
	
	private int q3a_x[]=new int[7];
	private int q3a_y[]=new int[7];
	
	private int q2as_x[]=new int[7];
	private int q2as_y[]=new int[7];
	private int q2as_r[]=new int[7];
	private int q2s_x[]=new int[80];
	private int q2s_y[]=new int[80];
	private int q2_ASX;
	private int q2_ASY;
	private int q2_ASR;
	
	private int q2asy_x[]=new int[80];
	private int q2asy_y[]=new int[80];
	private int q2asr[]=new int[80];
	private BufferedImage img=null;
	
	private int q3r[]=new int[7];
	
	private int q4ann_x,q4ann_y,q4r;
	private int q4a_x[]=new int[80];
	private int q4a_y[]=new int[80];
	
	
	private int q5ann_x;
	private int q5ann_y;
	private int q5ann_r;
	private String aID="";
	private int q5a_x[]=new int[80];
	private int q5a_y[]=new int[80];
	private int q5a_r[]=new int[80];
	private int q5c_y;
	private int q5c_x;
	private int q5c_r;
	private String q5a_id="";
	private String[] ASColors={"pink","magenta","blue","green","orange","white","yellow"};
	
   
    
    private int cord[] = new int[100];
  	Polygon[] p=new Polygon[36];
  	{
  		for(int f=0;f<p.length;f++)
  		{
  			 p[f]=new Polygon();	
  		}
  	
  	};
  	private Polygon q3p[]=new Polygon[200];
	{
	for (int i = 0; i < p.length; i++)
	{
	    q3p[i] = new Polygon();
	}
	};
  	
  	Polygon[] pqbuild=new Polygon[36];
  	{
  		for(int f=0;f<p.length;f++)
  		{
  			 pqbuild[f]=new Polygon();	
  		}
  	
  	};
  	Polygon[] q2BP=new Polygon[1];
  	{
  		for(int f=0;f<q2BP.length;f++)
  		{
  			 q2BP[f]=new Polygon();	
  		}
  	
  	};
  	private Polygon q2bp[]=new Polygon[200];
	{
	for (int i = 0; i < q2bp.length; i++)
	{
	    q2bp[i] = new Polygon();
	}
	};

	
	
  		
  	
  	int tupleCount=1;
  

	
	public hw2() {
		this.poly = "";
		getContentPane().setLayout(null);
	
	  	
  		try {
  		    img = ImageIO.read(new File("C:\\Users\\Garima\\Desktop\\HW2\\map.jpg"));
  		}   
  		catch (IOException e) 
  		{
  		}
  		
		
		
		
		panel = new JPanel()
		{
			
			public void paintComponent(Graphics g)
		
			{
			    super.paintComponent(g);
			   //Graphics g=panel.getGraphics();
			 
			    g.drawImage(img, 0, 0, 820, 580, null);
			    if(wholeregion)
			    {
			    
			    if(AS)
			    {
			    for(int c=0;c<a_pt.length;c++)
					{
					    
					    g.setColor(Color.red);
					    g.fillRect((int)a_pt[c]-7,(int)b_pt[c]-7,15,15);
					    g.drawOval((int)a_pt[c]-(int)c_pt[c],(int)b_pt[c]- (int)c_pt[c], (int)c_pt[c]*2, (int)c_pt[c]*2);
					}
			    }
			    
			    if(STUDENTS)
			    {
			    	for(int j=0;j<x_pt.length;j++)
					{
					    //System.out.println("garima"+x_pt[j]);
						
					   
					    g.setColor(Color.green);
					    g.fillRect((int)x_pt[j]-5,(int)y_pt[j]-5,10,10);
					}	
			    }

			   
			if(BUILDING)
			{
			//pop.BTuples();
			for(int a=0;a<p.length;a++)
			{
				
				g.setColor(Color.yellow);
				g.drawPolygon(p[a]);
			}
			
			}
			
			    }
			    else if(pointquery)
		        {	
			    	int q2x=q2evt.getX();
		        	 int q2y=q2evt.getY();
			    	 //System.out.println("garima"+x_pt[j]);
						
					  
					    g.setColor(Color.red);
					    g.fillRect((int)q2x-2,(int)q2y-2,5,5);
					    g.drawOval((int)q2x-50,(int)q2y-50, 100, 100);
					    
					    
					   if(submit)
					   {
					    	//System.out.println("ouh");
					    	if(STUDENTS)
					    	{
					    		for(int k=0;k<q2s_x.length;k++)
					    		{
					    			 g.setColor(Color.green);
						        	 
										g.fillRect(q2s_x[k]-5,q2s_y[k]-5,10,10);
										//System.out.println();
					    		} 
					    		
					    			 g.setColor(Color.yellow);
						        	 
										g.fillRect(q2_x-5,q2_y-5,10,10);
										//System.out.println();
					    		
										for(int k=0;k<q2s_x.length;k++)
										{
											q2s_x[k]=0;
											q2s_y[k]=0;
										}
										 q2_x=0;
										 q2_y=0;
												 
					        	 
						    	  
					         
					          
					        	 
					    		}
					    	
					    	
					    
					    		
					    	if(AS)
					    	{
					    		
					    	//System.out.println("point as ");
					    		for(int j=0;j<q2as_x.length;j++)
						        	
					    		{
					    		
					    			g.setColor(Color.green);
					    			 g.fillRect(q2as_x[j]-7, q2as_y[j]-7, 15, 15);
					                 g.drawOval(q2as_x[j]-q2asr[j],q2as_y[j]-q2asr[j],q2asr[j]*2,q2asr[j]*2);
									//System.out.println();
									
					    		}

					    		
					    		g.setColor(Color.yellow);
					    			g.fillRect(q2_ASX-7, q2_ASY-7, 15, 15);
					                 g.drawOval(q2_ASX-q2_ASR,q2_ASY-q2_ASR,q2_ASR*2,q2_ASR*2);
									//System.out.println();
									
									for(int j=0;j<q2as_x.length;j++)
									{
										q2as_x[j]=0;
										q2as_y[j]=0;
										q2asr[j]=0;
										
									}
									
					    		q2_ASX=0;
					    		q2_ASY=0;
					    		q2_ASR=0;
					    		
									
						        		
							    		}
					        	
						  
						  
		        
					    	
					    	if(BUILDING)
				        	{
					    		for(int k=0;k<q2bp.length;k++)
									
				        		{
								g.setColor(Color.green);	
								g.drawPolygon(q2bp[k]);
								}
                                for(int m=0;m<q2BP.length;m++)
									
				        		{	
					    		
								g.setColor(Color.yellow);	
								g.drawPolygon(q2BP[m]);
								
				        		}
				        	}
					    	

				    		for(int k=0;k<q2bp.length;k++)
								
			        		{
						      q2bp[k].reset();
							}
				    		for(int m=0;m<q2BP.length;m++)
								
			        		{	
				    		
							q2BP[m].reset();
							
			        		}
					    
			 
						  
						     
			    	
					   }
		}   
		
						  
			    else if(rangequery)
		        {	
			    	
		        	
		        	 if(q3evt.getButton() == MouseEvent.BUTTON1)
			          {
		        		 
		        		 if(flag)
					    	{
		        			 System.out.println("inside if");
					    	flag=false;
					    		lastx=0;
					    		lasty=0;
					    		poly="";
					    		fx=0;
					    		fy=0;
					    		 for(int i=0;i<q3x.size()-1;i++)
					    		 {
					    		q3x.clear();
					    		q3y.clear();
					    		 }
					    		 for(int i=0;i<q3s_x.length;i++)
						        	{
						        		
						        		if(q3s_x[i]!=0)
						        		{
						        	       q3s_x[i]=0;
						        	       q3s_y[i]=0;
						        		}
						        	}
					    		 for(int j=0;j<q3a_x.length;j++)
						        	{
						        		if(q3a_x[j]!=0)
						        		{
						        	       q3a_x[j]=0;
						        	       q3a_y[j]=0;
						        	       q3r[j]=0;
						               
						        		}
						        	}
					    		 for(int k=0;k<p.length;k++)
							 		{
									q3p[k].reset();
									}
					    		 
					    		
					    	}
			    		
			    		//panel.repaint();
			    		
			            int x1= q3evt.getX();
			            int y1= q3evt.getY();
			            
			            System.out.println("Drawing a polygon :"+x1+" , "+y1);
			            
			            if(poly.equals(""))
			            {
			                poly+=x1+","+y1+",";
			                lastx=x1;lasty=y1;
			                fx=x1;fy=y1;
			                q3x.add(x1);
			                q3y.add(y1);
			                
			            }
			            else
			            {
			               g.setColor(Color.red);
			               
			               
			                //g.drawLine(lastx, lasty, x, y);
			               // panel.repaint();
			                
			                poly+=x1+","+y1+",";
			                lastx=x1;lasty=y1;
			                q3x.add(x1);
			                q3y.add(y1);
			                System.out.println(q3x);
			                System.out.println(q3y);
			                for(int i=0;i<q3x.size()-1;i++)
			                {
			                	g.drawLine(q3x.get(i), q3y.get(i), q3x.get(i+1), q3y.get(i+1));
			                System.out.println(q3x.get(i));
			                }
			            }
			        }
			        
			    	else  if(q3evt.getButton() == MouseEvent.BUTTON3)
			            {
			               flag=true;
			                int x= q3evt.getX();
			                int y= q3evt.getY();
			               // poly+=x+","+y;
			                q3x.add(x);
			                q3y.add(y);
		
			                g.setColor(Color.red);
			                g.drawLine(lastx, lasty, x, y);
			                
			               // panel.repaint();
			                
			                lastx=x;lasty=y;
			                
			               // g.drawLine(lastx, lasty, fx, fy);
			                
			                for(int i=0;i<q3x.size()-1;i++)
			                {
			                	g.drawLine(q3x.get(i), q3y.get(i), q3x.get(i+1), q3y.get(i+1));
			                }
			                g.drawLine(lastx, lasty, fx, fy);
			                
			               // System.out.println(poly);
			            }
			        
		        	if(rangequery && submit)
		        {
		        	//System.out.println("inside range query in paint component");
		        	System.out.println(q3s_x[1]+"  "+q3s_x[2]);
		        	
		        	if(STUDENTS)
		        	{
		        		//System.out.println("students");
		        	for(int i=0;i<q3s_x.length;i++)
		        	{
		        		
		        		if(q3s_x[i]!=0)
		        		{
		        	       g.setColor(Color.GREEN);
		                   g.fillRect(q3s_x[i]-5, q3s_y[i]-5, 10, 10);
		        		}
		        	}
		        	
		        	}
		        if(AS)
		        	{
		        	for(int j=0;j<q3a_x.length;j++)
		        	{
		        		if(q3a_x[j]!=0)
		        		{
		        	       g.setColor(Color.RED);
		                   g.fillRect(q3a_x[j]-7, q3a_y[j]-7, 15, 15);
		                   g.drawOval(q3a_x[j]-q3r[j],q3a_y[j]-q3r[j],q3r[j]*2,q3r[j]*2);
		                   
		        		}
		        	}
		        	}
		        	
		        	if(BUILDING)
		        		
		        	{
		        		//System.out.println("inside q3 paint");
		        		for(int k=0;k<p.length;k++)
				 		{
						g.setColor(Color.yellow);	
						g.drawPolygon(q3p[k]);
						}
		        	}
		        	
		        }
		        }
		        
			     
		        	else if(emer_query){
		        		g.setColor(Color.RED);
			             g.fillRect(q5ann_x-7, q5ann_y-7, 15, 15);
			             g.drawOval(q5ann_x-q5ann_r,q5ann_y-q5ann_r,q5ann_r*2,q5ann_r*2);
			              
			             
		        		for(int j=0;j<q5a_x.length;j++)
			        	{
			        		if(q5a_x[j]!=0)
			        		{
			        	       g.setColor(Color.GREEN);
			                   g.fillRect(q5a_x[j]-5, q5a_y[j]-5, 10, 10);
			                   //g.drawOval(q5a_x[j]-q5a_r[j],q5a_y[j]-q5a_r[j],q5a_r[j]*2,q5a_r[j]*2);
			                   
			        		}
			        	
			        	}
		        		
		        		
		        		
			    
		        		
		        	}
		        
		
		        	else if(sr_stdnt)
			        {
			        	 g.setColor(Color.RED);
			             g.fillRect(q4ann_x-7, q4ann_y-7, 15, 15);
			             g.drawOval(q4ann_x-q4r,q4ann_y-q4r,q4r*2,q4r*2);
			             
			             if(submit && sr_stdnt)
			             {
			            	 for(int k=0;k<q4a_x.length;k++)
			            	 {
			            	 g.setColor(Color.GREEN);
			                 g.fillRect(q4a_x[k]-5, q4a_y[k]-5, 10, 10);
			            	 }
			             }
			             for(int k=0;k<q4a_x.length;k++)
		            	 {
		            	q4a_x[k]=0;
		            	q4a_y[k]=0;
		            	 }
			             
			              
			        }
		        	
		        		
		        
		        		
			}        	
		        	
		        
		        
			
	};
			
	
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				
			/*	Graphics g=panel.getGraphics();
				  g.clearRect(0,0,getWidth(),getHeight());
				    g.drawImage(img, 0, 0, 820, 580, null);*/
				System.out.println("Location: "+evt.getX()+", "+evt.getY());
				q2evt=evt;
				q3evt=evt;
				if(sr_stdnt)
				{
				query_4A(evt.getX(),evt.getY());
				}
				else if(rangequery)
				{   
					panel.repaint();
				}
			
				else if(pointquery)
				{   	//BufferedImage img;    
					
					     panel.repaint();
			}
				else if(emer_query)
				{
					query5();
					query_5B();
				}
			
			}	
		});
			
			    		  
				
				
		
		    
		    
				
				
				
				
			
				
		  setTitle("GARIMA BAWEJA      USC-ID: 6751532114 ");  
				
		
		panel.setBounds(0, 0, 820, 580);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Active Feature Type");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(830, 27, 167, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		
		chckbxNewCheckBox = new JCheckBox("AS"); 
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox.isSelected())
		    	  { 
		    		  AS=true;
		    		  
		    	  }
				else
				{ 
					AS=false;
				}
			}
		});
		
		 
			
		chckbxNewCheckBox.setBounds(837, 55, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Building");
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox_1.isSelected())
		    	  {
					
		    		  BUILDING=true;
		    		  
		    	  }
				else
				{
					BUILDING=false;
				}
			}
		});
		
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		chckbxNewCheckBox_1.setBounds(837, 95, 81, 23);
		getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Students");
		chckbxNewCheckBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox_2.isSelected())
		    	  {
		    		  
		    		  STUDENTS=true;
		    	  }
				else
				{
					STUDENTS=false;
				}
			}
		});
		
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxNewCheckBox_2.setBounds(927, 95, 91, 23);
		getContentPane().add(chckbxNewCheckBox_2);
		
		
		
		JLabel lblQuery = new JLabel("Query");
		lblQuery.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuery.setBounds(837, 182, 75, 29);
		getContentPane().add(lblQuery);
		
	
		
		rdbtnNewRadioButton = new JRadioButton("Whole Region");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton.isSelected())
		    	  {Graphics g=panel.getGraphics();
				 g.clearRect(0,0,getWidth(),getHeight());
				    g.drawImage(img, 0, 0, 820, 580, null);
		    		  
		    		  wholeregion=true;
		    		  pointquery=false;
		    		  rangequery=false;
		    		  emer_query=false;
		    		  sr_stdnt=false;
		    		  	  
		    	  }
				else
				{
					wholeregion=false;
				}
			
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(837, 230, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Point Query");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton_1.isSelected())
		    	  {
					Graphics g=panel.getGraphics();
					 g.clearRect(0,0,getWidth(),getHeight());
					    g.drawImage(img, 0, 0, 820, 580, null);
		    		  wholeregion=false;
		    		  pointquery=true;
		    		  rangequery=false;
		    		  emer_query=false;
		    		  sr_stdnt=false;
		    		  	  
		    	  }
				else
				{
					pointquery=false;
				}
			
		
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(837, 256, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Range Query");
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (rdbtnNewRadioButton_2.isSelected())
		    	  {
					Graphics g=panel.getGraphics();
					g.clearRect(0,0,getWidth(),getHeight());
					    g.drawImage(img, 0, 0, 820, 580, null);
					    wholeregion=false;
			    		  pointquery=false;
			    		  rangequery=true;
			    		  emer_query=false;
			    		  sr_stdnt=false;
		    		
		    	  }
				else
				{
					rangequery=false;
				}
			
				
				
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(837, 282, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Surrounding Student");
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton_3.isSelected())
		    	  {
					Graphics g=panel.getGraphics();
					g.clearRect(0,0,getWidth(),getHeight());
					    g.drawImage(img, 0, 0, 820, 580, null);
		    		  wholeregion=false;
		    		  pointquery=false;
		    		  rangequery=false;
		    		  emer_query=false;
		    		  sr_stdnt=true;
		    		  
		    		  	  
		    	  }
				else
				{
					sr_stdnt=false;
				}
			}
		});
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_3.setBounds(837, 308, 181, 23);
		getContentPane().add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Emergency Query");
		rdbtnNewRadioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNewRadioButton_4.isSelected())
		    	  {
					Graphics g=panel.getGraphics();
					 g.clearRect(0,0,getWidth(),getHeight());
					    g.drawImage(img, 0, 0, 820, 580, null);
		    		  wholeregion=false;
		    		  pointquery=false;
		    		  rangequery=false;
		    		  emer_query=true;
		    		  sr_stdnt=false;
		    		  	  
		    	  }
				else
				{
					emer_query=false;
				}
			}
		});
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_4.setBounds(837, 334, 142, 23);
		getContentPane().add(rdbtnNewRadioButton_4);
		
		ButtonGroup rb_group = new ButtonGroup();
	    rb_group.add(rdbtnNewRadioButton);
	    rb_group.add(rdbtnNewRadioButton_1);
	    rb_group.add(rdbtnNewRadioButton_2);
	    rb_group.add(rdbtnNewRadioButton_3);
	    rb_group.add(rdbtnNewRadioButton_4);
		
		JButton btnNewButton = new JButton("Submit Query");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit=true;
				
				populate pop4=new populate();
				if(wholeregion){
				if(AS)
				{
					//populate pop4=new populate();
					pop4.ConnectToDB();
					displayAS(pop4.mainStatement, pop4.mainConnection);
				}
				
				if(BUILDING)
				{
					//populate pop3=new populate();
					pop4.ConnectToDB();
					B_display(pop4.mainStatement, pop4.mainConnection);
				}
				if(STUDENTS)
				{
					
					pop4.ConnectToDB();
					Display_Tuples(pop4.mainStatement, pop4.mainConnection);
				}
				}
				else if(sr_stdnt)
				{
					
					pop4.ConnectToDB();
					query_4B();
				}
				
				else if(rangequery)
				{  
				if(AS)
					query3AS();
				if(BUILDING)
						QueryThreeBuilding();
					if(STUDENTS)
					QueryThree();
				}
				
				else if(pointquery)
				{
					if(STUDENTS)
					{
						query2_st();
					query2B_st();
					}
					if(AS)
					{
						
						query2as();
					    query2B_as();
					}
					if(BUILDING)
						{
						query2_b();
					query2B_b();
				}
					}
				else if(emer_query)
				{
					query5C();
				}
				
				}
				
			
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(830, 549, 177, 23);
		getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 591, 809, 66);
		JScrollPane scrollPane = new JScrollPane(); 
		scrollPane.setBounds(20,591, 809, 66);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(textArea);
	
		
		
		
		
		lblMouse = new JLabel("Mouse");
		getContentPane().addMouseMotionListener(new MouseMotionAdapter(){
		public void mouseMoved(MouseEvent evt)
			{
				lblMouse.setText("Location: "+evt.getX()+", "+evt.getY());
				
				
				
			}
		});
		lblMouse.setBounds(830, 384, 188, 49);
		getContentPane().add(lblMouse);
		
		this.setVisible(true);
		this.setBounds(0, 0, 1046,788);
	}

	

	  
	
public void Display_Tuples(Statement mainStatement,Connection mainConnection)
{
	
	STRUCT point;		//Structure to handle Geometry Objects
	Geometry geom;

   
	try
	{
		
		GeometryAdapter sdoAdapter = OraSpatialManager.getGeometryAdapter("SDO", "9",STRUCT.class, null, null, mainConnection);
		 
 			                     // searches for all tuples
 	       // System.out.println("\n ** Selecting all tuples in the table **" );
 	        mainResultset = mainStatement.executeQuery( "select * from STUDENTS" );
 	        textArea.append("Query "+count+": select * from STUDENTS \n");
 	        count++;
 	       
 	      
	      //System.out.println("\n ** Showing all Tuples ** " );
  
	    	   
  		int m=0;
  		
  			  	while(mainResultset.next())
	    {
    	    
  			  		//System.out.print( "Tuple " + tupleCount++ + " : " );

    	    point = (STRUCT)mainResultset.getObject(2);
			geom = sdoAdapter.importGeometry( point );
  			if ( (geom instanceof oracle.sdoapi.geom.Point) )
  			{
				oracle.sdoapi.geom.Point point0 =(oracle.sdoapi.geom.Point) geom;
				double X = point0.getX();
				double Y = point0.getY();
				System.out.print( "\"(X = " + X + ", Y = " + Y + ")\"" );
				x_pt[m]=X;
				y_pt[m]=Y;
				//textField.append("select * from STUDENTS");
				//System.out.println(x_pt[i]);
					
			}
  			//System.out.println(i);
  			m++; 
			// System.out.println(m);
  			
	    }
  			  
  	
	
	panel.repaint();
		
  		
	}


	catch( Exception e )
    { 
		System.out.println(" Error : " + e.toString() ); 
    }

	//System.out.println();
	}



public void displayAS(Statement mainStatement,Connection mainConnection)
{
	
	STRUCT point;		//Structure to handle Geometry Objects
	Geometry geom;
	
	//pop.ConnectToDB();
	int p=0;
	try
	{
		GeometryAdapter sdoAdapter = OraSpatialManager.getGeometryAdapter("SDO", "9",STRUCT.class, null, null, mainConnection);
		 
		 
 		
 	        //System.out.println("\n ** Selecting all tuples in the table **" );
 	       
 	        mainResultset = mainStatement.executeQuery( "select * from ANNOUNCEMENTSYSTEMS");
 	       textArea.append("Query "+count+": select * from ANNOUNCEMENTSYSTEMS \n");
	        count++;
 	       
	    //System.out.println("\n ** Showing all Tuples ** " );
        	   
  			  	while(mainResultset.next())
	    {
  			  		{  
  			  		System.out.print( "Tuple " + tupleCount++ + " : " );
    	    point = (STRUCT)mainResultset.getObject(2);
			geom = sdoAdapter.importGeometry( point );
  			if ( (geom instanceof oracle.sdoapi.geom.Point) )
  			{
				oracle.sdoapi.geom.Point point0 =(oracle.sdoapi.geom.Point) geom;
				double X = point0.getX();
				double Y = point0.getY();
				
				System.out.print( "\"(X = " + X + ", Y = " + Y + ")\"" );
				a_pt[p]=X;
				b_pt[p]=Y;
				
				
				//System.out.println(x_pt[i]);
					
			}
  			
  			 c_pt[p]=mainResultset.getInt(3);
  			//System.out.println(p);
	    }
  			//System.out.println(i);
  			p++; 
			// System.out.println();
  			
	    }
	 		  
  	  panel.repaint();
  		
		
	}
	

	catch( Exception e )
    { 
		System.out.println(" Error : " + e.toString() ); 
    }

	System.out.println();
}


public void query_4A(int evx,int evy)
{
	{
		populate p1=new populate(); 
	   Graphics g;

	 try
	 {
			ResultSet mainResultSet = p1.mainStatement.executeQuery( "select a.shape.sdo_point.x x,a.shape.sdo_point.y y,a.radius radius from announcementSystems a \n" + 
"where sdo_nn(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+evx+", "+evy+",NULL),NULL,NULL), 'sdo_num_res=1') = 'TRUE'" );
			
		textArea.append("Query "+count+": select a.shape.sdo_point.x x,a.shape.sdo_point.y y,a.radius radius from announcementSystems a where sdo_nn(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+evx+", "+evy+",NULL),NULL,NULL), 'sdo_num_res=1') = 'TRUE'\n ");
		count++;
			
	  while( mainResultSet.next() )
	    {
		  q4ann_x = mainResultSet.getInt("x");
          q4ann_y = mainResultSet.getInt("y");
          q4r=mainResultSet.getInt("radius");
          //System.out.println(q4ann_x+","+q4ann_y);
          
       
 	    }

	  panel.repaint();
  }
	catch( Exception e)
    { 
		System.out.println(" Error : " + e.toString() );
    }
	}

}
public void query_5B()
{
	{
		populate p1=new populate(); 
	   
		//System.out.println("Inside QueryFourPartB");
	   Graphics g;
       int i=0;
	 try
	 {
		//System.out.println("select s.location.sdo_point.X X,s.location.sdo_point.Y Y from students s where sdo_inside(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+(q5ann_x-q5ann_r)+", "+q5ann_y+", "+q5ann_x+", "+(q5ann_y+q5ann_r)+", "+(q5ann_x+q5ann_r)+","+q5ann_y+" )))='TRUE'" );	
		 ResultSet mainResultSet = p1.mainStatement.executeQuery( "select s.location.sdo_point.X X,s.location.sdo_point.Y Y from students s \n"+
					"where sdo_inside(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+(q5ann_x-q5ann_r)+", "+q5ann_y+", "+q5ann_x+", "+(q5ann_y+q5ann_r)+", "+(q5ann_x+q5ann_r)+","+q5ann_y+" )))='TRUE'" );
		
		 textArea.append("Query "+count+": select s.location.sdo_point.X X,s.location.sdo_point.Y Y from students s where sdo_inside(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+(q5ann_x-q5ann_r)+", "+q5ann_y+", "+q5ann_x+", "+(q5ann_y+q5ann_r)+", "+(q5ann_x+q5ann_r)+","+q5ann_y+" )))='TRUE' \n" );
		 count++;
		 
	  while( mainResultSet.next() )
	    {
		  q5a_x[i] = mainResultSet.getInt(1);
          q5a_y[i] = mainResultSet.getInt(2);
        //  System.out.println("q5a_x "+i+" : "+q5a_x[i]+","+q5a_y[i]);
          i++;
         
	    }
	  
	  panel.repaint();
  }
	catch( Exception e)
    { 
		System.out.println(" Error : " + e.toString() );
    }
	}

}

public void query5C()
{

populate p1=new populate();
//int j=0;
    try
{
   ResultSet mainResultSet1;
   //System.out.println("Inside query 5cc");
for(int i=0;i<q5a_x.length;i++)
{
	//System.out.println("inside for");
if(q5a_x[i]!=0 && q5a_y[i]!=0)
{
//System.out.println("q5a_x :"+q5a_x[i]);
//System.out.println("q5a_y :"+q5a_y[i]);

mainResultSet1=p1.mainStatement.executeQuery( "select a.asID a_id,a.shape.sdo_point.x X,a.shape.sdo_point.y Y,a.radius radius from announcementSystems a \n" + 
                "where sdo_nn(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q5a_x[i]+", "+q5a_y[i]+",NULL),NULL,NULL), 'sdo_num_res=2') = 'TRUE' \n"+
"and a.asID <> '"+aID+"'");

textArea.append("Query "+count+": select a.asID a_id,a.shape.sdo_point.x X,a.shape.sdo_point.y Y,a.radius radius from announcementSystems a where sdo_nn(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q5a_x[i]+", "+q5a_y[i]+",NULL),NULL,NULL), 'sdo_num_res=2') = 'TRUE' and a.asID <> '"+aID+"'\n ");
count++;
//System.out.println(query);
while( mainResultSet1.next() )
 	   {
if(mainResultSet1.isFirst())
{	 


q5c_x= mainResultSet1.getInt("X");
q5c_y=mainResultSet1.getInt("Y");
         q5c_r=mainResultSet1.getInt("radius");
         q5a_id=mainResultSet1.getString("a_id");
         // System.out.println(q2a_x[i]+","+q2a_y[i]);*/

//System.out.println("Final Query 5:");
System.out.println("q5c_x :"+q5c_x+"q5c_y :"+q5c_y);



Graphics g=panel.getGraphics();
//g.setColor(Color.GREEN);


if(q5a_id.equals("a1psa"))

g.setColor(Color.ORANGE);

else if(q5a_id.equals("a2ohe"))
g.setColor(Color.GREEN);
else if(q5a_id.equals("a3sgm"))
g.setColor(Color.BLUE);
else if(q5a_id.equals("a4hnb"))
g.setColor(Color.MAGENTA);
else if(q5a_id.equals("a5vhe"))
g.setColor(Color.YELLOW);
else if(q5a_id.equals("a6ssc"))
g.setColor(Color.WHITE);
else if(q5a_id.equals("a7helen"))
g.setColor(Color.PINK);


g.fillRect(q5a_x[i]-5,q5a_y[i]-5, 10, 10);

//g.setColor(Color.RED);
g.fillRect(q5c_x-7,q5c_y-7, 15, 15);
g.drawOval(q5c_x-q5c_r, q5c_y-q5c_r,q5c_r*2 , q5c_r*2);
}

 	   } 
}

}
for(int j=0;j<q5a_x.length;j++)
{
	if(q5a_x[j]!=0)
	{
       //g.setColor(Color.GREEN);
       q5a_x[j]=0;
       q5a_y[j]=0;
	}

}


}
    catch( Exception e )
    { 
System.out.println(" Error : " + e.toString()); 
    }
}





public void query2B_st()
{
	populate p1=new populate();
	
      //int i=0;
      int q2x=q2evt.getX();
      int q2y=q2evt.getY();
      
    //  System.out.println("Inside point Query a student");
      System.out.println(q2x+""+q2y);

        try
    {
       ResultSet mainResultSet1=p1.mainStatement.executeQuery("select s.location.sdo_point.x X,s.location.sdo_point.y Y FROM STUDENTS s WHERE SDO_NN(s.location,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2x+","+q2y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_INSIDE(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE'");
        
    	textArea.append(" Query "+count+": select s.location.sdo_point.x X,s.location.sdo_point.y Y FROM STUDENTS s WHERE SDO_NN(s.location,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2x+","+q2y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_INSIDE(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE' \n");	
       //System.out.println("printing values for student in query2a:");	
    	count++;	
    		  while( mainResultSet1.next() )
    	    {
    		   q2_x = mainResultSet1.getInt("X");
               q2_y = mainResultSet1.getInt("Y");
              System.out.println(q2_x+","+q2_y);
              
    	    } 
    		
    		  

       panel.repaint();

}
        catch( Exception e )
        { 
    		System.out.println(" Error : " + e.toString()); 
        }


}

public void query2B_as()
{
	populate p1=new populate();
	
      //int i=0;
      int q2x=q2evt.getX();
      int q2y=q2evt.getY();
      
      //System.out.println("Inside point Query b as");
      System.out.println(q2x+""+q2y);

        try
    {
       ResultSet mainResultSet1=p1.mainStatement.executeQuery("select a.shape.sdo_point.X X,a.shape.sdo_point.Y Y,a.radius R FROM ANNOUNCEMENTSYSTEMS a where SDO_NN(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2x+","+q2y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_ANYINTERACT(a.shape,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE'");
      textArea.append(" Query "+count+": select a.shape.sdo_point.X X,a.shape.sdo_point.Y Y,a.radius R FROM ANNOUNCEMENTSYSTEMS a where SDO_NN(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2x+","+q2y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_ANYINTERACT(a.shape,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE' \n");
    	count++;	
      //System.out.println("printing values for AS in query2B:");	
    		
    		  while( mainResultSet1.next() )
    	    {
    		   q2_ASX = mainResultSet1.getInt("X");
               q2_ASY = mainResultSet1.getInt("Y");
               q2_ASR = mainResultSet1.getInt("R");
              System.out.println(q2_ASX+","+q2_ASY+","+q2_ASR);
              
    	    } 
    		
    		  

       panel.repaint();

}
        catch( Exception e )
        { 
    		System.out.println(" Error : " + e.toString()); 
        }


}





		
		public void query2_st()
		{
			populate p1=new populate();
			
		      
		      int q2x=q2evt.getX();
		      int q2y=q2evt.getY();
		      
		      System.out.println(q2x+""+q2y);
		
	            try
	        {
	           ResultSet mainResultSet1=p1.mainStatement.executeQuery("select s.location.sdo_point.x X,s.location.sdo_point.y Y FROM STUDENTS s WHERE SDO_ANYINTERACT(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE'");
	            
               textArea.append(" Query "+count+": select s.location.sdo_point.x X,s.location.sdo_point.y Y FROM STUDENTS s WHERE SDO_ANYINTERACT(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE' \n");
	           count++;	
	        		
	        		  while( mainResultSet1.next() )
	        	    {
	        		   q2s_x[j] = mainResultSet1.getInt(1);
	                   q2s_y[j] = mainResultSet1.getInt(2);
	                  System.out.println(q2s_x[j]+","+q2s_y[j]);
	                  j++;
	        	    } 

		       panel.repaint();
		
		}
	            catch( Exception e )
	            { 
	        		System.out.println(" Error : " + e.toString()); 
	            }
	

	}
		
		public void query2as()
		{
			populate p1=new populate();
			
		      int i=0;
		      int q2x=q2evt.getX();
		      int q2y=q2evt.getY();
		      
		      //System.out.println("Inside point quuery AS parta");
		      System.out.println(q2x+","+q2y);
		
	          try    // select s.location.sdo_point.x X,s.location.sdo_point.y Y FROM STUDENTS s WHERE SDO_ANYINTERACT(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE'");
	      {
	         ResultSet mainResultSet1=p1.mainStatement.executeQuery("select a.shape.sdo_point.X X,a.shape.sdo_point.Y Y,a.radius R FROM ANNOUNCEMENTSYSTEMS a \n"+ 
	                                         "where SDO_ANYINTERACT(a.shape,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE'");
	         textArea.append(" Query "+count+": select a.shape.sdo_point.X X,a.shape.sdo_point.Y Y,a.radius R FROM ANNOUNCEMENTSYSTEMS a where SDO_ANYINTERACT(a.shape,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2x-50)+","+q2y+","+q2x+","+(q2y+50)+","+(q2x+50)+","+q2y+")))='TRUE' \n");
	      		
	      	count++;	 
	         while( mainResultSet1.next() )
	      	    {
	      		   q2as_x[i] = mainResultSet1.getInt("X");
	               q2as_y[i] = mainResultSet1.getInt("Y");
	               q2asr[i]=mainResultSet1.getInt("R");
	               System.out.println(q2as_x[i]+","+q2as_y[i]+","+q2asr[i]);
	              // System.out.println("WHILE");
	               i++;
	      	    } 

		       panel.repaint();
		
		}
	          catch( Exception e )
	          { 
	      		System.out.println(" Error : " + e.toString()); 
	          }
		}
		public void query2_b()
		{
			populate p1=new populate();
			
		      //int i=0;
		      int q2bx=q2evt.getX();
		      int q2by=q2evt.getY();
		      
		     // System.out.println("Inside point query A BUILDING");
		      System.out.println(q2bx+""+q2by);
		
	        try
	    {
	       ResultSet mainResultset3=p1.mainStatement.executeQuery("select b.building_id, b1.X,b1.Y from BUILDINGS b,table(mdsys.sdo_util.getvertices(b.shape))b1 where SDO_relate(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2bx-50)+","+q2by+","+q2bx+","+(q2by+50)+","+(q2bx+50)+","+q2by+")),'mask=ANYINTERACT')='TRUE'");
	       textArea.append(" Query "+count+": select b.building_id, b1.X,b1.Y from BUILDINGS b,table(mdsys.sdo_util.getvertices(b.shape))b1 where SDO_relate(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2bx-50)+","+q2by+","+q2bx+","+(q2by+50)+","+(q2bx+50)+","+q2by+")),'mask=ANYINTERACT')='TRUE' \n"); 
	       count++;
	    		//System.out.println("printing values for BUILDING in query2A:");	
	    		
	    		  str="";
	   		   str1="";
	   		   ctr=-1;
	   		   int x0=0;
	   		   int y0=0;	
	   			
	   		  // System.out.println("printing values for Building:");	
	   		
	              
	   		 while(mainResultset3.next())
	   	            
	   	        {
	   	            x0 = Integer.parseInt(mainResultset3.getString(2));
	   	            y0 = Integer.parseInt(mainResultset3.getString(3));
	   	            if((str=mainResultset3.getString(1)).equalsIgnoreCase(str1))
	   	            {
	   	                q2bp[ctr].addPoint(x0, y0);
	   	                //System.out.println("Q3 Building :  "+q3p[ctr]);
	   	            }
	   	            else
	   	            {
	   	                str1 = str;
	   	                ctr++;
	   	                q2bp[ctr].addPoint(x0, y0);
	   	               // System.out.println("Q3 Building :  "+q3p[ctr]);
	   	            }
	   	            
	   	        }
	   		 panel.repaint();
		}
	        catch( Exception e )
	        { 
	    		System.out.println(" Error : " + e.toString()); 
	        }
		
		
		}

		public void query2B_b()
		{
			populate p1=new populate();
			
		      //int i=0;
		      int q2bx=q2evt.getX();
		      int q2by=q2evt.getY();
		      
		     // System.out.println("Inside point wuery b building");
		      System.out.println(q2bx+""+q2by);
		      
	        try
	        //select b.building_id, b.shape.sdo_point.x x, b.shape.sdo_point.y y from BUILDINGS b where SDO_NN(b.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type(400,300,NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_ANYINTERACT(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY(300,400,400,500,500,400)))='TRUE'
	    {
	       ResultSet mainResultset3=p1.mainStatement.executeQuery("SELECT b.building_id, COORD.x, COORD.y FROM buildings b, TABLE(SDO_UTIL.GETVERTICES(b.shape)) COORD WHERE SDO_NN(b.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2bx+","+q2by+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_ANYINTERACT(b.shape, SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2bx-50)+","+q2by+","+q2bx+","+(q2by+50)+","+(q2bx+50)+","+q2by+"))) = 'TRUE'");
	       textArea.append(" Query "+count+": SELECT b.building_id, COORD.x, COORD.y FROM buildings b, TABLE(SDO_UTIL.GETVERTICES(b.shape)) COORD WHERE SDO_NN(b.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q2bx+","+q2by+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' AND SDO_ANYINTERACT(b.shape, SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,4),SDO_ORDINATE_ARRAY("+(q2bx-50)+","+q2by+","+q2bx+","+(q2by+50)+","+(q2bx+50)+","+q2by+"))) = 'TRUE' \n");
	    	count++;
	    		
	    		  str="";
	   		   str1="";
	   		   ctr=-1;
	   		   int x0=0;
	   		   int y0=0;	
	   			
	   		  // System.out.println("printing values for Building B:");	
	   		
	              
	   		 while(mainResultset3.next())
	   	            
	   	        {
	   	            x0 = Integer.parseInt(mainResultset3.getString(2));
	   	            y0 = Integer.parseInt(mainResultset3.getString(3));
	   	            if((str=mainResultset3.getString(1)).equalsIgnoreCase(str1))
	   	            {
	   	                q2BP[ctr].addPoint(x0, y0);
	   	                //System.out.println("Q3 Building :  "+q3p[ctr]);
	   	            }
	   	            else
	   	            {
	   	                str1 = str;
	   	                ctr++;
	   	                q2BP[ctr].addPoint(x0, y0);
	   	               // System.out.println("Q3 Building :  "+q3p[ctr]);
	   	            }
	   	            
	   	        }
	   		 panel.repaint();
		}
	        catch( Exception e )
	        { 
	    		System.out.println(" Error : " + e.toString()); 
	        }
		
		
		}

		
public void QueryThreeBuilding()
{
	q3polyb="";
	populate p1=new populate(); 
	//System.out.println("inside query three.");
	 for(int i=0;i<q3x.size();i++)
	   { 
		 if(i==q3x.size()-1)
			 q3polyb+=q3x.get(i)+","+q3y.get(i); 
		 else 
		     q3polyb+=q3x.get(i)+","+q3y.get(i)+",";
		 
		   //System.out.println(q3x.size());
		  // System.out.println("x :"+q3x.get(i));
		 
	   }
	   //System.out.println("inside query3as poly: "+q3polyb);
	  
	   //System.out.println("inside QueryThreeAS");
	   
	 try
	 {
			//ResultSet mainResultset = p1.mainStatement.executeQuery( "select s1.x X,s1.y Y from students s,table(mdsys.sdo_util.getvertices(s.student_location))s1 \n"+
                //                       "where SDO_relate(s.student_location,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3poly+")),'mask=ANYINTERACT')='TRUE'" );
			
			//ResultSet mainResultset=p1.mainStatement.executeQuery("select as1.x,as1.y,asys.radius R from announcementSystems asys,table(mdsys.sdo_util.getvertices(asys.as_location))as1 \n"+ 
              //                       "where SDO_relate(asys.as_location,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3polyas+")),'mask=ANYINTERACT')='TRUE'");
			
			ResultSet mainResultset=p1.mainStatement.executeQuery("select b.building_id, b1.x,b1.y from BUILDINGS b,table(mdsys.sdo_util.getvertices(b.shape))b1 where SDO_relate(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3polyb+")),'mask=ANYINTERACT')='TRUE'");
			   textArea.append(" Query "+count+": select b.building_id, b1.x,b1.y from BUILDINGS b,table(mdsys.sdo_util.getvertices(b.shape))b1 where SDO_relate(b.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3polyb+")),'mask=ANYINTERACT')='TRUE' \n");
			count++;
			//System.out.println("inside query three.");
			
       str="";
	   str1="";
	   ctr=-1;
	   int x0=0;
	   int y0=0;	
		
	   //System.out.println("printing values for Building:");	
	
       
	 while(mainResultset.next())
            
        {
            x0 = Integer.parseInt(mainResultset.getString(2));
            y0 = Integer.parseInt(mainResultset.getString(3));
            if((str=mainResultset.getString(1)).equalsIgnoreCase(str1))
            {
                q3p[ctr].addPoint(x0, y0);
                //System.out.println("Q3 Building :  "+q3p[ctr]);
            }
            else
            {
                str1 = str;
                ctr++;
                q3p[ctr].addPoint(x0, y0);
               // System.out.println("Q3 Building :  "+q3p[ctr]);
            }
            
        }
	 /*while(mainResultset.next())
	  {	  
		 
       q3a_x[j] = mainResultset.getInt("X");
       q3a_y[j] = mainResultset.getInt("Y");
       q3r[j]   = mainResultset.getInt("R");
       System.out.println(q3a_x[j]+","+q3a_y[j]);
       j++;
	  }*/
       
     panel.repaint();
}
	catch(Exception e)
    { 
		System.out.println(" Error : " + e.toString() );
    }
	}


public void query3AS()
{
	q3polyas="";
	populate p1=new populate(); 
	//System.out.println("inside query three.");
	 for(int i=0;i<q3x.size();i++)
	   { 
		 if(i==q3x.size()-1)
			 q3polyas+=q3x.get(i)+","+q3y.get(i); 
		 else 
		     q3polyas+=q3x.get(i)+","+q3y.get(i)+",";
		 
		   
		 
	   }
	   //System.out.println("inside query3as poly: "+q3polyas);
	  
	  
	   
	 
	 try
	 {
			/*ResultSet mainResultset = p1.mainStatement.executeQuery( "select s1.x X,s1.y Y from students s,table(mdsys.sdo_util.getvertices(s.student_location))s1 \n"+
                                       "where SDO_relate(s.student_location,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3poly+")),'mask=ANYINTERACT')='TRUE'" );*/
			
			ResultSet mainResultset=p1.mainStatement.executeQuery("select as1.x,as1.y,asys.radius R from announcementSystems asys,table(mdsys.sdo_util.getvertices(asys.shape))as1 \n"+ 
                                     "where SDO_relate(asys.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3polyas+")),'mask=ANYINTERACT')='TRUE'");
			
			textArea.append(" Query "+count+": select as1.x,as1.y,asys.radius R from announcementSystems asys,table(mdsys.sdo_util.getvertices(asys.shape))as1 where SDO_relate(asys.shape,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3polyas+")),'mask=ANYINTERACT')='TRUE' \n");
			count++;
		//int i=0,j=0;	
		
	//System.out.println("printing values for AS:");	
	
       
	 while(mainResultset.next())
	  {	  
       q3a_x[j] = mainResultset.getInt("X");
       q3a_y[j] = mainResultset.getInt("Y");
       q3r[j]   = mainResultset.getInt("R");
       //System.out.println(q3a_x[j]+","+q3a_y[j]);
       j++;
	  }
	 q3a_x[j]=0;
	 q3a_y[j]=0;
       
     panel.repaint();
}
	 catch( Exception e)
	    { 
			System.out.println(" Error : " + e.toString() );
	    }

	}


    
     
        

public void QueryThree()
{
	q3poly="";
	populate p1=new populate(); 
	//System.out.println("inside query three.");
	   for(int i=0;i<q3x.size();i++)
	   { 
		 if(i==q3x.size()-1)
			 q3poly+=q3x.get(i)+","+q3y.get(i); 
		 else 
		     q3poly+=q3x.get(i)+","+q3y.get(i)+",";
		 
		 
		  // System.out.println("x :"+q3x.get(i));
		 
	   }
	 //  System.out.println("inside query3student poly: "+q3poly);
	   
	 
	 try
	 {
			ResultSet mainResultset1 = p1.mainStatement.executeQuery( "select s1.X X,s1.Y Y from students s,table(mdsys.sdo_util.getvertices(s.location))s1 \n"+
                                       "where SDO_relate(s.location,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3poly+")),'mask=INSIDE')='TRUE'" );
			
			textArea.append(" Query "+count+": select s1.X X,s1.Y Y from students s,table(mdsys.sdo_util.getvertices(s.location))s1 where SDO_relate(s.location,SDO_GEOMETRY(2003,NULL,NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY("+q3poly+")),'mask=INSIDE')='TRUE' \n" );
		count++;
			int i=0,j=0;	
		
	//System.out.println("printing values for student:");	
	
	  while( mainResultset1.next() )
    {
	   q3s_x[i] = mainResultset1.getInt("X");
       q3s_y[i] = mainResultset1.getInt("Y");
      System.out.println(q3s_x[i]+","+q3s_y[i]);
      i++;
    } 
	 
     
       panel.repaint();

}
	catch( Exception e)
    { 
		System.out.println(" Error : " + e.toString() );
    }
	}



public void B_display(Statement mainStatement,Connection mainConnection)

	{
  ctr=-1;
  
    try
    {
    	
    	GeometryAdapter sdoAdapter = OraSpatialManager.getGeometryAdapter("SDO", "9",STRUCT.class, null, null, mainConnection);
		 
		 
 		
 			                     // searches for all tuples
 	        System.out.println("\n ** Selecting all tuples in the table **" );
 	        mainResultset = mainStatement.executeQuery( "select b.building_id, b.no_of_vertices, COORD.x, COORD.y from BUILDINGS b, TABLE(SDO_UTIL.GETVERTICES(b.shape)) COORD");
 	       textArea.append(" Query "+count+": select b.building_id, b.no_of_vertices, COORD.x, COORD.y from BUILDINGS b, TABLE(SDO_UTIL.GETVERTICES(b.shape)) COORD \n"); 
 	       count++;
 	       
    	while(mainResultset.next())
    
    {
        xco = Integer.parseInt(mainResultset.getString(3));
        yco = Integer.parseInt(mainResultset.getString(4));
        if((str=mainResultset.getString(1)).equalsIgnoreCase(str1))
        {
            p[ctr].addPoint(xco, yco);
        }
        else
        {
            str1 = str;
            ctr++;
            p[ctr].addPoint(xco, yco);
            System.out.println(p[ctr]);
        }
        
    }
    	panel.repaint();
    }
    catch( Exception e )
    { 
		System.out.println(" Error : " + e.toString() ); 
    }
    

	System.out.println();
}

public void query5()
{
	int q5x=q2evt.getX();
	 int q5y=q2evt.getY();
	 
	 populate p1=new populate();
	 int i=1;

	 try
	 {
		 { 
			 //System.out.println("select a.asID, a.shape.sdo_point.X x,a.shape.sdo_point.Y y,a.radius FROM ANNOUNCEMENTSYSTEMS a WHERE SDO_NN(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q5x+","+q5y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE'");
			 
		 mainResultset = p1.mainStatement.executeQuery( "select a.asID, a.shape.sdo_point.X x,a.shape.sdo_point.Y y,a.radius r FROM ANNOUNCEMENTSYSTEMS a WHERE SDO_NN(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q5x+","+q5y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE'");
		
		 textArea.append(" Query "+count+": select a.asID, a.shape.sdo_point.X x,a.shape.sdo_point.Y y,a.radius r FROM ANNOUNCEMENTSYSTEMS a WHERE SDO_NN(a.shape,mdsys.sdo_geometry(2001,NULL,mdsys.sdo_point_type("+q5x+","+q5y+",NULL),NULL,NULL),'sdo_num_res=1') = 'TRUE' \n");
		 count++;
		 
		 // System.out.println("\n ** Showing all Tuples ** " );
  	   
		  	while(mainResultset.next())
 {
		  		aID=mainResultset.getString(1);
               q5ann_x = mainResultset.getInt(2);
               q5ann_y = mainResultset.getInt(3);
               q5ann_r=mainResultset.getInt(4);
               
             
 }
	 
		i++; 
		  System.out.println(q5ann_x+","+q5ann_y+","+q5ann_r);
	 
	}
	 panel.repaint();
}
	 
	 catch( Exception e )
	    { 
			System.out.println(" Error : " + e.toString() ); 
	    }

}
		
public void query_4B()
{
	
	
	{
		populate p1=new populate(); 
	   
		System.out.println("Inside QueryFourPartB");
	   Graphics g;
       int i=0;
	 try
	 {
			ResultSet mainResultSet = p1.mainStatement.executeQuery( "select s.location.sdo_point.x x,s.location.sdo_point.y y from students s \n"+
					"where sdo_inside(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+(q4ann_x-q4r)+", "+q4ann_y+", "+q4ann_x+", "+(q4ann_y+q4r)+", "+(q4ann_x+q4r)+","+q4ann_y+" )))='TRUE'" );
			textArea.append(" Query "+count+": select s.location.sdo_point.x x,s.location.sdo_point.y y from students s where sdo_inside(s.location,mdsys.sdo_geometry(2003,NULL,NULL,mdsys.sdo_elem_info_array(1,1003,4),sdo_ordinate_array("+(q4ann_x-q4r)+", "+q4ann_y+", "+q4ann_x+", "+(q4ann_y+q4r)+", "+(q4ann_x+q4r)+","+q4ann_y+" )))='TRUE' \n" );
			count++;
	  while( mainResultSet.next() )
	    {
		  q4a_x[i] = mainResultSet.getInt("x");
          q4a_y[i] = mainResultSet.getInt("y");
          System.out.println("q4a_x "+i+" : "+q4a_x[i]+","+q4a_y[i]);
          
          int x = mainResultSet.getInt("x");
          int y = mainResultSet.getInt("y");
          System.out.println(x+","+y);
          
          
          /* g = panel.getGraphics();
          g.setColor(Color.GREEN);
          g.fillRect(x-5, y-5, 10, 10);*/
          i++;
 	    }

	  panel.repaint();
  }
	catch( Exception e)
    { 
		System.out.println(" Error : " + e.toString() );
    }
	}
}
}
	
	