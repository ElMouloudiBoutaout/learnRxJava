package intro;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ObservableVariant {

    public static void main(String[] args) {

        //single : will Only emit one item (onNext >>> onSuccess)

        List<String> list = new ArrayList<String>(Arrays.asList("intro.A","intro.B","C"));
        Observable observable = Observable.fromIterable(list);
        observable.first("Z").subscribe(System.out::println);
        Single.just("H2O").subscribe(System.out::println);

        System.out.println("");

        //Maybe : maybe it will emit an element or not (in case of 0 emission the onComplete is called)
        observable.firstElement().subscribe(System.out::println,
                e->{},
                ()->System.out.println("Completed"));


        //Completable : No emission concerned if the action is complete has only onSuccess and onError
        Completable completable = Completable.complete();

        completable.subscribe(System.out::println);
        Completable.fromRunnable(()->System.out.println("Running task in different thread"))
                    .subscribe(()->System.out.println("Task complete"),Throwable::printStackTrace);

        Completable.fromRunnable(()->{
            System.out.println("Running task in error thread");
            throw new NullPointerException();
        }).subscribe(()->System.out.println("Task complete"),Throwable::printStackTrace);


    }

    @NonNull
    private static Action getPrintln() {
        return null;
    }


}
