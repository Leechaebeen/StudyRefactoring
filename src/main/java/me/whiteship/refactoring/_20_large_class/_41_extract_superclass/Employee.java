package me.whiteship.refactoring._20_large_class._41_extract_superclass;

/**
 * 리팩토링 41. 슈퍼클래스 추출하기 Extract Superclass
 * - 두 개의 클래스에서 비슷한 것들이 보인다면 상속을 적용하고, 슈퍼클래스로 "필드 올리기(Pull Up Field)"와
 *   "메소드 올리기(Pull Up Method)"를 사용한다.
 * - 대안으로는 "클래스 추출하기(Extract Class)" 를 적용해 위임을 사용할 수 있다.
 * - 우선은 간단히 상속을 적용한 이후, 나중에 필요하다면 "슈퍼클래스를 위임으로 교체하기"를 적용한다.
 * */
public class Employee extends Party {

    private Integer id;

    private double monthlyCost;

    public Employee(String name) {
        super(name);
    }

    public Integer getId() {
        return id;
    }
    @Override
    protected double monthlyCost(){
        return monthlyCost;
    }
}
