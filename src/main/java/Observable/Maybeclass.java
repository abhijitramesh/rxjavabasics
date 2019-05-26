package Observable;

import io.reactivex.Maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Maybeclass {
    public static void main(String args[]) throws InterruptedException{
        Disposable disposable = Maybe.just("Hello World")
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(new DisposableMaybeObserver<String>(){
                    @Override
                    public void onError(Throwable throwable){
                        throwable.printStackTrace();
                    }
                    @Override
                    public void onSuccess(String value){
                        System.out.println(value);
                    }
                    @Override
                    public void onComplete(){
                        System.out.println("Done");
                    }
                               }
                );
     Thread.sleep(3000);

        disposable.dispose();
    }
}
