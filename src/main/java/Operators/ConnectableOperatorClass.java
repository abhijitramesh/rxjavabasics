package Operators;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ConnectableOperatorClass {
    public static void main(String[] args){
        String[] letters = {"a","b","c","d"};
        Integer[] numbers = {1,2,3,4,5};

        final StringBuilder result = new StringBuilder();
        ConnectableObservable<String> connectable = Observable.fromArray(letters).publish();
        connectable.subscribe(letter -> result.append(letter));
        System.out.println(result.length());
        connectable.connect();
        System.out.println(result);
    }
}
