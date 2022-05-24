package me.whiteship.refactoring._07_divergent_change._25_move_function;

public class AccountType {
    private boolean premium;

    public boolean isPremium() {
        return this.premium;
    }

    // 예제에서는 Account 를 넘겼지만 account.xxx 이런 식으로 참조하는 값이 많다면
    // Account 클래스에 overdraftCharge(int daysOverdrawn) 메소드를 두는 것이 더 적절하다고 볼 수 있다.
    double overdraftCharge(int daysOverdrawn) {
        if (this.isPremium()) {
            final int baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
