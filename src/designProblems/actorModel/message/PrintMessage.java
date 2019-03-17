package designProblems.actorModel.message;

import designProblems.actorModel.actor.Actor;

/**
 * @author chandan on 17/03/19
 */
public class PrintMessage extends Message {
    public PrintMessage(String msg, Actor Sender) {
        super(msg, Sender);
    }
}
