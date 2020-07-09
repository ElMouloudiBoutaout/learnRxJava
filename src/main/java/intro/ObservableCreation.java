package intro;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableCreation {

    public static void main(String[] args) throws InterruptedException {

        //create
        Observable observable = Observable.create(
                emitter -> {
                    emitter.onNext("intro.A");
                    emitter.onComplete();
                }
        );
        observable.subscribe(System.out::println);


        //just
        Observable<Integer> observable1 = Observable.just(10,20,30);
        observable1.subscribe(System.out::println);

        //fromIterable
        Observable observable2 = Observable.fromIterable(Arrays.asList('x','y','z'));
        observable2.subscribeOn(Schedulers.io()).subscribe(System.out::println);

        //range
        Observable.range(1,10).subscribe(System.out::println);

        //interval
        Observable.interval(1, TimeUnit.SECONDS).subscribe(System.out::println);
        Thread.sleep(10000);

        //Observable.defer
        List<String> list = new ArrayList<>(Arrays.asList("Aron","Bob"));
        Observable<String> observable3 = Observable.defer(()->Observable.fromIterable(list));
        observable3.subscribe(System.out::println);

        list.add("Jessy");
        observable3.subscribe(System.out::println);







    }

}
