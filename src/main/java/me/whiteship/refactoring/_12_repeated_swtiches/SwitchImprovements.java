package me.whiteship.refactoring._12_repeated_swtiches;

/**
 * 냄새 12. 반복되는 switch 문 repeated Switches
 * - 예전에는 switch 문이 한번만 등장해도 코드 냄새로 생각하고 다형성 적용을 권장했다.
 * - 하지만 최근에는 다형성이 꽤 널리 사용되고 있으며, 여러 프로그래밍 언어에서 보다 세련된 형태의 switch 문을 지원하고 있다.
 * - 따라서 오늘날은 "반복해서 등장하는 동일한 switch 문"을 냄새로 여기고 있다.
 * - 반복해서 동일한 switch 문이 존재할 경우, 새로운 조건을 추가하거나 기존의 조건을 변경할 때 모든 switch 문을 찾아서 코드를 고쳐야 할지 모른다.
 * */
public class SwitchImprovements {

    public int vacationHours(String type) {
        int result;
        switch (type) {
            case "full-time": result = 120; break;
            case "part-time": result = 80; break;
            case "temporal": result = 32; break;
            default: result = 0;
        }
        return result;
    }
}
