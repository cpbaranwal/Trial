package designProblems.actorModel.message;

import designProblems.actorModel.actor.Actor;

/**
 * @author chandan on 17/03/19
 */
public class FwdMessage extends Message {
    Actor recipient;
    Message recipientMsg;

    public FwdMessage(Actor recipient, Message recipientMsg, Actor Sender) {
        super("", Sender);
        this.recipient = recipient;
        this.recipientMsg = recipientMsg;
    }

    public Actor getRecipientActor(){
        return recipient;
    }

    public Message getRecipientMsg(){
        return recipientMsg;
    }
}
