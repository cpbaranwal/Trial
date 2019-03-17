package designProblems.actorModel.actor;


import designProblems.actorModel.message.Message;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chandan on 17/03/19
 */
public abstract class Actor {
    String name;
    LinkedBlockingQueue<Message> inbox;
    private volatile boolean stopped = false;
    Thread worker = null;

    //TODO store supervisor/parent actor


    public Actor(String name){
        this.name = name;
        inbox = new LinkedBlockingQueue<>();
        start();
    }


    /* private methods
     */
    private void start(){
        worker = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("actor " + name + "alive now!");
                while(!stopped){
                    Message msg = inbox.poll();
                    processMessage(msg);
                }

            }
        });
        worker.start();
    }
    protected void stop(){
        stopped = true;
        worker.interrupt();// in case worker thread is blocking on inbox
        worker = null;
        inbox = null;
        System.out.println("actor " + name + "dead!");
    }


    /* public method
     */
    public void receive(Message msg){
        inbox.offer(msg);
    }

    public String getName(){
        return name;
    }



    // abstract methods
    protected abstract void processMessage(Message msg);


    // generated methods
    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
