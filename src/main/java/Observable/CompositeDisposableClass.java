package Observable;

import io.reactivex.Maybe;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CompositeDisposableClass {

    public static void main(String[] args) throws InterruptedException {
       CompositeDisposable compositeDisposable = new CompositeDisposable();

        //Create an Single observer
        Disposable disposableSingle = Single.just("Single Observer")
                .delay(2, TimeUnit.SECONDS, Schedulers.io())
                .subscribeWith(
                        new DisposableSingleObserver<String>() {
                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }

                            @Override
                            public void onSuccess(String value) {
                                System.out.println(value);
                            }
                        });
        //Create an observer
        Disposable disposableMaybe = Maybe.just("Maybe Observer")
                .delay(2,TimeUnit.SECONDS,Schedulers.io())
                .subscribeWith(new DisposableMaybeObserver<String>(){
                    @Override
                    public void onError(Throwable e){
                        e.printStackTrace();

                    }
                    @Override
                    public void onSuccess(String value){
                        System.out.println(value);
                    }
                    @Override
                    public void onComplete(){
                        System.out.println("Completed");
                    }
                });
        Thread.sleep(3000);
compositeDisposable.add(disposableSingle);
compositeDisposable.add(disposableMaybe);

compositeDisposable.dispose();
   }
}

