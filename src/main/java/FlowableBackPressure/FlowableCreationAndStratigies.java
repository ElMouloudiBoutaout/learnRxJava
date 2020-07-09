package FlowableBackPressure;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableCreationAndStratigies {

    public static void main(String[] args) throws InterruptedException {

        /*
        BUFFER :
        DROP : drop elements if consumer cannot keep up with resource
        ERROR : signal missing back pressure missing exception if consumer cannot keep up with resource
        LATEST : keep the last elements
        MISSING : no back pressure

         */

        Flowable.create(emitter -> {
                    for (int i = 0; i < 10000; i++) {
                        if (emitter.isCancelled())
                            return;
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                }
                ,BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        Thread.sleep(1000);

    }
}
