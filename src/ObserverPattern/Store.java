package ObserverPattern;

import ObserverPattern.Observable.IPhoneStockObservable;
import ObserverPattern.Observer.EmailObserver;
import ObserverPattern.Observer.NotificationObserver;
import ObserverPattern.Observer.SmsObserver;

public class Store {

    public static void main(String[] args) {
        IPhoneStockObservable iphoneObservable = new IPhoneStockObservable();
        NotificationObserver obs1 = new EmailObserver("abc@gmail.com", iphoneObservable);
        NotificationObserver obs2 = new SmsObserver("1234567891", iphoneObservable);

        iphoneObservable.add(obs1);
        iphoneObservable.add(obs2);
        iphoneObservable.setCount(10);
    }
}
