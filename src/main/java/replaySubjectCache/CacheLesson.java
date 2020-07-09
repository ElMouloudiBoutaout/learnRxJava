package replaySubjectCache;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class CacheLesson {

    public static void main(String[] args) throws InterruptedException {

        // cache operator return an observable

        Observable<Long> src =
                Observable.interval(1, TimeUnit.SECONDS).cache();

        src.subscribe(e->System.out.println(" e1 "+e));

        Thread.sleep(5000);

        src.subscribe(e->System.out.println(" e2 "+e));

        Thread.sleep(3000);


    }
}
