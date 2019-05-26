package Operators;

import io.reactivex.Observable;

public class CombiningOperatorsClass {
    public static void main(String[] args){
        Integer[] numbers = {1,2,3,4,5};
        String[] letters = {"a","b","c","d"};
        final StringBuilder result = new StringBuilder();

        Observable<Integer> observable1 = Observable.fromArray(numbers);
        Observable<String> observable2 = Observable.fromArray(letters);

        Observable.combineLatest(observable1,observable2, (a,b)->a+b)
                .subscribe(letter -> result.append(letter));
        result.append(" ");
        Observable.merge(observable1,observable2)
                .subscribe(letter -> result.append(letter));
        System.out.println(result);

    }
}
