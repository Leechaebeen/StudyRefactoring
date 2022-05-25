package me.whiteship.refactoring._08_shotgun_surgery._29_inline_class;

/**
 * 리팩토링 29. 클래스 인라인 Inline Class
 * - "클래스 추출하기(Extract Class)"의 반대에 해당하는 리팩토링
 * - 리팩토링을 하는 중에 클래스의 책임을 옮기다보면 클래스의 존재 이유가 빈약해지는 경우가 발생할 수 있다.
 * - 두 개의 클래스를 여러 클래스로 나누는 리팩토링을 하는 경우에, 우선 "클래스 인라인"을 적용해서
 *   두 클래스의 코드를 한 곳으로 모으고 그런 다음에 "클래스 추출하기"를 적용해서 새롭게 분리하는 리팩토링을 적용할 수 있다.
 * */
public class Shipment {

    // 필드를 먼저 복사해오고
    private String shippingCompany;
    private String trackingNumber;

    // 생성자를 만들어주고
    public Shipment(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingInfo() {
        return this.shippingCompany + ": " + this.trackingNumber;
    }

    // 메소드를 가져온다
    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

}
