package designProblems.messageBroker.broker;

import designProblems.messageBroker.consumer.AbstractConsumer;
import designProblems.messageBroker.model.Topic;
import designProblems.messageBroker.producer.AbstractProducer;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chandan on 11/03/19
 */
public class Broker extends AbstractBroker {


    Map<String, Topic> topics ;
    ExecutorService exec ;
    private volatile boolean running ;
    int numThreads = 3;

    public Broker(){
        running = true;
        topics = new ConcurrentHashMap<String, Topic>();
        exec = Executors.newCachedThreadPool();
        for(int i =1; i<= numThreads; i++)
            exec.submit(new Worker(i));
        //new Thread(new Worker(1)).start();
        //new Thread(new Worker(2)).start();
        //new Thread(new Worker(3)).start();
    }


     class Worker implements Runnable{
        int id;
        public Worker(int id){
            this.id = id;
        }
        @Override
        public void run() {
            while(running){
                for(Topic tp: topics.values()){
                    String msg = tp.getNextElement();
                    if(msg != null){
                        System.out.println("Worker "+id+" processing msg: "+msg);
                        Set<AbstractConsumer> consumers = tp.getConsumers();
                        for(AbstractConsumer cons: consumers)
                        {
                            cons.process(msg);
                        }

                    }

                }



            }

        }
    }



    @Override
    public boolean pushMessage(String msg, String topic, AbstractProducer producer) {
        topic = getNormalizedString(topic);
        if(eligibleProducer(topic, producer)){
            topics.get(topic).getNextElement();
            System.out.println("producer :"+producer.getName()+"  published  to topic : "+ topic+" msg = "+msg);
            return true;
        }
        return false;
    }



    @Override
    public boolean deleteTopic(String topic) {
        topic = getNormalizedString(topic);
        Topic tp = topics.get(topic);
        if(tp==null) {
            System.out.println("topic does not exist : "+ topic);
            //TODO log some exception
            return false;
        }
        topics.remove(topic);
        System.out.println("topic removed : "+ topic);
        return true;
    }

    @Override
    public boolean createTopic(String topic) {
        topic = getNormalizedString(topic);
        if(topics.containsKey(topic.toLowerCase())){
            System.out.println("topic already exists : "+ topic);
            return false;
        }
        Topic tp = new Topic(topic);

        topics.put(topic, tp);
        System.out.println("new topic created : "+ topic);
        return true;
    }

    @Override
    public boolean registerProducer(String topic, AbstractProducer producer) {
        Topic tp = topics.get(topic);
        if(tp==null) {
            System.out.println("unable to register producer : "+ producer);
            //TODO log some exception
            return false;
        }
        if(tp.getProducers().add(producer))
            System.out.println("producer registered : "+ producer);
        return true;
    }

    @Override
    public boolean registerConsumer(String topic, AbstractConsumer consumer) {
        Topic tp = topics.get(topic);
        if(tp==null) {
            System.out.println("unable to register consumer : "+ consumer);
            //TODO log some exception
            return false;
        }
        if(tp.getConsumers().add(consumer))
            System.out.println("consumer registered : "+ consumer);
        return true;
    }

    @Override
    public boolean shutdown() {
        running = false;
        //exec.shutdown();
        topics.clear();
        return true;
    }


    // helper methods
    private String getNormalizedString(String str){
        if(str == null)
            throw new IllegalArgumentException("string can not be null");
        str = str.trim();
        if(str.isEmpty())
            throw new IllegalArgumentException("string can not be empty");
        return str.toLowerCase();
    }

    private boolean eligibleProducer(String topic, AbstractProducer producer) {
        Topic tp = topics.get(topic);
        if(tp==null) {
            //TODO log some exception
            return false;
        }
        return tp.getProducers().contains(producer);
    }

    @Override
    public String toString() {
        return "Broker{" +
                "topics=" + topics +
                '}';
    }
}
