package concurrency;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlatMapConcurrencyUsage {

    // using flatMap to create observables/thread per emission (parallel)

    public static void main(String[] args) throws InterruptedException {

        Observable.just("A","B","C","D","E","F","G","H")
                .flatMap(getStringObservableSourceFunction())
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }

    @NonNull
    private static Function<String, ObservableSource<? extends String>> getStringObservableSourceFunction() {
        return e ->
                Observable.just(e)
                        .subscribeOn(Schedulers.computation())
                        .map(FlatMapConcurrencyUsage::compute);
    }

    @NonNull
    private static String compute(String e) throws InterruptedException {
        return e + " : "+Thread.currentThread().getName();
    }

}



