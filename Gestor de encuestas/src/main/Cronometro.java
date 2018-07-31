

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.*; 
public class Cronometro extends Panel{
 Timer timer = new Timer(); //administra los tiempo de repeticion
	public int hrs,min,seg; 
	public boolean parar,first;
    TextField tf;
    Panel control;
   

    public Cronometro(){
        tf=new TextField("0:0:0");
        control=new Panel();
        tf.setEditable(false);
        
        
        setLayout(new BorderLayout());      
        add(tf,BorderLayout.NORTH);
        add(control,BorderLayout.CENTER);
        first=true;
        parar=false;      
    } 
	// clase interna en la que se indican las tareas a ejecutar por el timer
	class MiTarea extends TimerTask {
		public void run() {
                     if(!parar){
			seg++;	
                        if(seg%60==0){
                           min+=seg/60;
                           seg=seg%60;
                           if(min%60==0){
                              hrs+=min/60;
                              min=min%60;
                           }
                        }		
			tf.setText(" "+hrs+":"+min+":"+seg);
                     }
		}
	}
 
	public void start() {
           if(first){
             try{
		parar= false;
                hrs=min=seg=0;
		// le asignamos una tarea al timer
		timer.schedule(new MiTarea(),0,1000);
                first=false;
              }catch(Exception e){
                System.out.println("Error en el Timer (start)");      
            }
	}else reset();
       }
 
	public void stop() {
  	   try{
		parar= true;
           }catch(Exception e){
                System.out.println("Error en el Timer (stop)");      
            }
	}
 
    public void reset() {		
                hrs=min=seg=0;
                parar=false;
	}
/*
public void actionPerformed(ActionEvent e){
  
     if(e.getSource().equals(start))
           start();
     else if(e.getSource().equals(stop))
             stop();
          else if(e.getSource().equals(reset))reset(); 
   
}  
*/
 //public static void main(String args[]){
   // Frame f=new Frame();
    
    
 //}

}