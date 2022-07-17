package me.whiteship.refactoring._17_message_chain._37_hide_delegate;

/**
 * 냄새 17. 메시지 체인 Message Chains
 * - 레퍼런스를 따라 계속해서 메소드 호출이 이어지는 코드
 *   예) this.member.getCredit().getLevel().getDescription()
 * - 해당 코드의 클라이언트가 코드 체인을 모두 이해해야 한다.
 * - 체인 중 일부가 변경된다면 클라이언트의 코드도 변경해야 한다.
 * - 관련 리팩토링
 *  - "위임 숨기기 (Hide Delegate)" 를 사용해 메시지 체인을 캡슐화 할 수 있다.
 *  - "함수 추출하기(Extract Function)"로 메시지 체인 일부를 함수로 추출한 다음 "함수 옮기기(Move Function)" 으로
 *    해당 함수를 적절한 곳으로 이동할 수 있다.
 * */
public class Department {

    private String chargeCode;

    public Department(String chargeCode, Person manager) {
        this.chargeCode = chargeCode;
    }

    public String getChargeCode() {
        return chargeCode;
    }

}
