package designProblems.messageBroker.broker;

import designProblems.messageBroker.consumer.AbstractConsumer;
import designProblems.messageBroker.producer.AbstractProducer;

/**
 * @author chandan on 11/03/19
 */
public abstract class AbstractBroker {

    public abstract boolean pushMessage(String msg, String topic, AbstractProducer producer);
    public abstract boolean deleteTopic(String topic);
    public abstract boolean createTopic(String topic);
    public abstract boolean registerProducer(String topic, AbstractProducer producer);
    public abstract boolean registerConsumer(String topic, AbstractConsumer consumer);
    public abstract boolean shutdown();

}
