package intro;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DisposableLesson {

    //tu unsubscribe from an observable

    public static void main(String[] args) throws InterruptedException {

        CompositeDisposable compositeDisposable = new CompositeDisposable();

        Observable observable = Observable.interval(1, TimeUnit.SECONDS);

        System.out.println("from d1");
        Disposable d1 = observable.subscribe(System.out::println);

        //Thread.sleep(5000);
        //d1.dispose();

        System.out.println("from d2");
        Disposable d2 = observable.subscribe(System.out::println);

        Thread.sleep(5000);
        compositeDisposable.addAll(d1,d2);
        compositeDisposable.dispose();

        System.out.println("from d3");
        observable.subscribe(System.out::println);
        Thread.sleep(10000);

        System.out.println(B.val);

        B.val++;

        System.out.println(A.val);

      int[] arr = coupleSum(new int[]{1,2,9,11,25},20);
      System.out.println(arr[0]);
      System.out.println(arr[1]);
    }


    // java.util.* and java.util.streams.* have been imported for this problem.
// You don't need any other imports.

    public static int[] coupleSum(int[] numbers, int target) {


        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }

        for(int i=0;i<numbers.length;i++){

            int rest = target - numbers[i];

            if(map.containsKey(rest))
                return new int[]{i+1, Integer.parseInt(map.get(rest).toString()+1)};


        }

        return null;
    }


}


class A {
    public static int val = 1000;
}

class B extends A {

}
