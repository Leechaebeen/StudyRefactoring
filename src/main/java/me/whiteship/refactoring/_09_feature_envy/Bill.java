package me.whiteship.refactoring._09_feature_envy;

/**
 * 냄새 9. 기능 편애 Feature Envy
 * - 어떤 모듈에 있는 함수가 다른 모듈에 있는 데이터나 함수를 더 많이 참조하는 경우에 발생한다.
 *      - 예) 다른 객체의 getter 를 여러개 사용하는 메소드.
 * - 관련 리팩토링 기술
 *      - "함수 옮기기(Move Function)"를 사용해서 힘수를 적절한 위치로 옮긴다.
 *      - 함수 일부분만 다른 곳의 데이터와 함수를 많이 참조한다면 "함수 추출하기(Extract Function)"로
 *        함수를 나눈 다음에 함수를 옮길 수 있다.
 * - 만약에 여러 모듈을 참조하고 있다면? 그 중에서 가장 많은 데이터를 참조하는 곳으로 옮기거나,
 *   함수를 여러 개로 쪼개서 각 모듈로 분산시킬 수도 있다.
 *
 * - 데이터와 해당 데이터를 참조하는 행동을 같은 곳에 두도록 하자.
 * - 예외적으로, 데이터와 행동을 분리한 디자인 패턴(전략 패턴 또는 방문자 패턴)을 적용할 수 있다.
 * */
public class Bill {

    private ElectricityUsage electricityUsage;

    private GasUsage gasUsage;

    public double calculateBill() {
        return electricityUsage.getElecticityBill() +  gasUsage.getGasBill();
    }
}
