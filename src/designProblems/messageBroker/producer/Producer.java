package designProblems.messageBroker.producer;

import designProblems.messageBroker.broker.AbstractBroker;

/**
 * @author chandan on 11/03/19
 */
public class Producer extends AbstractProducer {


    public Producer(String name, AbstractBroker broker, String topic){
        this.broker = broker;
        this.topic = topic;
        this.name = name;
        broker.registerProducer(topic,this);
    }

    @Override
    public boolean sendRecord(String msg, String topic ) {
        return broker.pushMessage(msg, topic, this);
    }
}
