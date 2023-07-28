package rocha.andre.streaming.models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;

    private List<Shop> shops;

    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
        this.shops = new ArrayList<>();
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public boolean purchaseConfirmed(Shop shop) {
        if (shop.isLimitExceeded(balance)) {
            return false;
        }

        balance = shop.getLimitLeft(balance);
        shops.add(shop);

        return true;
    }

    @Override
    public String toString() {
        return "Compra: " + shops + "\n" +
                "Limite: " + limit + "\n" +
                "Saldo: " + balance + "\n";
    }
}
