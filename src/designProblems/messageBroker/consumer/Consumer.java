package designProblems.messageBroker.consumer;

import designProblems.messageBroker.broker.AbstractBroker;

/**
 * @author chandan on 11/03/19
 */
public class Consumer extends AbstractConsumer {

    public Consumer(String name, AbstractBroker broker, String topic){
        this.broker = broker;
        this.topic = topic;
        this.name = name;
        broker.registerConsumer(topic,this);
    }

    @Override
    public boolean process(String msg) {
        System.out.println("consumer : "+this.name + " processed msg = "+ msg);
        return true;
    }
}
