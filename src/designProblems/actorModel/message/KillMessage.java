package designProblems.actorModel.message;

import designProblems.actorModel.actor.Actor;

/**
 * @author chandan on 17/03/19
 */
public class KillMessage extends Message {
    public KillMessage(String msg, Actor Sender) {
        super(msg, Sender);
    }
    public KillMessage(Actor Sender) {
        super("", Sender);
    }
}
