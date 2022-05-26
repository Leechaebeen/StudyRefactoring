package me.whiteship.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

/**
 * 리팩토링 31. 타입 코드를 서브 클래스로 바꾸기 Replace Type Code with Subclasses
 * - 비슷하지만 다른 것들을 표현해야 하는 경우, 문자열(String), 열거형(enum), 숫자(int) 등으로 표현하기도 한다.
 *      - 예) 주문타입, "일반 주문", "빠른 주문"
 *      - 예) 직원타입, "엔지니어", "매니저", "세일즈"
 * - 타입을 서브클래스로 바꾸는 계기
 *      - 조건문을 다형성으로 표현할 수 있을 때, 서브클래스를 만들고 "조건부 로직을 다형성으로 바꾸기"를 적용한다.
 *      - 특정 타입에만 유효한 필드가 있을 때, 서브클래스를 만들고 "필드 내리기"를 한다.
 * */
public abstract class Employee {

    private String name;

    public Employee() {}

    protected Employee(String name) {
        this.name = name;
    }

    public static Employee createEmployee(String name, String type) {
        switch (type) {
            case "engineer" : return new Engineer(name);
            case "manager" : return new Manager(name);
            case "salesman" : return new Salesman(name);
            default: throw new IllegalArgumentException(type);
        }
    }

    protected abstract String getType();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
