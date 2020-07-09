package combineObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ZibCombineLatest {

    // zip : combine multiple emission based on zip method
    // CombineLatest: like zip operator but id does not wait for the second emission , it use the latest .
                   // each element from an observable or emission is cached until the new element is provided
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> o1 = Observable.interval(100, TimeUnit.MILLISECONDS);
        Observable<Long> o2 = Observable.interval(10, TimeUnit.MILLISECONDS);

        Observable.zip(o1,o2,(x,y) -> x+"zip"+y).subscribe(System.out::println);

        Observable.combineLatest(o1,o2,(x,y) -> x+"combineLatest"+y).subscribe(System.out::println);

        Thread.sleep(1000);
    }




}
