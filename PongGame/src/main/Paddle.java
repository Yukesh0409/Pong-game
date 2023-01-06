

package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import static sun.applet.AppletResourceLoader.getImage;


public class Paddle implements Runnable {
 
    int x,y,yDirection,id;
 Rectangle paddle;
 Image PaddleImage1;
  Image PaddleImage2;
 
  public Paddle(int x,int y,int id)
  {
  this.x=x;
  this.y=y;
  this.id=id;
paddle=new Rectangle(x,y,10,80);

  }
  
  public void keyPressed(KeyEvent e)
  {
      switch(id)
      {
        
              case 1:
                   
                if(e.getKeyCode()== e.VK_W)
                {
                setYDirection(-1);
                }
                if(e.getKeyCode()== e.VK_S)
                {
                    setYDirection(1);
                }
              break;
             
              case 2:
            if(e.getKeyCode()== e.VK_UP)
            {
             setYDirection(-1);
            }
            if(e.getKeyCode()== e.VK_DOWN)
            {
                 setYDirection(+1);
            }
          break;
                default:
              System.out.println("Enter correct id");
          break;
      
  
  }
}
  public void keyReleased(KeyEvent e)
  {
      switch(id)
      {
            
              case 1:
                if(e.getKeyCode()== e.VK_W)
                {
                setYDirection(0);
                }
                if(e.getKeyCode()== e.VK_S)
                {
                    setYDirection(0);
                }
              break;
             
              case 2:
            if(e.getKeyCode()== e.VK_UP)
            {
             setYDirection(0);
            }
            if(e.getKeyCode()== e.VK_DOWN)
            {
                 setYDirection(0);
            }
          break;
                default:
              System.out.println("Enter correct id");
          break;
      
  
  }
}
  public void setYDirection(int ydir)
  {
      yDirection=ydir;
 
  }
  public void move()
  {
  paddle.y+=yDirection;
  if(paddle.y<=30)
  {
  paddle.y=30;
  
  }
  if(paddle.y>=405)
  {
  paddle.y=405;
  }
  
  }
  public void draw(Graphics g)
  {
     java.net.URL url1 = getClass().getResource("PaddleImage1.png");  
PaddleImage1 = getImage(url1); 
 java.net.URL url2 = getClass().getResource("PaddleImage2.png"); 
PaddleImage2 = getImage(url2);

              


      
  switch(id)
  {
          
      case 1:
          g.drawImage(PaddleImage1, this.paddle.x, this.paddle.y, null);
          break;
      
      case 2:
       g.drawImage(PaddleImage2, this.paddle.x, this.paddle.y, null);
          break;
      default:
          System.out.println("Enter correct id");
          
          
  }
  }
    @Override
    
    public void run() {
    
    try
    {
    while(true)
    {
    move();
    Thread.sleep(4);
    }
    }
    catch(Exception e)
            {
             System.err.println(e.getMessage());
            }
    }

   
}
