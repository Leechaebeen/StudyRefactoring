package me.whiteship.refactoring._07_divergent_change._26_extract_class;

/**
 * 리팩토링 26. 클래스 추출하기 Extract Class
 * - 클래스가 다루는 책임(Responsibility)이 많아질수록 클래스가 점차 커진다.
 * - 클래스를 쪼개는 기준
 *      - 데이터나 메소드 중 일부가 매우 밀접한 관련이 있는 경우
 *      - 일부 데이터가 대부분 같이 바뀌는 경우
 *      - 데이터 또는 메소드 중 일부를 삭제한다면 어떻게 될 것인가?
 * - 하위 클래스를 만들어 책임을 분산 시킬 수도 있다.
 * */
public class Person {

    private TelephoneNumber telephoneNumber;
    private String name;

    public Person(TelephoneNumber telephoneNumber, String name) {
        this.telephoneNumber = telephoneNumber;
        this.name = name;
    }

    public String telephoneNumber(){
        return this.telephoneNumber.toString();
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }
}
