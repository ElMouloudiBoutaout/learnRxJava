package intro;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotColdObservables {

    public static void main(String[] args) throws InterruptedException {

        //hot
        List<String> list = new ArrayList<String>(Arrays.asList("intro.A","intro.B","C"));

        Observable observable = Observable.fromIterable(list);

        observable.subscribe(System.out::println);

        System.out.println("-");

        list.add("D");

        observable.subscribe(System.out::println);


        //Cold
        ConnectableObservable coldObservable = Observable.interval(1, TimeUnit.SECONDS).publish();

        coldObservable.connect();

        coldObservable.subscribe(System.out::println);
        Thread.sleep(10);


        coldObservable.subscribe(System.out::println);
        Thread.sleep(10);




    }

}
