package operators;

import io.reactivex.rxjava3.core.Observable;

public class TransformingOperators {

    // transform data from type T to type R

    // map
    // cast(classname.class)
    // delay
    // delaySubscription

    // scan : take accumulator function and apply it to the first item and feed results to next

    // sorted
    //repeat


    public static void main(String[] args) {

        Observable.just(1,2,3,4,5).scan((x,y) -> x+y).subscribe(System.out::println);

    }





}
