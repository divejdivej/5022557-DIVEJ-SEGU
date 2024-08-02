package Observer2;
import java.util.List;
import java.util.ArrayList;
public class ObserverPatternExample {
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    interface Observer {
        void update(double price);
    }

    static class StockMarket implements Stock {
        private List<Observer> observers;
        private double price;

        public StockMarket() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(price);
            }
        }

        public void setPrice(double price) {
            this.price = price;
            notifyObservers();
        }
    }

    static class MobileApp implements Observer {
        @Override
        public void update(double price) {
            System.out.println("Mobile app: Stock price updated to " + price);
        }
    }

    static class WebApp implements Observer {
        @Override
        public void update(double price) {
            System.out.println("Web app: Stock price updated to " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice(100.0);
        stockMarket.setPrice(120.0);

        stockMarket.deregisterObserver(webApp);

        stockMarket.setPrice(150.0);
    }
}