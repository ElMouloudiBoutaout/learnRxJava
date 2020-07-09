package operators;

import io.reactivex.rxjava3.core.Observable;

public class Main {

    // Types :
        // Suppression operators
        // Transforming operators
        // Reducing operators
        // Error recovery operators
        // Action operators

    public static void main(String[] args) {

        Observable<Integer> observable = Observable.just(10,23,12,7,9,1,19);

        observable.
                filter(e -> e > 11 ).
                sorted(Integer::compareTo).
                subscribe(System.out::println);


    }

}
