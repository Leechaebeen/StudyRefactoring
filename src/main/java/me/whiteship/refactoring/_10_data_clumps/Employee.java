package me.whiteship.refactoring._10_data_clumps;

/**
 * 냄새 10. 데이터 뭉치 Data Clumps
 * - 항상 뭉쳐 다니는 데이터는 한 곳으로 모아두는 것이 좋다.
 *      - 여러 클래스에 존재하는 비슷한 필드 목록
 *      - 여러 함수에 전달하는 매개변수 목록
 * - 관련 리팩토링 기술
 *      - "클래스 추출하기(Extract Class)"를 사용해 여러 필드를 하나의 객체나 클래스로 모을 수 있다.
 *      - "매개변수 객체 만들기(Introduce Parameter Object)" 또는 "객체 넘기기(Preserve Whole Object)"를 사용해
 *         메소드 매개변수를 개선할 수 있다.
 * */
public class Employee {

    private String name;

    private TelephoneNumber personalPhoneNumber;

    public Employee(String name, TelephoneNumber personalPhoneNumber) {
        this.name = name;
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String personalPhoneNumber() {
        return this.personalPhoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 이렇게 제공해줄지는 선택 사항
    public TelephoneNumber getPersonalPhoneNumber(){
        return personalPhoneNumber;
    }
}
