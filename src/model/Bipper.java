package model;

public class Bipper extends WorldObject {

    private int amount;

    public Bipper() {
    }

    public Bipper(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
