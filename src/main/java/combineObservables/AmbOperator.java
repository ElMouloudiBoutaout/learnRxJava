package combineObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AmbOperator {

    // amb : to return the data from the faster observable

    public static void main(String[] args) throws InterruptedException {


        Observable<String> o1 = Observable.interval(100, TimeUnit.MILLISECONDS).map(e -> e + "Obs1 ").take(10);
        Observable<String> o2 = Observable.interval(10, TimeUnit.MILLISECONDS).map(e -> e + "Obs2 ").take(10);

        Observable.amb(Arrays.asList(o1,o2)).subscribe(System.out::println);

        Thread.sleep(1000);

    }


}
