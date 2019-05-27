package Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

/**
 * Here I am using the Newthread Scheduler which returns a new thread for every task
 */

public class NewThreadClass {

        public static void main(String[] args) throws InterruptedException {
            Observable.just("A", "AB", "ABC")
                    .flatMap(v -> getLengthWithDelay(v)
                            .doOnNext(s -> System.out.println("Processing Thread "
                                    + Thread.currentThread().getName()))
                            .subscribeOn(Schedulers.newThread()))
                    .subscribe(length -> System.out.println("Receiver Thread "
                            + Thread.currentThread().getName()
                            + ", Item length " + length));

            Thread.sleep(10000);
        }
    protected static Observable<Integer> getLengthWithDelay(String v){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3)*1000);
            return Observable.just(v.length());
        }catch (InterruptedException t){
            t.printStackTrace();
        }
        return null;
    }
    }

