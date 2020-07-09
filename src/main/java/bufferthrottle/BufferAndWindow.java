package bufferthrottle;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class BufferAndWindow {

    /*
    operators:

    buffer(): gather emission in a particular scope - emit each batch or group as a collection type

    window : - similar to buffer but they group emissions on observable thant collection
             - window emit data as soon as they become available


     */

    public static void main(String[] args) throws InterruptedException {

        Observable.range(1,50)
                //.buffer(5) by default collection type is List
                .buffer(4, HashSet::new) // we can specify Hashset as our type of collection
                .subscribe(System.out::println);


        System.out.println("xxxxxxxxxxxxxxxxxxxxx");

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1,TimeUnit.SECONDS,2)
                .subscribe(System.out::println);

        Thread.sleep(5000);

        System.out.println("xxxxxxxxx observable as arguments xxxxxxxxx");

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(Observable.interval(1,TimeUnit.SECONDS))
                .subscribe(System.out::println);

        System.out.println("xxxxxxxx WINDOW EXAMPLE xxxxxxxxx");

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .window(10)
                .subscribe(System.out::println);

        Thread.sleep(5000);


    }

}
