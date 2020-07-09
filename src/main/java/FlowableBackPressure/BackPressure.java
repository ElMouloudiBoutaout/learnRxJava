package FlowableBackPressure;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressure {

    public static void main(String[] args) throws InterruptedException {


        Observable.range(1,100000)
                .map(e->{
                    System.out.println("produce item e :"+e);
                    return e;
                }).observeOn(Schedulers.io())
                .subscribe(e->{
                    Thread.sleep(100);
                    System.out.println("Consume Item : "+e);
                });


        Observable.range(1,100000)
                .map(e->{
                    System.out.println("produce item e :"+e);
                    return e;
                }).observeOn(Schedulers.io())
                .subscribe(e->{
                    Thread.sleep(100);
                    System.out.println("Consume Item : "+e);
                });

        //vice versa toFlowable/toObservable
        Observable.range(1,100000)
                .toFlowable(BackpressureStrategy.BUFFER)
                .map(e->{
                    System.out.println("produce item e :"+e);
                    return e;
                }).observeOn(Schedulers.io())
                .subscribe(e->{
                    Thread.sleep(100);
                    System.out.println("Consume Item : "+e);
                });

        Thread.sleep(1000999900);

        Thread.sleep(1000999900);




    }

}
