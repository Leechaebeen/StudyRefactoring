package me.whiteship.refactoring._07_divergent_change._25_move_function;

/**
 * 리팩토링 25.함수 옮기기 Move Function
 * - 모듈화가 잘 된 소프트웨어는 최소한의 지식만으로 프로그램을 변경할 수 있다.
 * - 관련있는 함수나 필드가 모여있어야 더 쉽게 찾고 이해할 수 있다.
 * - 하지만 관련있는 함수나 필드가 항상 고정적인 것은 아니기 때문에 때에 따라 옮겨야 할 필요가 있다.
 * - 함수를 옮겨야 하는 경우
 *      - 해당 함수가 다른 문맥(클래스)에 있는 데이터(필드)를 더 많이 참조하는 경우.
 *      - 해당 함수를 다른 클라이언트(클래스)에서도 필요로 하는 경우.
 * - 함수를 옮겨갈 새로운 문캑(클래스)이 필요한 경우에는 "여러 함수를 클래스로 묶기(Combine Functions info Class)"
 *   또는 "클래스 추출하기(Extract Class)" 를 사용한다.
 * - 함수를 옮길 적당한 위치를 찾기가 어렵다면 그대로 두어도 괜찮다. 언제든 나중에 옮길 수 있다.
 *
 * */
public class Account {

    int daysOverdrawn;

    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (this.daysOverdrawn() > 0) {
            result += this.type.overdraftCharge(this.daysOverdrawn);
        }
        return result;
    }

    private int daysOverdrawn() {
        return this.daysOverdrawn;
    }

}
