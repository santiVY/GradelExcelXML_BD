package co.com.bancolombia.factoring.google.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent; 

public class Tab {
       
       public void tab() throws InterruptedException, AWTException{
        try {
               
               Robot bot = new Robot();
               Thread.sleep(2000);
		       bot.keyPress(KeyEvent.VK_ESCAPE);
		       bot.keyRelease(KeyEvent.VK_ESCAPE);
		       Thread.sleep(2000);
		       bot.keyPress(KeyEvent.VK_ESCAPE);
		       bot.keyRelease(KeyEvent.VK_ESCAPE); 
		       Thread.sleep(2000);
       
                
        }catch( AWTException e) {
               e.printStackTrace();
        }
       }
}