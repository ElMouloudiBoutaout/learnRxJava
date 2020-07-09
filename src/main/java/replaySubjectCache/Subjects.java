package replaySubjectCache;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import javax.security.auth.Subject;

public class Subjects {

    // subject : work as proxy, can act as observer and as observable

    // subject implementations :
    // PublishSubject : start emitting to an observer from of subscription to the PublishSubject observable
    //                  not thread safe we call Subject.toSerialize() to call à safe thread subject implementation.
    // ReplaySubject : replay the emissions regardless of when the subscriber subscribe
    // BehaviorSubject : emit the most recent element from the point of subscription
    // AsyncSubject:  emit only the last element after invoking the OnComplete method
    // UniCastSubject : buffer all the emission received bt the source, until an observer subscribe to it, after emissions it clear the cache
    //                   therefore it will use on observer

    public static void main(String[] args) {

       // @NonNull UnicastSubject<String> subject = UnicastSubject.create();
        @NonNull UnicastSubject<String> subject = UnicastSubject.create();

        subject.subscribe(e->System.out.println("obs1 : "+e));

        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("B");

       // subject.subscribe(e->System.out.println("obs2 : "+e));

        subject.onNext("C");
        subject.onNext("D");


    }


}
