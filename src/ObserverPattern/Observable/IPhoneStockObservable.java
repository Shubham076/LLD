package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationObserver;
import java.util.ArrayList;
import java.util.List;

public class IPhoneStockObservable implements StockObservable {

    public List<NotificationObserver> observers = new ArrayList<>();
    int cnt = 0;

    @Override
    public void add(final NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(final NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationObserver obs: observers) {
            obs.update();
        }
    }

    @Override
    public void setCount(int newStockAdded) {
        if (cnt == 0) {
            notifyObservers();
        }
        cnt += newStockAdded;
    }

    @Override
    public int getCount() {
        return cnt;
    }
}
