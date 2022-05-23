package me.whiteship.refactoring._06_mutable_data._20_remove_setting_method;

/**
 * 리팩토링 20. 세터 제거하기 Remove Setting Method
 * - 세터를 제공한다는 것은 해당 필드가 변경될 수 있다는 것을 뜻한다.
 * - 객체 생성 시 처음 설정된 값이 변경될 필요가 없다면
 *   해당 값을 설정할 수 있는 생성자를 만들고 세터를 제거해서 변경될 수 있는 가능성을 제거해야 한다.
 *
 * */
public class Person {

    private String name;

    private int id;

    public Person(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
