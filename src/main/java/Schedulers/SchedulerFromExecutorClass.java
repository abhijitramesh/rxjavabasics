package Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Here I am using from Scheduler which converts an Executor into a new Scheduler
 */
public class SchedulerFromExecutorClass {
    public static void main(String[] args) throws InterruptedException{
        Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                        .doOnNext(s -> System.out.println("Processing Thread "
                                + Thread.currentThread().getName()))
                        .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(3))))
                .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));
        Thread.sleep(1000);
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
