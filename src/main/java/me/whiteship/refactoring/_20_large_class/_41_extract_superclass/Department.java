package me.whiteship.refactoring._20_large_class._41_extract_superclass;

import java.util.List;

/**
 * 냄새 20. 거대한 클래스 Large Class
 * - 어떤 클래스가 너무 많은 일을 하다보면 필드도 많아지고 중복 코드도 보이기 시작한다.
 * - 클라이언트가 해당 클래스가 제공하는 기능 중에 일부만 사용한다면 각각의 기능을 별도의 클래스로 분리할 수 있다.
 *      - "클래스 추출하기(Extract Class)" 를 사용해 관련있는 필드를 한 곳으로 모을 수 있다.
 *      - 상속 구조를 만들 수 있다면 "슈퍼클래스 추출하기(Extract Superclass)"
 *        또는 "타입 코드를 서브클래스로 교체하기"를 적용할 수 있다.
 * - 클래스 내부에 산재하는 중복 코드는 메소드를 추출하여 제거할 수 있다.
 * */
public class Department extends Party{

    private List<Employee> staff;

    public Department(String name) {
        super(name);
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public double monthlyCost() {
        return this.staff.stream().mapToDouble(Employee::monthlyCost).sum();
    }

    public int headCount() {
        return this.staff.size();
    }
}
