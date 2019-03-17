package designProblems.actorModel;

import designProblems.actorModel.actor.Actor;
import designProblems.actorModel.actor.MyActor;
import designProblems.actorModel.message.FwdMessage;
import designProblems.actorModel.message.KillMessage;
import designProblems.actorModel.message.Message;
import designProblems.actorModel.message.PrintMessage;

/**
 * @author chandan on 17/03/19
 */
public class ActorSystem {

    public static void main(String[] args){
        Actor a1 = new MyActor("a1");
        Actor a2 = new MyActor("a2");
        Actor a3 = new MyActor("a3");

        Message msg1 = new PrintMessage(" this is msg1", null);
        //a1.receive(msg1);
        Message msg2 = new PrintMessage(" this is msg2", a1);
        a2.receive(msg2);

        Message msg3 = new FwdMessage(a3, new PrintMessage(" this is msg3", null), null);
        //a2.receive(msg3);

        Message msg4 = new KillMessage(a1);
        a2.receive(msg4);

        msg2 = new PrintMessage(" this is msg2", a1);
        a2.receive(msg2);


    }
}
