/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ahmed
 */
public class Side_button_movable extends Side_button implements MouseListener{
   //ImageIcon icon= new ImageIcon(getClass().getResource("close.png"));
   int i=0;
    public Side_button_movable() {
        super();
        
        addMouseListener(this);
        
    }
    public Side_button_movable(String text) {
        super(text);
        
        addMouseListener(this);
        
    }

     Timer btimer = new Timer() ;
     Timer btimer2 = new Timer() ;
    @Override
    public void mouseEntered(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
        
       btimer2.cancel();
        System.out.println("2 cancel");
        btimer = new Timer() ;
        System.out.println("1 start");
        btimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if(getWidth()<240)
                 setSize(getWidth()+40, getHeight());
                else if(getWidth()>=240)
                    cancel();
            }
        }, 0,50);
    }

    @Override
    public void mouseExited(MouseEvent me) {
         btimer.cancel();
        System.out.println("1 cancel");
        btimer2= new Timer();
        System.out.println("2 start");
        btimer2.schedule(new TimerTask() {

            @Override
            public void run() {
                if(getWidth()>60)
                 setSize(getWidth()-40, getHeight());
                else if(getWidth()<=60)
                    cancel();
            }
        }, 0,50);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
