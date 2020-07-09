package replaySubjectCache;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class UniCastSubjectLesson {

    public static void main(String[] args) throws InterruptedException {

            UnicastSubject<Long> subject = UnicastSubject.create();

            Observable.interval(1, TimeUnit.SECONDS)
                    .subscribe(subject);

            Thread.sleep(3000);

            // UnicastSubject will buffer the emission of the first three seconds until a observer subscribe
           // then hit will emit
             //obs1 : 0
             //obs1 : 1
             //obs1 : 2
            subject.subscribe(e->System.out.println("obs1 : "+e));

            Thread.sleep(2000);

    }
}
