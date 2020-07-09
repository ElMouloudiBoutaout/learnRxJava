package bufferthrottle;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.concurrent.TimeUnit;

public class ThrottleOperator {

    // throttle operator : to exclude and skip elements

    public static void main(String[] args) {

        Observable observable = new Observable() {
            @Override
            protected void subscribeActual(@NonNull Observer observer) {

                try {
                    observer.onNext("A");

                    Thread.sleep(100);
                    observer.onNext("B");

                    Thread.sleep(910);
                    observer.onNext("C");

                    Thread.sleep(800);
                    observer.onNext("D");

                    Thread.sleep(800);
                    observer.onNext("E");

                    Thread.sleep(200);
                    observer.onNext("F");

                    Thread.sleep(750);
                    observer.onNext("I");

                    Thread.sleep(250);
                    observer.onNext("J");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        // skip last elements between second 1 2 3 ....
        //observable.throttleFirst(1, TimeUnit.SECONDS).subscribe(System.out::println);

        // skip first elements between second 1 2 3 ....
        //observable.throttleLast(1, TimeUnit.SECONDS).subscribe(System.out::println);
        observable.sample(1000, TimeUnit.MILLISECONDS).subscribe(System.out::println);


        // emit data after 700 ms of silence
        observable.debounce(700, TimeUnit.MILLISECONDS).subscribe(System.out::println);



    }
}
