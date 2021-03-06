package me.whiteship.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

import java.util.List;


/**
 * 리팩토링 30. 기본형을 객체로 바꾸기 Replace Primitive with Object
 * - 개발 초기에는 기본형(숫자 또는 문자열)으로 표현한 데이터가 나중에는 해당 데이터와 관련있는
 *   다양한 기능을 필요로 하는 경우가 발생한다.
 *      예) 문자열로 표현하던 전화번호의 지역 코드가 필요하거나 다양한 포맷을 지원하는 경우.
 *      예) 숫자로 표현하던 온도의 단위(화씨, 섭씨)를 변환하는 경우
 * - 기본형을 사용한 데이터를 감싸 줄 클래스를 만들면, 필요한 기능을 추가할 수 있다.
 */
public class OrderProcessor {

    public long numberOfHighPriorityOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getPriority().isHigherThan(new Priority("normal")))
                .count();
    }
}
