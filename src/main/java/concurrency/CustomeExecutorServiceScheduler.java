package concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomeExecutorServiceScheduler {

    public static void main(String[] args) throws InterruptedException  {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Scheduler scheduler = Schedulers.from(executorService);

        Observable observable =  Observable.just("A","B","C","D","E")
                .subscribeOn(scheduler)
                .doFinally(executorService::shutdown);

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
