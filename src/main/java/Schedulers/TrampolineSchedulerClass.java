package Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

/**
 * Here I am using the trampoline Scheduler that retruns a Scheduler which queues the work on the current to be executed after the current work completes
 *
 */
public class TrampolineSchedulerClass{
    public static void main(String[] args) throws InterruptedException {
    Observable.just("A","BB","CCC","DDDD")
            .flatMap(v -> getLengthWithDelay(v))
            .doOnNext(s -> System.out.println("Processing in thread"+Thread.currentThread().getName()+"Item Length"))
            .subscribeOn(Schedulers.trampoline())
            .subscribe(length -> System.out.println("Recived in thread"+Thread.currentThread().getName()+"Item Length"+length));

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
