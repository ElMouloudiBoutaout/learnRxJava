package concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserverOn {

    // subscribeOn : cannot change the type of scheduler, always take the first declared type
    // ObserverOn : to change the type of the scheduler in the process of chaining data

    public static void main(String[] args) throws InterruptedException {

        Observable.just("A","B","C","D","E")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toLowerCase())
                .observeOn(Schedulers.newThread())
                .doOnNext(e -> System.out.println(Thread.currentThread().getName()))
                .subscribe(System.out::println);

        Thread.sleep(1000);
    }


}
