package Subjects;

import io.reactivex.subjects.BehaviorSubject;

/**
 * Here I am using two string builder result1 and result2
 * I have created a BehaviourSubject
 * Initialy the subject is subscribed with result1
 * after c I have subscribed the result 2 with this which emits the value before subscribing and the on
 */
public class BehaviourSubjectClass {
    public static void main(String[] args){
        final StringBuilder result1 = new StringBuilder();
        final StringBuilder result2 = new StringBuilder();
        BehaviorSubject<String> subject = BehaviorSubject.create();
        subject.subscribe(value -> result1.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("d");
        subject.onNext("e");
        subject.onNext("f");
        subject.onComplete();

        System.out.println(result1);
        System.out.println(result2);
    }

}
