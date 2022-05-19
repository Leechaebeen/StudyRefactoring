package me.whiteship.refactoring._06_mutable_data._18_split_variable;

/** 냄새 6. 가변 데이터 Mutable Data
 * - 데이터를 변경하다보면 예상치 못했던 결과나 해결하기 어려운 버그가 발생하기도 한다.
 * - 함수형 프로그래밍 언어는 데이터를 변경하지 않고 복사본을 전달한다. 하지만 그 밖의 프로그래밍 언어는 데이터 변경을 허용하고 있다.
 * - 따라서 변경되는 데이터 사용 시 발생할 수 있는 리스크를 관리할 수 있는 방법을 적용하는 것이 좋다.
 * - 관련 리팩토링
 *      - "변수 캡슐화하기(Encapsulate Variable)"를 적용해 데이터를 변경할 수 있는 메소드를 제한하고 관리할 수 있다.
 *      - "변수 쪼개기(Split Variable)"을 사용해 여러 데이터를 저장하는 변수를 나눌 수 있다.
 *      - "코드 정리하기(Slide Statements)"를 사용해 데이터를 변경하는 코드를 분리하고 피할 수 있다.
 *      - "함수 추출하기(Extract Function)"으로 데이터를 변경하는 코드로부터 사이드 이팩트가 없는 코드를 분리할 수 있다.
 *      - "질의 함수와 변경 함수 분리하기(Separate Query from Modifier)"를 적용해서 클라이언트가 원하는 경우에만 사이드 이펙트가
 *        있는 함수를 호출하도록 API 를 개선할 수 있다.
 *      - 가능하다면 "세터 제거하기(Remove Setting Method)" 를 적용한다.
 *      - 계산해서 알아낼 수 있는 "파생 변수를 질의 함수로 바꾸기(Replace Derived Variable with Query)"를 적용할 수 있다.
 *      - 변수가 사용되는 범위를 제한하려면 "여러 함수를 클래스로 묶기(Combine Functions into Class)" 또는
 *        "여러 함수를 변환 함수로 결합하기(Combine Functions into Transform)"을 적용할 수 있다.
 *      - "참조를 값으로 바꾸기(Change Reference to Value)"를 적용해서 데이터 일부를 변경하기 보다는 데이터 전체를 교체할 수 있도록록 *
 * */
public class Haggis {

    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    public Haggis(double primaryForce, double secondaryForce, double mass, int delay) {
        this.primaryForce = primaryForce;
        this.secondaryForce = secondaryForce;
        this.mass = mass;
        this.delay = delay;
    }

    public double distanceTravelled(int time) {
        double result; // result 는 누적값을 합산하는 변수이므로 ㄱㅊ
        final double primaryAcceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            final double primaryVelocity = primaryAcceleration * delay;
            final double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime + secondaryTime;
        }

        return result;
    }
}
