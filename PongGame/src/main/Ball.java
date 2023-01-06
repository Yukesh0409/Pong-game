

package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import static main.Main.b;
import static sun.applet.AppletResourceLoader.getImage;


public class Ball implements Runnable{

    int x,y,xDirection,yDirection;
    Rectangle ball;
        Paddle p1=new Paddle(15,140,1);
        Paddle p2=new Paddle(770,140,2);
        
        int p1Score,p2Score;
        

       
        Image BallImage;
    
    public Ball(int x,int y)
    {
        p1Score=p2Score=0;
    this.x=x;
    this.y=y;
    Random r=new Random();
    int rDir=r.nextInt(1);
    if(rDir==0)
    {
    rDir--;
   
    }
     setXDirection (rDir);
     
       int yrDir=r.nextInt(1);
    if(yrDir==0)
    {
    yrDir--;
   
    }
     setYDirection (yrDir);
     ball=new Rectangle(this.x,this.y , 15,15);
    
    
    }
    
    public void setXDirection(int xdir)
    {
    xDirection=xdir;  
    }
     
     public void setYDirection(int ydir)
    {
    yDirection=ydir;  
    }
   public void draw(Graphics g)
   {
       java.net.URL urlBall = getClass().getResource("Ball.png"); 
BallImage = getImage(urlBall);
 g.drawImage(BallImage, this.ball.x, this.ball.y,null); 
   }
   
    public void collision()
   {        
            if(ball.intersects(p1.paddle))
            {
            setXDirection(+1);
            }
             
             if(ball.intersects(p2.paddle))
            {
            setXDirection(-1);
            }
    }

   
                public void move()
        {
                    collision();
               ball.x+=xDirection;
                ball.y+=yDirection;
                
                if(ball.x<=0)
                {
                setXDirection(+1);
                p2Score++;

                }
                  if(ball.x>=785)
                {
                setXDirection(-1);
                p1Score++;

                }
                  if(ball.y<=0)
                {
                setYDirection(+1);

                }
                  if(ball.y>=485)
                {
                setYDirection(-1);

                }

         }
                
                
                    public void run()
                    {

                        try{
                            while(true)
                            {  
                            move();
                            Thread.sleep(2);
                                }
                                
                            }
                        

                            catch(Exception e)
                            {
                            System.err.println(e.getMessage());
                            } 
                    }
}
