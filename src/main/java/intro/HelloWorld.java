package intro;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class HelloWorld {


    public static void main(String[] args) {


        Observable source = Observable.fromStream(Stream.of(1,2,3,'a','b','v'));

        source.subscribe(System.out::println);
        source.subscribe(x->System.out.println(x+"1"));

        System.out.println("hello");

       Arrays.asList("GOOGLE","AMAZON","ITC");

    }

}
