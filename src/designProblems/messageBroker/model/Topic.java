package designProblems.messageBroker.model;

import designProblems.messageBroker.consumer.AbstractConsumer;
import designProblems.messageBroker.producer.AbstractProducer;
import designProblems.messageBroker.utils.Constants;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.*;


/**
 * @author chandan on 11/03/19
 */
public class Topic {

    String name;
    String backupFilePath;//TODO implement fault tolerance
    ConcurrentLinkedQueue<String> queue;
    Set<AbstractConsumer> consumers;
    Set<AbstractProducer> producers;

    public Topic(String name){
        this.name = name;
        this.queue = new ConcurrentLinkedQueue<>();
        this.consumers = new HashSet<AbstractConsumer>();
        this.producers = new HashSet<AbstractProducer>();
        backupFilePath = Constants.DEFAULT_BACKUP_DIR + name;
    }

    private ConcurrentLinkedQueue<String> getQueue() {
        return queue;
    }

    public String getNextElement(){
        return queue.poll();
    }

    public Set<AbstractConsumer> getConsumers() {
        return consumers;
    }

    public Set<AbstractProducer> getProducers() {
        return producers;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", backupFilePath='" + backupFilePath + '\'' +
                ", queue=" + queue +
                ", consumers=" + consumers +
                ", producers=" + producers +
                '}';
    }
}
