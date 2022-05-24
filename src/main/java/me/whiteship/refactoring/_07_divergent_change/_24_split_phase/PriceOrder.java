package me.whiteship.refactoring._07_divergent_change._24_split_phase;

/**
 * 냄새 7. 뒤엉킨 변경 Divergent Change
 * - 소프트웨어는 변경에 유연하기(soft) 대체할 수 있어야 한다.
 * - 어떤 한 모듈이 (함수 또는 클래스가) 여러가지 이유로 다양하게 변경되어야 하는 상황.
 *     - 예) 새로운 결제 방식을 도입하거나, DB를 변경할 때 동일한 클래스에 여러 메소드를 수정해야 하는 경우.
 * - 서로 다른 문제는 서로 다른 모듈에서 해결해야 한다.
 *     - 모듈의 책임이 분리되어 있을수록 해당 문맥을 더 잘 이해할 수 있으며 다른 문제는 신경쓰지 않아도 된다.
 * - 관련 리팩토링 기술
 *     - "단계 쪼개기(Split Phase)"를 사용해 서로 다른 문맥의 코드를 분리할 수 있다.
 *     - "함수 옮기기(Move Function)"를 사용해 적절한 모듈로 함수를 옮길 수 있다.
 *     - 여러가지 일이 하나의 함수에 모여 있다면 "함수 추출하기(Extract Function)"를 사용할 수 있다.
 *     - 모듈이 클래스 단위라면 "클래스 추출하기(Extract Class)" 를 사용해 별도의 클래스로 분리할 수 있다.
 * */
public class PriceOrder {

    public double priceOrder(Product product, int quantity, ShippingMethod shippingMethod) {
        final PriceData priceData = getPriceData(product, quantity);
        return applyShipping(priceData, shippingMethod);
    }

    private PriceData getPriceData(Product product, int quantity) {
        final double basePrice = product.basePrice() * quantity;
        final double discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();

        final PriceData priceData = new PriceData(basePrice, discount, quantity);   // 중간 데이터
        return priceData;
    }

    private double applyShipping(PriceData priceData, ShippingMethod shippingMethod)
    {
        final double shippingPerCase = (priceData.basePrice() > shippingMethod.discountThreshold()) ?
                shippingMethod.discountedFee() : shippingMethod.feePerCase();
        final double shippingCost = priceData.quantity() * shippingPerCase;
        final double price = priceData.basePrice() - priceData.discount() + shippingCost;
        return price;
    }
}
