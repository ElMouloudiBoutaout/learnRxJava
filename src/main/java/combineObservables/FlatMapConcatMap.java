package combineObservables;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.Arrays;
import java.util.List;

public class FlatMapConcatMap {

    // flatMap : take each each element and  break it up into multiple elements and return an Observable
    //  flatMap take a mapper as parameter  which return an observable

    // flatMap work : OBSERVABLE1 ===> obs1 obs2 obs3 .... obsN ====> merge ===> return one OBSERVABLE2

    // concatMap like flatMap the difference is the final merge is sequentially in concatMap

    public static void main(String[] args) {

        Observable<List<String>> observable1 = Observable.just(Arrays.asList("a","b","f"),Arrays.asList("d","z","y"),Arrays.asList("k","o","y"));
        observable1.flatMap(e -> Observable.fromIterable(e)).subscribe(System.out::print);
        System.out.println();
        Observable.just("A","B","C","D").flatMap(e -> Observable.just(e+"1")).subscribe(System.out::print);
        System.out.println();
        observable1.concatMap(e -> Observable.fromIterable(e)).subscribe(System.out::print);

    }

}
