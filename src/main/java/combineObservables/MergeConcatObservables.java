package combineObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MergeConcatObservables {

    // merge multiple observables to get on source observables


    public static void main(String[] args) throws InterruptedException {

        // merge : take 2 or more observables and merge them does not maintain order
        // concat the same as merge but maintain order


        Observable<String> observable1 = Observable.just("A","B","C","D ");
        Observable<String> observable2 = Observable.just("a","b","c","d ");

        Observable.merge(observable1,observable2).subscribe(System.out::print); // they are in order beceause  the program is sequential

        Observable o1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> e + "Obs1 ");
        Observable o2 = Observable.interval(1, TimeUnit.SECONDS).map(e -> e + "Obs2 ");;

        System.out.println();
        //Observable.merge(o1,o2).subscribe(System.out::print);

        System.out.println();
        Observable.concat(o1,o2).subscribe(System.out::print);

        Thread.sleep(20000);





    }


}
