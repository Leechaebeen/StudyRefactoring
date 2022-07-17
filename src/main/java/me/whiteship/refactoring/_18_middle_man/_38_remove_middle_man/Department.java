package me.whiteship.refactoring._18_middle_man._38_remove_middle_man;

/**
 * 냄새 18. 중제자 Middle Man
 * - 캡슐화를 통해 내부의 구체적인 정보를 최대한 감출 수 있다.
 * - 그러나, 어떤 클래스의 메소드가 대부분 다른 클래스로 메소드 호출을 위임하고 있다면
 *   중재자를 제거하고 클라이언트가 해당 클래스를 직접 사용하도록 코드를 개선할 수 있다.
 * - 관련 리팩토링
 *  - "중재자 제거하기(Remove Middle Man)" 리팩토링을 사용해 클라이언트가 필욯나 클래스를 직접 사용하도록 개선할 수 있다.
 *  - "함수 인라인(Inline Function)" 을 사용해서 메소드 호출한 쪽으로 코드를 보내서 중재자를 없앨 수 있다.
 *  - "슈퍼클래스를 위임으로 바꾸기(Replace Superclass with Delegate)"
 * - "서브클래스를 위임으로 바꾸기(Replace Subclass with Delegate)"
 * */
public class Department {

    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}
