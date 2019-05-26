package Subjects;

import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectClass {
    public static void main(String[] args){
        final StringBuilder result = new StringBuilder();
        final StringBuilder result1 = new StringBuilder();

        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(value -> result.append(value));
        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");
        subject.onNext("d");
        subject.onNext("e");
        subject.subscribe(value -> result1.append(value));
        subject.onNext("f");
        subject.onNext("g");
        subject.onNext("h");
        subject.onComplete();
System.out.println(result);
System.out.println(result1);

    }
}
