/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskers;

import javafx.application.Platform;

/**
 *
 * @author dalemusser
 * 
 * This example uses an object passed in with a notify()
 * method that gets called when a notification is to occur.
 * To accomplish this the Notifiable interface is needed.
 * 
 */
public class Task1 extends Thread {
    
    private int maxValue, notifyEvery;
    boolean exit = false;
    boolean twentyfive = false;
    boolean fifty = false;
    boolean seventyfive = false;
    boolean done = false;

    
    
    private Notifiable notificationTarget;
    
    public Task1(int maxValue, int notifyEvery)  {
        this.maxValue = maxValue;
        this.notifyEvery = notifyEvery;
    }
    
    @Override
    public void run() {
        doNotify("Task1 start.");
        for (int i = 0; i < maxValue; i++) {
            
            if (i % notifyEvery == 0) {
                doNotify("It happened in Task1: " + i);

                if (!twentyfive && i > (maxValue*0.25)) {
                    System.out.println("25% complete");
                    twentyfive = true;
                }
                if (!fifty && i > (maxValue*0.50)) {
                    System.out.println("50% complete");
                    fifty = true;
                }
                if (!seventyfive && i > (maxValue*0.75)) {
                    System.out.println("75% complete");
                    seventyfive = true;
                }
                if (!done && i > (maxValue*0.98)) {
                    System.out.println("100% complete");
                    done = true;
                }
            }
            
            if (exit) {
                System.out.println("100% complete");
                return;
            }
        }
        doNotify("Task1 done.");
    }
    
    public void end() {
        exit = true;
    }
    
    public void setNotificationTarget(Notifiable notificationTarget) {
        this.notificationTarget = notificationTarget;
    }
    
    private void doNotify(String message) {
        // this provides the notification through a method on a passed in object (notificationTarget)
        if (notificationTarget != null) {
            Platform.runLater(() -> {
                notificationTarget.notify(message);
            });
        }
    }
}
