package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import static sun.applet.AppletResourceLoader.getImage;
import java.net.MalformedURLException;
import java.net.URL;


public class Main  extends JFrame{
    
    Image dbImage;
    Graphics dbg;
    int GWIDTH=800,GHEIGHT=500;
    Dimension ScreenSize=new Dimension(GWIDTH,GHEIGHT);
  static  Ball b=new Ball(193,143); 
   Image BackgroundImage;
  JFrame frame;
  
    public Main()
    {

    setTitle("Pong Game");
    setSize(ScreenSize);
  setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
 
    this.addKeyListener(new AL());
    setLocationRelativeTo(null);
  
    
    }
  
    
    @Override
    public void paint(Graphics g)
    {
        
          
        dbImage=createImage(getWidth(),getHeight());
        dbg=dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
     
    }
    public void draw(Graphics g)
    {
        java.net.URL urlBackground = getClass().getResource("white.jpg"); 
BackgroundImage = getImage(urlBackground);
 g.drawImage(BackgroundImage, 0, 0, null);
    b.draw(g);
    
    b.p1.draw(g);
    b.p2.draw(g);
    g.drawString(""+ b.p1Score, 15,50);
        g.drawString(""+ b.p2Score, 770,50);
      
    repaint();
    
    }

  
    public static void main(String[] args) {
        Main m=new Main();
        
        Thread th=new Thread(b);
        th.start();
        Thread p1=new Thread(b.p1);
          Thread p2=new Thread(b.p2);
          p1.start();
          p2.start();

        
    }
    public class AL implements KeyListener
    {

     

        @Override
        
        public void keyPressed(KeyEvent e) {
       
           
            
            b.p1.keyPressed(e);
           b.p2.keyPressed(e);   
        }
  @Override
  
        public void keyReleased(KeyEvent e) {
            b.p1.keyReleased(e);
          b.p2.keyReleased(e);
        }
      @Override
        public void keyTyped(KeyEvent e) {
            
            
        }
        }
}
