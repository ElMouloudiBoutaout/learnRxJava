package intro;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;

public class Lesson1 {

    public static void main(String[] args) {

        Observable observable  =  new ObservableCreate<String>(
                new ObservableOnSubscribe() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {

                        emitter.onNext("intro.A");
                        emitter.onNext("b");
                        emitter.onNext("D");
                        //emitter.onError(new RuntimeException("Error is coming"));
                        emitter.onNext("Z");
                        emitter.onComplete();
                    }
                }
        );

        Observer observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(String o) {
                System.out.println(o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Watch out from errors");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        observable.subscribe(observer);

    }

}
