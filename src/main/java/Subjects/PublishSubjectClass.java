package Subjects;

import io.reactivex.subjects.PublishSubject;

/**
 * PublisSubject would emit the data only after the time it is suscribed
 * In this example I have used two String Builders result1 and result2
 * the result1 is subscribed before a b c and d so it gives all the output while
 * result 2 is subscribed only after d so it emits all the data before d
 * and prints e and f
 */
public class PublishSubjectClass {
    public static void main(String[] args){
        final StringBuilder result1 = new StringBuilder();
        final  StringBuilder result2 = new StringBuilder();

        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(value -> result1.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.onNext("d");
        subject.subscribe(value -> result2.append(value));
        subject.onNext("e");
        subject.onNext("f");

        System.out.println(result1);
        System.out.println(result2);
    }
}
