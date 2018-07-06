package com.simple.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @author: Jfeng
 * @date: 2018/5/18
 */
public class RxTest {
    public static void main(String[] args) {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello rxjava");
                subscriber.onNext("end");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String o) {
                System.out.println("o = " + o);
            }
        };

        observable.subscribe(subscriber);


    }


}
