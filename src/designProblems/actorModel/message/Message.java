package designProblems.actorModel.message;

import designProblems.actorModel.actor.Actor;

/**
 * @author chandan on 17/03/19
 */
public abstract class Message {

    private String msg;
    private Actor sender;
    public Message(String msg, Actor sender){
        this.msg = msg;
        this.sender= sender;
    }

    public Message(Actor sender){
        this("", sender);
    }

    public String getMessage(){
        return msg;
    }

    public Actor getSender(){
        return sender;
    }

    // TODO abstract method









}
