package FlowableBackPressure;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableAndSubscriber {

    // flowable : emitter (replacement of Observable if we need back pressure)
    // subscriber : consume

    public static void main(String[] args) throws InterruptedException {


     /*   Flowable.range(1,1000)
                .map(e->{
                    System.out.println("produce item e :"+e);
                    return e;
                }).observeOn(Schedulers.computation())
                // unlike subscribe of Observable it does not return Disposable ,it return Subscription
                .subscribe(e->{
                    Thread.sleep(100);
                    System.out.println("Consume Item : "+e);
                });*/

        Flowable.range(1,10000)
                .map(e->{
                    System.out.println("produce item e :"+e);
                    return e;
                }).observeOn(Schedulers.io())
                // unlike subscribe of Observable it does not return Disposable ,it return Subscription
                .subscribe(new Subscriber<Integer>() {

                    Subscription subscription;
                    AtomicInteger atomicInteger = new AtomicInteger();

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Asking 50 elements");
                        this.subscription=subscription;
                        this.subscription.request(50);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("subscriber consumed "+integer);
                        if(atomicInteger.incrementAndGet() %50 ==0){
                            System.out.println("Asking for "+atomicInteger.get()+" next 50 elements");
                            subscription.request(50);
                        }

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("emissions Complete");
                    }
                });

        Thread.sleep(100000);


    }

}
