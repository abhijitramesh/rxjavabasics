package Operators;

import io.reactivex.Observable;

public class TakeOperatorclass {
    public static void main(String[] args){
        String[] letters = {"a","b","c","d","e" };
        final StringBuffer result = new StringBuffer();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .take(2)
                .subscribe(letter -> result.append(letter));
        result.append(" ");
        observable
                .takeLast(2)
                .subscribe(letter -> result.append(letter));
        result.append(" ");
        observable
                .skip(3)
                .subscribe(letter -> result.append(letter));
        result.append(" ");

        System.out.println(result);


    }
}
