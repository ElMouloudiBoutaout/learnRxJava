import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Flowable.range(1,100)
                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);

        System.out.println("HELLO");
        Thread.sleep(1000);


    }

}
