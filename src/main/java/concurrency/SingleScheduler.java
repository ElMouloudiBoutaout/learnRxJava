package concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {

    public static void main(String[] args) throws InterruptedException  {

        // it created single thread used in case of tasks that are not thread safe

        Observable observable =  Observable.just("A","B","C","D","E")
                .subscribeOn(Schedulers.single());

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
