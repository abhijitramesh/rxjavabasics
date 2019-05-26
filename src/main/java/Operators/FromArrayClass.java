package Operators;

import io.reactivex.Observable;

public class FromArrayClass {
    public static void main(String[] args){
        String[] letters = {"a","b","c","d","e"};
        final StringBuffer result = new StringBuffer();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .map(String::toUpperCase)
                .subscribe( letter -> result.append(letter));
                System.out.println(result);
    }
}
