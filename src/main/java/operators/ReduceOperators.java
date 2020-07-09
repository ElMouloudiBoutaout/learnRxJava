package operators;

import io.reactivex.rxjava3.core.Observable;

public class ReduceOperators {

    // taking series of emissions and reduce them to Single emission
    // Observable ---> reduce operators x ---> Single
    // finite  emission

    // examples :
    // count
    // reduce is identical to scan but emit final emission
    // contains
    // all
    // any


    public static void main(String[] args) {

        Observable.just(1,2,3,4,5).reduce((x, y) -> x+y).subscribe(System.out::println);

    }


}
