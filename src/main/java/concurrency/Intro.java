package concurrency;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class Intro {

    public static void main(String[] args) {

        Observable observable = new Observable() {
            @Override
            protected void subscribeActual(@NonNull Observer observer) {


                observer.onNext(Thread.currentThread().getName());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Thread.currentThread().getName());
                        observer.onNext(Runtime.getRuntime().availableProcessors());


                    }
                }).start();

            }
        };


        observable.subscribe(System.out::println);

    }

}
