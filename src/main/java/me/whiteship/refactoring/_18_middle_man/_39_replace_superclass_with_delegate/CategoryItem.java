package me.whiteship.refactoring._18_middle_man._39_replace_superclass_with_delegate;

import java.util.List;

/**
 * 리팩토링 39.슈퍼클래스를 위임으로 바꾸기 Replace Superclass with Delegate
 * - 객체지향에서 "상속"은 기존의 기능을 재사용하는 쉬우면서 강력한 방법이지만 때로는 적절하지 않은 경우도 있다.
 * - 서브클래스는 슈퍼클래스의 모든 기능을 지원해야 한다.
 *      - Stack 이라는 자료구조를 만들 때 List 를 상속받는 것이 좋을까?
 * - 서브클래스는 슈퍼클래스 자리를 대체하더라도 잘 동작해야 한다.
 *      - 리스코프 치환 원칙
 * - 서브클래스는 슈퍼클래스의 변경에 취약하다
 * - 그렇다면 상속을 사용하지 않는 것이 좋은가?
 *       - 상속은 적절한 경우에 사용한다면 매우 쉽고 효율적인 방법이다.
 *       - 따라서 우선 상속을 이용한 이후에, 적절하지 않다고 판단이 되면 그때 이 리팩토링을 적용하자.
 * */
public class CategoryItem {

    private Integer id;

    private String title;

    private List<String> tags;

    public CategoryItem(Integer id, String title, List<String> tags) {
        this.id = id;
        this.title = title;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }
}
