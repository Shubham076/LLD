package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class SmsObserver implements NotificationObserver {
    String phoneNo;
    StockObservable obs;

    public SmsObserver(String phoneNo, StockObservable obs) {
        this.phoneNo = phoneNo;
        this.obs = obs;
    }
    @Override
    public void update() {
        sendMessage();
    }

    public void sendMessage() {
        System.out.println("sms message sent");
    }
}
