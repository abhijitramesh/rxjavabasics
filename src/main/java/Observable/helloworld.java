package Observable;

import io.reactivex.Flowable;

public class helloworld {
    public static void main(String[] args) {
        Flowable.just("Hello World!").subscribe(System.out::println);
    }
}
