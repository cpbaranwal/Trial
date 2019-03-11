package designProblems.messageBroker.consumer;

import designProblems.messageBroker.broker.AbstractBroker;

/**
 * @author chandan on 11/03/19
 */
public abstract class AbstractConsumer  {

    String topic;
    AbstractBroker broker;
    String name;
    public abstract boolean process(String msg);

    public String getName(){
        return name;
    }



}
