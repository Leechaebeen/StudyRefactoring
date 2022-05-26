package me.whiteship.refactoring._09_feature_envy;

public class ElectricityUsage {

    private double amount;

    private double pricePerUnit;

    public ElectricityUsage(double amount, double pricePerUnit) {
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
    }

    double getElecticityBill(){
        var electicityBill = getAmount() * getPricePerUnit();
        return electicityBill;
    }
    public double getAmount() {
        return amount;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
