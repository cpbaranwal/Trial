package designProblems.actorModel.actor;

import designProblems.actorModel.message.FwdMessage;
import designProblems.actorModel.message.KillMessage;
import designProblems.actorModel.message.Message;
import designProblems.actorModel.message.PrintMessage;

/**
 * @author chandan on 17/03/19
 */
public class MyActor extends Actor {

    public MyActor(String name) {
        super(name);
    }

    @Override
    protected void processMessage(Message msg) {
        if(msg == null)
            return;
        if(msg instanceof KillMessage){
            System.out.println("KillMessage(): actor "+name+" received kill message from "+msg.getSender());
            stop();
        }
        else if(msg instanceof PrintMessage){
            System.out.println("PrintMessage(): actor "+name+" received print message from "+msg.getSender());
            System.out.println("PrintMessage(): actor "+name+" printing message: " + msg.getMessage());
        }
        else if(msg instanceof FwdMessage){
            System.out.println("FwdMessage(): actor "+name+" received fwd message from "+msg.getSender());
            FwdMessage fwdMsg = (FwdMessage)msg;
            fwdMsg.getRecipientActor().receive(fwdMsg.getRecipientMsg());
        }
        else{
            System.out.println("unknownMessage(): actor "+name+" got  unknown message msg="+msg+" , throwing exception");
            throw new IllegalArgumentException("unknown message in actor "+name+" msg="+msg);
        }
    }
}
