package me.whiteship.refactoring._18_middle_man._38_remove_middle_man;

/**
 * 리팩토링 38. 중재자 제거하기 Remove Middle Man
 * - "위임 숨기기"의 반대에 해당하는 리팩토링.
 * - 필요한 캡슐화의 정도는 시간에 따라 그리고 상황에 따라 바뀔 수 있다.
 * - 캡슐화의 정도를 "중재자 제거하기"와 "위임 숨기기" 리팩토링을 통해 조절할 수 있다.
 * - 위임하고 있는 객체를 클라이언트가 사용할 수 있도록 getter 를 제공하고,
 *   클라이언트는 메시지 체인을 사용하도록 코드를 고친 뒤에 캡슐화에 사용했던 메소드를 제거한다.
 * - Law of Demeter 를 지나치게 따르기 보다는 상황에 맞게 활용하도록 하자.
 *  - 디미터의 법칙 "가장 가까운 객체만 사용한다."
 * */
public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment(){
        return this.department;
    }
}
