package Subjects;
import io.reactivex.subjects.ReplaySubject;

/**
 * Here I have made two String builders result1 and result2
 * I have used ReplaySubject here result1 is subscribed in the beginning
 * result2 is subscribed only after d
 * but the result will have both the values since they are subscribed to ReplaySubject<T>
 */
public class ReplaySubjectClass {
    public static void main(String[] args){
        final StringBuilder result = new StringBuilder();
        final  StringBuilder result1 = new StringBuilder();

        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(value -> result.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.onNext("d");
        subject.subscribe(value -> result1.append(value));
        subject.onNext("e");
        subject.onNext("f");
        subject.onNext("g");
        subject.onComplete();

        System.out.println(result);
        System.out.println(result1);

    }
}
