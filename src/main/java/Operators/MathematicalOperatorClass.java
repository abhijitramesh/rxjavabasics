package Operators;

import io.reactivex.Observable;

public class MathematicalOperatorClass {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        String[] letters = {"a", "b", "c", "d" };

        final StringBuilder result = new StringBuilder();
        Observable<String> observable1 = Observable.fromArray(letters);
        Observable<Integer> observable2 = Observable.fromArray(numbers);
        Observable.concat(observable1, observable2)
                .subscribe(letter -> result.append(letter));

        System.out.println(result);
    }

}
