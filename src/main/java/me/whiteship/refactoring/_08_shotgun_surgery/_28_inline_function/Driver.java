package me.whiteship.refactoring._08_shotgun_surgery._28_inline_function;

/**
 * 리팩토링 28. 함수 인라인 Inline Function
 * - "함수 추출하기(Extract Function)"의 반대에 해당하는 리팩토링
 *      - 함수로 추출하여 함수 이름으로 의도를 표현하는 방법.
 * - 간혹, 함수 본문이 함수 이름만큼 또는 그보다 더 잘 의도를 표현하는 경우도 있다.
 * - 함수 리팩토링이 잘못된 경우에 여러 함수를 인라인하여 커다란 함수를 만든 다음에 다시 함수 추출하기를 시도할 수 있다.
 * - 단순히 메소드 호출을 감싸는 우회형(indirection) 메소드라면 인라인으로 없앨 수 있다.
 * - 상속 구조에서 오버라이딩 하고 있는 메소드는 인라인할 수 없다. (해당 메소드는 일종의 규약이니까)
 * */
public class Driver {

    private int numberOfLateDeliveries;

    public Driver(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    public int getNumberOfLateDeliveries() {
        return this.numberOfLateDeliveries;
    }
}
