package concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ComputationalScheduler {

    public static void main(String[] args) throws InterruptedException  {

        Observable observable =  Observable.just("A","B","C","D","E")
                .subscribeOn(Schedulers.computation());

        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());

        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());
        observable.subscribe(e-> compute());



        Thread.sleep(10000);


    }

    public static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation Done By : "+Thread.currentThread().getName());
    }
}
