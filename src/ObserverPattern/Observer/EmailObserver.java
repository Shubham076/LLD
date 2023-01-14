package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class EmailObserver implements NotificationObserver {
    String mail;
    StockObservable obs;

    public EmailObserver(String mail, StockObservable obs) {
        this.mail = mail;
        this.obs = obs;
    }
    @Override
    public void update() {
        sendMail();
    }

    public void sendMail() {
        System.out.println("email sent");
    }
}
