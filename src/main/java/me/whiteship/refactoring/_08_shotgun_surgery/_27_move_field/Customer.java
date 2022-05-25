package me.whiteship.refactoring._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 냄새 8. 산탄총 수술 Shotgun Surgery
 * - 어떤 한 변경 사항이 생겼을 때 여러 모듈을 (여러 함수 또는 여러 클래스를) 수정해야 하는 상황.
 *      - "뒤엉킨 변경" 냄새와 유사하지만 반대의 상황이다.
 *      - 예) 새로운 결제 방식을 도입하려면 여러 클래스의 코드를 수정해야 한다.
 * - 변경 사항이 여러 곳에 흩어진다면 찾아서 고치기도 어렵고 중요한 변경 사항을 놓칠 수 있는 가능성도 생긴다.
 * - 관련 리팩토링 기술
 *      - "함수 옮기기(Move Function)" 또는 "필드 옮기기(Move Field)"를 사용해서 필요한 변경 내역을 하나의 클래스로 모을 수 있다.
 *      - 비슷한 데이터를 사용하는 여러 함수가 있다면 "여러 함수를 클래스로 묶기(Combine Functions into Class)"를 사용할 수 있다.
 *      - "단계 조개기(Split Phase)"를 사용해 공통으로 사용되는 함수의 결과물들을 하나로 묶을 수 있다.
 *      - "함수 인라인(Inline Function)"과 "클래스 인라인(Inline Class)"로 흩어진 로직을 한 곳으로 모을 수 있다.
 * */
public class Customer {

    private String name;

    private double discountRate;

    private CustomerContract contract;

    public Customer(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
        this.contract = new CustomerContract(dateToday());
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void becomePreferred() {
        this.discountRate += 0.03;
        // 다른 작업들
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.discountRate))).doubleValue();
    }

    private LocalDate dateToday() {
        return LocalDate.now();
    }
}
