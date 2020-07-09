package replaySubjectCache;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ReplayCacheLesson {

    public static void main(String[] args) throws InterruptedException {

        Observable<Long> src =
                Observable.interval(1, TimeUnit.SECONDS)
                .replay() //  replay(n) to replay only last n emissions
                          // example :  replay(1, TimeUnit.SECONDS) to replay only last 1 second emissions
                .autoConnect(); // the observable start emitting when this line is called

        src.subscribe(e->System.out.println(" e1 "+e));

        Thread.sleep(5000);

        src.subscribe(e->System.out.println(" e2 "+e));

        Thread.sleep(3000);

    }

}
