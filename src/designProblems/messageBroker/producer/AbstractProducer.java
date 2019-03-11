package designProblems.messageBroker.producer;

import designProblems.messageBroker.broker.AbstractBroker;

/**
 * @author chandan on 11/03/19
 */
public abstract class AbstractProducer {

    String topic;
    AbstractBroker broker;
    String name;
    // abstract methods:
    public abstract boolean sendRecord(String msg, String topic);

    public String getName(){
        return name;
    }

}
