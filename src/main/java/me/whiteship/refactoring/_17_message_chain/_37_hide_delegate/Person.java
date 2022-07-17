package me.whiteship.refactoring._17_message_chain._37_hide_delegate;

/**
 * 리팩토링 37.위임 숨기기 Hide Delegate
 * - 캡슐화(Encapsulation)란 어떤 모듈이 시스템의 다른 모듈을 최소한으로 알아야 한다는 것이다.
 *   그래야 어떤 모듈을 변경할 때, 최소한의 모듈만 그 변경에 영향을 받을 것이고, 그래야 무언가를 변경하기 쉽다.
 * - 처음 객체 지향에서 캡슐화를 배울 때 필드를 메소드로 숨기는 것이라 배우지만, 메소드 호출도 숨길 수 있다.
 *   - person.department().manager(); -> person.getManager();
 *   - 이전의 코드는 Department 를 통해 Manager 에 접근할 수 있다는 정보를 알아야 하지만, getManager() 를 통해
 *     위임을 숨긴다면 클라이언트는 person 의 getManager() 만 알아도 된다.
 *     나중에 getManager() 내부 구현이 바뀌더라도 getManager()를 사용한 코드는 그대로 유지할 수 있다.
 * */
public class Person {

    private String name;

    private Department department;

    private Person manager;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
    public Person getManager() {
        return this.manager;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
