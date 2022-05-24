package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value;

/**
 * 리팩토링 23. 참조를 값으로 바꾸기 Change Reference to Value
 * - 레퍼런스(Reference) 객체 vs 값(Value) 객체
 *      - https://martinfowler.com/bliki/ValueObject.html
 *      - "Objects that are equal due to the value of their properties, in this case
 *         their x and y coordinates, are called value objects."
 *      - 값 객체는 객체가 가진 필드의 값으로 동일성을 확인한다.
 *      - 값 객체는 변하지 않는다.
 *      - 어떤 객체의 변경 내역을 다른 곳으로 전파시키고 싶다면 레퍼런스, 아니라면 값 객체를 사용한다.
 * */
public class Person {

    private TelephoneNumber officeTelephoneNumber;

    public String officeAreaCode() {
        return this.officeTelephoneNumber.areaCode();
    }

    public void officeAreaCode(String areaCode) {
        this.officeTelephoneNumber = new TelephoneNumber(areaCode, this.officeAreaCode());
    }

    public String officeNumber() {
        return this.officeTelephoneNumber.number();
    }

    public void officeNumber(String number) {
        this.officeTelephoneNumber = new TelephoneNumber(this.officeAreaCode(), number);
    }

}
