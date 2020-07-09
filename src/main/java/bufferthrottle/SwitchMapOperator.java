package bufferthrottle;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class SwitchMapOperator {

    // like FlatMap but only subscribe to last emitted observable ans dispose from previous ones

    public static void main(String[] args) throws InterruptedException {


        Observable source = Observable
                .just("A","B","C","D","E")
                .flatMap(e->Observable.just(e).delay(1000, TimeUnit.MILLISECONDS));


        Observable.interval(2,TimeUnit.SECONDS)
                .switchMap(s -> source.doOnDispose(()->System.out.println("disposing")))
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }


}
