package me.whiteship.refactoring._24_comments._43_introduce_assertion;

/**
 * 냄새 24. 주석 Comments
 * - 주석을 남겨야 할 것 같다면 먼저 코드를 리팩토링하라. 불필요한 주석을 줄일 수 있다.
 *      - 모든 주석이 나쁘다는 것도 아니고, 주석을 쓰지 말자는 것도 아니다.
 *      - 주석은 좋은 냄새에 해당하기도 한다.
 * - 관련 리팩토링
 *      - "함수 추출하기"를 사용해 설명이 필욯나 부분을 별도의 메소드로 빼낸다.
 *      - "함수 선언부 변경하기"를 사용해 함수 이름을 재정의할 수 있다.
 *      - 시스템적으로 어떤 필요한 규칙이 있다면, "어셔션 추가하기(Introduce Assertion)" 을 적용할 수 있다.
 * */
public class Customer {

    private Double discountRate;

    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
}
