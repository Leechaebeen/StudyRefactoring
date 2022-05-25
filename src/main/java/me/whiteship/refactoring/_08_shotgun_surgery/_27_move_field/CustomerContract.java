package me.whiteship.refactoring._08_shotgun_surgery._27_move_field;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 리팩토링 27. 필드 옮기기 Move Field
 * - 좋은 데이터 구조를 가지고 있다면, 해당 데이터에 기반한 어떤 행위를 코드로 (메소드나 함수) 옮기는 것도 간편하고 단순해진다.
 * - 처음에는 타당해 보였던 설계적인 의사 결정도 프로그램이 다루고 있는 도메인과 데이터 구조에 대해 더 많이 익혀나가면서,
 *   틀린 의사 결정으로 바뀌는 경우도 있다.
 * - 필드를 옮기는 단서 :
 *      - 어떤 데이터를 항상 어떤 레코드와 함께 전달하는 경우.
 *      - 어떤 레코드를 변경할 때 다른 레코드에 있는 필드를 변경해야 하는 경우.
 *      - 여러 레코드에 동일한 필드를 수정해야 하는 경우
 *      - (여기서 언급한 '레코드'는 클래스 또는 객체로 대체할 수도 있음)
 * */
public class CustomerContract {

    private LocalDate startDate;

    private double discountRate;
    public CustomerContract(LocalDate startDate, double discountRate) {
        this.startDate = startDate;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public void becomePreferred() {
        this.setDiscountRate(this.getDiscountRate() + 0.03);
        // 다른 작업들
    }

    public double applyDiscount(double amount) {
        BigDecimal value = BigDecimal.valueOf(amount);
        return value.subtract(value.multiply(BigDecimal.valueOf(this.getDiscountRate()))).doubleValue();
    }
}
