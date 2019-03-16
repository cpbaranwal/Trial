package designProblems.messageBroker;
import designProblems.messageBroker.broker.Broker;
import designProblems.messageBroker.consumer.Consumer;
import designProblems.messageBroker.producer.Producer;

/**
 * @author chandan on 11/03/19
 */
public class MessageBrokerMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("in main");

        Broker broker = new Broker();
        String tp1 = "topic1";
        broker.createTopic(tp1);
        broker.createTopic(tp1);

        System.out.println("111111 broker = "+ broker);

        //Producer p1 = new Producer("p1", broker,tp1);
        //p1.sendRecord("msg1",tp1);
        Producer p2 = new Producer("p2", broker,tp1);
        Consumer c2 = new Consumer("c2", broker,tp1);
        Consumer c1 = new Consumer("c1", broker,tp1);

        System.out.println("22222 broker = "+ broker);

        for(int i=0; i<3; i++){
            p2.sendRecord("msg"+i,tp1);
            Thread.sleep(1*1000);
        }

        System.out.println("333333 broker = "+ broker);

        Thread.sleep(30*1000);
        System.exit(1);


    }
}
