package combineObservables;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class GroupObservables {

    //groupBy : like the opposite of flat Map it group observables based on a key

    public static void main(String[] args) {

        List persons =  Arrays.asList(new Person("Ali","Kenitra"),
                new Person("Badre","Kenitra"),
                new Person("John","Kenitra"),
                new Person("Mohammed","Kenitra"),
                new Person("Karoll","London"),
                new Person("Youness","Kenitra"),
                new Person("Terry","London"),
                new Person("Li","Pekin")
        );

        Observable<Person> personObservable =  Observable.fromIterable(persons);

                personObservable
                .groupBy(e -> e.city)
                .flatMapSingle(e -> e.toMultimap(k->k.city,v ->v.name))
                .subscribe(System.out::println);

    }

}

class Person{

   public String name;

    public String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

